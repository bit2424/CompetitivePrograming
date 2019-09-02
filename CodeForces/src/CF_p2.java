import java.io.*;

public class CF_p2 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data[] = br.readLine().split(" ");
        int h = Integer.parseInt(data[0]);
        int w = Integer.parseInt(data[1]);

        char matrix[][] = new char[h][w];

        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }

        wr.write(Sol(matrix));
        wr.flush();
    }

    static String Solve(int a[],int shift){
        int Solution[] = new int[a.length];
        for(int i = 0;i<a.length;i++){
            int ref = i+shift;
            if(ref >= a.length){
                ref = ref-5;
            }
            Solution[ref] = a[i];
        }
        String out = "";
        for(int i = 0;i<a.length;i++){
            out += String.valueOf(a[i]);
        }
        return out;
    }


    private static String Sol(char[][] matrix) {
        int possible = 0;
        int cont = 0;
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '*'){
                    cont +=1;
                }
            }
        }

        for (int i = 1; i < matrix.length-1; i++) {
            for (int j = 1; j < matrix[0].length-1; j++) {
                int ref = verify(matrix,i,j);
                if(ref>max){
                    max = ref;
                }
            }
        }

        if (cont == max && croos){
            return "YES";
        }else{
            return  "NO";
        }
    }

    static boolean croos = false;

    private static int verify(char[][] matrix, int x, int y) {


        if(matrix[x][y] == '*'){
            int points = 1;
            if(matrix[x+1][y] == '*'){
                points++;
            }

            if(matrix[x-1][y] == '*'){
                points++;
            }

            if(matrix[x][y+1] == '*'){
                points++;
            }

            if(matrix[x][y-1] == '*'){
                points++;
            }

            if(points == 5) {
                points = 0;
                croos = true;
                for (int i = 0; i+x < matrix.length; i++) {
                    if (matrix[x+i][y] != '*'){
                        break;
                    }
                    points++;
                }
                for (int i = x; i >= 0; i--) {
                    if (matrix[i][y] != '*'){
                        break;
                    }
                    points++;
                }
                for (int i = 0; i+y < matrix[0].length; i++) {
                    if (matrix[x][y+i] != '*'){
                        break;
                    }
                    points++;
                }
                for (int i = y; i >= 0; i--) {
                    if (matrix[x][i] != '*'){
                        break;
                    }
                    points++;
                }
                return points-3;
            }else{
                return 0;
            }
        }

        return 0;
    }
}
