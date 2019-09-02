import java.io.*;
import java.util.HashSet;

public class CF7_p2 {

    public  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        int elem = Integer.parseInt(br.readLine());
        int A[] = new int[elem];
        String data[] = br.readLine().split(" ");
        int distances[][] = new int[elem][2];
        int state = 0;
        int comodin = 0;
        long result = 0;

        for (int i = 0; i < elem; i++) {
            A[i] = Integer.parseInt(data[i]);
            distances[i][0] = Math.abs(1-A[i]);
            distances[i][1] = Math.abs(-1-A[i]);

            if (distances[i][0]<distances[i][1]){
                result += distances[i][0];
            }else if(distances[i][0]>distances[i][1]){
                state--;
                result += distances[i][1];
            }else {
                comodin++;
            }

            if(state == -2){
                state = 0;
            }
        }

        if(state<0){
            if(comodin == 0){
                result += 2;
            }
        }

        result += comodin;

        wr.write(String.valueOf(result));
        wr.flush();
    }
}
