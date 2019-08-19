import java.io.*;
import java.util.PriorityQueue;

public class Madrid {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            String data[] = br.readLine().split(" ");
            int colums = Integer.parseInt(data[0]);
            int rows = Integer.parseInt(data[1]);

            int matriz[][] = new int[colums][rows];

            for (int j = 0; j < rows ; j++) {
                String data1[] = br.readLine().split(" ");
                for (int k = 0; k <colums; k++) {
                    matriz[j][k] = Integer.parseInt(data1[k]);

                }
            }

            int result = getBestPath(matriz);

            wr.write(result+ "\n");

        }

        wr.flush();
    }

     static int bestDistance;

    private static int getBestPath(int[][] matriz) {
        bestDistance = 0;
        PriorityQueue<Integer> paths = new PriorityQueue<>();

        int best = count(0,0,matriz, 0);

        return best;
    }

    private static int count(int i, int j, int[][] mat, int bestValue) {
        if(i==mat.length-1 && j==mat[0].length-1){
            return bestValue;
        }
        int value1 = 0;
        int value2 = 0;
        if(i<mat.length-1){
            value1 = count(i+1,j,mat,bestValue+mat[i][j]);
        }

        if(j<mat[0].length-1){
            value2 = count(i,j+1,mat,bestValue+mat[i][j]);
        }

        return Math.max(value1,value2);
    }


}
