import java.util.Scanner;

public class Oil {

	static int max_value = 5_000_000;
	static int max_M = 50;
	static int max_N = 25;		
	
	static int Sum (int[] a, int start, int end) {
		
		int res = 0;
		
		for (int i = start; i<=end; i++) res += a[i];
		
		return res;
	}
	
	static int Patrition(int k, int n, int[] deps) {
		
		  int res = max_value;
		  for(int offset = 0; offset < n; ++offset) {
		    int l_min = 0;
		    for(int r_min = l_min; r_min < n; ++r_min) {
		      int min_sum = Sum (deps, l_min, r_min);

		      int[][] dp = new int [k][n];
		      for (int s = 0; s < k; ++s) {
		        for (int q = 0; q < n; ++q) {
		          dp[s][q] = max_value;
		        }
		      }
		      // assuming that current sum is a target sum
		      dp[0][r_min-l_min] = min_sum;

		      for(int p = 1; p < k; ++p) {
		        for(int l_max = r_min; l_max < n; ++l_max) {
		          for(int r_max = l_max; r_max < n; ++r_max) {
		            int max_sum = Sum(deps, l_max+1, r_max);

		            if (max_sum >= min_sum) {
		              dp[p][r_max] = Math.min(dp[p][r_max], Math.max(dp[p-1][l_max], max_sum));
		            }

		          } // l_maxs
		        } // r_maxs
		      } // partitions

		      // skip incorrect partitioning, when not all K partitions were used
		      if (dp[k-1][n-1] == max_value) continue;

		      // update difference
		      res = Math.min (res, dp[k-1][n-1] - min_sum);
		    } // end min sum seg
		    int[] tmp = new int[n];
		    for (int i = 0; i < n; ++i) {
		      int new_idx = i + n - 1;

		      tmp[new_idx % n] = deps[i];
		    }

		    for(int i = 0; i < n; ++i) deps[i] = tmp[i];

		  } // start min sum seg
		  return res;
		}
		
		
		/*		int res = max_value;
		
		for (int offset = 0; offset < M; offset++) {
			
			int l_min = 0;
			
			for (int r_min = l_min; r_min < M; r_min++) {
				
				int min_sum = Sum (C, l_min, r_min);
				
				int[][] dp = new int [N][M];
				
				for (int s = 0; s < N; s++) {
					
					for (int q = 0; q<M; q++) {
						
						dp[s][q] = max_value;
					}
				}
				
				dp[0][r_min - l_min] = min_sum;
				
				for (int p = 1; p<N; p++) {
					
					for (int l_max = r_min; l_max < M; l_max++) {
						
						for(int r_max = l_max; r_max < M; ++r_max) {

							int max_sum = Sum(C, l_max+1, r_max);

							if (max_sum >= min_sum) dp[p][r_max] = Math.min(dp[p][r_max], Math.max(dp[p-1][l_max], max_sum));
				              

				        }						
					} 
				}
			}
			
		}
		
		return 0;
	}*/
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		int[][] data = new int[T][];
		
		for (int i = 0; i<T; i++) {
			
			int temp = scan.nextInt();
			data[i] = new int[scan.nextInt() + 1];
			data[i][0] = temp;
			
			for (int j = 1; j<data[i].length; j++) data[i][j] = scan.nextInt();
		} 
		
		scan.close();
		
		for (int test = 0; test<T; test++) {
			
			int N = data[test][0];
			int M = data[test].length - 1;
			
			int[] C = new int[M];
			
			for (int i = 1; i<M+1; i++) C[i-1] = data[test][i];
				
			System.out.println(Patrition(N, M, C));
		}
	}
}
