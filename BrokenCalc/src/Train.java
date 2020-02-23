import java.util.Scanner;

public class Train {
		
	static int[] digits;
	static int[] operations;
	
	static int Solution(int Max, int Need) {
		
		int[][] dp = new int[Max/2][1000];
		int[] pre = new int[1000];
		
		for (int i = 0; i<pre.length; i++) pre[i] = CalcPre(i);
		if(pre[Need] != 0) return pre[Need];
		
		int press = 0;
		int min = 100000;
		int num = 0;
		
		for (int i = 0; i<pre.length; i++) {
			
			if (pre[i] == 0) continue;
			
			for (int j = 0; j<pre.length; j++) {
				
				if(pre[j] == 0) continue;
		
				press = pre[i] + pre[j] + 1;
				
				for (int k = 0; k<4; k++) {

					if(operations[k] == 0) continue;
					
					num = Operations(i, j, k);
					
					if ((num < 0) || (num > 999)) continue;
					
					if(num == Need) min = Math.min(min, press + 1);
					
					if(dp[0][num] != 0) dp[0][num] = Math.min(dp[0][num], press); 
					else dp[0][num] = press;					
				}
			}
		}
		
		for (int step = 1; step<Max/2; step++) {
			
			for (int i = 0; i<pre.length; i++) {
				
				if (dp[step-1][i] == 0) continue;
				
				for (int j = 0; j<pre.length; j++) {
					
					if(pre[j] == 0) continue;
			
					press = dp[step-1][i] + pre[j] + 1;
					
					for (int k = 0; k<4; k++) {
						
						if(operations[k] == 0) continue;
						
						num = Operations(i, j, k);
						
						if ((num < 0) || (num > 999)) continue;
						
						if(num == Need) min = Math.min(min, press + 1);
						
						if(dp[step][num] != 0) dp[step][num] = Math.min(dp[step][num], press); 
						else dp[step][num] = press;					
					}
				}
			}
		}
		
		if (min > Max) return -1;
		else return min;
	}
		
	static int CalcPre(int num) {
		
		int d;
		int amount = 0;
		
		do {
			d = num%10;
			num /= 10;
			
			if(IsDigit(d)) amount++;
			else return 0;
			
		} while (num != 0);
		
		return amount;
	}
	
	static boolean IsDigit(int d) {
		
		for (int i = 0; i<digits.length; i++) if (digits[i] == d) return true;
		
		return false;
	}
	
	static int Operations(int i, int j, int k) {
		
		switch(k) {
		
		case 0: return i+j;
		case 1: return i-j;
		case 2: return i*j;
		case 3: if(j != 0) return i/j;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();		
		digits = new int[n];
		operations = new int[4];
		
		for (int i = 0; i<n; i++) digits[i] = scan.nextInt();
		
		scan.nextInt();
		String op = scan.nextLine();
		
		for (int i = 0; i<op.length(); i++) {
			
			if(op.charAt(i) == '+') operations[0] = 1;
			if(op.charAt(i) == '-') operations[1] = 1;
			if(op.charAt(i) == '*') operations[2] = 1;
			if(op.charAt(i) == '/') operations[3] = 1;
		}
		
		
		int Max = scan.nextInt();
		int Need = scan.nextInt();
		
		scan.close();
		
		System.out.println(Solution(Max, Need));
	}	
}
