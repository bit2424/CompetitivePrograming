import java.io.*;

public class ACM_Team {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String d[] = br.readLine().split(" ");
        int n = Integer.parseInt(d[0]);
        int m = Integer.parseInt(d[1]);
        boolean matrix[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String data[] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (data[j].equals("1"));
            }
        }
        int solution[] = solve(matrix,0,0);
        wr.write(String.valueOf(solution[0])+"\n");
        wr.write(String.valueOf(solution[1])+"\n");
        wr.flush();
        wr.close();
        br.close();
    }

    private static int[] solve(boolean[][] matrix, int k, int m) {
        int max = 0;
        int number = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = 0;
                for (int K = 0; K < matrix[0].length; K++) {
                    if(matrix[i][K] || matrix[j][K]){
                        temp++;
                    }
                }
                if(temp > max){
                    max = temp;
                    number = 1;
                }else if(temp == max){
                    number++;
                }
            }
        }
        int Sol[] = {max,number};
        return Sol;
    }
}
