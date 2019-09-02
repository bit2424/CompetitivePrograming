import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Dictionary {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String d = br.readLine();
        HashSet<String> palabras = new HashSet<>();
        while (d != null) {
            String data = d;
            String offer = "";
            for (int i = 0; i < data.length(); i++) {

                if(Character.isLetter(data.charAt(i))){
                    offer += data.charAt(i)+"";
                }else{
                    offer = offer.toLowerCase();
                    if(offer.length()>0) {
                        palabras.add(offer);
                    }
                    offer = "";
                }

            }
            offer = offer.toLowerCase();
            if(offer.length()>0) {
                palabras.add(offer);
            }
            offer = "";

            d = br.readLine();
        }
        String[] out = new String[palabras.size()];
        Iterator<String> ref = palabras.iterator();
        int k = 0;
        while(ref.hasNext()) {
            out[k] = String.valueOf(ref.next());
            k++;
        }
        Arrays.sort(out);
        for (int i = 0; i < palabras.size(); i++) {
            wr.write(out[i]+"\n");
            //System.out.println(out[i]);
        }
        wr.flush();
        wr.close();
    }
}
