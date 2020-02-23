import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		scan.close();
		
//		String str = "g2 a1";		
		
		int p1 = str.charAt(1) - 48; 
		int p2 = str.charAt(0) - 96;
		
		int h1 = str.charAt(4) - 48;
		int h2 = str.charAt(3) - 96;
 		
		int[][] cb = new int[9][9]; 
		cb[p1][p2]   = 1;
		cb[h1][h2]   = 1;
		

		double temp = 0;
		if (p1 == 2) {
			
			temp = WhoWins(cb, p1, p2, h1, h2);

			if (temp == 1) System.out.println(1);
			else if ((temp == 0.5) & (cb[p1+1][p2] != 1)) {
				
				temp = WhoWins(cb, p1+1, p2, h1, h2);
				if (temp == 1) System.out.println(1); 
				if (temp == 0.5) System.out.println(0.5); 
				if (temp == -1) System.out.println(0.5); 
			}

			else if ((temp == -1) & (cb[p1+1][p2] != 1)) {

				temp = WhoWins(cb, p1+1, p2, h1, h2);
				if (temp == 1) System.out.println(1); 
				if (temp == 0.5) System.out.println(0.5); 
				if (temp == -1) System.out.println(-1); 
			}
			else {
				
				if (temp == -1) System.out.println(-1);
				if (temp == 0.5) System.out.println(0.5);				
			}

		} else{
			temp = WhoWins(cb, p1, p2, h1, h2);
			if (temp == -1) System.out.println(-1);
			if (temp == 1) System.out.println(1);
			if (temp == 0.5) System.out.println(0.5);
		}
	}

	public static double WhoWins(int[][] cb, int p1, int p2, int h1, int h2) {

		double t = 1;
		double temp;
		int t1 = h1, t2 = h2, t3 = p1, t4 = p2;
		
		if(p1<8) {
			
				if ((p1+1 <= 8) & (p2+1 <= 8)) if (cb[p1+1][p2+1] == 1) return 1;
				if ((p1+1 <=8 ) & (p2-1 >= 1)) if (cb[p1+1][p2-1] == 1) return 1;
				if (cb[p1+1][p2] == 0) {

				cb[p1][p2] = 0;
				p1++;
				cb[p1][p2] = 1;				
			}else return 0.5;			

			if((h1+2<= 8) & (h2+1 <= 8)) { // 1
				
				if (cb[h1+2][h2+1] == 0) {

					cb[h1][h2] = 0;
					h1 += 2; h2 += 1;
					cb[h1][h2] = 1;
					temp = WhoWins(cb, p1, p2, h1, h2); 
					if (temp == -1) return -1;
					else {
						t = Math.min(t, temp); 				

						cb[h1][h2] = 0;
						h1 = t1; h2 = t2;
						cb[h1][h2] = 1;
					}
				} else return -1;
			}

			if((h1+1<= 8) & (h2+2 <= 8)) { // 2
				
				if (cb[h1+1][h2+2] == 0) {

					cb[h1][h2] = 0;
					h1 += 1; h2 += 2;
					cb[h1][h2] = 1;	
					temp = WhoWins(cb, p1, p2, h1, h2); 
					if (temp == -1) return -1;
					else {
						t = Math.min(t, temp); 				

						cb[h1][h2] = 0;
						h1 = t1; h2 = t2;
						cb[h1][h2] = 1;
					}
				} else return -1;
			}

			if((h1-1 >= 1) & (h2+2 <= 8)) { // 3
				
				if (cb[h1-1][h2+2] == 0) {

					cb[h1][h2] = 0;
					h1 -= 1; h2 += 2;
					cb[h1][h2] = 1;	
					temp = WhoWins(cb, p1, p2, h1, h2); 
					if (temp == -1) return -1;
					else {
						t = Math.min(t, temp); 				

						cb[h1][h2] = 0;
						h1 = t1; h2 = t2;
						cb[h1][h2] = 1;
					}
				} else return -1;
			}

			if((h1-2 >= 1) & (h2+1 <= 8)) { // 4
				
				if (cb[h1-2][h2+1] == 0) {

					cb[h1][h2] = 0;
					h1 -= 2; h2 += 1;
					cb[h1][h2] = 1;	
					temp = WhoWins(cb, p1, p2, h1, h2); 
					if (temp == -1) return -1;
					else {
						t = Math.min(t, temp); 				

						cb[h1][h2] = 0;
						h1 = t1; h2 = t2;
						cb[h1][h2] = 1;
					}
				} else return -1;
			}

			if((h1-2 >= 1) & (h2-1 >= 1)) { // 5
				
				if (cb[h1-2][h2-1] == 0) {

					cb[h1][h2] = 0;
					h1 -= 2; h2 -= 1;
					cb[h1][h2] = 1;	
					temp = WhoWins(cb, p1, p2, h1, h2); 
					if (temp == -1) return -1;
					else {
						t = Math.min(t, temp); 				

						cb[h1][h2] = 0;
						h1 = t1; h2 = t2;
						cb[h1][h2] = 1;
					}
				} else return -1;
			}

			if((h1-1 >= 1) & (h2-2 >= 1)) { // 6
				
				if (cb[h1-1][h2-2] == 0) {

					cb[h1][h2] = 0;
					h1 -= 1; h2 -= 2;
					cb[h1][h2] = 1;	
					temp = WhoWins(cb, p1, p2, h1, h2); 
					if (temp == -1) return -1;
					else {
						t = Math.min(t, temp); 				

						cb[h1][h2] = 0;
						h1 = t1; h2 = t2;
						cb[h1][h2] = 1;
					}
				} else return -1;
			}

			if((h1+1 <= 8) & (h2-2 >= 1)) { // 7
				
				if (cb[h1+1][h2-2] == 0) {

					cb[h1][h2] = 0;
					h1 += 1; h2 -= 2;
					cb[h1][h2] = 1;	
					temp = WhoWins(cb, p1, p2, h1, h2); 
					if (temp == -1) return -1;
					else {
						t = Math.min(t, temp); 				

						cb[h1][h2] = 0;
						h1 = t1; h2 = t2;
						cb[h1][h2] = 1;
					}
				} else return -1;
			}

			if((h1+2 <= 8) & (h2-1 >= 1)) { // 8
				
				if (cb[h1+2][h2-1] == 0) {

					cb[h1][h2] = 0;
					h1 += 2; h2 -= 1;
					cb[h1][h2] = 1;	
					temp = WhoWins(cb, p1, p2, h1, h2); 
					if (temp == -1) return -1;
					else {
						t = Math.min(t, temp); 				

						cb[h1][h2] = 0;
						h1 = t1; h2 = t2;
						cb[h1][h2] = 1;
					}
				} else return -1;
			}			

			cb[p1][p2] = 0;
			p1 = t3; p2 = t4;
			cb[p1][p2] = 1;	
		}

		return t;
	}
}
