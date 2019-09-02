import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


//Solved

public class CF1_p2 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data[] = br.readLine().split(" ");
        int n_E = Integer.parseInt(data[0]);
        int Sum = Integer.parseInt(data[1]);
        data = br.readLine().split(" ");

        int numbers[] = new int[data.length];
        PriorityQueue<Integer> acumulatedN = new PriorityQueue<>();

        for (int i = 0; i < data.length; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }

        int acumSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            acumSum += numbers[i];
            acumulatedN.add(-numbers[i]);
            int min = 0;
            System.out.println(Arrays.toString(acumulatedN.toArray()));
            if(acumSum > Sum){
                min = Solve(Sum,acumSum,numbers,acumulatedN,i);
            }
            wr.write(String.valueOf(min)+" ");
        }
        wr.flush();
    }

    private static int Solve(int sum, int acumSum, int[] numbers, PriorityQueue<Integer> times, int finish) {
        int output = 0;

        Iterator<Integer> keep = times.iterator();

        while (keep.hasNext()){
            int next = -keep.next();
            if(sum < acumSum){
                acumSum -= next;
                output++;
            }else{
                break;
            }
        }
        System.out.println("");

        return output;
    }
}
