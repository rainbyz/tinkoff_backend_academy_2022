import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution4 {
    private static class Node {
        int to;
        int weight;

        public Node(int to, int wt) {
            this.to = to;
            this.weight = wt;
        }
    }

    private static int n;
    private static ArrayList<Node>[] edges;

    public Solution4() {
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v, int wt) {
        edges[u].add(edges[u].size(), new Node(v, wt));
        edges[v].add(edges[v].size(), new Node(u, wt));
    }

    // BFS method calc
    public void solutionBFS(int src) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        dist[src] = 0;
        queue.addLast(src);

        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            for (int i = 0; i < edges[v].size(); i++) {
                if (dist[edges[v].get(i).to] >
                        dist[v] + edges[v].get(i).weight) {

                    dist[edges[v].get(i).to] =
                            dist[v] + edges[v].get(i).weight;

                    if (edges[v].get(i).weight == 0) {
                        queue.addFirst(edges[v].get(i).to);
                    } else {
                        queue.addLast(edges[v].get(i).to);
                    }
                }
            }
        }

        // print result
        int sum = 0;
        for (int j : dist) {
            sum += j;
        }

        System.out.print(sum);

    }

    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            // init
            String[] line = input.readLine().split("\\s");

            n = Integer.parseInt(line[0]);
            edges = new ArrayList[n];
            Solution4 graph = new Solution4();
            int m = Integer.parseInt(line[1]);

            int i = 0;
            while (i < m) {
                line = input.readLine().split("\\s");
                graph.addEdge(Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]) - 1, Integer.parseInt(line[2]));
                i++;
            }
            int src = 0;

            graph.solutionBFS(src);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
