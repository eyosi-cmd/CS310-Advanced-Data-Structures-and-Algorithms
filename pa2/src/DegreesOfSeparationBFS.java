import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.SymbolGraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.BreadthFirstPaths;
public class DegreesOfSeparationBFS {

    private DegreesOfSeparationBFS() { }

    public static void main(String[] args) {
        String filename  = args[0];
        String separator = args[1];
        String center    = args[2];
        Stack<String> st = new Stack<String>();
        SymbolGraph sg = new SymbolGraph(filename, separator);
        Graph G = sg.graph();
        if (!sg.contains(center)) {
            StdOut.println(center + " not in database.");
            return;
        }
        String query  =  args[3];
        int s = sg.indexOf(center);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
            if (sg.contains(query)) {
                int t = sg.indexOf(query);
                if (bfs.hasPathTo(t)) {
                    int beaconnumber = bfs.distTo(t);
            for (int v : bfs.pathTo(t)) {
                    st.push(sg.nameOf(v));

            }
                //StdOut.printf("Done reading %s\n", filename);
                StdOut.printf("%s has a bacon number of %d.\n", query, beaconnumber/2);
                //StdOut.println();
                    while (st.size() > 1 && !st.isEmpty()) {
                        int i = sg.indexOf(st.pop());
                        int j = sg.indexOf(st.pop());
                        int top = sg.indexOf(st.peek());
                            StdOut.printf("%s was in the movie %s with %s\n", sg.nameOf(i), sg.nameOf(j), sg.nameOf(top));
                    }
                }
                else {
                    StdOut.println("Not connected");
                }
            }
            else {
                StdOut.println("   Not in database.");
            }
        }
}