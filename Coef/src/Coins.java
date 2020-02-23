import java.util.Scanner;

public class Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Min();
		MyMin();
	}

	public static void Combinations() {

		int[] de = new int[] {1, 5, 12};
		int[] comb = new int[13];
		comb[0] = 1;
		
		for (int i = 0; i<3; i++) {
			
			for (int j = 1; j<13; j++) {
				
				if (j >= de[i])
					comb[j] += comb[j-de[i]];
			}
		}
 		
		System.out.println(comb[12]);
	}
	
	public static void Min() {
 
		int n = 3, k = 100000;		
		int[] coin = new int[] {1, 5, 7};
		
/*		Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int coin[] = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = scanner.nextInt();
        }
*/
        int d[] = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            d[i] = -1;
            for (int j = 0; j < n; j++) {
                if (coin[j] <= i) {
                    if (d[i - coin[j]] < 0) continue;
                    if (d[i] < 0) d[i] = d[i - coin[j]] + 1;
                    else if (d[i - coin[j]] + 1 < d[i]) d[i] = d[i - coin[j]] + 1;
                }
            }
        }

        System.out.println(d[k]);
		
	}
	
	public static void MyMin() {
		
		int n = 3, k = 100000;		
		int[] coin = new int[] {1, 5, 7};
		int[] min = new int[k+1];
		min[0] = 0;
		int t;
		
		for (int i = 1; i<k+1; i++) {
			
			t = 100000000;
			for (int j = 0; j<n; j++) {
				
				
				if (i >= coin[j]) { 
					min[i] = min[i-coin[j]] + 1;
					t = Math.min(t, min[i]);
				}				
			}			
			min[i] = t;
		}
		
		System.out.println(min[k]);
	}
}
