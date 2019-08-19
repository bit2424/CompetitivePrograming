import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Hulams_Sequence {
    public static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    static long Hulam_sequence[] = new long[10002];
    static HashSet<Long> in_Sequence = new HashSet<>();

    public static void main(String args[]) throws IOException {
        SolveProblem();
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            int pos = Integer.parseInt(br.readLine());
            wr.write(String.valueOf(Hulam_sequence[pos])+"\n");
        }
        wr.flush();
    }

    private static void SolveProblem() {
        Hulam_sequence[1] = 1;
        Hulam_sequence[2] = 2;
        in_Sequence.add(1L);
        in_Sequence.add(2L);
        int pos = 3;
        for (int i = 3; pos < 10001; i++) {
            Iterator<Long> it = in_Sequence.iterator();
            boolean found = false;
            while (it.hasNext()){
                long search = i-it.next();
                if(i%2 == 0 && search == (i/2)){
                    continue;
                }
                if( in_Sequence.contains(search)){
                    found = true;
                    break;
                }
            }

            if(!found){
                in_Sequence.add((long)i);
                Hulam_sequence[pos] = i;
                pos++;
            }
        }
    }}
