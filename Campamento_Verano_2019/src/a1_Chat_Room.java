import java.io.*;

public class a1_Chat_Room {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String data = br.readLine();
        int counter = 0;
        for (int i = 0; i < data.length(); i++) {
            if(counter == 0 && data.charAt(i)=='h'){
                counter++;
            }else if(counter == 1 && data.charAt(i)=='e'){
                counter++;
            }else if(counter == 2 && data.charAt(i)=='l'){
                counter++;
            }else if(counter == 3 && data.charAt(i)=='l'){
                counter++;
            }else if(counter == 4 && data.charAt(i)=='o'){
                counter++;
            }
        }

        if(counter == 5){
            wr.write("YES");
        }else{
            wr.write("NO");
        }
        wr.flush();
    }
}
