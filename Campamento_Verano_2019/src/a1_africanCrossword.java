import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class a1_africanCrossword {
    static    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String args[]) throws IOException {
        String data[] = br.readLine().split(" ");
        int x = Integer.parseInt(data[0]);
        int y = Integer.parseInt(data[1]);
        
        char table[][] = new char[x][y];

        ArrayList<HashMap<Character,Integer>> rows = new ArrayList<>();
        ArrayList<HashMap<Character,Integer>> colums = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            String info = br.readLine();
            rows.add(new HashMap<>());
            for (int j = 0; j < info.length(); j++) {
                table[i][j] = info.charAt(j);
                if(i == 0){
                    colums.add(new HashMap<>());
                }

                if(!rows.get(i).containsKey(table[i][j])) {
                    rows.get(i).put(table[i][j], 1);
                }else{
                    rows.get(i).put(table[i][j], rows.get(i).get(table[i][j])+1);
                }
                if(!colums.get(j).containsKey(table[i][j])){
                    colums.get(j).put(table[i][j],1);
                }else{
                    colums.get(j).put(table[i][j],colums.get(j).get(table[i][j])+1);
                }
            }
        }

        StringBuilder out = new StringBuilder();

        for (int I = 0; I < x; I++) {
            for (int J = 0; J < y; J++) {
                char elem = table[I][J];
                if(rows.get(I).get(elem) != null && colums.get(J).get(elem) != null && rows.get(I).get(elem) == 1 &&  colums.get(J).get(elem) == 1){
                    out.append(elem);
                }
            }
        }
        wr.write(out.toString());
        wr.flush();
        
    }
}
