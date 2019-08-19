import java.io.*;

public class Anton_Danik {
    public  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    static int candies[][];

    public static void main(String args[]) throws IOException {
        br.readLine();
        String values[] = br.readLine().split("");
        int d= 0;
        int a = 0;

        for (int i = 0; i < values.length; i++) {
            if(values[i].equals("D")){
                d++;
            }else{
                a++;
            }
        }

        if(d>a){
            wr.write("Danik");
        }else if(a>d){
            wr.write("Anton");
        }else{
            wr.write("Friendship");
        }

        wr.flush();
    }
}
