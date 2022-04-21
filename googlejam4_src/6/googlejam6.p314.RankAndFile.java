package googlejam6.p314;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RankAndFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        for (int numTest = 0; numTest < numTests; numTest++) {
            int numHeights = sc.nextInt();
			Map<Integer, Integer> heightToCount = new HashMap<>();
			for (int numList = 0; numList < (2 * numHeights - 1); numList++) {
			    for (int numHeight = 0; numHeight < numHeights; numHeight++) {
			        int height = sc.nextInt();
			        if (!heightToCount.containsKey(height)) {
			            heightToCount.put(height, 1);
			        } else {
			            heightToCount.put(height, heightToCount.get(height) + 1);
			        }
			    }
			}
			//System.out.println(heightToCount);
			List<Integer> missingRowOrColumn = heightToCount.entrySet().stream()
			        .filter(entry -> entry.getValue() % 2 == 1)
			        .map(Entry::getKey)
			        .sorted()
			        .collect(Collectors.toList());
			StringBuilder out = new StringBuilder();
			for (int integer : missingRowOrColumn) {
			    out.append(integer).append(" ");
			}
            String answer = out.toString();
            System.out.format("Case #%d: %s%n", numTest + 1, answer);
        }
    }
}
