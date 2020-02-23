import java.util.Scanner;

public class BrokenCalc {	
	
	static int[] digits;
	static int[] operations;
	
	static int Solution(int Max, int Need) {
		
		int[][] dp = new int[Max/2][1000];
		int[] predic = new int[1000];
		
		for (int i = 0; i < predic.length; i++) predic[i] = CalcPredic(i);
		if (predic[Need] != 0) return predic[Need];
		
		int num   = 0;
		int press = 0;
		int min   = 1000000;
		
		for(int i = 0; i < predic.length; i++) {
			
			if(predic[i] == 0) continue;
			
			for(int j = 0; j < predic.length; j++) {
				
				if (predic[j] == 0) continue;
				
				press = predic[i] + predic[j] + 1;
				
				for(int k = 0; k < operations.length; k++) {
					
					if (operations[k] == 0) continue;
					
					num = Operation(i, j, k);
					
					if ((num < 0) || (num > 999)) continue;

					if (num == Need) min = Math.min(press + 1, min);
					
					if (dp[0][num] == 0) dp[0][num] = press;
					else dp[0][num] = Math.min(dp[0][num], press);
				}						
			}			
		}

		for (int step = 1; step < Max/2; step++) {
			
			for(int i = 0; i < predic.length; i++) {
				
				if(dp[step-1][i] == 0) continue;
				
				for(int j = 0; j < predic.length; j++) {
					
					if (predic[j] == 0) continue;
					
					press = dp[step-1][i] + predic[j] + 1;
					
					for(int k = 0; k < operations.length; k++) {
						
						if (operations[k] == 0) continue;
						
						num = Operation(i, j, k);
						
						if ((num < 0) || (num > 999)) continue;

						if (num == Need) min = Math.min(press + 1, min);
						
						if (dp[step][num] == 0) dp[step][num] = press;
						else dp[step][num] = Math.min(dp[step][num], press);
					}						
				}			
			}
		}
		if (min > Max) return -1;
		return min;
	}
	
	static boolean IsDigit(int n) {
		
		for(int i = 0; i < digits.length; i++) if (digits[i] == n) return true;
		
		return false;
	}
	
	static int Operation(int i, int j, int k) {
		
		switch(k) {
		
		case 0: return i+j;
		
		case 1: return i-j;
		
		case 2: return i*j;
		
		case 3: if (j != 0) return i/j;			

		}
		
		return -1;
	}

	static int CalcPredic (int num) {
		
		int n = 0;
		int dig = 0;
		
		do {
			
			dig = num % 10;
			num /= 10;

			if(IsDigit(dig)) n++;

			else return 0;
			
		}while(num != 0);
		
		return n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		digits = new int[N];
		
		for(int i = 0; i<N; i++) digits[i] = scan.nextInt();
		
		operations = new int[4];
		
		scan.nextInt();
		String oper = scan.nextLine();
		
		for(int i = 0; i<oper.length(); i++) {
			
			if(oper.charAt(i) == '+') operations[0] = 1;
			if(oper.charAt(i) == '-') operations[1] = 1;
			if(oper.charAt(i) == '*') operations[2] = 1;
			if(oper.charAt(i) == '/') operations[3] = 1;
		}
		
		int Max  = scan.nextInt();
		int Need = scan.nextInt();
		
		scan.close();
		
		System.out.println(Solution(Max, Need));
	}		
}
//--------------------------------------------------------------------------------------------------------------------|

