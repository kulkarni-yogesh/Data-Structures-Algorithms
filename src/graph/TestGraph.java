package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestGraph<T> {

	Map<T, List<T>> map = new HashMap<>();

	// 1. Add Edge
	public void addEdge(T source, T destination, boolean bidirectional) {
		if (!map.containsKey(source)) {
			addVertex(source);
		}
		if (!map.containsKey(destination)) {
			addVertex(destination);
		}
		map.get(source).add(destination);
		if (bidirectional) {
			map.get(destination).add(source);
		}

	}

	// 2. Add Vertex
	public void addVertex(T vertex) {

		map.putIfAbsent(vertex, new LinkedList<T>());

	}

	// 3. Check Vertex Count
	public void checkVertexCount() {
		System.out.println("The Graph has " + map.keySet().size() + " number of vertices");

	}

	// 4. Has an edge
	public void hasAnEdge(T source, T destination) {
		if (map.get(source).contains(destination)) {
			System.out.println("Graph contains edge between " + source + " and " + destination);
		}

	}

	// 5. Check number of edges

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		map.forEach((key, value) -> {
			sb.append(key + ": ");
			sb.append(value);
			sb.append("\n");
		});

		return sb.toString();
	}

	public static void main(String[] args) {
		TestGraph<Integer> g = new TestGraph<Integer>();

		g.addEdge(0, 1, true);
		g.addEdge(0, 4, true);
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 4, true);

		// print the graph.
		System.out.println("Graph:\n" + g.toString());

	}

}
