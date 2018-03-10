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
 * Group2_Dijkstra.java
 * Version 4.0
 * 
 * The following class calculates the
 * shortest path for two nodes.
 * 
 * Utilizing a priority queue it finds
 * the minimum distance between a node
 * and it's neighbors.
 ****************************************/
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Group2_Dijkstra {

	public void shortestPath(Group2_Vertex source) { // Starting position of Dikstra's algorithm
		// Algorithm:
		// 1. Take the unvisited node with minimum weight.
		// 2. Visit all its neighbors.
		// 3. Update the distances for all the neighbors (In the Priority Queue).
		// Repeat the process till all the connected nodes are visited.

		source.setDist(0); // Set distance to 0, since minimum distance to yourself is 0

		PriorityQueue<Group2_Vertex> mahQueue = new PriorityQueue<Group2_Vertex>(); // Create a priority queue of vertices

		mahQueue.add(source); // Add the current vertex to the priority queue

		while (!mahQueue.isEmpty()) { // While the priority queue is not empty

			Group2_Vertex current = mahQueue.poll(); // Get the head element in the priority queue

			for (Group2_Edge neighbor : current.getNeighbors()) { // For every neighbor that the current node has
				int newDist = current.getDist() + neighbor.getWeight(); // Recalculate the distance between the current and the neighboring node

				if (newDist < neighbor.getDest().getDist()) { // Compare the new distance with original weighted distance
					// The new distance is less than the current
					mahQueue.remove(neighbor.getDest()); // Remove and update the neighbor
					neighbor.getDest().setDist(newDist); // Update the distance from the current node to it's neighbor

					// Visit all the nodes & it's neighbors
					neighbor.getDest().setPath(new LinkedList<Group2_Vertex>(current.getPath())); // Set the neighbor's paths with the current's path
					neighbor.getDest().getPath().add(current); // Add the current node to the path

					// Re-insert the neighbor with updated distance & path
					mahQueue.add(neighbor.getDest());
				}
			}
		}
	}
}