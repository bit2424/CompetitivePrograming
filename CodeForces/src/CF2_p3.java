import java.io.*;
import java.util.LinkedList;

public class CF2_p3 {
    //Solved
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String Data[] = br.readLine().split(" ");
        int n = Integer.parseInt(Data[0]);
        int q = Integer.parseInt(Data[1]);
        results = new int[2*n+1][2];
        LinkedList<Integer> Deque = new LinkedList<>();
        int numbers[] = new int[n];
        String data[] = br.readLine().split(" ");
        int max = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(data[i]);
            if(numbers[i]>max){
                max = numbers[i];
            }
            Deque.add(numbers[i]);
        }
        Simulate(numbers,Deque,max);

        for (int i = 0; i < q; i++) {
            long query = Long.parseLong(br.readLine());
            if(query<=uO){
                wr.write(results[(int)query][0]+" "+results[(int)query][1]+"\n");
            }else{
                query = ((query-uO)%aO)+(uO);
                //System.out.println(query);
                wr.write(results[(int)query][0]+" "+results[(int)query][1]+"\n");
            }
        }
        wr.flush();

    }

    static int uO;
    static int aO;
    static  int results[][];

    private static long Simulate(int[] numbers, LinkedList<Integer> deque, int max) {
        int a1 = 0;
        int a2 = 0;
        uO = 1;

        while (a1 != max){
            a1 = deque.pollFirst();
            a2 = deque.pollFirst();
            if(a1>a2){
                deque.addFirst(a1);
                deque.addLast(a2);
            }else{
                deque.addFirst(a2);
                deque.addLast(a1);
            }
            results[uO][0]=a1;
            results[uO][1]=a2;
            //System.out.println(results[uO][0]+" "+results[uO][1]);

            uO++;
        }
        uO--;
        aO = 0;

        int ref = uO;
        a1 = deque.pollFirst();
        for (int i = ref; i < ref+numbers.length-1; i++) {
            aO++;
            results[i][0]=a1;
            results[i][1]=a2;
            //System.out.println(results[i][0]+" "+results[i][1]+" Segunda parte");
            a2 = deque.pollFirst();
        }
        //System.out.println("aO = "+aO+" uO = "+uO);

        return 1;
    }
}
