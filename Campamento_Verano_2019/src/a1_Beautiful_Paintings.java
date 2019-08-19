import java.io.*;
import java.util.TreeMap;

public class a1_Beautiful_Paintings {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String args[]) throws IOException {
        int size = Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> elements = new TreeMap<>();
        String data[] = br.readLine().split(" ");
        for (int i = 0; i < data.length; i++) {
            int num = Integer.parseInt(data[i]);
            if(!elements.containsKey(num)){
                elements.put(num,1);
            }else{
                
            }
        }
    }
}
