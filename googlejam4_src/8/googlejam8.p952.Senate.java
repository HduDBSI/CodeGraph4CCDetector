package googlejam8.p952;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Senate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 1; i <= numOfCases; ++i) {
            int numOfParties = scanner.nextInt();
            List<Integer> parties = new ArrayList<>();
            for (int v = 0; v < numOfParties; ++v) {
                int num = scanner.nextInt();
                parties.add(num);
            }
			final List<Integer> parties1 = parties;
			StringBuffer sb = new StringBuffer("");
			int sum = parties1.stream().reduce(0, (a, v) -> a + v);;
			while (sum != 0) {
			    if (sum % 2 == 1) {
			        int max1 = 0;
					int position = -1;
					for (int i1 = 0; i1 < parties1.size(); i1++) {
					    if (parties1.get(i1) > max1) {
					        position = i1;
					        max1 = parties1.get(i1);
					    }
					}
					int max = position;
			        parties1.set(max, parties1.get(max) - 1);
			        sb.append(" ").append((char)('A' + max));
			    } else {
			        int max2 = 0;
					int position1 = -1;
					for (int i2 = 0; i2 < parties1.size(); i2++) {
					    if (parties1.get(i2) > max2) {
					        position1 = i2;
					        max2 = parties1.get(i2);
					    }
					}
					int max = position1;
					int max1 = 0;
					int position = -1;
					for (int i1 = 0; i1 < parties1.size(); i1++) {
					    if (i1 != max && parties1.get(i1) > max1) {
					        position = i1;
					        max1 = parties1.get(i1);
					    }
					}
			        int max2nd = position;
			        if (max2nd == -1) {
			            System.err.println("Something wrong");
			            parties1.forEach(System.err::print);
			            System.err.println(" " + sb.toString());
			            throw new RuntimeException("Something went wrong");
			        } else {
			            if ((((double) parties1.get(max2nd)) / ((double) (sum - 2))) >= 0.6){
			                sb.append(" ").append((char) ('A'+max)).append((char)('A'+max2nd));
			                parties1.set(max, parties1.get(max) - 1);
			                parties1.set(max2nd, parties1.get(max2nd) - 1);
			            } else {
			                sb.append(" ").append((char)('A'+max)).append((char)('A'+max));
			                parties1.set(max, parties1.get(max) - 2);
			            }
			        }
			    }
			    sum = parties1.stream().reduce(0, (a, v) -> a + v);
			}
            String plan = sb.toString();
            System.out.println("Case #" + i + ":" + plan);
            scanner.nextLine();
        }
    }
}
