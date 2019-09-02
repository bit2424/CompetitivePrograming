import java.io.*;

public class Talking_P {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            wr.write(Solve(br.readLine())+"\n");
        }

        wr.flush();
    }

    private static String Solve(String readLine) {
        StringBuilder out = new StringBuilder();
        String Data[] = readLine.split("");
        for (int i = 0; i < Data.length; i++) {
            String a = Data[i];
            if(a.equals("a") ||a.equals("e") ||a.equals("i") ||a.equals("o") ||a.equals("u")){
                out.append(a+"p"+a);
            }else{
                out.append(a);
            }
        }
        return out.toString();
    }


}
