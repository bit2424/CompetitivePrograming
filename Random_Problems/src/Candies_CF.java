import java.io.*;

public class Candies_CF {
    public  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    static int candies[][];

    public static void main(String args[]) throws IOException {
        int length = Integer.parseInt(br.readLine());

        String values[] = br.readLine().split(" ");

        int vals[] = new int[values.length];

        SegmentTree st = new SegmentTree(0,length-1);

        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.parseInt(values[i]);
            st.set(i,vals[i]);
        }

        /*candies = new int[values.length][values.length];

        for (int i = 0; i < candies.length; i++) {
            for (int j = 0; j < candies.length; j++) {
                candies[i][j] = -1;
            }
        }*/

        //Solve(0,values.length-1,vals);

        int queries = Integer.parseInt(br.readLine());

        for (int i = 0; i < queries; i++) {
            String couple[] = br.readLine().split(" ");
            int begin = Integer.parseInt(couple[0]);
            int finish = Integer.parseInt(couple[1]);

            wr.write(st.getVal(begin-1,finish-1)[1]+"\n");
        }

        wr.flush();
    }

    private static int[] Solve(int izq,int der, int[] vals){
        if(der == izq){
            candies[izq][der] = 0;
            return new int[]{vals[der], 0};
        }else{
            int mid = (der+izq)/2;
            int lefVal[] = Solve(izq, mid, vals);
            int rigVal[] = Solve(mid+1,der,vals);

            int candi =  rigVal[1] + lefVal[1];
            int value = rigVal[0] + lefVal[0];

            if(value >= 10){
                value %= 10;
                candi++;
            }

            candies[izq][der] = candi;
            return new int[]{value,candi};
        }
    }
}

class SegmentTree {
    int start, end;
    SegmentTree leftTree, rightTree;
    int [] Value;

    public SegmentTree(int start, int end) {
        this.start = start;
        this.end = end;
        this.Value = new int[2];
        if(start == end) {  // es una hoja
            leftTree = rightTree = null;
            return;
        }
        int mid = (start + end) / 2;
        leftTree = new SegmentTree(start, mid);
        rightTree = new SegmentTree(mid + 1, end);
    }

    public void set(int pos, int value) {
        if(start == end) {
            Value = new int[]{value,0};
            return;
        }

        int mid = (start + end) / 2;

        if(pos <= mid)
            leftTree.set(pos, value);
        else
            rightTree.set(pos, value);

        int candi =  leftTree.Value[1] + rightTree.Value[1];
        int v = leftTree.Value[0] + rightTree.Value[0];

        if(v >= 10){
            v %= 10;
            candi++;
        }

        Value = new int[]{v,candi};
    }


    public int[] getVal(int low, int high) {
        if(start == low && end == high)
            return Value;

        int mid = (start + end) / 2;

        // [low,high] totalmente incluido en [start,mid]
        if(high <= mid)
            return leftTree.getVal(low, high);

        // [low,high] totalmente incluido en [mid+1,end]
        if(low > mid)
            return rightTree.getVal(low, high);

        // debemos dividir el intervalo en [low,mid] y [mid+1,high]
        int left[] = leftTree.getVal(low, mid);
        int right[] = rightTree.getVal(mid+1, high);

        int candi =  left[1] + right[1];
        int v = left[0] + right[0];

        if(v >= 10){
            v %= 10;
            candi++;
        }

        return new int[]{v,candi};

    }

}

