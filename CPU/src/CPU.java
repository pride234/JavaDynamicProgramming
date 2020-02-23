import java.util.Scanner;


public class CPU {

	static int Solution(int[][] data) {
		
		
		int t = 1;
		boolean change = true;
		boolean stop = true;

		int l = data.length;
		int h = 0;
		int min = 0;
		int[][] C = new int[5][l];
		
		while (h < l) {
			
			if (change) {
				
				for (int i = 0; i<5; i++) {
					
					if(C[i][0] == 0) continue;
					
					C[i][0]--;
					if(C[i][0] == 0) {
						
						for (int j = 1; j<l; j++) {
							
							if(C[i][j] == 0) break;
							C[i][j-1] = C[i][j];
						}
					}
				}
			}
			
			if (data[h][t] == 0) {
				
				t++;
				change = true;
				continue;
			}
			
			for (int i = 0; i<5; i++) {
				
				int sum = 0;

				for (int j = 0; j<l; j++) sum += C[i][j];

				if (sum + data[h][t] > 10) {
					
					stop = true;
					continue;
				}
				
				for (int j = 0; j<l; j++) {
					
					if(C[i][j] != 0) continue;
					else {

						C[i][j] = data[h][t];
						stop = false;
						break;
					}
				}
				break;
			}

			if(stop) return -1;
			
			if (h + 1 < l) {
				
				if(data[h][t] != 0) {
					
				change = false;
				h++;
				int amount = 0;
				
				for (int i = 0; i<5; i++) if (C[i][0] != 0) amount++;
				
				min = Math.max(min, amount);
				
				continue;
				
				}
			}
			
			t++;
			h++;
			change = true;

			int amount = 0;
			
			for (int i = 0; i<5; i++) if (C[i][0] != 0) amount++;
			
			min = Math.max(min, amount);						
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		int[][][] data = new int[T][][];
		
		for (int i = 0; i<T; i++) {
			
			data[i] = new int[scan.nextInt()][5001];

			for (int j = 0; j<data[i].length; j++) data[i][j][scan.nextInt()] = scan.nextInt();
		}
		
		scan.close();
		
		for (int test = 0; test<T; test++) System.out.println("#" + (test+1) + " " + Solution(data[test]));
	}
}
