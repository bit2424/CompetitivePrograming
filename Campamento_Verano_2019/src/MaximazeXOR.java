import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.Scanner;

public class MaximazeXOR {
    static int maximizingXor(int l, int r) {
        int max = 0;

        for (int i = l; i <= r; i++) {
            for (int j = i; j <= r; j++) {
                BitSet a = BitSet.valueOf(new long[]{i});
                BitSet b = BitSet.valueOf(new long[]{j});
                a.xor(b);
                long conteiner[] = a.toLongArray();

                int ref = 0;
                if (conteiner.length >0 ){
                    ref = (int)conteiner[0];
                }

                if (ref>max){
                    max = ref;
                }
            }
        }
        return  max;
    }

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = scanner.nextInt();

        int r = scanner.nextInt();

        int result = maximizingXor(l, r);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
