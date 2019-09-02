import java.io.*;

public class CF2_p2 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int numbers[] = new int[n];
        String Data[] = br.readLine().split(" ");
        int negative = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(Data[i]);
        }
        wr.write(solve(numbers));
        wr.flush();
    }

    private static String solve(int[] numbers) {
        int i_menor = 0;
        int min = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]>=0){
                numbers[i] = -numbers[i]-1;
            }

            if(numbers[i]<min){
                min = numbers[i];
                i_menor = i;
            }
        }

        if(numbers.length%2 != 0){
            numbers[i_menor] = -numbers[i_menor]-1;
        }
        StringBuilder sol = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            sol.append(numbers[i]+" ");
        }


        return sol.toString();
    }
}
