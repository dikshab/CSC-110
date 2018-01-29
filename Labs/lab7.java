import java.*;

public class lab7{

	public static void main(String[] args){
	
		System.out.println("This is lab 7 program");
		checkFile("textFile.txt");
		
	
}

	public static boolean checkFile(String filename){
		File f = new File(filename);
		//checks if the text file exists
		if(f.exists){
			System.out.println(filename + "exists");
		}
		else{
			System.out.println(filename + "does not exists in this directory");
			return false;
		}
		//checks if the text file is readable
			if(f.canRead()){
				System.out.println("File can be read");
			}
			else{
				System.out.println("File cannot be read");
				return false;
		}
	
	return false;
	}
}

