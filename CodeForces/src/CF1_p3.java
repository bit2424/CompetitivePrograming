import java.io.*;

//Not solved

public class CF1_p3 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int mod = 1000000007;

    public static void main(String args[]) throws IOException {
        String data[] = br.readLine().split(" ");
        int n_E = Integer.parseInt(data[0]);
        int Sum = Integer.parseInt(data[1]);
        int duration[] = new int[n_E];
        int type[] = new int[n_E];
        DP = new long[n_E][Sum+1][4];
        for (int i = 0; i < n_E; i++) {
            for (int j = 0; j < Sum+1; j++) {
                DP[i][j][1] = -1;
                DP[i][j][2] = -1;
                DP[i][j][3] = -1;
            }
        }
        boolean visited[] = new boolean[n_E];
        for (int i = 0; i < n_E; i++) {
            data = br.readLine().split(" ");
            duration[i] = Integer.parseInt(data[0]);
            type[i] = Integer.parseInt(data[1]);
        }

        long count = 0;

        //for (int i = 0; i < n_E; i++) {
            count += Solve(duration,type,0,Sum,0,visited.clone())%mod;
            count = count%mod;
        //}

        wr.write(String.valueOf(count%mod));
        wr.flush();
    }
    static long[][][] DP;
    private static long Solve(int[] duration, int[] type, int pos, int sum, int a_type, boolean[] visited) {
        if (sum == 0){
            return DP[pos][sum][type[pos]]=1;
        }
        if(sum<0){
            return DP[pos][sum][type[pos]]=0;
        }

        if(DP[pos][sum][type[pos]] != -1){
            return DP[pos][sum][type[pos]];
        }

        long sol = 0;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && type[i] != a_type) {
                visited[i] = true;
                sol += Solve(duration, type, i, sum - duration[i], type[i], visited.clone());
                sol %= mod;
                visited[i] = false;
            }
        }

        return DP[pos][sum][type[pos]] = sol%mod;
    }

}
