import java.io.*;

public class CF2_p1 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int  n  = Integer.parseInt(br.readLine());
        wr.write(String.valueOf(Solve(n,2)+1));
        wr.flush();
    }

    private static long Solve(int n,int i) {
        if(n==1){
            return 0;
        }
        if(n==i){
            return 4*(i-1);
        }

        return 4*(i-1)+Solve(n,i+1);
    }
}
