import java.util.Scanner;

public class Train {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		
		int[] a = new int[n];
		int[][] c = new int[n][n];

		for (int i = 0; i<n; i++) a[i] = scan.nextInt();
		
		for (int i = 0; i<k; i++) c[scan.nextInt() - 1][scan.nextInt() - 1] = scan.nextInt();
		
		int N = 1 << n;
		long[][] dp = new long[N][n];
		
		for (int i = 0; i<n; i++) dp[1 << i][i] = a[i];
		
		for (int mask = 0; mask<N; mask++) for (int i = 0; i<n; i++) if((mask & (1 << i)) != 0) {
			
			for (int j = 0; j<n; j++) {
				
				int t = 1 << j;
				if((mask&t) == 0) dp[mask|t][j] = Math.max(dp[mask|t][j], dp[mask][i] + c[i][j] + a[j]);
			}
		}
		
		long max = 0;
		
		for (int mask = 0; mask<N; mask++) {
			
			int amount = 0;
			for (int i = 0; i<n; i++) if( (mask & (1 << i)) != 0) amount++;
			
			if(amount == m) for (int i = 0; i<n; i++) max = Math.max(max, dp[mask][i]);
		}
		System.out.println(max);
	} 
}
