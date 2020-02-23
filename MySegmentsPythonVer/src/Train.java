import java.util.Scanner;

public class Train {

	static int[] A2;
	
	static void add(int s1, int s2) {
		
		if(s1 > s2) {
			
			int temp = s1;
			s1 = s2; 
			s2 = temp;
		}
		
		int d = s2 - s1;
		
		if(A2[d] != -1) A2[d] = Math.max(A2[d], s1);
		else A2[d] = s1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
				
		int[][] data = new int[T][];		
		
		for (int t = 0; t<T; t++) {
			
			data[t] = new int[scan.nextInt()];
			for (int i = 0; i<data[t].length; i++) data[t][i] = scan.nextInt();
		}
		
		
		scan.close();
		
		for (int test = 0; test<T; test++) {
			
			int sum = 0;
			for (int i = 0; i<data[test].length; i++) sum+=data[test][i];
			
			int[] A = new int[sum+1];
			A[0] = 0;
			for (int i = 1; i<=sum; i++) A[i] = -1;
			
			int sum2 = 0;
			
			for (int i = 0; i<data[test].length; i++) {
				
				A2 = new int[sum+1];
				for (int j = 0; j<=sum; j++) A2[j] = -1;
				
				for (int j = 0; j<A.length; j++) {
					
					if(A[j] == -1) continue;
					
					sum2 = j + A[j];
					add(A[j], sum2);
					add(A[j] + data[test][i], sum2);
					add(A[j], sum2 + data[test][i]);
				}
				A = A2;
			}
			
			System.out.println("#" + (test+1) + " " + A[0]);
		}	 
	}
}
