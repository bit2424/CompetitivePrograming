import java.io.*;
import java.util.ArrayList;

public class elecciones {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        String Data[] = br.readLine().split(" ");
        int vertex = Integer.parseInt(Data[0]);
        int conections = Integer.parseInt(Data[1]);
        ArrayList<ArrayList<pair>> graph = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < conections; i++) {
            Data = br.readLine().split(" ");
            int a = Integer.parseInt(Data[0])-1;
            int b = Integer.parseInt(Data[1])-1;
            double value = Double.parseDouble(Data[2]);
            graph.get(a).add(new pair(b,value));
        }

        double result = Prim(graph);

        wr.write(String.valueOf(result));
        wr.flush();
    }

    private static double Prim(ArrayList<ArrayList<pair>> graph) {
        int V = graph.size();
        int parent[] = new int[V];
        double key[] = new double[V];

        boolean mstSet[] = new boolean[V];

        for(int i = 0; i< V ; i++){
            key[i]= Double.MAX_VALUE;
        }

        key[0] = 0;

        parent[0] = -1;

        for (int i = 0; i < V-1; i++) {
            int u = minKey(key,mstSet);
            mstSet[u] = true;

            for (int j = 0; j < graph.get(u).size(); j++) {
                if(mstSet[graph.get(u).get(j).getX()] == false && graph.get(u).get(j).getValue() <= key[graph.get(u).get(j).getX()] ){
                    parent[j] = u;
                    key[graph.get(u).get(j).getX()] = graph.get(u).get(j).getValue();
                }
            }
        }

        double result = 0;

        for (int i = 0; i < V; i++) {
            result += key[i];
        }

        return result;
    }

    private static int minKey(double[] key, boolean[] mstSet) {
        double min = Double.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < key.length; i++) {
            if(mstSet[i] == false && key[i]< min){
                min = key[i];
                min_index = i;
            }
        }

        return  min_index;
    }
}

class pair implements Comparable<pair>{
    int x;
    double value;



    public pair(int x, double value) {
        this.x = x;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int compareTo(pair pair) {
        return 0;
    }
}
