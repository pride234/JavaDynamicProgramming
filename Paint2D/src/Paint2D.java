import java.util.Scanner;

public class Paint2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		scan.close();
		
//		int A = 4, B = 6;
				
		if ((A == 1) & (B == 1)) System.out.println(4);
		else System.out.println(Min(A,B));
		
	}

	public static int Min(int A, int B) { 

		if (A > B) {
			
			int temp = A;
			A = B;
			B = temp;
		}
		
		if ((A == 1) &  (B == 2)) return 6;
		if ((A == 1)) {
			
			if ((B&1) == 0) return (Min(A, B/2) + 4);
			else return (4 + 2*(B-1));		
		}
		if ((B&1) == 0) return (Min(A, B/2) + 4);
		if ((A&1) == 0) return (Min(A/2, B) + 4);
				
		return ((4 + 2*(B-1) + 2*A));
	}
}
