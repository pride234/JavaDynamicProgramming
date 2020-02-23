import java.util.Scanner;

public class Segments {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] segments = new int[N];
		
		for(int i = 0; i<N; i++) {
			
			segments[i] = scan.nextInt();
			
			for (int j = i; j > 0; j--) {
				
				if (segments[j] > segments[j-1]) {
					
					int temp = segments[j-1];
					segments[j-1] = segments[j];
					segments[j] = temp;
				}
			}
		}
		
		scan.close();
		
		long[][] A = new long[1001][N];
		int t = 0;
		
		for (int i = 0; i<N; i++) {
			
			t = i;
			while(A[segments[i]][t] != 0) t++;
			A[segments[i]][t] = 1L << N-1-i;
		}
		
		for(int i = 1; i<1000; i++) {
			
			for(int j = 0; j<N; j++) {
				
				if((A[i][j] == 0)) break;
				for(int k = 0; k<N; k++) {
					
					if(((1L << k) & A[i][j]) != 0) {
						
						for (int l = N - k; l<N; l++) {
							
							t = j;
							while(A[i + segments[l]][t] != 0) t++;
							//if (t+1 >= N) break;
							A[i + segments[l]][t] = A[i][j] | (1L << N-1-l);
						}
						break;
					}

				}
			}
		}
		
		int res = 0;
		for(int i = 1000; i>=0; i--) {
			
			if (res != 0) break;
			for (int j = 0; j<N-1; j++) {

				if (res != 0) break;				
				if(A[i][j+1] == 0) break;
				
				for (int k = j + 1 ; k<N; k++) {
					
					if(A[i][k] == 0) break;
					if((A[i][j] & A[i][k]) == 0) {
								
						for (int l = 0; l<N; l++) if((A[i][j] & (1<<l)) != 0) res += segments[N - 1 - l];
						break;
					}
				}	
			}
		}
		
		System.out.println(res);
	}	
}
