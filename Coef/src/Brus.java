
public class Brus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] cost = new double[] {0, 1, 2.32, 3.25, 4.125};
		double[] r = new double[5];
		r[0] = 0;
		
		System.out.println(R(r, cost, 4));		
	}

	public static double R(double[] r, double[]cost, int n) {
		
		if (n == 0) return cost[0];
		if (n == 1) return cost[1];
				
		for (int i = 1; i<=n; i++) {
			
			if (r[i] != 0) continue;
			double t = -1000;
			for (int k = 1; k<=i; k++) {
				
				double temp = R(r, cost, i-k);
				if (t >= cost[k] + temp);
				else t = cost[k] + temp;
			} 

			r[i] = t;
		}
		return r[n];
	}
}
