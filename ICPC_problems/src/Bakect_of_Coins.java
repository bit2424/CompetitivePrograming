import java.io.*;

public class Bakect_of_Coins {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String info = br.readLine();



        while (info != null && !info.equals("") ){
            String data[] = info.split(" ");
            long N = Integer.parseInt(data[0]);
            long w = Integer.parseInt(data[1]);
            long d = Integer.parseInt(data[2]);
            long Size = Integer.parseInt(data[3]);
            long a = ((((N)*(N-1))/2)*w - Size)/d;
            if(a == 0) {
                System.out.println(N);
            }else{
                System.out.println(a);
            }
            info = br.readLine();
        }
    }
}
