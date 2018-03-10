
/*-
 *****************************************
 * Group 2
 * Kyle Nguyen
 * 
 * COMP 282
 * Spring 2018
 * Dr. Wen-Chin Hsu
 * M/W 9:30 A.M - 10:45 A.M
 * 
 * Project 2: 
 * 
 * Group2_ReadFile.java
 * Version 5.0
 * 
 * The program works as expected as it
 * reads in a file given the file is
 * properly formatted such that the 
 * node's name is a character and the
 * distance between them is an integer.
 * 
 * It creates a graph based on the file
 * and calculates the shortest path 
 * between two nodes.
 * 
 * Following all the specifications,
 * it creates a table where the table
 * does not display paths of distance 0
 * nor does it display nodes that are
 * unreachable.
 ****************************************/

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Group2_ReadFile {
	private Scanner sc; // Scanner for read file
	private final String pathName; // File to read in

	public Group2_ReadFile(String pathName) {
		this.pathName = pathName; // Set the file to read in to the path name
		openFile(); // Attempt to open the file
	}

	private void openFile() {
		try { // Try to open the file
			sc = new Scanner(new File(this.pathName));
		} catch (Exception e) { // The file wasn't found
			System.out.println("File not found. . . ");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void readFile(ArrayList<Character> src, ArrayList<Character> dest, ArrayList<Integer> weight) {
		while (sc.hasNext()) { // Read in the file given the file is formatted correclty with a src, dest and a weight
			src.add(sc.next().charAt(0)); // Add the first character to the list
			dest.add(sc.next().charAt(0)); // Add the second character to the list
			weight.add(sc.nextInt()); // Add the weight to the list
		}
		closeFile();
	}

	private void closeFile() { // Close the file
		sc.close();
	}
}