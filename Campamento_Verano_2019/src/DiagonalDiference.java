import javax.xml.crypto.Data;
import java.io.*;

public class DiagonalDiference {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int size = Integer.parseInt(br.readLine());
        String Data[] = new String[size];
        for (int i = 0; i < size; i++) {
            Data[i] = br.readLine();
        }

        wr.write(String.valueOf(Math.abs(solve(Data,size-1,0))));
        wr.flush();
    }

    private static int solve(String[] data, int size, int i) {
        if(i==size+1){
            return 0;
        }

        return (Integer.parseInt(data[i].split(" ")[size-i])-Integer.parseInt(data[i].split(" ")[i])+ solve(data,size,i+1));
    }
}
