package googlejam6.p309;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankAndFile {

	public static void main(String[] args) throws Exception {
		int caseNo = 1;
		boolean noRead = false;
		try (BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\fengze\\scala_workspace\\jam\\input.txt"));
				FileWriter fw = new FileWriter("output.txt")) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!noRead) {
					noRead = true;
					continue;
				} else {
					int n = Integer.parseInt(line);
					String[] lines = new String[2 * n - 1];
					for (int i = 0; i < lines.length; i++) {
						lines[i] = br.readLine();
					}
					RankAndFile rf = new RankAndFile(n, lines);
					int[] result = new int[rf.n];
					
					Map<Integer, Integer> map = new HashMap<>();
					
					for (int i1 = 0; i1 < 2 * rf.n - 1; i1++) {
						String[] temp = rf.list[i1].split("\\s+");
						for (int j = 0; j < rf.n; j++) {
							Integer height = Integer.parseInt(temp[j]);
							if (map.containsKey(height)) {
								Integer count = map.get(height);
								map.put(height, count + 1);
							} else {
								map.put(height, 1);
							}
						}
					}
					
					int i2 = 0;
					for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
						if (entry.getValue() % 2 != 0) {
							result[i2] = entry.getKey();
							i2++;
						}
					}
					
					Arrays.sort(result);
					int[] array = result;
					StringBuilder sb = new StringBuilder();
					for(int i = 0; i < array.length; i ++) {
						sb.append(' ');
						sb.append(array[i]);
					}
					fw.write("Case #" + caseNo + ":" + sb.toString() + "\r\n");
					caseNo++;
				}

			}
		}
	}

	private int n;
	private String[] list;

	public RankAndFile(int n, String[] list) {
		this.n = n;
		this.list = list;
	}
}
