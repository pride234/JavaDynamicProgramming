import java.util.Scanner;

public class Segments {
	
	public static int[] A;
	public static int[] A2;
	
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
		
		A = new int[1001];
		A[0] = 0;
		int sum1, sum2;
		
		for (int i = 0; i<N; i++) {
			
			A2 = new int[1001];
			
			int j = 0; 
			while ( (A[j] != 0)){
				
				sum2 = j + A2[j];
				Add(A2[j], sum2);
				Add(A2[j] + segments[i], sum2);
				Add(A2[j], sum2 + segments[i]);
				j++;
			}
			A = A2;
		}
		System.out.println(A[0]);
	}
	
	public static void Add(int s1, int s2) {
		
		if(s1>s2) {
			
			int temp = s1;
			s1 = s2;
			s2 = temp;
		}
		int d = s2-s1;
		
		A2[d] = Math.max(A2[d], s1);		
	}
}
