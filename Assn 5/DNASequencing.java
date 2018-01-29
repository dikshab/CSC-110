 import java.*;
 
 public class  DNASequencing{
	 
	public static void main(String[] args){
		 
		 String[] arr = {"AC", "TACG", "AAC", "GTY", "AC", "AC", "AC", "AC", "TCA", "TTCCCCA", " TCCAA", "TCA", "TCA", "TCA", "TCA", "TCA"};
		 String big = findLongest(arr);
		 System.out.println("The longest String is " + big);
		 int count = findFrequency("TCA", arr);
		 System.out.println("AC occurs  "+ count+"times");
		 printArray(arr);
		 
	}
	
	public static void printArray(String[] strings){
		for(int i = 0; i < strings.length; i++){
			
			System.out.println(strings[i]);
		}
		
	}
	
	public static String findLongest(String[] strings){
		 
		int index = 0;
		int max = strings[0].length();
		for(int i = 1; i < strings.length; i++){
			
			if(strings[i].length() > max) 
				index = i;	
				max = strings[i].length();
		}
		 
		return strings[index];
	}
	 
	public static int findFrequency(String target, String[] strings){
		
		int count = 0;
		for(int i = 0; i < strings.length; i++){
			
			if(strings[i].equals(target))
				count++ ;
			else
				count = count;
		}
		
		return count;
	}
	
	public static String Duplicate(String str){
		
		String res = new String("");
		for(int i = 0; i < str.length(); i++){
			
			if(!res.contains("" + str.charAt(i))){
				res = res + "" + str.charAt(i);
				
			}
		}		
		return res;
	}
	public static int findFreqWithMutations(String target, String[] seqArray){
		
		String[] duplicate_arr = new String[seqArray.length];
		int count = 0;
		
		// removes the duplicate characters and stores it another array 
		for(int i = 0; i < seqArray.length; i++)
				
			duplicate_arr[i] = Duplicate(seqArray[i]);
		
		for(int j = 0; j < duplicate_arr.length; j++){
			
			if(duplicate_arr[j].contains(target))
				
				count ++;
			
		}
		return count;		
	}
	
	public static int countTotalMutations(String[] seqArray){
		int counter = 0;
		
		for(int i = 0; i < seqArray.length; i++){
			for(int j = i+1; j < seqArray.length; j++)
				
				if(seqArray[i] == seqArray[j])
					counter++;
		}
		return counter;
	}
	 
	public static boolean hasMutation(String sequence){
		
		boolean result;
		int counter = 0;
		
		for(int i = 0; i < sequence.length(); i++){
			for(int j = i+1; j < sequence.length(); j++)
				
				if(sequence.charAt(i) == sequence.charAt(j))
					counter++;
			
		}
		if(counter > 0)
			result = true;
		else
			result = false;
		
		return result;
	}
 }