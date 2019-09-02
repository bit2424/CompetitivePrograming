package Round_1c;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Problem_1 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int cases = Integer.parseInt(br.readLine());


        for(int I = 0; I<cases; I++){
            String Solution = Solve();
            wr.write("Case #"+ (I+1) +": "+Solution+"\n");

        }
        wr.flush();
    }

    static  HashMap<char[],Integer> Moves;

    private static String Solve() throws IOException {
        Moves = new HashMap<>();
        chargeData();
        boolean stop = false;
        boolean imposible = false;

        StringBuilder output = new StringBuilder();

        int cont = 0;

        int cont2 = 0;

        while (!stop){

            Iterator loop = Moves.entrySet().iterator();

            StringBuilder ref = new StringBuilder();

            while (loop.hasNext()){
                Map.Entry pair = (Map.Entry)loop.next();

                char[] tempChar = (char[])pair.getKey();

                int tempVal = (int) pair.getValue();

                ref.append(tempChar[tempVal]);

                if(tempVal+1 < tempChar.length) {
                    Moves.replace(tempChar, tempVal+1);
                }else{
                    Moves.replace(tempChar, 0);
                }
            }



            getData(ref.toString());

            boolean hasS = false;
            boolean hasR = false;
            boolean hasP = false;
            if(hasP && hasR && hasS){
                imposible = true;
                stop = true;
                break;
            }

            if(!hasP && !hasR && !hasS){
                cont++;
                continue;
            }

            if(hasP && hasS){
                output.append('S');
                Moves[I].replace('P',false);
            }

            if(hasP && hasR){
                output.append('P');
                Moves[I].replace('R',false);
            }

            if(hasR && hasS){
                output.append('R');
                Moves[I].replace('S',false);
            }

            if(hasP){
                output.append('S');
                Moves[I].replace('P',false);
            }

            if(hasR){
                output.append('P');
                Moves[I].replace('R',false);
            }

            if(hasS){
                output.append('R');
                Moves[I].replace('S',false);
            }

            if(output.length() > 500){
                System.out.println(output.length());
                stop = true;
                imposible = true;
            }

            if(cont == Moves.){
                stop = true;
            }else{
                cont = 0;
            }

        }

        if(imposible){
            return "IMPOSSIBLE";
        }


        return output.toString();
    }

    public static String getData(String toWork){
        for (int I = 0; I< toWork.length() ; I++){


        }
        return null;
    }

    private static void chargeData() throws IOException {
        int cases = Integer.valueOf(br.readLine());
        char data[];
        for(int I =0 ; I< cases ; I++){
            data = br.readLine().toCharArray();
            for (int K = 0; K< data.length ; K++){
                Moves.put(data,0);
            }
        }

    }
}


