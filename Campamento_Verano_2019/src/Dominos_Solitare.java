import java.io.*;

public class Dominos_Solitare {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data = br.readLine();

        while (!data.equals("0")) {
            wr.write(Solve(data)+"\n");
            data = br.readLine();
        }
        wr.flush();
    }

    private static String Solve(String data) throws IOException {

        int spaces = Integer.parseInt(data);
        data =br.readLine();
        int posibilities = Integer.parseInt(data);

        int dominos[][] = new int[posibilities+2][2];
        boolean check[] = new boolean[posibilities+2];

        String d[] = br.readLine().split(" ");
        dominos[0][0] = Integer.parseInt(d[0]);
        dominos[0][1] = Integer.parseInt(d[1]);

        d = br.readLine().split(" ");
        dominos[posibilities+1][0] = Integer.parseInt(d[0]);
        dominos[posibilities+1][1] = Integer.parseInt(d[1]);

        for (int i = 1; i <= posibilities; i++) {
            d = br.readLine().split(" ");
            dominos[i][0] = Integer.parseInt(d[0]);
            dominos[i][1] = Integer.parseInt(d[1]);
        }


        dp = new boolean[posibilities+2][2];
        boolean posible2 = TryP(dominos,0,0,1,spaces,check);

        if(posible2) {
            return "YES";
        }else{
            return "NO";
        }
    }

    static boolean dp[][];

    private static boolean TryP(int[][] dominos, int ant, int i, int j, int spaces, boolean[] check) {
        if(i == dominos.length-1){
            int a = dominos[i][0];
            int b =dominos[ant][j];
            if (spaces<=0 &&  a == b){
                return true;
            }else{
                return false;
            }
        }

        if(spaces == 0){
            return TryP(dominos, i, dominos.length-1, j, spaces, check.clone());
        }

        for (int k = 1; k < dominos.length-1; k++) {
            if(k != i && !check[k]){
                boolean posi = false;

                if(dominos[i][j] == dominos[k][0]){
                    check[i] = true;
                    posi = TryP(dominos, i, k, 1, spaces-1,check.clone());
                }

                if(dominos[i][j] == dominos[k][1]){
                    check[i] = true;
                    posi = posi || TryP(dominos, i, k, 0, spaces-1,check.clone());
                }
                if(posi){
                    return posi;
                }
            }
        }

        return false;
    }
}
