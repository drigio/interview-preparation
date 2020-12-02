import GraphImp.GraphImp;

public class GraphMain {
    public static void main(String args[]) {
        GraphImp g = new GraphImp();

        g.print();
        g.BFS();

        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);

        g.addEdge(1, 2, true);
        g.addEdge(2, 1, false);
        g.addEdge(2, 3, true);
        g.addEdge(3, 1, true);
        g.addEdge(3, 2, false);

        g.print();
        System.out.println("BFS :-");
        g.BFS();
        System.out.println("DFS :-");
        g.DFS();

        System.out.println("No of Vertices in Graph is " + g.getVertexCount());
        System.out.println("No of Edges in Graph is " + g.getEdgesCount());

        System.out.println("Does an edge from 1 to 3 exist? " + g.hasEdge(1, 3));
        System.out.println("Does an edge from 3 to 1 exist? " + g.hasEdge(3, 1));

        System.out.println("Does vertex 1 exist? " + g.hasVertex(1));
        System.out.println("Does vertex 5 exist? " + g.hasVertex(5));
    }
}
