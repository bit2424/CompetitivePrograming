import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Creative_Snap {

    final static int N = (int)1e5;
    static InputReader in;
    static PrintWriter out;
    static int n,k,A,B,a[],r;

    static int leftmorethan(int x) {
        int l = 1,r = k,temp=-1;
        while (l<=r) {
            int mid = (l+r)>>1;
            if (x<=a[mid]) {
                temp = mid;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return temp;
    }

    static int rightlessthan(int x) {
        int l = 1,r = k,temp = -1;
        while (l<=r) {
            int mid = (l+r)>>1;
            if (x>=a[mid]) {
                temp = mid;
                l = mid + 1;
            }else {
                r = mid-1;
            }
        }
        return temp;
    }


    static long dfs(int l,int r) {
        int L = leftmorethan(l);
        int R = rightlessthan(r);
        boolean ok = true;
        if (L==-1 || R==-1) ok = false;
        if (L>R) ok = false;
        if (!ok) return 1l*A;

        if (l==r) return 1l*B*(R-L+1);

        int mid = (l+r)>>1;
        long ans;
        //select all
        ans = 1l*B*(R-L+1)*(r-l+1);

        //divede
        ans = Math.min(ans, dfs(l,mid)+dfs(mid+1,r));
        return ans;
    }

    public static void main(String[] args) throws IOException{
        in = new InputReader();
        out = new PrintWriter(System.out);

        //code start from here
        a = new int[N+10];
        n = in.nextInt();k = in.nextInt();A = in.nextInt();B = in.nextInt();
        for (int i = 1; i <= k;i++) a[i] = in.nextInt();
        r = 1;
        for (int i = 1;i <= n;i++) r = r*2;
        Arrays.sort(a, 1,k+1);
        out.print(dfs(1,r));
        out.close();
    }

    static class InputReader{
        public BufferedReader br;
        public StringTokenizer tokenizer;

        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next(){
            while (tokenizer==null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                }catch(IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
