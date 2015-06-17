package cs320.counter;

public class counter {

	private static int c = 1;
	private int count;
	
	public counter () {
		count = 0;
	}
	public void setC(int counter) {
		 c ++; 
	}
	
	public int getC() {
		return c;
	}

}
