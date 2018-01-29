import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class ImageManipulations{

	public static void main(String[] args){
	
		if(args.length > 2){
			String inputfilename = new String();
			String outputfilename = new String();
			String method = new String();
			args[0] = inputfilename;
			args[1] = outputfilename;
			args[2] = method;
			
			int[][] img = readGrayscaleImage(inputfilename);
			if(method.equals("invert")){
				int[][] img_invert;
                img_invert = invert(img);   
				writeGrayscaleImage(outputfilename, img_invert);
			}
			else
			if(method.equals("verticalFlip")){
				int[][] img_vert;
                img_vert = verticalFlip(img);
				writeGrayscaleImage(outputfilename, img_vert);
			}
			else
			if(method.equals("horizontalFlip")){
				int[][] img_hor;
                img_hor = horizontalFlip(img);	
				writeGrayscaleImage(outputfilename, img_hor);
			}
			else
			if(method.equals("makeAscii")){	
				String s  = "ascii.txt";
                makeAscii(img, s);  
			}
			else
			if(method.equals("scale")){
				double factor = Double.parseDouble(args[3]);
				int[][] img_scale;
				img_scale = scale(img, factor);
				writeGrayscaleImage(outputfilename, img_scale);
			}
			else
			if(method.equals("rotate")){
				int[][] img_rot;
                img_rot = rotate(img);
				writeGrayscaleImage(outputfilename, img_rot);
			}
		}
	}

	/**
	 * Inverts each value in a 2D array of integers between 0 and 255. 
	 * A value of 255 becomes 0, 254 becomes 1, all the way down to 0 becomes 255.
	 * @param image 2D array
	 * @return res inverted array
	 */

	public static int[][] invert(int[][] image){
	
		int N = 255;
		int rows = image.length;
		int cols = image[0].length;
		int[][] res = new int[rows][cols];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols ; j++){
				res[i][j] = N - image[i][j];
			}
		}
			return res; 
	}
	
	/**
     * Reverses all the values in each column in a 2D array of integers
     * simulating a vertical flip.
     * @param image 2-D array of the image      
     * @return ver_flip vertically flipped array     
     */

	public static int[][] verticalFlip(int[][] image){
		
		int rows = image.length;
		int cols = image[0].length;
		int[][] ver_flip = new int[rows][cols];
		
		for(int i = rows - 1; i >= 0; i--){
			for(int j = cols - 1; j >= 0; j--){
				ver_flip[i][cols - 1 - i] = image[i][j];
			}
			
		}
		return ver_flip;
	}

	/**
     * Reverses all the values in each row in a 2D array of integers,
     * simulating a horizontal flip..
     * @param image 2-D array of the image
     * @return hor_flip horizontally flipped array
     */
	public static int[][] horizontalFlip(int[][] image){
		
		int rows = image.length;
		int cols = image[0].length;
		int[][] hor_flip = new int[rows][cols];
		
		for(int i = rows - 1; i >= 0; i--){
			for(int j = cols - 1; j >= 0; j--){
					hor_flip[rows - 1 - i][j] = image[i][j];
			}
		}
	
		return hor_flip;
	}
        
        
    /**
     * Creates an ASCII image text file with each character represents a 
     * range of integer values. 
     * The mapping key is specified in the assignment document.
     * @param image 2-D array of the image
     * @param outName name of the text file
     */
	public static void makeAscii(int[][] image, String outName){
		
		int rows = image.length;
		int cols = image[0].length;
		PrintStream writer = null;
		
		try{
			writer = new PrintStream(new File(outName));
		}
		catch (FileNotFoundException fne){
			
			System.out.println("The file named "+ outName + " cannot be opened for writing");
			return;
		}
		for(int i = 0 ; i < rows; i++){
				for(int j = 0; j < cols; j++){
					if(image[i][j] >= 0 && image[i][j] <= 20)
						writer.println("M");
					else
					if(image[i][j] >= 21 && image[i][j] <= 40)
						writer.println("L");
					else
					if(image[i][j] >= 41 && image[i][j] <= 60)
						writer.println("I");
					else
					if(image[i][j] >= 61 && image[i][j] <= 80)
						writer.println("o");
					else
					if(image[i][j] >= 81 && image[i][j] <= 100)
						writer.println("|");
					else
					if(image[i][j] >= 101 && image[i][j] <= 120)
						writer.println("=");
					else
					if(image[i][j] >= 121 && image[i][j] <= 140)
						writer.println("*");
					else
					if(image[i][j] >= 141 && image[i][j] <= 160)
						writer.println(":");
					else
					if(image[i][j] >= 161 && image[i][j] <= 180)
						writer.println("-");
					else
					if(image[i][j] >= 181 && image[i][j] <= 200)
						writer.println(",");
					else
					if(image[i][j] >= 201 && image[i][j] <= 220)
						writer.println(".");
					else
						writer.println(" ");
				}
			}
			writer.close();
	
	}

        
    /**
     * Scales a 2D array of integers by a given factor.
     * @param image 2-D array of the image
     * @param scalefactor factor to which we have to scale the image
     * @return resimg scaled array
     */
	public static int[][] scale(int[][] image, double scalefactor){
	
		int rows = image.length;
		int cols = image[0].length;
		
		int resrow = (int) ((int) rows * scalefactor);
		int rescols = (int) ((int) cols * scalefactor);

		int[][] resimg = new int[resrow][rescols];
		int r = 0;
		int count = 0;
		int c;
		
		for(int i = 0 ; i < resrow ; i++){
			c = 0;
			for(int j = 0; j < cols; j++){
				for(int k = 0; k < scalefactor; k++){
					
					resimg[i][c] = image[r][j];
					c++;
				}
			}
			count++;
			if(count >= scalefactor){
				r++;
				count = 0;
			}
		}
		
		return resimg;
	}

	
    /**
     * Rotates a 2D array of integers 90 degrees clockwise. The value 
     * in the top left corner moves to the top right corner and all over
     * values move with respect to their original position.
     * @param image 2-D array of the image
     * @return imgRot rotated array
     */
        public static int[][] rotate(int[][] image){
	
		int rows = image.length;
		int cols = image[0].length;
		
		int[][] imgRot = new int[cols][rows];
		
		for(int i = 0; i < rows; i++){
		
			for(int j = 0; j < cols; j++){
				imgRot[j][rows-1-i] = image[i][j];
			}
		}
		return imgRot ;
	}

	/** 
	 * Reads an image file and converts it to a 2D array
	 * of integers.
	 * Each value in the array is a representation
	 * of the corresponding pixel's grayscale value.
	 * @param filename The name of the image file
	 * @return A 2D array of integers.
	 * @throws RuntimeException if the input file cannot be found or read.
	 */
	public static int[][] readGrayscaleImage(String filename) {
		int[][] result = null;
		File imageFile = new File(filename);
		BufferedImage image = null;
		try {
			image = ImageIO.read(imageFile);
		} 
		catch (IOException ioe) {
			System.err.println("Problems reading file named " + filename);
			throw new RuntimeException("Please ensure the image file is saved in the same directory as your java file.");
		}
		int height = image.getHeight();
		int width  = image.getWidth();
		result = new int[height][width];
		int rgb;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				rgb = image.getRGB(x, y);
				result[y][x] = rgb & 0xff;
			}
		}
		return result;
	}

    /**
	 * Reads a 2D array of integers and creates
	 * a grayscale image. Each pixel's grayscale value is
	 * based on the corresponding value in the 2D array.
	 * @param filename The name of the image file to create
	 * @param array The 2D array of integers
	 */
	public static void writeGrayscaleImage(String filename, int[][] array) {
		int width = array[0].length;
		int height = array.length;
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

		int rgb;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				rgb = array[y][x];
				rgb |= rgb << 8;
				rgb |= rgb << 16;
				image.setRGB(x, y, rgb);
			}
		}
		File imageFile = new File(filename);
		try {
			ImageIO.write(image, "jpg", imageFile);
		} 
		catch (IOException ioe) {
			System.err.println("The file could not be created " + filename);
			return;
		}
	}
}