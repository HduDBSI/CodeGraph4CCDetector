package googlejam1.p682;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Run {
	public static final String fileIn = "textFiles/mushrooms/A-large.in.txt";
	public static final String fileOut = "textFiles/mushrooms/large-out.txt";
	
	public static void main(String[] args) 
			throws FileNotFoundException, IOException {
		PrintWriter writer = new PrintWriter(fileOut, "UTF-8");
		try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
			int numIn = Integer.parseInt(br.readLine());
			for (int i = 0; i < numIn; i++) {
				int time = Integer.parseInt(br.readLine());
				String[] numListString = br.readLine().split(" ");
				int[] intList = new int[time];
				int curr = Integer.parseInt(numListString[0]);
				intList[0] = curr;
				int case1Sum = 0;
				int case2NegMax = 0;
				for (int j = 1; j < time; j++) {
					int next = Integer.parseInt(numListString[j]);
					intList[j] = next;
					int diff = next - curr;
					if (diff < 0) {
						case1Sum += -diff;
						if (-diff > case2NegMax) {
							case2NegMax = -diff;
						}
					}
					curr = next;
				}
				int case1 = case1Sum;
				int case2Sum = 0;
				for (int j = 0; j < time - 1; j++) {
					curr = intList[j];
					int next = intList[j+1];
					int diff = next - curr;
					if (curr < case2NegMax) {
						case2Sum += curr;
					} else {
						case2Sum += case2NegMax;
					}
				}
				writer.println("Case #" + (i+1) + ": " + case1 + " " + case2Sum);
			}
		}
		writer.close();
	}
}
