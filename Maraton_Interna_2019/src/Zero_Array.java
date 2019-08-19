import java.io.*;
import java.util.Arrays;

public class Zero_Array {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));


    public  static void main(String args[]) throws IOException {
        int size = Integer.parseInt(br.readLine());

        String data[] = br.readLine().split(" ");
        int elements[] = new int[size];

        for (int i = 0; i < elements.length; i++) {
            elements[i] = Integer.parseInt(data[i]);
        }

        Arrays.sort(elements);

        for (int i = 0; i < elements.length-1; i++) {
            elements[i+1] -= elements[i];
            elements[i] = 0;
        }

        if(elements[elements.length-1] != 0){
            wr.write("NO");

        }else{
            wr.write("YES");

        }

        wr.flush();
    }

}
