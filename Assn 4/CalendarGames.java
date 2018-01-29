import java.util.*;
import java.lang.*;

public class CalendarGames{
	
	public static void main(String[] args){
	
		guessMyBirthday();
	}
	
	public String monthToString(int month){
		
		String monthString;
		switch(month){
			
			case 1: monthString = "January";
					break;
			case 2: monthString = "February";
					break;
			case 3: monthString = "March";
					break;
			case 4: monthString = "April";
					break;
			case 5: monthString = "May";
					break;
			case 6: monthString = "June";
					break;
			case 7: monthString = "July";
					break;
			case 8: monthString = "August";
					break;
			case 9: monthString = "September";
					break;
			case 10: monthString = "October";
					break;
			case 11: monthString = "November";
					break;
			case 12: monthString = "December";
					break;
			default: monthString = "Not a valid month";
					break;
			
		return monthString;
	}
	
	public boolean isLeapYear(int year){

		boolean Is_Leap_year;
		if(year%4 != 0){
		Is_Leap_year = false;}
		else
		if(year%100 != 0){
		Is_Leap_year = true;}
		else
		if(year%400 != 0){
		Is_Leap_year = false;}
		else{
	Is_Leap_year = true;}
		
		return Is_Leap_year;
	}
	
	public int numDaysInMonth(int month, int year){
		isLeapYear();	
		if(month == 2){
				
			if(isLeapYear == true)
				return 29;
			else
				return 28;
		}	
		else
		if((month == 4) || (month == 6) || (month == 9) || (month == 11)) 
			return 30;
		else
			return 31;
	}
	public void middleNumber(int low, int high) {
	int middle = (low+high)/2;
}

	public void guessMyBirthday(){
		int day_low=1;
		int day_high; 
		int min_month = 1;
		int max_month = 12;
		//Random rand_month = new Random();
		int month_guess;
		int num_guess;
		
		int count=0; 
		String ans;
		boolean go = true;
		
		while(go){
			month_guess = middleNumber(min_month, max_month);
			num_guess = middleNumber(day_low, day_high);
			Scanner str = new Scanner(System.in);
			System.out.println("Is your birthday in " + monthToString(month_guess) + "? yes or no: ");
			ans = console.next();
		
			if(ans.equals("yes")){
				
				System.out.println("Is your birthday in " + monthToString(month_guess) + num_guess + "? yes or no: ");
				ans = console.next();
				
				if(ans.equals("yes")){
						System.out.println("It took " + count + " guesses to find your birthday, which is " +monthToString(month_guess) + num_guess);
				}		go = false; 
				else 
				if(ans.equals("no")){
						System.out.println("Is your birthday before or after?" );
						ans = console.next();
						
						if(ans.equals("before"))
							day_high = num_guess + 1;
						else
						if(ans.equals("after"))
							day_low = num_guess - 1;
						else
							System.out.println("Invalid answer");		
				}
			else 
			if(ans.equals("no")){
				System.out.println("Is your birthday before or after?" );
				ans = console.next();
						
				if(ans.equals("before"))
					max_month = month_guess;
						if(max_month.equals(3))
								System.out.println("What year were you born in? ");
								ans = console.next();
								int year;
								day_high = numDaysInMonth(2, year);
				else
				if(ans.equals("after"))
					min_month = month_guess;
				else
					System.out.println("Invalid answer");	
			}
			
			count++;
			}
		}	
	
	}


}