import java.io.*;

public class a1_Wasted_Time {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        String data[] = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);

        int coordenates[][] = new int[n][2];

         double distance = 0;
         double time = 0;

        for (int i = 0; i < n; i++) {
            data = br.readLine().split(" ");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            coordenates[i][0] = x;
            coordenates[i][1] = y;
        }

        for (int i = 0; i < n-1; i++) {
            distance += Math.sqrt(Math.pow(coordenates[i][0]-coordenates[i+1][0],2)  + Math.pow(coordenates[i][1]-coordenates[i+1][1],2));
        }

        time = distance/50;
        time *= k;

        wr.write(String.valueOf(time));
        wr.flush();
    }
}
