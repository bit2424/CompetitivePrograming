import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CF3_p2 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            String d[] = br.readLine().split(" ");
            int n = Integer.parseInt(d[0]);
            int k = Integer.parseInt(d[1]);

            String data[] = br.readLine().split(" ");
            int numbers[] = new int[data.length];

            for (int j = 0; j < data.length; j++) {
                numbers[j] = Integer.parseInt(data[j]);
            }

            Arrays.sort(numbers);

            int B = 0;

            boolean posible =true;

            int start = k + numbers[0];
            int finish = numbers[numbers.length-1]-k;

            B=start;
            if(start>=finish){
                posible = true;
            }else{
                posible = false;
            }

            if(posible){

                wr.write(String.valueOf(B)+"\n");
            }else{

                wr.write(-1+"\n");
            }
        }


        wr.flush();

    }
}
