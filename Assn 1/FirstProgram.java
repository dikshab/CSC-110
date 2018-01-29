public class FirstProgram{
	
	public static void main(String args[]){
		printFrog();
		printOwl();
		approxPi();
	}
	
	public static void printFrog(){
		System.out.println("   @..@");
		System.out.println("  (----)");
		System.out.println(" ( >__< )");
		System.out.println(" \"\"    \"\"");
	}
	
	public static void printOwl(){
		System.out.println("   ^...^  ");
		System.out.println("  / o,o \\  ");
		System.out.println("  |):::(|  ");
		System.out.println(" ===w=w===  ");
	}
	
	public static void approxPi(){
		
		double nextTerm = 1;
		double denom = 1;
		double series = 0;
	
	
		for(int i=1; i<=8; i++){
			
			series = series + (nextTerm/denom);
			denom = denom + 2;
			nextTerm = nextTerm * (-1); 
			
		}
	series = 4 * series;
		
		System.out.println(series);
	}
}