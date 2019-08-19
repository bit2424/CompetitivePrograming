import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Whole_new_Word {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());
        for(int I = 0; I<cases ; I++){
            wr.write("Case #"+(I+1)+": "+Solve()+ "\n");
        }
        wr.flush();
    }

    static HashSet<String> words;

    private static String Solve() throws IOException {
        String data[] = br.readLine().split(" ");
        int rows = Integer.parseInt(data[0]);
        int colums = Integer.parseInt(data[1]);

        char[][] Letters = new char[rows][colums];
        words = new HashSet<>();

        for(int I = 0; I<rows ; I++){
            String a = br.readLine();
            words.add(a);


            for(int K = 0; K < colums ; K++){
                Letters[I][K] = a.charAt(K);
            }
        }

        String solution = findnewWord( Letters.length-1 , Letters[0].length-1 ,"" ,Letters);

        //OJO
        System.out.println("");

        if(solution == null){
            return "-";
        }else{
            return solution;
        }

    }

    private static String findnewWord(int row, int colum,String concat,char[][] letters) {
        if(colum < 0){
            //OJO
            System.out.println(concat);
            if(concat.length() == letters[0].length && !words.contains(concat)){
                 return concat;
            }
            return null;
        }

        String F_sol = null;

        for(int I = 0; I<=row ; I++){
                String aux = letters[row-I][colum]+concat;
                F_sol = findnewWord( row,colum-1, aux ,letters);
                if(F_sol != null){
                    break;
                }
        }

        return F_sol;
    }


}
