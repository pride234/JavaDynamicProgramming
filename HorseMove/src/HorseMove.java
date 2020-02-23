import java.util.Scanner;

public class HorseMove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		if (n == 1) System.out.println(8);
		else {
		
		int[][] phone = new int[][] {
			{7,  8,  9},
			{4,  5,  6},
			{1,  2,  3},
			{-1, 0, -1}};
			
		int[] a = new int[10];
/*		for (int i = 0; i<=9;) {
						
			if (i != 5) amount += Amount(n-1, i);
		}
*/
//		for (int i = 0; i<10; i++) if ((i != 8) & (i!=0)) a[i] = 1;

		a[0] = 2;
		a[1] = 1;
		a[2] = 2;
		a[3] = 1;
		a[4] = 2;
		a[5] = 0;
		a[6] = 2;
		a[7] = 2;
		a[8] = 2;
		a[9] = 2;
		
		int[] old = new int[10];
		
		for (int i = 2; i<n; i++) {
			
			old[0] = a[0];
			a[0] = (a[4] + a[6]);
			
			old[1] = a[1];
			a[1] = (a[6] + a[8]);
			
			old[2] = a[2];
			a[2] = (a[7] + a[9]);
			
			old[3] = a[3];
			a[3] = (a[4] + a[8]);
			
			old[4] = a[4];
			a[4] = (old[0] + old[3] + a[9]);
			
			old[6] = a[6];
			a[6] = (old[0] + old[1] + a[7]);
			
			a[7] = (old[2] + old[6]);
			a[8] = (old[1] + old[3]);
			a[9] = (old[2] + old[4]);
		}
		
		long b = 0;

		for (int i = 0; i<10; i++) b += a[i];
			
		System.out.println(b);
		}
	}
	
/*	public static int Amount (int n, int end) {		
		
		if (n == 1) return 7;
		int amount = 0;
		if (end == 0) amount = Amount(n-1, 4) + Amount(n-1, 6);
		if (end == 1) amount = Amount(n-1, 6) + Amount(n-1, 8);
		if (end == 2) amount = Amount(n-1, 7) + Amount(n-1, 9);
		if (end == 3) amount = Amount(n-1, 4) + Amount(n-1, 8);
		if (end == 4) amount = Amount(n-1, 3) + Amount(n-1, 9) + Amount(n-1, 0);
		if (end == 6) amount = Amount(n-1, 1) + Amount(n-1, 7) + Amount(n-1, 0);
		if (end == 7) amount = Amount(n-1, 2) + Amount(n-1, 6);
		if (end == 8) amount = Amount(n-1, 1) + Amount(n-1, 3);
		if (end == 9) amount = Amount(n-1, 2) + Amount(n-1, 4);

		
		return amount;
	}*/
}
