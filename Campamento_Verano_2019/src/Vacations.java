import java.io.*;

public class Vacations {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int Cases = Integer.parseInt(br.readLine());
        int numbers[] = new int[Cases];
        String info[] = br.readLine().split(" ");
        for (int i = 0; i < Cases; i++) {
            numbers[i] = Integer.parseInt(info[i]);
        }
        dp = new int[3][Cases];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        wr.write(String.valueOf(Solve(0,0,numbers)));
        wr.flush();
    }

    static int[][] dp;

    private static int Solve(int ant, int pos, int[] numbers) {
        if(pos == numbers.length){
            return 0;
        }
        if(dp[ant][pos] != -1){
            return dp[ant][pos];
        }

        if(numbers[pos] == 0){
            dp[ant][pos] = Solve(0, pos+1, numbers)+1;
            return dp[ant][pos];
        }

        if(numbers[pos] == 1){
            if(ant == 2) {
                dp[ant][pos] = Solve(0, pos + 1, numbers) + 1;
            }else{
                dp[ant][pos] = Solve(2, pos + 1, numbers);
            }
            return dp[ant][pos];
        }

        if(numbers[pos] == 2){
            if(ant == 1) {
                dp[ant][pos] = Solve(0, pos + 1, numbers) + 1;
            }else{
                dp[ant][pos] = Solve(1, pos + 1, numbers);
            }
            return dp[ant][pos];
        }

        if(numbers[pos] == 3){
            int a = 0;

            if(ant == 1) {
                a = Solve(0, pos + 1, numbers) + 1;
            }else{
                a = Solve(1, pos + 1, numbers);
            }

            int b = 0;
            if(ant == 2) {
                b = Solve(0, pos + 1, numbers) + 1;
            }else{
                b = Solve(2, pos + 1, numbers);
            }

            dp[ant][pos] = Math.min(a,b);
            return dp[ant][pos];
        }

        return 0;
    }
}
