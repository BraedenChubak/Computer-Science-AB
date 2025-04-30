package Q4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Algorithms.GraphAlgorithms;
import DataStructures.Dictionary;
import DataStructures.GraphList;
import DataStructures.GraphMatrix;

public class Prog5000d {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog5000d.txt"));
            var vertexData = new Dictionary<String, String>();
            var graph = new GraphList<String>();
            // var graph = new GraphMatrix<String>(21);
            boolean foundEdges = false;

            file.nextLine();
            while (file.hasNext()) {
                String line = file.nextLine();
                if (line.equals("Edges:")) {
                    foundEdges = true;
                    continue;
                }
                var parts = line.split("\t");
                if (!foundEdges) {
                    graph.addVertex(parts[0]);
                    vertexData.insert(parts[0], parts[1]);
                } else {
                    graph.addEdge(parts[0], parts[1]);
                }
            }

            file.close();

            graph.display();

            var distances = GraphAlgorithms.shortestPath(graph, "A");
            String closestCity = "";
            int minDistance = Integer.MAX_VALUE;
            for (var entry : distances.entrySet()) {
                if (entry.value < minDistance && !entry.key.equals("A") && !entry.key.startsWith("T")) {
                    minDistance = entry.value;
                    closestCity = entry.key;
                }
            }

            System.out.printf("Closest city to %s: %s", vertexData.get("A"), vertexData.get(closestCity));
            System.out.printf("\nDistances from %s:\n", vertexData.get("A"));
            for (var entry : distances.entrySet()) {
                if (!entry.key.equals("A") && !entry.key.startsWith("T")) {
                    System.out.println(vertexData.get(entry.key) + " -> " + entry.value);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
{
	A:	Data: A	Neighbors: [ 4 TD TA TB TC ],
	B:	Data: B	Neighbors: [ 1 TF ],
	C:	Data: C	Neighbors: [ 1 TO ],
	D:	Data: D	Neighbors: [ 1 TH ],
	E:	Data: E	Neighbors: [ 1 TD ],
	F:	Data: F	Neighbors: [ 1 TK ],
	TA:	Data: TA	Neighbors: [ 3 TH TK A ],
	TB:	Data: TB	Neighbors: [ 5 TC TN A TI TJ ],
	TC:	Data: TC	Neighbors: [ 7 TF TG TK TN A TB TD ],
	TD:	Data: TD	Neighbors: [ 4 TL A E TC ],
	TE:	Data: TE	Neighbors: [ 3 TH TK TL ],
	TF:	Data: TF	Neighbors: [ 5 TC TN TO TG B ],
	TG:	Data: TG	Neighbors: [ 3 TF TI TC ],
	TH:	Data: TH	Neighbors: [ 4 TE TN D TA ],
	TI:	Data: TI	Neighbors: [ 4 TG TJ TB TK ],
	TJ:	Data: TJ	Neighbors: [ 3 TB TI TL ],
	TK:	Data: TK	Neighbors: [ 7 F TI TL TN TA TC TE ],
	TL:	Data: TL	Neighbors: [ 4 TD TE TJ TK ],
	TM:	Data: TM	Neighbors: [ 0 ],
	TN:	Data: TN	Neighbors: [ 6 TH TK TB TO TC TF ],
	TO:	Data: TO	Neighbors: [ 3 TN TF C ],
}
Closest city to Milwaukee: Kenosha
Distances from Milwaukee:
Madison -> 3
Appleton -> 4
Waukesha -> 3
Kenosha -> 2
Racine -> 3

Process finished with exit code 0

 */