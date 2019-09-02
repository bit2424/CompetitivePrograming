import java.io.*;

public class CF6_p1 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String line[] = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int limit = Integer.parseInt(line[1]);

        String data[] =  br.readLine().split(" ");

        int result = 0;

        for (int i = 0; i < n; i++) {
            int  da = Integer.parseInt(data[i]);
            if(da<=limit){
                result += 1;
            }else{
                result += 2;

            }
        }

        wr.write(String.valueOf(result));
        wr.flush();
    }

}
