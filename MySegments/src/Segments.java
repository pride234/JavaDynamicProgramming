import java.util.Scanner;

public class Segments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		long[] segments = new long[N];
		
		for (int i = 0; i<N; i++) segments[i] = scan.nextInt();
		
		scan.close();
		
		System.out.println(MaxLenLess31(N, segments));
		
		//for (int i = 0; i<n; i++) System.out.println(i);
		
	}
	
	public static int MaxLenLess31(int n, long[] segments) {

		long N = 1L << n;
		long temp1 = 0, temp2 = 0;
		int sum1 = 0, sum2, max = -1;
		
		for (long i = 0L; i<N; i++){
			
//			temp1 |= (1<<i);
			
			sum1 = 0;
			for (long j = 0L; j<segments.length; j++) if ((i&(1<<j)) != 0) sum1 += segments[(int)j];
			
/*			for (long j = 0L; j<N; j++) {
				
				sum2 = 0;
//				temp2 |= (1<<j);
				if(((i&j) == 0)) {
					
					for(long k = 0L; k<segments.length; k++) if((j&(1<<k)) != 0) sum2 += segments[(int)k];
					if(sum1 == sum2) max = Math.max(max, sum1);
				}
			} */
		}

		return sum1;
	}

	public static int MaxLenLarger31(int N, int[] segments) {

		long[] bl = new long[2];
		bl[0] = 0;
		bl[1] = 1 << (N-31);
		
		
		return 0;
	}
}

/*public class Segments {

    public static void main(String[] args) {
        // write your code here
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] input_array = new int[N];
		
		for (int i = 0; i<N; i++) input_array[i] = scan.nextInt();
		
		scan.close();
		
        int max_len = get_sub_seq(input_array);
        System.out.print(max_len);
    }

    public static int get_sub_seq(int[] input_array) {
        int N = 1 << input_array.length;
        int[] res = new int[N];
        int sum;
        for (int mask = 0; mask < N; mask++) {
            sum = 0;
            for (int j = 0; j < input_array.length; j++)
                if ((mask & (1 << j)) != 0)
                    sum += input_array[j];
            res[mask] = sum;
        }
        int max = 0;
        for (int i = 0; i < res.length; i++)
            for (int j = i + 1; j < res.length; j++)
                if (((i & j) == 0) & (res[i] == res[j]) & (max < res[i]))
                    max = res[i];
        return max;
    }
}*/

