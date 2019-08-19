

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class walker {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            String[] data = br.readLine().split(" ");
            int  nPeople =  Integer.parseInt(data[0]);
            int conections = Integer.parseInt(data[1]);
            int positionInfected = Integer.parseInt(data[2]);
            int points[] = new int[nPeople];

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            data = br.readLine().split(" ");

            for (int j = 0; j < nPeople; j++) {
                graph.add(new ArrayList<>());
                points[j] = Integer.parseInt(data[j]);
            }

            points[positionInfected] = -1;

            for (int j = 0; j < conections; j++) {
                data = br.readLine().split(" ");
                int a = Integer.parseInt(data[0]);
                int b = Integer.parseInt(data[1]);
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            String solution = seeDeadOnes(graph,points,positionInfected);
            wr.write(solution+" \n");
        }
        wr.flush();
    }

    private static String seeDeadOnes(ArrayList<ArrayList<Integer>> graph, int[] points, int positionInfected) {
        Queue<Integer> list = new LinkedList<>();
        boolean infected[] = new boolean[points.length];
        Queue<Integer> inf = new LinkedList<>();
        list.offer(positionInfected);
        while(!list.isEmpty()){
            int position = list.poll();
            if(infected[position]){
                continue;
            }
            infected[position] = true;
            inf.offer(position);
            for (int i = 0; i < graph.get(position).size(); i++) {
                if(points[position] < 0){
                    points[graph.get(position).get(i)] -= 1;
                    if (points[graph.get(position).get(i)]<0 && !infected[graph.get(position).get(i)]){
                        list.offer(graph.get(position).get(i));
                    }
                }

            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; !inf.isEmpty(); i++) {
            out.append(inf.poll());
            out.append(" ");
        }

        return out.toString();
    }
}
