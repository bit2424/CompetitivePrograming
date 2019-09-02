import java.io.*;

public class CF6_p2 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int lenght = Integer.parseInt(br.readLine());
        String line[] = br.readLine().split("");

        StringBuilder ap = new StringBuilder();

        int s = lenght;
        for (int i = 0; i < s; i++) {

            if(lenght%2 == 0){
                ap.insert(0,line[i]);
            }else{
                ap.append(line[i]);
            }
            lenght--;
        }

        wr.write(ap.toString());

        wr.flush();
    }
}
