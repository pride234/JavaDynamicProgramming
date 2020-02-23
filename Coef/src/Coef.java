import java.util.Scanner;

public class Coef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		scan.close();
		int[][] C = new int[n+1][k+1];		
		
		Bottom_Up(n, k);
		System.out.println(Top_Down(C, n, k));
	}
	
	public static void Bottom_Up(int n, int k){
			
		int[][] C = new int[n+1][k+1];		
		
		for (int i = 0; i <= n; i++) {
			
			C[i][0] = 1; 
			if (i<=k) { 
				
				C[i][i] = 1;			
				for (int j = 1; j<Math.min(k, i); j++) C[i][j] = C[i-1][j] + C[i-1][j-1];
			
			} else for (int j = 1; j<=k; j++) C[i][j] = C[i-1][j] + C[i-1][j-1];
			
			
		}
		System.out.println(C[n][k]);		
	}

	public static int Top_Down (int C[][], int n, int k) {
		
		if ((k == 0) || (n == k) || (n == 0)) C[n][k] = 1;
		if (C[n][k] == 0) {
			
			return	C[n][k] = Top_Down(C, n-1, k) + Top_Down(C, n-1, k-1);
			
		}
		else return C[n][k];
	}
}
