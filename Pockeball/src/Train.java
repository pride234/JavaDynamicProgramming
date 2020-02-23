import java.util.Scanner;

public class Train {

	static int mod = 1000000007;
	static int mask = 1<<20;
	static int[][] dp;
 
	static int Solution(int n, String bits) {
		
		for (int i = 0; i<n+1; i++) dp[i][0] = 1;
		
		int start;
		
		for (int i = 0; i<n; i++) {
			
			start = i+1;
			
			while ((start < n+1) && (bits.charAt(start - 1) != '1')) start++;
			
			int num = 0;
			for (int j = start; j <=n; j++) {
				
				num*=2;
				
				if (bits.charAt(j-1) == '1') num++;
				if(num > 20) break;
				
				for (int k = 0; k<mask; k++) {
					
					if(dp[i][k] == 0) continue;
					
					int nmask = k | (1 << num-1);
					dp[j][nmask] += dp[i][k];
					dp[j][nmask] %= mod;
				}
			}
		}
		
		int res = 0;
		int gmask = 2;
		
		while(gmask <= mask) {
			
			for (int i = 0; i<=n; i++) {
				
				res += dp[i][gmask - 1];
				res %= mod;
			}
			gmask = gmask << 1;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		String bits = scan.next();
		
		dp = new int[n+1][mask];
		
		scan.close();
		
		System.out.println(Solution(n, bits));
	}

}
