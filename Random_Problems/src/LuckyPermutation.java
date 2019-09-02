import java.io.*;

public class LuckyPermutation {
    public  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    static int candies[][];

    public static void main(String args[]) throws IOException {
        int val = Integer.parseInt(br.readLine());
        if( val%2 != 0) {
            int out = 0;
            int solution[] = new int[val];
            int numbers[] = new int[val];
            int midle[] = new int[val];
            for (int i = 0; i < val; i++) {
                numbers[i] = val-i-1;
                solution[i] = i;
                int temp = 0;
                if(numbers[i] > solution[i]){
                    temp = solution[i]+val-numbers[i];
                }else{
                    temp = solution[i] - numbers[i];
                }

                midle[i] = temp;
            }

            for (int i = 0; i < val; i++) {
                wr.write(String.valueOf(numbers[i])+" ");
            }
            wr.write("\n");
            for (int i = 0; i < val; i++) {
                wr.write(String.valueOf(midle[i])+" ");
            }
            wr.write("\n");
            for (int i = 0; i < val; i++) {
                wr.write(String.valueOf(solution[i])+" ");
            }


        }else{
            wr.write("-1");
        }

        wr.flush();
    }
}
