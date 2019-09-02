//package RPC20198;

import java.io.*;

public class parity {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data = br.readLine();

        int values [] = new int[1000];
        int cantidad = 0;

        for (int i = 0; i < data.length(); i++) {
            char ref = data.charAt(i);
            if(values[ref] == 0){
                cantidad++;
            }
            values[ref]++;
        }

        int odd = 0;
        int even = 0;

        for (int i = 0; i < data.length(); i++) {
            if(values[data.charAt(i)] != 0) {
                if (values[data.charAt(i)] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            values[data.charAt(i)] = 0;
        }

        if(even == cantidad){
            wr.write("0");
        }else if(odd == cantidad){
            wr.write("1");
        }else{
            wr.write("2");
        }

        wr.flush();

    }
}
