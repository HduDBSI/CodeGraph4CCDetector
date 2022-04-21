package googlejam6.p539;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RankAndFile {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfTestCases = in.nextInt();
		int x = 1;
		Map<Integer, List<List<Integer>>> testCaseMap = new HashMap<Integer, List<List<Integer>>>();
		for (int i = 0; i < numberOfTestCases; i++) {
			List<List<Integer>> inputRowColumnList = new ArrayList<List<Integer>>();
			Integer gridSize = in.nextInt();
			for (int j = 0; j < (2*gridSize - 1) ; j ++) {
				List<Integer> inputList = new ArrayList<Integer>();
				for (int k = 0; k < gridSize; k++) {
					inputList.add(in.nextInt());
				}
				inputRowColumnList.add(inputList);
			}
			testCaseMap.put(i, inputRowColumnList);
		}
		for (int i = 0; i< numberOfTestCases; i++) {
			List<Integer> missingList1 = new ArrayList<Integer>();
			Map<Integer, Integer> oddEvenMap = new HashMap<Integer, Integer>();
			for (List<Integer> list : testCaseMap.get(i)) {
				for (Integer height : list) {
					Integer oddEvenCount = oddEvenMap.get(height);
					if (null == oddEvenCount) {
						oddEvenCount = 1;
						oddEvenMap.put(height, oddEvenCount);
					} else {
						oddEvenCount = oddEvenCount + 1;
						oddEvenMap.put(height, oddEvenCount);
					}
				}
			}
			for (Map.Entry<Integer, Integer> entry : oddEvenMap.entrySet()) {
				Integer height = entry.getKey();
				Integer oddEven = entry.getValue();
				if (oddEven % 2 != 0) {
					missingList1.add(height);
				}
			}
			Collections.sort(missingList1);
			List<Integer> missingList = missingList1;
			System.out.print("Case #" + x + ":");
			for (Integer temp : missingList) {
				System.out.print(" " + temp);
			}
			System.out.println();
			x++;
		}
	}

}
