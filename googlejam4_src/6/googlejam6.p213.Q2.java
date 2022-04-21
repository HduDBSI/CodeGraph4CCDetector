package googlejam6.p213;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Q2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("input.in"));
		String count = null;
		FileWriter fw = new FileWriter("output.out");  
		count = bf.readLine();
		ArrayList<Integer> times = new ArrayList<Integer>();
		for (int i = 0; i < Integer.parseInt(count); i++) {
				times.clear();
				for (int i1 = 0; i1 < 2501 ;i1++) {
					Integer a = new Integer(0);
					times.add(i1, a);
				}
				Integer n = Integer.parseInt(bf.readLine());
				for (int i2 = 1; i2 < 2*n; i2++) {
					String lines = bf.readLine();
					String []nums = lines.split(" ");
					for (int i1 = 0; i1 < nums.length; i1++) {
						Integer temp = Integer.parseInt(nums[i1]);
						times.set(temp, times.get(temp) + 1);
					}
				}
				String buffers = "";
				for (Integer i1 = 0; i1 < 2501; i1 ++) {
					if (times.get(i1) % 2 != 0) {
						buffers += i1.toString() + " ";
					}
				}

				fw.write("Case #" + (i + 1) + ": " + buffers + "\n");

		}
		bf.close();
		fw.close();
	}
}
