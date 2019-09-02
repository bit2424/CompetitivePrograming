import javax.swing.*;
import java.io.*;
import java.util.PriorityQueue;

public class TBoxes {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        int numbers = Integer.parseInt(br.readLine());
        int max = 0;
        int min = 0;
        String data[] = br.readLine().split(" ");

        for (int i = 0; i < numbers; i++) {
            int ref = (Integer.parseInt(data[i]));
            if(i == 0){
                max = ref;
                min = ref;
            }else if(ref>max){
                max = ref;
            }else if(ref<min){
                min = ref;
            }
            wr.write(String.valueOf(max+min) +"\n");
        }

        wr.flush();
    }
}
