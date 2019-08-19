import java.io.*;

public class Pay_The_Prices {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data = br.readLine();
        int sum = Integer.parseInt(data);

        DP = new  long[sum+1];



        while (data != null){
            String info[] = data.split(" ");

            for (int i = 0; i < DP.length; i++) {
                DP[i] = -1;
            }

            long sol = 0;

            if(info.length == 1){
                sol = Solve(sum,1,1001);
            }else if(info.length == 2){
                sol = Solve(sum,1,Integer.parseInt(info[1]));
            }else{
                sol = Solve(sum,Integer.parseInt(info[1]),Integer.parseInt(info[2]));
            }

            wr.write(String.valueOf(sol)+"\n");

            data = br.readLine();
        }

        wr.flush();
    }

    static long[] DP;

    private static long Solve(long sum, int start, int end) {
        if (sum == 0){
            return 1;
        }
        if(DP[(int)sum] != -1){
            return DP[(int)sum];
        }

        long sol = 0;

        for (int i = start; i < end; i++) {
            if(sum-i<0)
                break;
            sol += Solve(sum-i, i, end);
        }

        DP[(int)sum] = sol;
        return sol;
    }
}
