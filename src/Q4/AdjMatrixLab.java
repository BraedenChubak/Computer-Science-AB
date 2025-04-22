package Q4;

import DataStructures.GraphMatrix;
import DataStructures.Dictionary;
import java.util.Arrays;

public class AdjMatrixLab {
    public static <T extends Comparable<T>> void colorGraph(GraphMatrix<T> graph) {
        int vCount = graph.getVertexCount();
        int[][] matrix = graph.getMatrix();
        Dictionary<T, Integer> vertices = graph.getVertices();

        int[] result = new int[vCount];
        Arrays.fill(result, -1);  // -1 = Uncolored
        result[0] = 0; // First color to first vertex
        boolean[] available = new boolean[vCount];

        for (int u = 0; u < vCount; u++) {
            Arrays.fill(available, true);
            // mark adjacent as unavailable
            for (int v = 0; v < vCount; v++) {
                if (matrix[u][v] != 0 && result[v] != -1) {
                    available[result[v]] = false;
                }
            }
            // find first available color
            int color;
            for (color = 0; color < vCount; color++) {
                if (available[color]) break;
            }
            result[u] = color;
        }

        System.out.println("Vertex colors:");
        for (int i = 0; i < vCount; i++) {
            System.out.println("Vertex " + vertices.getKey(i) + " --> Color " + result[i]);
        }
    }

    public static void main(String[] args) {
        var graph = new GraphMatrix<String>(6);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "F");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("E", "F");

        graph.display();
        System.out.println();

        colorGraph(graph);
    }
}
/*
Vertices
{
	A:	0,
	B:	1,
	C:	2,
	D:	3,
	E:	4,
	F:	5,
}
Matrix
0 1 1 0 0 0
1 0 1 1 0 1
1 1 0 0 1 1
0 1 0 0 0 0
0 0 1 0 0 1
0 1 1 0 1 0

Vertex colors:
Vertex A --> Color 0
Vertex B --> Color 1
Vertex C --> Color 2
Vertex D --> Color 0
Vertex E --> Color 0
Vertex F --> Color 3
 */