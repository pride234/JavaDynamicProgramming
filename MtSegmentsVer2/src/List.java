
public class List {
	
	private long[] array;
	
	public List(){
		
		this.array = new long[1];
	}

	public void Add(long num) {
		
		if((this.array[0] != 0) || this.array.length > 1) {
			
			long[] temp = new long[array.length];
			
			for (int i = 0; i<array.length; i++) temp[i] = this.array[i];
			
			this.array = new long[array.length+1 ];
			this.array[array.length] = num;

			for (int i = 0; i<array.length; i++) this.array[i] = temp[i];
			
			temp = null;
			
		}
	}
	
	public long Get(int i) {
		
		return array[i];
	}
}
