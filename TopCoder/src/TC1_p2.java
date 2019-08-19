public class TC1_p2 {

    public static void main(String args[]){
        OrderlyString test = new OrderlyString();
        System.out.println(test.longestLength("BSDBFDDDDAAAAAAAA"));
    }
}
class OrderlyString{

    int MEMO[][][] = new int[201][201][201];

    public int longestLength(String s){
        for (int i = 0; i < MEMO.length; i++) {
            for (int j = 0; j < MEMO[0].length; j++) {
                for (int k = 0; k < MEMO[0].length; k++) {
                    MEMO[i][j][k] = -1;
                }
            }
        }
        String data[] = s.split("");
        return Solve(data,0,0 ,0 );
    }

    private int Solve(String[] data, int last, int pos, int sum) {
        if(pos == data.length){
                return sum;
        }

        int a = 0;
        int b = 0;

        if(MEMO[pos][sum][last] != -1){
            if((data.length-pos)+sum-MEMO[pos][sum][last]>MEMO[pos][sum][last]){
                return MEMO[pos][sum][last];
            }
        }

        if (data[last].compareTo(data[pos])<=0){
            a = Solve(data,pos,pos+1, sum+1);
        }

        b = Solve(data,last,pos+1,sum);

        return MEMO[pos][sum][last] = Math.max(a,b);
    }
}

