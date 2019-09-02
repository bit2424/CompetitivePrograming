import java.io.*;

public class BearFCriminals {
    public  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    static int candies[][];

    public static void main(String args[]) throws IOException {
        String val[] = br.readLine().split(" ");
        String values[] = br.readLine().split(" ");

        int elements = Integer.parseInt(val[0]);
        int position = Integer.parseInt(val[1])-1;
        int max = position+1;
        int min = position-1;

        int capture =  0;
        int out = values[position].equals("1")? 1 : 0;

        int salio = 0;

        while(salio != 2){
            salio = 0;

            if(max<elements){
                capture += values[max].equals("1")? 1 : 0;
                max++;
            }else{
                salio++;
            }

            if(min>=0){
                capture += values[min].equals("1")? 1 : 0;
                min--;
            }else {
                salio++;
            }

            if(capture==2 || salio==1){
                out += capture;
            }

            capture = 0;
        }

        wr.write(String.valueOf(out));
        wr.flush();

    }
}
