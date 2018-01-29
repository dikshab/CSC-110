import java.util.*;

public class SecondProgram{

	public static void main(String[] args){
		printOwl();
		areaCircle();
}

/* 
	Gets the message and puts in between the stars
	thus creating a dialog box
*/


	public static void printMessage(){
		Scanner input = new Scanner(System.in);
		String message = input.nextLine();
		int str_length = message.length();
		
		for(int i = 1; i<= str_length+4; i++){
			System.out.print("*");
		}
		System.out.println("\n| "+ message + " | \n");
		for(int i = 1; i<= str_length+4; i++){
			System.out.print("*");
		}
		System.out.println("\n     \\ \n      \\");
	}

/*
	Prints the owl from the first program
 
*/
	
	public static void printOwl(){
		printMessage();                                       // calls printMessage and prints the dialog box
		System.out.println("          ^...^  ");
		System.out.println("         / o,o \\  ");
		System.out.println("         |):::(|  ");
		System.out.println("        ===w=w===  ");
	}
	
/*
	Calculates the area of the circle

*/
	
	public static void areaCircle(){
		Scanner input = new Scanner(System.in);	
		System.out.println("Enter the radius of the circle:" );
		double radius = input.nextDouble();
		
		double area;
		double pi = approxPi(); // calls the function to get the value of pi
		
		area = pi*radius*radius;
		System.out.println("The area of the circle of radius "+radius+" is: "+area);
	}
	
	
/*
	Calculates the value of pi
*/
	public static double approxPi(){
		
		double nextTerm = 1;
		double denom = 1;
		double series = 0;
	
	
		for(int i=1; i<=1000000; i++){
			
			series = series + (nextTerm/denom);
			denom = denom + 2;
			nextTerm = nextTerm * (-1); 
			
		}
		series = 4 * series;
		return series;
		
	}
}
