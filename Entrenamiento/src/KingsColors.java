import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class KingsColors {

    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();  //number of nodes
        k = sc.nextInt();  // number of colors

        for (int i = 0; i < 2501; i++) {
            for (int j = 0; j < 2501; j++) {
                dp[i][j] = -1;
            }
        }
        long solution = k%1000000007*recurse(1,1)%1000000007;
        System.out.println(solution%1000000007);
    }

    static long dp[][] = new long[2501][2501];

    static int n = 0;
    static  int k = 0;

    private static long recurse(int usados,int elementos) {
        if(elementos == n){
           if(k == usados){
               return 1;
           }else{
               return 0;
           }
        }



        if(dp[usados][elementos] != -1){
            return dp[usados][elementos];
        }

        long nuevos = 0;
        long viejos = 0;

        if(usados < k) {
            nuevos = ((k-usados) % 1000000007*recurse(usados+1, elementos+1) % 1000000007) % 1000000007;
        }

        viejos = ((usados-1) % 1000000007*recurse(usados,elementos+1) % 1000000007) % 1000000007;

        dp[usados][elementos] = (nuevos%1000000007 + viejos%1000000007)% 1000000007;

        return dp[usados][elementos];
    }
}
