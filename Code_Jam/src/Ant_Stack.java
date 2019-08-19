import java.io.*;

public class Ant_Stack {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());
        for(int I = 0; I<cases; I++){
            String Solution = Solve();
            wr.write("Case #"+ (I+1) +": "+Solution+"\n");

        }
        wr.flush();
    }

    static int ants[];

    static int memo[][];

    private static String Solve() throws IOException {
        int number_ants = Integer.parseInt(br.readLine());
        ants = new int[number_ants];
        String data[] = br.readLine().split(" ");

        for(int I = 0; I<data.length ; I++){
            ants[I] = Integer.parseInt(data[I]);
        }

        memo = new int[number_ants+1][100001];
        for(int I = 0; I<number_ants+1 ; I++){
            for(int K = 0 ;K< 100001;K++){
                memo[I][K] = -1;
            }
        }

        return String.valueOf(max_Ant_Stack(ants, number_ants -1, 100000));
    }

    private static int max_Ant_Stack(int[] ants, int number_ants, int maxWeight) {
        if(number_ants == -1){
            return 0;
        }
        if(maxWeight == 0){
            return 0;
        }
        if(memo[number_ants][maxWeight] == -1){
            if(ants[number_ants] > maxWeight){
                memo[number_ants][maxWeight] = max_Ant_Stack(ants,number_ants-1,maxWeight);
                return memo[number_ants][maxWeight];
            }else{
                int a = max_Ant_Stack(ants,number_ants-1,maxWeight);
                int b = max_Ant_Stack(ants,number_ants-1,Math.min(ants[number_ants]*6,maxWeight-ants[number_ants]))+1;
                memo[number_ants][maxWeight] = Math.max(a,b);
                return memo[number_ants][maxWeight];
            }
        }else{
            return memo[number_ants][maxWeight];
        }
    }
}
