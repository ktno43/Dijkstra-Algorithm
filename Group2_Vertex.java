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
 * Group2_Vertex.java
 * Version 6.0
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

import java.util.ArrayList;
import java.util.LinkedList;

public class Group2_Vertex implements Comparable<Group2_Vertex> {
	private final char name; // Name of vertex
	private ArrayList<Group2_Edge> neighbors; // Array list for the edges connecting two vertices
	private LinkedList<Group2_Vertex> path; // Path to the current vertex
	private int dist = Integer.MAX_VALUE; // Default value to the distance between two nodes

	public Group2_Vertex(char name) { // Initialize the name and create a list for the edges and path
		this.name = name;
		this.neighbors = new ArrayList<Group2_Edge>();
		this.path = new LinkedList<Group2_Vertex>();
	}

	protected char getName() { // Get the name of the vertex
		return this.name;
	}

	protected ArrayList<Group2_Edge> getNeighbors() { // Get the list of it's neighbors
		return this.neighbors;
	}

	protected void setPath(LinkedList<Group2_Vertex> newPath) { // Set the path to the new path
		this.path = newPath;
	}

	protected LinkedList<Group2_Vertex> getPath() { // Get the path to the current node
		return this.path;
	}

	protected void setDist(int dist) { // Set the distance of the current node
		this.dist = dist;
	}

	protected int getDist() { // Get the distance of the current node
		return this.dist;
	}

	protected String printPath() {
		String output = "";
		for (Group2_Vertex pathV : this.getPath()) { // Display the corresponding path of the current index
			output += pathV.toString();
		}
		output += this.toString();
		
		return output;
	}

	public String toString() { // String representation of the vertex
		return Character.toString(this.name);
	}

	@Override
	public int compareTo(Group2_Vertex other) { // Implement comparable interface
		return Integer.compare(this.dist, other.dist);
	}
}