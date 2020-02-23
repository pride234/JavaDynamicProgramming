import java.util.Scanner;

public class Habr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sequence();
	}
//-----------------------------------------------------------------------------------------------------|	

	public static void Fibonacci() {

		int a = 1; 
		int b = 1;
		int temp = 0;
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		for (int i = 0; i<n; i++) {
			
			temp = b;
			b = a+b;
			a = temp;
		}
		
		System.out.println(b);		
	}
//-----------------------------------------------------------------------------------------------------|	
	
	public static void Sequence() {
		
		int[] A = new int[] {2, 8, 5, 9, 12, 6};
		int[] L = new int[A.length];
		int[] N = new int[A.length];
		int t;
		
		L[0] = 1;
		
		for (int i = 1; i < L.length; i++) {
			
			t = -1;
			for (int j = 0; j<i; j++) if(A[i] > A[j]) t = Math.max(L[j], t);
			
			L[i] = t+1;
			
		}
		
		int max = L[0];
		
		for (int counter = 1; counter < L.length; counter++)
		{
		     if (L[counter] > max)
		    	 max = L[counter];
		}
		
		System.out.println(max);
		
		for(int i = 0; i<N.length; i++) System.out.println(N[i]); 
	}
}
