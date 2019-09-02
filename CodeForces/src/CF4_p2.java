import java.io.*;

public class CF4_p2 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data[] = br.readLine().split(" ");
        long a = Integer.parseInt(data[0]);
        long b = Integer.parseInt(data[1]);

        wr.write(String.valueOf(Math.max(Solve(a,b),Solve(b,a))));
        wr.flush();
    }

    private static long Solve(long a, long b) {
        double n = a;
        double m = b;

        double reps = Math.round(n/3);

        long op1 = 0;

        if(n%3 == 1){
            op1 = (long)(reps*(Math.ceil(m/2))+ Math.round(m/3));
        }else{
            op1 = (long)(reps*(Math.ceil(m/2)));
        }
        return op1;

    }
}
