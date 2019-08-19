import java.io.*;
import java.util.PriorityQueue;
import java.util.Stack;

public class Priority {
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int Cases = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Stack<Integer> numbers = new Stack<>();

        for (int i = 0; i < Cases; i++) {
            String data[] = br.readLine().split(" ");

            if(data[0].equals("1")){
                int ref = Integer.parseInt(data[1]);
                numbers.push(ref);
                pq.offer(-ref);
            }else if(data[0].equals("2")){
                if(!numbers.isEmpty()){
                    int ref = numbers.pop();
                    pq.remove(-ref);
                }
            }else{
                wr.write( (-pq.peek())+"\n");
            }
        }
        wr.flush();
    }
}
