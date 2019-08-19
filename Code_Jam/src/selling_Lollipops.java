import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class selling_Lollipops {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {

        long probabilities[][];

        int cases = Integer.parseInt(br.readLine());
        for(int I = 0; I<cases ; I++){

            int Loly_sell = Integer.parseInt(br.readLine());
            //0 - #_people_Prefered     1 - has been bought
            probabilities = new long[Loly_sell][2];


            for(int K = 0; K< Loly_sell; K++){

                String data[] = br.readLine().split(" ");
                int Flavors = Integer.parseInt(data[0]);
                int index = 1;
                int flavorIndex = Integer.parseInt(data[1]);
                ArrayList<Integer> Candidates = new ArrayList<>();

                for(int M = 0;M<Loly_sell ; M++){
                    if(flavorIndex == M){
                        index++;
                        flavorIndex = Integer.parseInt(data[index]);

                    }else{

                    }
                }


            }
        }
    }

}
