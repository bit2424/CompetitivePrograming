import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Whole_new__Word_2 {

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



        ArrayList<HashSet<Character>> Letters = new ArrayList<>();
        words = new HashSet<>();

        for(int I = 0; I<colums ; I++){
            HashSet<Character> noRepeated = new HashSet<>();
            Letters.add(noRepeated);
        }

        long numberCandidates = 1;

        for(int I = 0; I<rows ; I++){
            String a = br.readLine();
            words.add(a);

            for(int K = 0; K < colums ; K++){
                    Letters.get(K).add(a.charAt(K));
            }

        }

        for(int K = 0; K < colums ; K++){
            numberCandidates *= Letters.get(K).size();
        }

        String solution = null;

        if(rows<numberCandidates){
            solution = findnewWord(Letters.get(Letters.size() - 1).size(), Letters.size() - 1, "", Letters);
        }

        if(solution == null){
            return "-";
        }else{
            return solution;
        }

    }

    private static String findnewWord(int row, int colum, String concat, ArrayList<HashSet<Character>> letters) {
        if(colum < 0){
            if(concat.length() == letters.size() && !words.contains(concat)){
                return concat;
            }
            return null;
        }

        String F_sol = null;


        Iterator a = letters.get(colum).iterator();

        while (a.hasNext()){
            String aux = a.next()+concat;
            F_sol = findnewWord( row,colum-1, aux ,letters);
            if(F_sol != null){
                break;
            }
        }


        return F_sol;
    }


}