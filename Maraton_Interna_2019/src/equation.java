import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class equation {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());

        br.readLine();

        for (int i = 0; i < cases; i++) {
            String line = br.readLine();
            Queue<Integer> sum = new LinkedList<>();
            Queue<Integer> mult = new LinkedList<>();

            while(line != null && !line.equals("")){

                line = br.readLine();
            }
        }


    }

}
