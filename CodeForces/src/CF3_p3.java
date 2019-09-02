import java.io.*;

public class CF3_p3 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            String data[] = br.readLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int k = Integer.parseInt(data[1]);
            long solve = Play(n,k,Integer.parseInt(data[2]),Integer.parseInt(data[3]),0);
            wr.write(String.valueOf(solve)+"\n");
        }
        wr.flush();
    }

    private static long Play(int battery, int turns, int a, int b,int freeTurns) {
        long right = turns;
        long left = 0;
        long mid = (right+left)/2;
        long lastToWork = -1;

        boolean keep = true;

        while (!(left>right)){
            long temp = (turns-mid);
            if(battery>mid*a+temp*b){
                lastToWork = mid;
                left = mid+1;

            }else{
                right = mid-1;
            }
            mid = (right+left)/2;
        }

        return lastToWork;



    }
}
