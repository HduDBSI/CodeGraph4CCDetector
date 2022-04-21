package googlejam6.p647;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws IOException {
		final Scanner sc = new Scanner(new FileReader("Bin.in"));
		final BufferedWriter w = new BufferedWriter(new FileWriter("Bout.txt"));

		if (sc.hasNext()) {
			final int testNumber = sc.nextInt();
			for (int test = 1; test <= testNumber; test++) {
				int N = sc.nextInt();
				String answer = "";

				HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
				for (int j = 0; j < ((N*N*2)-N); j++) {
					Integer num = sc.nextInt();
					if (!map.containsKey(num)) {
						map.put(num,1);
					} else {
						map.replace(num, map.get(num)+1);
					}
				}
				ArrayList<Integer> al = new ArrayList<Integer>();
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					if ((entry.getValue() %2) ==1) {
						al.add(entry.getKey());
					}
				}
				int temp;
				for (int i = 1; i < al.size(); i++) {
					for (int j = i; j > 0; j--) {
						if (al.get(j-1) > al.get(j)) {
							temp = al.get(j-1);
							al.set(j-1,al.get(j));
							al.set(j, temp);
						}
					}
				}
				for (int num : al) {
					answer += num + " ";
				}

				w.write("Case #"+test+": "+answer+"\n");
				System.out.println("Case #"+test+": "+answer);
			}
		}
		sc.close();
		w.flush();
		w.close();
	}
}

