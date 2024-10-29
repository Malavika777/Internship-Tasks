import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JobSchedulingProblem {

    static class Job implements Comparable<Job> {
        char id;
        int deadline;
        int profit;

        @Override
        public int compareTo(Job otherJob) {
            return otherJob.profit - this.profit;
        }

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        JobSchedulingProblem jobSheduling = new JobSchedulingProblem();
        ArrayList<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job('a', 4, 100));
        jobs.add(new Job('b', 2, 11));
        jobs.add(new Job('c', 3, 43));
        jobs.add(new Job('d', 1, 30));
        jobs.add(new Job('e', 4, 5));

        Collections.sort(jobs);

        for (Job job: jobs) {
            System.out.println(job.id + " - " + job.deadline + " - " + job.profit);
        }
       
        jobSheduling.printJobSheduling(jobs, jobs.size());

    }

    private void printJobSheduling(ArrayList<Job> jobs, int size) {
        Boolean[] slots = new Boolean[size];

        Arrays.fill(slots, false);

        int result[] = new int[size];

        for (int i = 0; i < size; i++) {
            for (int j = jobs.get(i).deadline - 1; j >= 0; j--) {
                if (!slots[j]) {
                    result[j] = i;
                    slots[j] = true;
                    break;
                }
            }
        }
        for (int i = 0; i < jobs.size(); i++) {
            if (slots[i])
                System.out.print(jobs.get(result[i]).id + " -> ");
        }
    }
}


Graph Colouring Problem:

import java.util.*;
 
public class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
 
class Graph
{
    List<List<Integer>> adjList = null;
 
   
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
 
class Main23
{
    private static String[] color = {
            "", "BLUE", "GREEN", "RED", "YELLOW", "ORANGE", "PINK",
            "BLACK", "BROWN", "WHITE", "PURPLE", "VOILET"
    };
 
    public static void colorGraph(Graph graph, int n)
    {
        Map<Integer, Integer> result = new HashMap<>();
 
        for (int u = 0; u < n; u++)
        {
]            Set<Integer> assigned = new TreeSet<>();
 
            for (int i: graph.adjList.get(u))
            {
                if (result.containsKey(i)) {
                    assigned.add(result.get(i));
                }
            }
 
            int color = 1;
            for (Integer c: assigned)
            {
                if (color != c) {
                    break;
                }
                color++;
            }
 
            result.put(u, color);
        }
 
        for (int v = 0; v < n; v++)
        {
            System.out.println("The color assigned to vertex " + v + " is "
                    + color[result.get(v)]);
        }
    }
 
    public static void main(String[] args)
    {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 4), new Edge(0, 5), new Edge(4, 5),
                new Edge(1, 4), new Edge(1, 3), new Edge(2, 3), new Edge(2, 4)
        );
 
        int n = 6;
 
        Graph graph = new Graph(edges, n);
 
        colorGraph(graph, n);
    }
}
