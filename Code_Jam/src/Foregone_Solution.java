import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Foregone_Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int cases = Integer.parseInt(br.readLine());
		for(int I = 0; I<cases ; I++) {
			wr.write("Case #" + (I+1) +Solve() + "\n");
		}
		wr.flush();
	}

	private static String Solve() throws IOException {
		String number[] = br.readLine().split("");
		
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();
		
		for (int i = 0; i < number.length; i++) {
			int ev = Integer.parseInt(number[i]);
			int al = ev;
			int bl = 0;
			
			if(ev == 4){
				al = ev-1;
				bl = 1;
			}
			
			a.append(al);
			b.append(bl);
		}
		
		return ": " + a.toString()+ " " +b.toString();
	}
}
