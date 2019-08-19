import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class inversa {
    public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        String line = br.readLine();

        while(line != null && !line.equals("")){
            wr.write(String.valueOf(Solve(line))+"\n");
            line = br.readLine();
        }
        wr.flush();
    }

    private static long Solve(String line) {
        String data[] = line.split(" ");
        Stack<Long> numbers = new Stack<>();
        Queue<String> simbols = new LinkedList<>();


        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("+") || data[i].equals("-") || data[i].equals("*") || data[i].equals("/")){
                simbols.offer(line);
                if(data[i].equals("+")){
                    long a = numbers.pop();
                    long b = numbers.pop();
                    numbers.push(b+a);
                }
                if(data[i].equals("-")){
                    long a = numbers.pop();
                    long b = numbers.pop();
                    numbers.push(b-a);
                }
                if(data[i].equals("*")){
                    long a = numbers.pop();
                    long b = numbers.pop();
                    numbers.push(b*a);
                }
                if(data[i].equals("/")){
                    long a = numbers.pop();
                    long b = numbers.pop();
                    if(a!= 0) {
                        numbers.push(b / a);
                    }else{
                        numbers.push(0L);
                    }
                }
            }else{
                numbers.push(Long.parseLong(data[i]));
            }
        }
        return numbers.pop();
    }

}
