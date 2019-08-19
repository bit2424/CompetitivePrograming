import java.io.*;

public class CF1_p4 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int mod = 1000000007;

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            String data1 = br.readLine();
            String data2 = br.readLine();

            int pos2 = 0;
            boolean compared = false;
            int e1 = 1;
            int e2 = 0;
            int elements = data2.length();
            for (int j = 0; j < data1.length(); j++) {
                compared = false;
                while (data1.length()>j+1 && data1.charAt(j)==data1.charAt(j+1)){j++;e1++;}
                while (data2.length()>pos2  && data1.charAt(j)== data2.charAt(pos2)){elements--;pos2++;compared=true;e2++;}
                if(!compared || e1>e2){
                    compared = false;
                    break;
                }
                e1 = 1;
                e2 = 0;
            }
            if(compared && elements==0){
                wr.write("YES\n");
            }else{
                wr.write("NO\n");
            }
        }

        wr.flush();
    }
}
