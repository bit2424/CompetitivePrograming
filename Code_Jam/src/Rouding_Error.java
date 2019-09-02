import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Rouding_Error {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int cases = Integer.parseInt(br.readLine());
        for(int I = 0; I<cases ; I++) {
            wr.write("Case #" + (I+1)+": " +Solve() + "\n");
        }
        wr.flush();
    }

    private static String Solve() throws IOException {
        String data [] = br.readLine().split(" ");
        double people = Integer.parseInt(data[0]);
        int numberL_selected = Integer.parseInt(data[1]);

        ArrayList<lenguage> list_L_selected = new ArrayList<>();


        data =  br.readLine().split(" ");


        double people_avalible = people;

        for (int I = 0 ; I <= people ; I++){
            if(I<data.length) {
                double votes = Integer.parseInt(data[I]);
                double probability = (votes*100/people);
                list_L_selected.add(new lenguage(probability,votes));
                people_avalible -= votes;
            }else{
                list_L_selected.add(new lenguage(0,0));
            }
        }


        Collections.sort(list_L_selected);

        int max_probability = 0;

        for(int K = 0; K < list_L_selected.size() ; K++){
            double temp = list_L_selected.get(K).getVotes();
            double prob_ori = (temp/people)*100;
            double prob_round = Math.round(prob_ori);
            double add = 0;
            while (people_avalible > 0 && (prob_ori > prob_round || prob_ori == 0)){
                people_avalible--;
                add++;
                prob_ori = ((temp+add)/people)*100;
                prob_round = Math.round(prob_ori);
            }

            max_probability += prob_round;
        }

        return String.valueOf(max_probability);
    }
}


class lenguage implements Comparable<lenguage> {
    double proximity ;
    double votes ;

    public lenguage(double probability, double votes){
        this.votes = votes;
        proximity = Math.abs(probability-Math.floor(probability));
    }


    public double getVotes() {
        return votes;
    }

    public void setVotes(double votes) {
        this.votes = votes;
    }

    public double getProximity(){
        return proximity;
    }

    @Override
    public int compareTo(lenguage l2) {
        if(proximity > l2.getProximity()){
            return -1;
        }else if(proximity < l2.getProximity()){
            return 1;
        }else{
            return 0;
        }
    }
}