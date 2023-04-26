
import CITS2200.Graph;
import CITS2200.ListLinked;
import CITS2200.Queue;
import CITS2200.Search;

/*
 * @author JoeldotSmith
 * Tree search implementing breadth first search and depth first search
 */

public class SearchImp implements Search {
    public int black = -1;
    public int white = 1;
    public int grey = 0;

    public int[] colours;
    public int[][] times;
    public int time;

    @Override
    public int[] getConnectedTree(Graph testGraph, int startVertex) {
        int[][] edge = testGraph.getEdgeMatrix();
        int[] colours = new int[testGraph.getNumberOfVertices()];
        int[] parents = new int[testGraph.getNumberOfVertices()];

        for(int index = 0; index < testGraph.getNumberOfVertices(); ++index) {
            colours[index] = white;
            parents[index] = -1;
        }

        Queue queue = new LinkedList();

        colours[startVertex] = grey;
        queue.enqueue(startVertex);

        while(!queue.isEmpty()) {
            int vertex = (Integer) queue.dequeue();

            int[] edges = edge[vertex];
            for(int toVertex = 0; toVertex < edges.length; ++toVertex) {
                if(edges[toVertex] == 0)
                    continue;

                if(colours[toVertex] == white) {
                    colours[toVertex] = grey;
                    parents[toVertex] = vertex;
                    queue.enqueue(toVertex);
                }
            }

            colours[vertex] = black;
        }

        return parents;
    }
    public int[] getDistances(Graph g, int startVertex) {
        // TODO: Implement getDistances.
        int a[] = {1, 2};
        return a;
    }
    
    public int[][] getTimes(Graph g, int startVertex) {
        // TODO: Implement getTimes.
        int a[][] = {{1, 2}, {3, 4}};
        return a;
        
    }
}

