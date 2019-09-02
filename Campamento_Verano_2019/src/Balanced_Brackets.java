import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Balanced_Brackets{
    static String isBalanced(String s) {
        Stack<String> st = new Stack<>();
        String data[] = s.split("");
        boolean nice = true;
        int pos = 0;
        for (int i = 0; i < data.length; i++) {
            String ref = data[i];

            if(ref.equals("{")){
                st.push(ref);
            }else if(ref.equals("(")){
                st.push(ref);
            }else if(ref.equals("[")){
                st.push(ref);
            }else if(ref.equals("}")){
                if(st.peek().equals("{")){
                    st.pop();
                }else{
                    nice =false;
                    break;
                }
            }else if(ref.equals("]")){
                if(st.peek().equals("[")  && st.size() >0){
                    st.pop();
                }else{
                    nice =false;
                    break;
                }
            }else if(ref.equals(")")){
                if(st.peek().equals("(")  && st.size() >0){
                    st.pop();
                }else{
                    nice =false;
                    break;
                }
            }
        }
        
        if(nice && st.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
