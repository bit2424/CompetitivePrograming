import java.io.*;

public class Potenciometer {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data = br.readLine();
        int i = 1;
        while (!data.equals("0")){
            wr.write("Case "+i+":\n"+Solve(data));
            data = br.readLine();
            if(data.equals("0")){
                break;
            }
            wr.write("\n");
            i++;
        }
        wr.flush();
    }

    private static String Solve(String data) throws IOException {
        StringBuilder solition = new StringBuilder();
        int cases = Integer.parseInt(data);
        int values[] = new int[cases+1];
        int BIT[] = new int[cases+1];
        for (int i = 1; i <= cases; i++) {
            values[i] = Integer.parseInt(br.readLine());
            update(i,values[i],BIT);
        }
        data = br.readLine();

        while (!data.equals("END")){
            String info[] = data.split(" ");
            if(info[0].equals("M")){
                int a = Integer.parseInt(info[1]);
                int b = Integer.parseInt(info[2]);
                int result1 = 0;
                result1 = query(a-1,BIT);
                int result = query(b,BIT) - result1;
                solition.append(result+"\n");
            }else{
                int a = Integer.parseInt(info[1]);
                int b = Integer.parseInt(info[2]);

                update(a,b-values[a],BIT);
                values[a] = b;
            }
            data = br.readLine();
        }

        return solition.toString();
    }

    private static int query(int x, int[] bit) {
        int sum = 0;
        for (; x > 0; x-=x&-x) {
            sum+=bit[x];
        }
        return sum;
    }

    private static void update(int x, int delta, int[] bit) {
        for (;x<bit.length;x+=x&-x){
            bit[x] += delta;
        }
    }


}
