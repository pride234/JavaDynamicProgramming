import java.util.Scanner;

public class Dishes {
	
	private static int n;
	private static int k;
		
	private static int[][] used;
	private static int[][] rules;
	
	private static void Clear() {
		
		for (int i = 0; i<n+1; i++) for (int j = 0; j<n+1; j++) used[i][j] = 0;
	}
	
	private static void Used(int c1, int c2) {
		
		for (int i = 0; i<n+1; i++) {
			
			used[c1][i] = 1;
			used[i][c2] = 1;
		}
	}	

	private static long AnyRules2(int mask, int i) {

		long sum = rules[i][2];
		
		for (int j = i + 1; j<k; j++) {
			
			
			if ((( (mask & (1 << n - rules[j][0] )) != 0) & ((mask & (1 << n - rules[j][1] )) != 0)) == false ) continue;
			
			if (used[rules[j][0]][rules[j][1]] == 0) {
				
				Used(rules[j][0], rules[j][1]);
				used[rules[j][1]][rules[j][0]] = 1;
				sum += rules[j][2];
			}			
		}

		return sum;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();

		int m = scan.nextInt();

		k     = scan.nextInt();		
		used = new int[n+1][n+1];
		rules  = new int[k][3];

		int[] weight = new int[n];
		
		
		for (int i = 0; i<n; i++) weight[i] = scan.nextInt();

		for (int i = 0; i<k; i++) {
			
			for (int j = 0; j<3; j++) rules[i][j] = scan.nextInt();
			
			for (int j = i; j>0; j--) {
				
				if (rules[j][0] < rules[j-1][0]) {
					
					int[] temp = rules[j];
					rules[j] = rules[j-1];
					rules[j-1] = temp;
				}
			}
		}
				
		scan.close();
		
		int amount;
		int N = 1 << n;
		long sum = 0, max = -1;
		
		if (k == 0) {

			for (int mask = 0; mask<N; mask++) {
				
				amount = 0;
				for (int j = 0; j<n; j++) if((mask & (1 << j)) != 0) amount++;
				
				if(amount != m) continue;
				
				sum = 0;
				for (int l = 0; l<n; l++) if((mask & (1 << l)) != 0) sum += weight[n - 1 - l];
				
				max = Math.max(max, sum);
			}
			System.out.println(max);
						
		} else {

			for (int mask = 0; mask<N; mask++) {
				
				amount = 0;
				for (int j = 0; j<n; j++) if((mask & (1 << j)) != 0) amount++;
				
				if(amount != m) continue;
				
				sum = 0;
				for (int j = 0; j<n; j++) if((mask & (1 << j)) != 0) sum += weight[n - 1 - j];

				for (int j = 0; j<n; j++) {
					
					if ((mask & (1 << n - 1 - j )) == 0) continue;
					Used(0, j+1);
					
					for (int l = 0; l<k; l++) {

						if ((((mask & (1 << n - rules[l][0] )) != 0) & ((mask & (1 << n - rules[l][1] )) != 0)) == false) continue;
						if (used[rules[l][0]][rules[l][1]] == 1) continue;						
						
						Used(rules[l][0], rules[l][1]);
						used[rules[l][1]][rules[l][0]] = 1;
						max = Math.max(max, sum + AnyRules2(mask, l));
						Clear();
						Used(0, j+1);
					}					
					Clear();
				}								
			}
			System.out.println(max);			
		}
	}
}
