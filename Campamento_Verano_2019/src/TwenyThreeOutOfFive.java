import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class TwenyThreeOutOfFive {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String d = br.readLine();
        while(d != null && !d.equals("0 0 0 0 0")){
            wr.write(Solve(d)+"\n");
            d = br.readLine();
        }
        wr.flush();
    }

    private static String Solve(String d) {
        String data[] = d.split(" ");
        int numbers[] = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }

        //Arrays.sort(numbers);

        boolean posible = false;
        int a = 0;
        while (!posible){
            posible = f(numbers,0,numbers[0]);
            nextPermutation(numbers);
            a++;
            if (a>120){
                break;
            }
        }

        if(posible){
            return "Possible";
        }else{
            return "Impossible";
        }

    }

    private static boolean f(int[] numbers, int pos, int actualValue) {
        if( pos+1 == 5 && actualValue == 23){
            return true;
        }else if( pos+1 == 5){
            return  false;
        }

        pos = pos+1;

        boolean ref = f(numbers, pos, actualValue + numbers[pos]);

        if (!ref){
            ref = f(numbers, pos, actualValue - numbers[pos]);
            if (!ref){
                ref = f(numbers, pos, actualValue*numbers[pos]);
                return ref;
            }else{
                return ref;
            }
        }else{
            return ref;
        }

    }

    static public void nextPermutation(int[] nums) {
        //find first decreasing digit
        int mark = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                mark = i - 1;
                break;
            }
        }

        if (mark == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int idx = nums.length-1;
        for (int i = nums.length-1; i >= mark+1; i--) {
            if (nums[i] > nums[mark]) {
                idx = i;
                break;
            }
        }

        swap(nums, mark, idx);

        reverse(nums, mark + 1, nums.length - 1);
    }

    static private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    static private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
