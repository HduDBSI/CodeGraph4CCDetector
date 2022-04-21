package googlejam6.p591;
import java.io.File;
import java.util.*;

class Soldiers {
    static HashMap<Integer, Integer> check = new HashMap<Integer, Integer>();

    public static void main(String[] args) throws Exception {
        File file = new File("/Volumes/Macintosh HD/Users/avorobyev/Downloads/B-large.in");
        Scanner input = new Scanner(file);

        int totalCases = input.nextInt();

        for (int i = 1; i < totalCases + 1; i++) {

            check = new HashMap<Integer, Integer>();

            int n = input.nextInt();
            for (int j = 0; j < 2 * n - 1; j++) {
                for (int k = 0; k < n; k++) {
                    Integer m = input.nextInt();
                    if (check.get(m) == null) {
                        check.put(m, 1);
                    } else {
                        Integer old = check.get(m);
                        Integer newOld = old + 1;
                        check.put(m, newOld);
                    }
                }
            }

            ArrayList<Integer> toSort = new ArrayList<>();

            Iterator it = check.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                Integer toCheck = (Integer) pair.getValue();
                if ((toCheck % 2) != 0) {
                    toSort.add((Integer) pair.getKey());
                }
            }

            Collections.sort(toSort);

            System.out.print("Case #" + i + ": ");

            for (int j = 0; j < n; j++) {
                System.out.print(toSort.get(j) + " ");
            }
            System.out.println();
        }
    }
}