package googlejam1.p122;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class A {
//	static String file = "A";
	static String file = "A-large";

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(file + ".in");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		FileOutputStream fos = new FileOutputStream(file + ".out");
		OutputStreamWriter isw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(isw);

		String line = null;
		List<String> lines = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}

		int problemCount = Integer.parseInt(lines.get(0));
		int currentIndex = 1;
		for (int i = 0; i < problemCount; i++) {
			String line1 = lines.get(currentIndex++);
			String line2 = lines.get(currentIndex++);
			String[] vals = line2.split(" ");
			int[] ans = new int[vals.length];
			for (int i4 = 0; i4 < vals.length; i4++) {
				ans[i4] = Integer.valueOf(vals[i4]);
			}
			int[] mush = ans;
			long[] min1 = new long[2];
			//		System.out.println(Arrays.toString(mush));
					
					for (int i2 = 0; i2 < mush.length - 1; i2++) {
						if (mush[i2+1] < mush[i2]) {
							min1[0] += mush[i2] - mush[i2+1];
						}
					}
					
					int rate = 0;
					for (int i3 = 0; i3 < mush.length - 1; i3++) {
						if (mush[i3+1] < mush[i3]) {
							rate = Math.max(rate, mush[i3] - mush[i3+1]);
						}
					}
					
					for (int i1 = 0; i1 < mush.length - 1; i1++) {
						min1[1] += Math.min(mush[i1], rate);
					}
			long[] min = min1;
			String r = "Case #" + (i + 1) + ": " + min[0] + " " + min[1];

//			System.out.println(r);
			bw.write(r);
			bw.newLine();
		}

		if (bw != null)
			bw.close();

		if (br != null)
			br.close();
	}
}
