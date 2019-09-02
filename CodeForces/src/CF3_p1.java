import java.io.*;

public class CF3_p1 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String d =  br.readLine();
        String data[] = d.split("");

        Integer number = Integer.parseInt(d);
        long sum = 0;
        int numbers[] = new int[100000];

        for (int i = 0; i < data.length; i++) {
            numbers[i] = Integer.parseInt(data[i]);
            sum += numbers[i];
        }


        while (sum%4 != 0) {
            number++;
            d = number.toString();
            data = d.split("");
            sum = 0;
            for (int i = 0; i < data.length; i++) {
                numbers[i] = Integer.parseInt(data[i]);
                sum += numbers[i];
            }
        }

        for (int i = 0; i < data.length; i++) {
            wr.write(String.valueOf(numbers[i]));
        }
        wr.flush();

    }
}
