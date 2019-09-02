import java.io.*;

public class ValentinesDay {
    //Each test case contains a line with 5 integers separated by spaces A B X Y Z (1 <= A, B, C, D, E <= 10^8).

    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String atgs[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            wr.write(Solve(br.readLine())+ "\n");
        }

        wr.flush();
    }

    private static String Solve(String readLine) {
        String data[] = readLine.split(" ");
        long a = Long.parseLong(data[0]);
        long b = Long.parseLong(data[1]);
        long x = Long.parseLong(data[2]);
        long y = Long.parseLong(data[3]);
        long z = Long.parseLong(data[4]);
        if(a*b >= (2*x*y + 2*x*z + 2*z*y) ){
            return "POSSIBLE";
        }else{
            return "IMPOSSIBLE";
        }
    }

}
