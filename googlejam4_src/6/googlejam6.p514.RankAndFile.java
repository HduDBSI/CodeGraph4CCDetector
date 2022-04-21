package googlejam6.p514;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RankAndFile {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("B-large.in"));
		int numberOfCases = sc.nextInt();
		String[] result = new String[numberOfCases];
		//sc.nextLine();
		for (int i=0; i<numberOfCases; i++) {
			int numberOfLines = sc.nextInt();
			sc.nextLine();
			String tempIn = "";
			for (int j=0; j<(numberOfLines*2-1); j++) {
				String temp = sc.nextLine();
				tempIn += temp +" ";
			}
			String[] input = tempIn.split("\\s+");
			int[] intInput = new int[input.length];
			for (int i1=0; i1<input.length; i1++) {
				intInput[i1] = Integer.parseInt(input[i1]);
			}
			Map<Integer, Integer> map = new HashMap<>();
			for (int i2=0; i2<intInput.length; i2++) {
				if (map.get(intInput[i2])==null) {
					map.put(intInput[i2], 1);
				} else {
					map.put(intInput[i2], map.get(intInput[i2])+1);
				}
			}
			List<Integer> res = new ArrayList<>();
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int value = entry.getValue();
				if (value%2!=0) {
					res.add(entry.getKey());
				}
			}
			Collections.sort(res);
			StringBuilder finalResult = new StringBuilder();
			for (Integer e:res) {
				finalResult.append(e);
				finalResult.append(" ");
			}
			result[i] = finalResult.toString();
		}
		for (int i=0; i<numberOfCases; i++) {
			int caseNumber = i+1; 
			System.out.format("Case #%d: %s\n", caseNumber, result[i]);
		}
	}
}
