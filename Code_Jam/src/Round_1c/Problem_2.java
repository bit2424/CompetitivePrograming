package Round_1c;

import java.io.*;

public class Problem_2 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());
        for(int I = 0; I<cases; I++){
            String Solution = Solve();
            wr.write("Case #"+ (I+1) +": "+Solution+"\n");

        }
        wr.flush();
    }

    private static String Solve() {
        return null;
    }
}
