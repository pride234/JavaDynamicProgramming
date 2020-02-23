import java.math.BigInteger;

public class BM {
	
	public static void BM () {
		
		BigInteger p = new BigInteger("CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3",16 );
		BigInteger a = new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356",16 );
		BigInteger T = new BigInteger("BEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3", 16);
		
		String str = "";
		BigInteger temp = p.subtract(new BigInteger("1")).divide(new BigInteger("2"));
		
		byte[] bytes = new byte[8_000_000];
		
		for (int i = 0; i<8_000_000; i++) {
			
			if (T.compareTo(temp) < 0) bytes[i] = 1;
			T = a.modPow(T, p);
			
		}
		
		//System.out.println("Hurray!");		
		for (int i = 0; i < 8_000_000; i++) System.out.print(bytes[i]);		
	}
	
	public static void main(String[] args) {
	
		BigInteger p = new BigInteger("116995491816573403595817359648202689425306188838076635427257240061354081446611940345431009773466989176408799846235992485545684183529506363982790048962329921575089999885272209375021334845605223690793226562114596283459050123160313066940348354906360461625902756806851093170689674894644043118690635315725743403346"); 
		System.out.print(p.nextProbablePrime());
	}	
}
