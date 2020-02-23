import java.util.Scanner;

public class Boulder {
	
	int width;
	int depht;
	int hight;

	static Boulder[] Boulders;
	static int[] wastaken;
	static int[] copied;
 	
	Boulder(int w, int d, int h) {
		
		if(w < d) {
			
			int temp = w;
			w = d;
			d = temp;
		}
		
		this.width = w;
		this.depht = d;
		this.hight = h;
	}
	
	static boolean IsThere(int i, int w, int d, int h){
		
		for(int j = 0; j<i; j++) {

			if(Boulders[j] == null) continue;
			
			if ( (Boulders[j].width == w) && (Boulders[j].depht == d) && (Boulders[j].hight == h)) {
				
				copied[j]++;
				return true;
			}
			
		}
		
		return false;
	}
	
	boolean IsSmaller(Boulder B) {
		
		if( (this.width <= B.width) & (this.depht <= B.depht)) return true;
		
		return false;
	}
	
	static void IsTaken(int i, int bit) {
			
		wastaken[i - i%3    ] = bit;
		wastaken[i - i%3 + 1] = bit;
		wastaken[i - i%3 + 2] = bit;			
	}
	
	static int Top(int i) {
		
		int max = 0;
		if(Boulders[i] == null) return 0;
		
		for (int j = 0; j < i - i%3; j+=3) {
			
			if(Boulders[j] == null) continue;			 
			
			if(Boulders[i].IsSmaller(Boulders[j]) && (wastaken[j] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Top(j) + Boulders[j].hight);
				IsTaken(j, 0);
			}

			if(Boulders[i].IsSmaller(Boulders[j+1]) && (wastaken[j+1] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Top(j+1) + Boulders[j+1].hight);
				IsTaken(j, 0);
			}

			if(Boulders[i].IsSmaller(Boulders[j+2]) && (wastaken[j+2] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Top(j+2) + Boulders[j+2].hight);
				IsTaken(j, 0);
			}
		}

		for (int j = i + 3 - i%3; j < Boulders.length; j+=3) {

			if(Boulders[j] == null) continue;			 
			
			if(Boulders[i].IsSmaller(Boulders[j]) && (wastaken[j] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Top(j) + Boulders[j].hight);
				IsTaken(j, 0);
			}

			if(Boulders[i].IsSmaller(Boulders[j+1]) && (wastaken[j+1] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Top(j+1) + Boulders[j+1].hight);
				IsTaken(j, 0);
			}

			if(Boulders[i].IsSmaller(Boulders[j+2]) && (wastaken[j+2] == 0)) {
				
				IsTaken(j, 1);
				max = Math.max(max, Top(j+2) + Boulders[j+2].hight);
				IsTaken(j, 0);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int N = 3*(scan.nextInt());
		
		int w, d, h;
		Boulders = new Boulder[N];
		wastaken = new int[N];
		copied   = new int[N];
		
		for (int i = 0; i < N; i+=3) {
			
			w = scan.nextInt();
			d = scan.nextInt();
			h = scan.nextInt();
			
			if(IsThere(i, w, d, h)) continue;
			
			Boulders[i]   = new Boulder(w, d, h);
			Boulders[i+1] = new Boulder(d, h, w);
			Boulders[i+2] = new Boulder(h, w, d);						

		}
		
		scan.close();
		
		int maxhight = -1;
		
		for (int i = 0; i<N; i++) {
			
			if(copied[i] != 0) {
				
				Boulders[i - i%3]    .hight  *= copied[i] + 1;
				Boulders[i - i%3 + 1].hight  *= copied[i] + 1; 
				Boulders[i - i%3 + 2].hight  *= copied[i] + 1;
			}
		}
		
		for (int i = 0; i < N; i+=3) {
			
			if(Boulders[i] == null) continue;
			for (int j = 0; j<N; j++) wastaken[j] = 0;
			
			IsTaken(i, 1);
			
			maxhight = Math.max(maxhight, Top(i)   + Boulders[i]  .hight);
			maxhight = Math.max(maxhight, Top(i+1) + Boulders[i+1].hight);
			maxhight = Math.max(maxhight, Top(i+2) + Boulders[i+2].hight);
		}
		
		System.out.println(maxhight);
	} 
}
