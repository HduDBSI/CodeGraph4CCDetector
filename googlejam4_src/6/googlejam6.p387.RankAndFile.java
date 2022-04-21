package googlejam6.p387;
import java.util.*;

public class RankAndFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            ArrayList<Integer> lists = new ArrayList<>();
            for (int j = 0; j < n * n * 2 - n; j++) {
                lists.add(sc.nextInt());
            }
            sc.nextLine();
			HashSet<Integer> heights = new HashSet<>();
			for (Integer height1: lists) {
			    if (heights.contains(height1)) {
			        heights.remove(height1);
			    } else {
			        heights.add(height1);
			    }
			}
			Integer[] list = heights.toArray(new Integer[heights.size()]);
			Arrays.sort(list);
            Integer[] missingList = list;
            System.out.printf("Case #%d:", i + 1);
            for (int height: missingList) {
                System.out.printf(" %d", height);
            }
            System.out.println();
        }
    }
}
