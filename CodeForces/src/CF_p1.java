import java.io.*;

public class CF_p1 {
    //Solved
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int ways = Integer.parseInt(br.readLine());
        wr.write(String.valueOf(Solve(ways)));
        wr.flush();
    }

    static int pNumber;

    private static long Solve(int ways) {
        if(ways == 1){
            return 0;
        }else if(ways == 2){
            return 2;
        }else {
            /*boolean mark[][] = new boolean[3][ways];
            pNumber = ways*3;
            return P(true,true,0,0,mark,0);*/
            if(ways%2 == 0){
                long exp = ways/2;
                return (long)Math.pow(2,exp);
            }else{
                return 0;
            }
        }
    }

}
