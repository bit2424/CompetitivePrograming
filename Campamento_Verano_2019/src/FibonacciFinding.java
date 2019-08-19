import java.io.*;

public class FibonacciFinding {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data = br.readLine().trim();
        int cases = Integer.parseInt(data);

        for (int i = 0; i < cases; i++) {
            String Info[] = br.readLine().split(" ");
            wr.write(Solve(Integer.parseInt(Info[0]),Integer.parseInt(Info[1]),Integer.parseInt(Info[2]))+"\n");
        }
        wr.flush();
    }

    private static long Solve(int A, int B, int N) {
        if(N==0){
            return A;
        }
        if(N==1){
            return B;
        }

        mat = new long[2][2];
        mat[0][0] = 1;
        mat[0][1] = 1;
        mat[1][0] = 1;
        mat[1][1] = 0;

        long matrix[][] = new long[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 0;
        matrix = cFibonacci(matrix,N-1);
        long solution = (matrix[0][0]*B)%cons + (matrix[0][1]*A)%cons;
        return solution%cons;
    }

    static long mat[][];
    static final int cons= 1000000007;

    private static long[][] cFibonacci(long[][] matrix, int n) {
        if(n==1){
            return matrix;
        }else if(n%2 == 0){
            long ref[][] = cFibonacci(matrix, (n/2));
            return multiplicar(ref,ref);
        }else{
            return multiplicar(mat,cFibonacci(matrix, n-1));
        }
    }

    private static long[][] multiplicar(long[][] a, long[][] b) {
        long ref[][] = new long[2][2];
        ref[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0])%cons;
        ref[0][1] = (a[0][0]*b[0][1] + a[0][1]*b[1][1])%cons;
        ref[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0])%cons;
        ref[1][1] = (a[1][0]*b[0][1] + a[1][1]*b[1][1])%cons;
        return ref;
    }
}
