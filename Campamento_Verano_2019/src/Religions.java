import java.io.*;

public class Religions {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data = br.readLine();
        int i = 1;
        while(!data.equals("0 0")){
            String info[] = data.split(" ");
            wr.write("Case "+i+": "+Solve(info) +"\n");
            i++;
            data = br.readLine();
        }
        wr.flush();
    }

    private static String Solve(String[] info) throws IOException {
        int conections = Integer.parseInt(info[1]);
        int nodes = Integer.parseInt(info[0]);
        UnionFind test = new UnionFind(nodes);
        for (int i = 0; i < conections; i++) {
            String data[] = br.readLine().split(" ");
            int a = Integer.parseInt(data[0])-1;
            int b = Integer.parseInt(data[1])-1;
            test.union(a,b);
        }

        return String.valueOf(test.cont);
    }


}

class UnionFind{
    private int[] id;
    public int cont;
    private int[] sz;

    public UnionFind(int cont) {
        this.cont = cont;
        id = new int[cont];
        sz = new int[cont];
        for (int i = 0; i < cont; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int find(int p){
        while(p != id[p]){
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean find(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i != j){
            cont--;
        }
        if(sz[i]< sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
