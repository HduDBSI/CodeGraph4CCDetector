package googlejam8.p251;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Q1 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("input.in"));
		String input = null;
		String count = null;
		FileWriter fw = new FileWriter("output.out");  
		count = bf.readLine();
		for (int i = 0; i < Integer.parseInt(count); i++) {
				ArrayList<Integer> party = new ArrayList<Integer>();
				String a = bf.readLine();
				String b = bf.readLine();
				String []alls = b.split(" ");
				Integer totals = 0;
				for (int i1 = 0; i1 < alls.length;i1++) {
					party.add(Integer.parseInt(alls[i1]));
					totals += Integer.parseInt(alls[i1]);
				}
				fw.write("Case #" + (i + 1) + ": ");
				while (totals > 0) {
					int maxd = 0;
					int mark = -1;
					Integer max2d = 0;
					int mark2 = -1;
					for (int i1 = 0; i1 < party.size();i1++) {
						if (party.get(i1) > maxd) {
							maxd = party.get(i1);
							mark = i1;
							continue;
						}
						if ((party.get(i1) <= maxd) && (party.get(i1) > max2d)) {
							max2d = party.get(i1);
							mark2 = i1;
							continue;
						}
					}
					totals--;
					party.set(mark, party.get(mark) - 1);
					char c = 65;
					c += mark;
					String outputs = "" + c;
					String d = max2d.toString();
					Double prob = Double.parseDouble(d);
					if (prob / totals > 0.5) {
						totals--;
						party.set(mark2, party.get(mark2) - 1);
						char c2 = 65;
						c2 += mark2;
						outputs = outputs + c2;
					}
					fw.write(outputs+" ");
				}
				
					
				fw.write("\n");
		}
		bf.close();
		fw.close();
	}
}
