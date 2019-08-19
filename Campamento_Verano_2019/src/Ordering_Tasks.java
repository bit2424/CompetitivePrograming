import java.io.*;
import java.util.ArrayList;

//Graphs

public class Ordering_Tasks {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String d = br.readLine();
        while(!d.equals("0 0")){
            String data[] = d.split(" ");
            int tasks = Integer.parseInt(data[0]);
            int conections = Integer.parseInt(data[1]);
            wr.write(Solve(tasks,conections));
            d = br.readLine();
        }
    }

    private static String Solve(int tasks, int conections) throws IOException {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < tasks; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < conections; i++) {
            String a[] = br.readLine().split(" ");
            int x = Integer.parseInt(a[0])-1;
            int y = Integer.parseInt(a[1])-1;
            graph.get(x).add(y);
        }
        return "";
    }
}
