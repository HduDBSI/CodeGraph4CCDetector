package googlejam3.p192;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Brattleship {
	public static void main(String[] args) throws IOException {
		String[] input;
		if (args.length > 0) { input = args; }
		else {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String x = null;
			int size = Integer.parseInt(in.readLine());
			input = new String[size];
			for (int i=0; i<size; i++) {
				input[i] = in.readLine();
			}
		}
		int counter = 1;
		String[] temp;
		int r, c, w, score, base;
		for (String s: input) {
			temp = s.split(" ");
			r = Integer.parseInt(temp[0]);
			c = Integer.parseInt(temp[1]);
			w = Integer.parseInt(temp[2]);
			score = 0;
			base = c / w;
			score = base * r;
			score += w - 1;
			if (c % w != 0) { score++; }
			System.out.println("Case #" + counter + ": " + score);
			counter++;
		}
	}
}