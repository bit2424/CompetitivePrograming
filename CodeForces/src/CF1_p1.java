import java.io.*;

public class CF1_p1 {

    //Solved
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data[] = br.readLine().split(" ");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);
        int c = Integer.parseInt(data[2]);
        int d =Integer.parseInt(data[3]);

        int distA_B = Math.abs(a-b);
        int distB_C = Math.abs(b-c);
        int distA_C = Math.abs(c-a);
        if(Math.abs(distA_B) < d){
            distA_B = Math.abs(d-distA_B);
        }else{
            distA_B = 0;
        }

        if(Math.abs(distA_C) < d){
            distA_C = Math.abs(d-distA_C);
        }else{
            distA_C = 0;
        }

        if(Math.abs(distB_C) < d){
            distB_C = Math.abs(d-distB_C);
        }else{
            distB_C = 0;
        }

        char mid = finM(a,b,c);

        long sol = 0;
        if(mid == 'a'){
            sol += (distA_C+distA_B);
        }else if(mid == 'b'){
            sol = (Math.abs(distA_B)+Math.abs(distB_C));
        }else{
            sol = (Math.abs(distB_C)+Math.abs(distA_C));
        }

        wr.write(String.valueOf(sol));
        wr.flush();

    }

    private static char finM(int a, int b, int c) {
        if((a>=b && a<=c) ||(a<=b && a>=c)){
            return 'a';
        }

        if((a>=b && b>=c) ||(a<=b && b<=c)){
            return 'b';
        }

        if((a>=c && b<=c) ||(a<=c && b>=c)){
            return 'c';
        }
        return 'a';
    }
}
