import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class CF5_p2 {
    //B. Number Circle

    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());
        String data[] = br.readLine().split(" ");
        ArrayList<Long> numbers = new ArrayList();
        int sum = 0;

        for (int i = 0; i < data.length; i++) {
            numbers.add(Long.parseLong(data[i]));
        }
        String sol = Solution(numbers);

        if(sol != null){
            wr.write("YES\n");
            wr.write(sol+ "\n");
        }else{
            wr.write("NO");
        }

        wr.flush();
    }

    private static String Solution(ArrayList numbers) {

        Collections.sort(numbers);
        long ref[] = new long[numbers.size()];
        StringBuilder solution = new StringBuilder();

        int mid = (int)Math.floor((double)ref.length/(double)2);
        int r = 0;

        ref[0] = (long) numbers.get(numbers.size()-1);
        ref[numbers.size()-1] = (long) numbers.get(numbers.size()-2);

        int I = 1;
        for (int i = numbers.size()-3; i >= 0; i--) {
            ref[I] = (long) numbers.get(i);
            I++;
        }

        boolean posible = true;

        for (int i = 0; i < ref.length && posible; i++) {
            if(i == 0){
                if(ref[i] >= ref[i+1]+ref[ref.length-1]){
                    posible = false;
                    return null;
                }
            }else if(i == ref.length-1){
                if(ref[ref.length-1] >= ref[0]+ ref[ref.length-2]){
                    posible = false;
                    return null;
                }
            }else{
                if(ref[i] >= ref[i+1]+ref[i-1]){
                    posible = false;
                    return null;
                }
            }
        }

        for (int i = 0; i < ref.length; i++) {
            solution.append(ref[i]);
            solution.append(" ");
        }

        if(posible){
            return solution.toString();
        }return null;
    }
}
