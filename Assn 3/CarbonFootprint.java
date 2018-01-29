import java.util.*;

public class CarbonFootprint{
	
	public static void main(String[] args){	
		
		// Input for transportationFootprint method 
		
		Scanner input = new Scanner(System.in);	
		System.out.println("How many km do you drive in a day?" );
		double kPD = input.nextDouble();
		
		System.out.println("Choose the appropriate fuel efficiency for your car: ");
		System.out.println("\t\t very small car: 7.1 km/litre");
		System.out.println("\t\t small car: 8.2 km/litre");
		System.out.println("\t\t sports car: 14.9 km/litre");
		System.out.println("\t\t SUV: 12.3 km/litre");
		
		
		Scanner num =  new Scanner(System.in);
		System.out.println("Or, if you know the efficiency rating, choose another number: ");
		double effic = num.nextDouble();
		transportationFootprint(kPD, effic);
		
		// Input for electricityFootprint method 
		
		Scanner num_ = new Scanner(System.in);	
		System.out.println("What is the average electricity consumption per month, in kilowatts?" );
		double kwHours = num_.nextDouble();
		
		Scanner num2 = new Scanner(System.in);	
		System.out.println("How many people live in the house?" );
		int number = input.nextInt();

		electricityFootprint(kwHours, number);
		
		// Input for foodFootprint method
		
		Scanner input1 = new Scanner(System.in);	
		System.out.println("Of all the food you eat, what percent consists of meat or fish?" );
		double meat = input1.nextDouble();
		
		Scanner input2 = new Scanner(System.in);	
		System.out.println("Of all the food you eat, what percent consists of dairy?" );
		double dairy = input2.nextDouble();
		
		Scanner input3 = new Scanner(System.in);	
		System.out.println("Of all the food you eat, what percent consists of fruits and vegetables?" );
		double fv = input3.nextDouble();
		
		Scanner input4 = new Scanner(System.in);	
		System.out.println("Of all the food you eat, what percent consists of carbohydrates?" );
		double carb = input4.nextDouble();
		
		foodFootprint(meat, dairy, fv, carb);
		
		//finding the totalFootprint
		double trans = transportationFootprint(kPD, effic);
		double elec = electricityFootprint(kwHours, number);
		double food = foodFootprint(meat, dairy, fv, carb);
		totalFootprint(trans, elec, food);
	}

	
	// calculates the footprint due to vehicle use
	public static double transportationFootprint(double kPD, double effic){
		
		
		double transportation_footprint = 0;
		double litresUsedPerYear = 0;
		
		litresUsedPerYear = 365 * (kPD/effic);
		transportation_footprint = 2.3 * litresUsedPerYear;
		
		System.out.println("Your Carbon footprint with respect to car use is "+ transportation_footprint+" kg/year");
		
		return transportation_footprint;
	}
	
	// calculates the footprint due to electricity consumption
	public static double electricityFootprint(double kwHours, int number){
	
		double electricity_footprint = 0;
		
		electricity_footprint = (kwHours * 12 * 0.257)/number;
		
		System.out.println("Your Carbon footprint with respect to electricity use is "+electricity_footprint+" kg/year");
		
		return electricity_footprint;
		
	}
	
	//calculates the footprint due to food consumption
	public static double foodFootprint(double meat, double dairy, double fv, double carb){
		
		double food_footprint = 0;
		double meat_footprint = 0;
		double dairy_footprint = 0;
		double fv_footprint = 0;
		double carb_footprint = 0;
		
		meat_footprint = (meat * 53.1)/100;
		dairy_footprint = (dairy * 13.8)/100;
		fv_footprint = (fv * 7.6)/100;
		carb_footprint = (carb * 3.1)/100;
		
		food_footprint = meat_footprint + dairy_footprint + fv_footprint + carb_footprint;
		
		System.out.println("Your Carbon footprint with respect to food consumption is "+food_footprint+" kg/year");
		return food_footprint;
	}
	
	//calculates the total footprint
	public static double totalFootprint(double trans, double elec, double food){

		double total_footprint = 0;
		total_footprint = (trans + elec + food)/1000;
		
		System.out.println("You produce an annual total of "+ total_footprint+" metric tons of CO2 per year");
		return total_footprint;
	}


}