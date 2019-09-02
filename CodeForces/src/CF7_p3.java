import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CF7_p3 {
    public  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        int elem = Integer.parseInt(br.readLine());
        String solution = solve(elem);
        wr.write(solution);
        wr.flush();
    }

    private static String solve(int elem) {
        if(elem==1){
            return "YES\n"+"1 2";
        }else if(elem == 2){
            return "NO\n";
        }
        boolean used[] = new boolean[elem*2+1];
        int numbers[] = new int[elem*2];

        numbers[0] = 1;
        numbers[1] = elem*2;
        numbers[2] = elem;

        used[1] = true;
        used[elem*2] = true;
        used[elem] = true;

        boolean sol = recurse(used,numbers,3,true);


        StringBuilder out = new StringBuilder();



        if(sol) {
            for (int i = 0; i < numbers.length; i++) {
                out.append(numbers[i]);
                out.append(" ");
            }

            return "YES\n"+out.toString() ;
        }else{
            return "NO";
        }

    }

    private static boolean recurse(boolean[] used, int[] numbers, int pos,boolean up) {
        if(pos == numbers.length){
            return true;
        }
        int ref = numbers[pos-3];
        if(up){ ref++;
        }else{ ref--; }

        if(used[ref]){
            return false;
        }else{
            numbers[pos] = ref;
            used[ref] = true;
            return  recurse(used, numbers, pos+1, !up);
        }

    }
}
