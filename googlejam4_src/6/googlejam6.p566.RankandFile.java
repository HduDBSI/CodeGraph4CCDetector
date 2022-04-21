package googlejam6.p566;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class RankandFile {

	private static String infileName, outFileName;
	private static BufferedReader reader;
	private static BufferedWriter writer;

	public static void main(String[] args) throws IOException {

		infileName = args[0];
		outFileName = infileName.substring(0, infileName.indexOf('.')).concat(
				".out");
		reader = Files.newBufferedReader(Paths.get(infileName));
		writer = Files.newBufferedWriter(Paths.get(outFileName));
		int numTests = Integer.parseInt(reader.readLine());
		for (int i = 0; i < numTests; i++) {
			int len = Integer.parseInt(reader.readLine());
			int[][] in = new int[2*len - 1][len];
			int count = 0;
			int j1 = 0;
			for (; count < 2*len - 1; count++) {
				for (String s1 : reader.readLine().split("\\s")) {
					in[count][j1++] = Integer.parseInt(s1);
				}
				j1 = 0;
			}
			int hights[][] = in;
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			for (int i1 = 0; i1 < 2*len - 1; i1++)
				for (int j = 0; j < len; j++) {
					int num = hights[i1][j];
					if (m.get(num) == null)
						m.put(num, 1);
					else {
						m.put(num, m.get(num) + 1);
					}
				}
			Set<Integer> s = new TreeSet<Integer>();
			for (Entry<Integer, Integer> e : m.entrySet()) {
				if (e.getValue() % 2 != 0)
					s.add(e.getKey());
			}
			Iterator<Integer> iterator = s.iterator();
			String str = "";
			while (iterator.hasNext()) {
				str = str + iterator.next() +" ";
			}
			String ans = str.trim();
			writer.write("Case #" + (i + 1) + ": " + (ans));
			writer.newLine();
		}
		reader.close();
		writer.close();
	}
}
