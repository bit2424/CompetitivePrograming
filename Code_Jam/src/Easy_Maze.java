import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Easy_Maze {
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
		br.readLine();
		String reverse = br.readLine();
		StringBuilder rev = new StringBuilder();
		for (int i = 0; i < reverse.length(); i++) {
			if(reverse.charAt(i) == 'E') {
				rev.append("S");
			}else {
				rev.append("E");
			}
		}
		return rev.toString();
	}
}
