import java.io.*;
import java.util.ArrayList;

public class JokeInPermutation {
    static  BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String case1 = br.readLine();
        while(case1 != null && !case1.equals("")) {
            int size = 0;

            if (case1.length() < 10) {
                size = case1.length();
            } else {
                size = 9 + (case1.length() - 9) / 2;
            }

            wr.write(solve(case1, size)+"\n");
            case1 = br.readLine();
        }
        wr.flush();
    }

    private static String solve(String case1, int size) {
        boolean ocupados[] = new boolean[size+1];

        String acomp = "";
        String sol = R(case1,0,size,ocupados,acomp);



        return sol.trim();
    }

    private static String R(String case1, int pos, int sNumber, boolean[] ocupados, String acomp) {
        if(pos >= case1.length()){
            return acomp;
        }

        String sol1 = "";
        String sol2 = "";


        int a = Integer.parseInt(case1.substring(pos,pos+1));
        if(a<=sNumber && !ocupados[a] && a!= 0){
            acomp += a+" ";
            ocupados[a] = true;
            sol1 = R(case1, pos+1, sNumber, ocupados.clone(), acomp);
            if(sol1.equals("")){
                ocupados[a] = false;
                acomp = acomp.substring(0,acomp.length()-2);
            }
        }

        if(sol1.equals("") && pos+2<=case1.length()){
            a = Integer.parseInt(case1.substring(pos,pos+2));
            if(a<=sNumber && !ocupados[a] && a!= 0){
                acomp += a+" ";
                ocupados[a] = true;
                sol2 = R(case1, pos+2, sNumber, ocupados.clone(), acomp);
            }
        }



        if(sol1.length() >= sol2.length() ){
            return sol1;
        }else{
            return sol2;
        }
    }
}

