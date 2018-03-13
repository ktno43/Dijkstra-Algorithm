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
 * Group2_Edge.java
 * Version 7.0
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
public class Group2_Edge {
	private final Group2_Vertex src; // Source vertex
	private final Group2_Vertex dest; // Destination vertex
	private final int weight; // Weight of the path

	public Group2_Edge(Group2_Vertex src, Group2_Vertex dest, int weight) { // Create an edge between two vertices
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	protected Group2_Vertex getSrc() { // Get the source vertex
		return this.src;
	}

	protected Group2_Vertex getDest() { // Get the destination vertex
		return this.dest;
	}

	protected int getWeight() { // Get the weight of the edge
		return this.weight;
	}
}