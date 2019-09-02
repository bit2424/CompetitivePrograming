import java.io.*;
import java.util.ArrayList;

public class CF5_p3 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int length = Integer.parseInt(br.readLine());
        String data = br.readLine();

        StringBuilder sol = new StringBuilder();
        String []Solve = cut(data,0, 0,sol);
        wr.write(Solve[0]+"\n");
        wr.write(Solve[1]);
        wr.flush();
    }

    private static String[] cut(String data, int pos, int elem, StringBuilder sol) {
        if(pos == data.length()){
            String a[] = {String.valueOf(elem),sol.toString()};
            return a;
        }
        ArrayList<Integer> partitions = new ArrayList<>();

        int C = 0;
        int O = 0;

        int ref = 0;

        for (int i = pos; i < data.length(); i++) {
            if(data.charAt(i) == '1'){
                O++;
            }else{
                C++;
            }

            if(O!=C){
                ref = i;
            }
        }

        for (int i = pos; i <= ref; i++) {
            sol.append(data.charAt(i));
        }
        sol.append(" ");
        return cut(data, ref+1, elem+1, sol);
    }
}
