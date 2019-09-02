import java.io.*;
import java.util.HashSet;

public class CF7_p1 {
    public  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    static int candies[][];

    public static void main(String args[]) throws IOException {
        HashSet<Integer> values = new HashSet<>();
        int elemA = Integer.parseInt(br.readLine());
        int A[] = new int[elemA];
        String data[] = br.readLine().split(" ");
        for (int i = 0; i < elemA; i++) {
            A[i] = Integer.parseInt(data[i]);
            values.add(A[i]);
        }
        int elemB = Integer.parseInt(br.readLine());
        int B[] = new int[elemB];
        data = br.readLine().split(" ");
        for (int i = 0; i < elemB; i++) {
            B[i] = Integer.parseInt(data[i]);
            values.add(B[i]);
        }

        boolean found = false;

        for (int i = 0; i < elemA && !found; i++) {
            for (int j = 0; j < elemB && !found; j++) {
                if(!values.contains(A[i]+B[j])){
                    wr.write(A[i] + " "+B[j]);
                    found = true;
                }
            }
        }
        wr.flush();

    }
}
