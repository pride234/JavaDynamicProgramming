import java.util.Scanner;


public class Train {

	static Train[] Boulders;
	static int[] wastaken;
	static int[] copied;

	
	int width;
	int depth;
	int hight;
		
	Train(int w, int d, int h) {
		
		if(w < d) {
			
			int temp = w; 
			w = d;
			d = temp;
		}
		
		this.width = w;
		this.depth = d;
		this.hight = h;
	}
	
	static boolean IsThere(int w, int d, int h, int i) {
		
		for(int j = 0; j<i; j++) {
			
			if (Boulders[j] == null) continue;
			if ((w == Boulders[j].width) && (d == Boulders[j].depth) && (h == Boulders[j].hight)) {
				
				copied[j - j%3]++;
				copied[j - j%3 + 1]++;
				copied[j - j%3 + 2]++;
				
				return true;
			}
		}
		
		return false;
	}
	
	static int Top(int i) {
		
		if (Boulders[i] == null) return 0;
		
		int max = 0;
		
		for (int j = 0; j<i - i%3; j+=3) {
			
			if (Boulders[i].ISmaller(Boulders[j]) && (wastaken[j] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Boulders[j].hight + Top(j));
				IsTaken(j, 0);
			}

			if (Boulders[i].ISmaller(Boulders[j+1]) && (wastaken[j] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Boulders[j+1].hight + Top(j+1));
				IsTaken(j, 0);
			}

			if (Boulders[i].ISmaller(Boulders[j+2]) && (wastaken[j] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Boulders[j+2].hight + Top(j+2));
				IsTaken(j, 0);
			}
		}
		
		for (int j = i + 3 - i%3; j<Boulders.length; j+=3) {
			
			if (Boulders[i].ISmaller(Boulders[j]) && (wastaken[j] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Boulders[j].hight + Top(j));
				IsTaken(j, 0);
			}

			if (Boulders[i].ISmaller(Boulders[j+1]) && (wastaken[j] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Boulders[j+1].hight + Top(j+1));
				IsTaken(j, 0);
			}

			if (Boulders[i].ISmaller(Boulders[j+2]) && (wastaken[j] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Boulders[j+2].hight + Top(j+2));
				IsTaken(j, 0);
			}
		}
		
		return max;
	}
	
	boolean ISmaller(Train B) {
		
		if (B == null) return false;
		
		if ((this.width <= B.width) && (this.depth <= B.depth)) return true;
		
		return false;
	}
	
	static void IsTaken(int i, int bit) {
		
		wastaken[i - i%3]     = bit;
		wastaken[i - i%3 + 1] = bit;
		wastaken[i - i%3 + 2] = bit;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		int[][] arr = new int[T][];
		
		for (int i = 0; i<T; i++) {
			
			arr[i] = new int[3*scan.nextInt()];
			
			for (int j = 0; j<arr[i].length; j++) arr[i][j] = scan.nextInt();
		}

		scan.close();		
		
		for (int test = 0; test < T; test++) {
			
			int N = arr[test].length;
			
			Boulders = new Train[N];
			wastaken = new int[N];
			copied = new int[N];
			
			int w = 0, d = 0, h = 0;
			int k = 0;
			
			for (int i = 0; i<N; i+=3) {
				
				
				w = arr[test][k];
				d = arr[test][k+1];
				h = arr[test][k+2];				
				
				k+=3;
				
				if(IsThere(w, d, h, i)) continue;

				Boulders[i]   = new Train(w, d, h);
				Boulders[i+1] = new Train(d, h, w);
				Boulders[i+2] = new Train(h, w, d);
			}
			
			
			int max = 0;
			
			for (int i = 0; i<N; i+=3) {
				
				if(Boulders[i] == null) continue;
				
				if (copied[i] != 0) {
					
					Boulders[i]  .hight *= copied[i] + 1;
					Boulders[i+1].hight *= copied[i] + 1;
					Boulders[i+2].hight *= copied[i] + 1;
					
				}
				
				for (int j = 0; j<N; j++) wastaken[j] = 0;
				
				IsTaken(i, 1);
				
				max = Math.max(max, Boulders[i]  .hight + Top(i));
				max = Math.max(max, Boulders[i+1].hight + Top(i+1));
				max = Math.max(max, Boulders[i+2].hight + Top(i+2));
			}
			
			System.out.println("#" + (test + 1) + " " + max);
			
		}
		
	}
}
