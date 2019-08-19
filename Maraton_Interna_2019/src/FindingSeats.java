import java.io.*;

public class FindingSeats {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int matriz[][];
    static int colMatrix[][];
    static int rowMatrix[][];
    static int Coloms = 0;
    static int Rows = 0;
    static int ColomsSeats[];
    static int RowsSeats[];
    static int seats;

    public static void main(String args[]) throws IOException {
        String info = br.readLine();

        while(!info.equals("0 0 0")) {

            String data[] = info.split(" ");

            Rows = Integer.parseInt(data[0]);
            Coloms = Integer.parseInt(data[1]);

            ColomsSeats = new int[Coloms];
            RowsSeats = new int[Rows];

            int nSeats = 0;
            seats = Integer.parseInt(data[2]);

            matriz = new int[Rows][Coloms];
            colMatrix = new int[Rows][Coloms];
            rowMatrix = new int[Rows][Coloms];

            for (int i = 0; i < Rows; i++) {
                String rows = br.readLine();

                for (int j = 0; j < Coloms; j++) {
                    if(rows.charAt(j) == '.'){
                        matriz[i][j] = 1;
                        ColomsSeats[j]++;
                        RowsSeats[i]++;
                        nSeats++;
                    }else{
                        matriz[i][j] = 2;
                    }
                }
            }


            for (int i = 0; i < Rows; i++) {
                for (int j = 0; j < Coloms; j++) {
                    if(i == 0 && matriz[i][j] ==  1){
                        colMatrix[i][j] =  1;
                    }else if(matriz[i][j] ==  1){
                        colMatrix[i][j] = colMatrix[i-1][j]+1;
                    }
                }
            }

            for (int j = 0; j < Coloms; j++) {
                for (int i = 0; i < Rows; i++) {

                    if(j == 0 && matriz[i][j] ==  1){
                        rowMatrix[i][j] =  1;
                    }else if(matriz[i][j] ==  1){
                        rowMatrix[i][j] = colMatrix[i][j-1]+1;
                    }
                }
            }


            info = br.readLine();
        }

    }

    /*private static int recurse(int[][] matriz, int i, int j, int tMove, int width, int height, int i5) {
        return 0;
    }*/

    private static int recurseLines(int matriz[][],int intMatrix[][],int up, int down, int left,int right,int nElements,int state){
        if(state == 4 || up==(down-1) || left==(right-1) || left == Coloms-1 || up == Rows-1 || right == 1 || down == 1){
            return Math.abs((-up+down)*(-left+right));
        }

        int n2 = 0;
        int n1 = 0;


        if(state == 0) {
            nElements = nElements-RowsSeats[up];

            if(nElements>seats){
                return Integer.MAX_VALUE;
            }

            n1 = recurseLines(matriz, intMatrix, up+1, down, left, right, nElements, state);
            n2 = recurseLines(matriz, intMatrix, up, down, left+1, right, nElements, state+1);
        }else if(state == 1) {

            nElements = nElements-ColomsSeats[left] + intMatrix[up][left];

            if(nElements>seats){
                return Integer.MAX_VALUE;
            }

            n1 = recurseLines(matriz, intMatrix, up, down, left+1, right, nElements, state);
            n2 = recurseLines(matriz, intMatrix, up, down-1, left, right, nElements, state+1);
        }if(state == 2) {


            n1 = recurseLines(matriz, intMatrix, up, down-1, left, right, nElements, state);
            n2 = recurseLines(matriz, intMatrix, up, down, left, right-1, nElements, state+1);
        }if(state == 3) {


            n1 = recurseLines(matriz, intMatrix, up, down, left, right-1, nElements, state);
            n2 = Integer.MAX_VALUE;
        }

        return Math.min(n1,n2);
    }
}
