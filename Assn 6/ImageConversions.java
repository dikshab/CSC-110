/**
 * @author Diksha Bansal
 * student id: V00768613
 * Short description of the program
 */

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Class ImageConversions is a collection of methods that convert jpg images
 * into variations.
 */
public class ImageConversions {
	/**
	 * Handles all input instructions and relays the information to the
	 * appropriate method.
	 * If the input is not as specified, the program stops, with an informative message.
	 * @param args The input necessary to execute the appropriate conversion.
	 * The array is formated in one of the following ways:
	 * <ul style="list-style:none;">
	 * <li>[infile outfile] invert
	 * 	<ul style="list-style:none;">
	 *	<li>infile: image file  outfile: image file</li>
	 * 	</ul></li>
	 * <li>[infile outfile] verticalFlip</li>
	 * <li>[infile outfile] horizontalFlip</li>
	 * <li>[infile outfile] makeAscii</li>
	 * <li>[infile outfile] scale [scalefactor]
	 *	<ul style="list-style:none;">
	 *	<li>scalefactor: A number: 1 maintains original size, &lt; 1 reduces size, &gt; 1 enlarges size.</li>
	 *	</ul></li>
	 * <li>[infile outfile] rotate</li>
	 * </ul>
	 */
	public static void main(String[] args) {
		System.out.println("Please read through the Assignment 6 pdf file on conneX");
		System.out.println("The file includes instructions on how to use the two methods provided.");
	}	
				
	// THIS METHOD MAY BE CALLED, BUT MUST NOT BE MODIFIED!
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
		} catch (IOException ioe) {
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

	// THIS METHOD MAY BE CALLED, BUT MUST NOT BE MODIFIED!
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
		} catch (IOException ioe) {
			System.err.println("The file could not be created " + filename);
			return;
		}
	}
}