import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CF6_p3 {

    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long primes[] = new long[9];

    public static void main(String args[]) throws IOException {
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        primes[7] = 7;
        int lenght = Integer.parseInt(br.readLine());
        String line[] = br.readLine().split("");

        ArrayList<Integer> solve = new ArrayList<>();

        Solve(line,0,solve);

        Collections.sort(solve);

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < solve.size() ; i++) {
            out.append(solve.get(i));
        }

        wr.write(out.reverse().toString());
        wr.flush();
    }

    private static void Solve(String[] line, int pos, ArrayList<Integer> solve) {
        if(pos == line.length){
            return;
        }
        String ref = line[pos];
        int value = Integer.parseInt(ref);

        if(value == 8){
            solve.add(2);
            solve.add(2);
            solve.add(2);
            solve.add(7);
        }else if(value == 6){
            solve.add(3);
            solve.add(5);
        }else if(value == 4){
            solve.add(2);
            solve.add(2);
            solve.add(3);
        }else if(value == 9){
            solve.add(3);
            solve.add(3);
            solve.add(2);
            solve.add(7);
        }else {
            if(value != 0 && value != 1)
                solve.add(value);
        }

        Solve(line, pos+1, solve);

    }


}
