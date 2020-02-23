import java.util.Scanner;

public class Pockeball {

	static int mod = 1000000007;
	static int mask_l = 1 << 20;
	static int[][] d;

	static int Solution (int n, String bits) {
		
		int start;
		for (int i = 0; i<=n; i++) d[i][0] = 1;
		
		for (int i = 0; i<n; i++) {
			
			start = i + 1;
			while ( (start < n+1) && (bits.charAt(start-1) != '1') ) start++;
			
			int num = 0;
			
			for (int j = start; j<n+1; j++) {
				
				num *= 2;
				
				if (bits.charAt(j-1) == '1') num++;
				
				if (num > 20) break;
				
				for (int k = 0; k<mask_l; k++) {
					
					if(d[i][k] == 0) continue;
					
					int new_mask = k | (1 << num -1);
					d[j][new_mask] += d[i][k];
					d[j][new_mask] %= mod;
				}
			}
		}
		
		int res = 0;
		int good_mask = 2;
		
		while (good_mask <= mask_l) {
			
			for (int i = 0; i<=n; i++) {
				
				res += d[i][good_mask - 1];
				res %= mod;
			}
			good_mask = good_mask << 1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		String s = scan.next();	
		d = new int[n+1][mask_l];
		
		scan.close();
		
		System.out.println(Solution(n, s));
		
	}

}
