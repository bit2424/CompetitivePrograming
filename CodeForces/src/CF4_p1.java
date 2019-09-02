import java.io.*;

public class CF4_p1 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data[] = br.readLine().split(" ");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);
        int c = Integer.parseInt(data[2]);

        if(a<=b && a<=c){
            wr.write("Yes");
        }else{
            wr.write("No");
        }
        wr.flush();
    }
}
