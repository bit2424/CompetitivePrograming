import java.io.*;

public class Cesar_Legion {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data[] = br.readLine().split(" ");
        int n1 = Integer.parseInt(data[0]);
        int n2 = Integer.parseInt(data[1]);
        int k1 = Integer.parseInt(data[2]);
        int k2 = Integer.parseInt(data[3]);
        dp = new int[n1+1][n2+1][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        int a = Solve(n1,n2,k1,k2,0)%cons;


        int b = Solve(n1,n2,k1,k2,1)%cons;

        wr.write(String.valueOf((a+b)%cons));
        wr.flush();
    }

    public static int dp [][][];
    public static int cons = 100000000;

    private static int Solve(int n1, int n2, int k1, int k2,int pos) {
        if(n1 == 0 && n2 == 0){
            return 1;
        }
        if(dp[n1][n2][pos] != -1){
            return dp[n1][n2][pos];
        }

        long sol = 0;

        if(pos == 1){

            for (int i = 1; i <= k1; i++) {
                if(i<=n1){
                    sol += Solve(n1-i, n2, k1, k2, 0);
                    sol %= cons;
                }else{
                   break;
                }
            }
            dp[n1][n2][pos] = (int)(sol%cons);
            return dp[n1][n2][pos];
        }else{

            for (int i = 1; i <= k2; i++) {
                if(i<=n2){
                    sol += Solve(n1, n2-i, k1, k2, 1);
                    sol %= cons;
                }else{
                    break;
                }
            }
            dp[n1][n2][pos] = (int)(sol%cons);
            return dp[n1][n2][pos];
        }
    }
}
