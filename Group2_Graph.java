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
 * Group2_Graph.java
 * Version 8.0
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
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Group2_Graph {
	private ArrayList<Group2_Vertex> vertices;

	public Group2_Graph(String fileName) { // Given a file create a graph
		Group2_ReadFile file = new Group2_ReadFile(fileName); // Try to open the file given the file name

		ArrayList<Character> srcList = new ArrayList<Character>(); // List for the source vertex
		ArrayList<Character> destList = new ArrayList<Character>(); // List for the destination vertex
		ArrayList<Integer> weightList = new ArrayList<Integer>(); // List for the weight between the source and the destination
		Set<Character> uniqueSet = new TreeSet<Character>(); // Ordered set (will only contain unique elements)

		List<Character> uniqueList = new ArrayList<Character>(); // Ordered list which will contain the ordered set

		file.readFile(srcList, destList, weightList); // Read the file which will update the lists

		for (int i = 0; i < srcList.size(); i += 1) { // For the size of the list (source/destination) would work
			uniqueSet.add(srcList.get(i)); // Add the current element in the source list to the unique set (won't add duplicates)
			uniqueSet.add(destList.get(i)); // Add the current element in the destination list to the unique set (won't add duplicates)
		}

		uniqueList.addAll(uniqueSet); // Add all elements in the unique set to the unique list

		this.vertices = new ArrayList<Group2_Vertex>(uniqueList.size()); // Create an array list given the unique list

		for (int i = 0; i < uniqueList.size(); i += 1) { // Create a graph given the size of the unique list
			vertices.add(new Group2_Vertex(uniqueList.get(i))); // Add each element in the unique ordered list to the graph (will be lexicographical)
		}

		for (int i = 0; i < srcList.size(); i += 1) { // For all the elements in the source/destination list
			this.addEdge(srcList.get(i), destList.get(i), weightList.get(i)); // Add edges according with the corresponding source, destination, and weight
		}
	}

	protected void addEdge(char src, char dest, int weight) {
		int srcIndex = 0; // Source index
		int destIndex = 0; // Destination index

		for (int i = 0; i < this.vertices.size(); i += 1) { // Since the graph is in lexicographical ordering, get the corresponding index when reading from the list
			if (this.vertices.get(i).getName() == src) // Found the match, update the source index
				srcIndex = i;

			if (this.vertices.get(i).getName() == dest) // Found the match, update the destination index
				destIndex = i;
		}

		Group2_Vertex srcVertex = this.vertices.get(srcIndex); // Source vertex is the vertex corresponding to the source index in the graph
		Group2_Vertex destVertex = this.vertices.get(destIndex); // Destination vertex is the vertex corresponding to the destination index in the graph

		Group2_Edge e = new Group2_Edge(srcVertex, destVertex, weight); // Create an edge between the source and destination vertices

		srcVertex.getNeighbors().add(e); // Update the neighbors array list
	}

	protected ArrayList<Group2_Vertex> getGraph() { // Get the graph
		return this.vertices;
	}

	protected Group2_Vertex getVertex(int n) { // Get the vertex at index n in the graph
		return this.vertices.get(n);
	}

	protected String printPath(Group2_Vertex v) {
		return v.printPath(); // Invoke print path for the current vertex
	}

	protected void shortestPath(char srcVertexName) { // Calculate the shortest path given the starting point
		Group2_Dijkstra alg = new Group2_Dijkstra(); // Use dijkstra class and calculate the shortest path given the source
		int srcIndex = -1;
		
		for (int i = 0; i < this.vertices.size(); i += 1) { // Since the graph is in lexicographical ordering, get the corresponding index when reading from the list
			if (this.vertices.get(i).getName() == src) // Found the match, update the source index
				srcIndex = i;
		}
		
		if (srcIndex == -1) { // Vertex was not found
			System.out.println("Vertex " + srcVertexName + " is not in the graph.");
		}
		
		else // Vertex match, calculate the shortest path=
			alg.shortestPath(this.vertices.get(srcIndex));
	}
}
