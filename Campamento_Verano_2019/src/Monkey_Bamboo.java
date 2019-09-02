import java.io.*;

public class Monkey_Bamboo {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int Cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < Cases; i++) {
            int positions = Integer.parseInt(br.readLine());
            String data[] = br.readLine().split(" ");
            int numbers[] = new int[data.length];
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = Integer.parseInt(data[j]);
            }
            wr.write("Case "+(i+1)+": "+Solve(numbers)+"\n");
        }
        wr.flush();
    }

    private static int Solve(int[] numbers) {
        int fin = 100000;
        int inicio = 0;
        boolean visited[] = new boolean[100000];
        int result = BinarySearch(inicio,fin,numbers)+1;

        return result;
    }

    private static int BinarySearch(int inicio, int fin, int[] numbers) {
        if (inicio >= fin)
            return (int)Math.ceil((inicio+fin)/2);

        int mid = (int)Math.ceil((inicio+fin)/2);

        boolean solve = climb(mid,numbers);
        if(solve){
            return BinarySearch(inicio, mid-1, numbers);
        }else{
            return BinarySearch(mid+1, fin, numbers);
        }
    }

    private static boolean climb(int k, int[] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            int ref = (-numbers[i]+numbers[i+1]);
            if(k< ref){
                return false;
            }else if(k==ref){
                k--;
            }
        }
        if(k<0){
            return false;
        }else{
            return true;
        }
    }
}
