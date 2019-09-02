import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Important_exam {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data[] = br.readLine().split(" ");

        int nEstudets = Integer.parseInt(data[0]);
        int nQues = Integer.parseInt(data[1]);

        int anserwMatrix[][] = new int[5][nQues];

        for (int i = 0; i < nEstudets; i++) {
            String info = br.readLine();
            for (int j = 0; j < info.length(); j++) {
                if(info.charAt(j) == 'A'){anserwMatrix[0][j]++;}
                if(info.charAt(j) == 'B'){anserwMatrix[1][j]++;}
                if(info.charAt(j) == 'C'){anserwMatrix[2][j]++;}
                if(info.charAt(j) == 'D'){anserwMatrix[3][j]++;}
                if(info.charAt(j) == 'E'){anserwMatrix[4][j]++;}
            }
        }
        String info[] = br.readLine().split(" ");
        int solution = 0;

        for (int i = 0; i < info.length; i++) {
            int temp = 0;
            for (int j = 0; j < 5; j++) {
                if(temp <= anserwMatrix[j][i]){
                    temp = anserwMatrix[j][i];
                }
            }
            solution += temp*Integer.parseInt(info[i]);
        }

        wr.write(String.valueOf(solution));
        wr.flush();

    }

}
