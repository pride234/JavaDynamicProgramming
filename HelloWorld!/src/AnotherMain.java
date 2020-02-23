
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class AnotherMain {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner sc = null;
		try {
			sc = new Scanner(new File("test.txt"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		char[] key = new char[]{'h', 'e', 'l', 'o'};
		int c = 4;
		int T= 0;
		int min = 0;
		T = sc.nextInt();
		String currline = sc.nextLine();

		for (int k = 0; k<T; k++) {

			int [] value = new int[c];			
			currline = sc.nextLine();
			
			for (int i = 0; i<currline.length(); i++) {
				
				char temp = currline.charAt(i);
				
				for (int j = 0; j<c; j++) if (temp == key[j]) value[j]++;
								
			}

			value[2] = value[2]/2;
			min = value[0];
			
			for (int i = 1; i<c; i++) {
				if (min == 0) continue;
				else if (min > value[i]) min = value[i];
			}

			System.out.println("Case #"+(k+1));
			System.out.println(min);
		}		
	}
	
}
