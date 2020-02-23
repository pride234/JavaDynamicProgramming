import java.util.Scanner;

public class Dict {

	private static int[] A2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		int N = scan.nextInt();
		int[] data = new int[N];
		
		for(int i = 0; i<N; i++) {
			
			data[i] = scan.nextInt();
			sum += data[i];
		}
		
		scan.close();
		
		int sum2 = 0;
		int[] A = new int[sum+1];
		A[0] = 0;
		for (int j = 1; j<=sum; j++) A[j] = -1;
		
		for(int i = 0; i<data.length; i++ ){
			
			A2 = new int[sum+1];
			for (int j = 0; j<=sum; j++) A2[j] = -1;
			
			for (int j = 0; j<sum+1; j++) {
				
				if (A[j] == -1) continue;
				sum2 = j + A[j];
				add(A[j], sum2);
				add(A[j] + data[i], sum2);
				add(A[j], sum2 + data[i]);
			}
			
			A = A2;
		}	
		
		System.out.println(A[0]);
	}
	
	public static void add(int s1, int s2){
		
		if(s1 > s2) {
			
			int temp = s1;
			s1 = s2; 
			s2 = temp;
		}
		
		int d = s2 - s1;
		
		if(A2[d] != -1) A2[d] = Math.max(A2[d], s1);
		else A2[d] = s1;
	}
}
