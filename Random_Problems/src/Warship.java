import java.io.*;

public class Warship {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        String data1 = br.readLine();
        String data2 = "";
        while (data1 != null && !data1.equals("")){
            data2 = br.readLine();
            wr.write(Solve(data1.split(" "),data2.split(" "))+"\n");
            data1 = br.readLine();
        }
        wr.flush();
    }

    private static String Solve(String[] data1, String[] data2) {
        String name1 = data1[0];
        int points1 = Integer.parseInt(data1[1]);

        String name2 = data2[0];
        int points2 = Integer.parseInt(data2[1]);

        if(name1.equals("Cruisers") && name2.equals("Battleships")){
            if(points2>=points1*2){
                return "Naebbirac";
            }else{
                return  "Tobby";
            }
        }

        if(name1.equals("Battleships") && name2.equals("Destroyers")){
            if(points2>=points1*2){
                return "Naebbirac";
            }else{
                return  "Tobby";
            }
        }

        if(name1.equals("Destroyers") && name2.equals("Cruisers")){
            if(points2>=points1*2){
                return "Naebbirac";
            }else{
                return  "Tobby";
            }
        }

        if(name2.equals("Cruisers") && name1.equals("Battleships")){
            if(points1>=points2*2){
                return "Tobby";
            }else{
                return  "Naebbirac";
            }
        }

        if(name2.equals("Battleships") && name1.equals("Destroyers")){
            if(points1>=points2*2){
                return "Tobby";
            }else{
                return  "Naebbirac";
            }
        }

        if(name2.equals("Destroyers") && name1.equals("Cruisers")){
            if(points1>=points2*2){
                return "Tobby";
            }else{
                return  "Naebbirac";
            }
        }

        if(name2.equals(name1)){
            if(points1>points2){
                return "Tobby";
            }else if(points1<points2){
                return "Naebbirac";
            }
        }

        return "Draw";
    }
}
