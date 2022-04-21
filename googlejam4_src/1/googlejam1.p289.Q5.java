package googlejam1.p289;
import java.util.ArrayList;
import java.util.Scanner;


public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = Integer.parseInt(s.nextLine());
		ArrayList<ArrayList<Integer>> trials = new ArrayList<>();
		for (int i = 0; i < numberOfTestCases; i++) {
			ArrayList<Integer> myCase = new ArrayList<>();
			int num = Integer.parseInt(s.nextLine());
			String str = s.nextLine();
			for (int j = 1; j < num; j++) {
				myCase.add(Integer.parseInt(str.substring(0, str.indexOf(" "))));
				str = str.substring(str.indexOf(" ") + 1);
			}
			myCase.add(Integer.parseInt(str));
			trials.add(myCase);
		}
		s.close();

		int counter = 1;
		for (ArrayList<Integer> c : trials) {
			//m1
			int m1Sum = 0;
			for (int i = 0; i < c.size() - 1; i++) {
				int prev = c.get(i);
				int now = c.get(i + 1);
				if (prev > now) {
					m1Sum += prev - now;
				}
			}
			//m2
			int m2Sum = 0;
			int greatestDiff = 0;
			for (int i = 0; i < c.size() - 1; i++) {
				int prev = c.get(i);
				int now = c.get(i + 1);
				if (prev - now > greatestDiff) {
					greatestDiff = prev - now;
				}
			}
			for (int i = 0; i < c.size() - 1; i++) {
				if (c.get(i) < greatestDiff) {
					m2Sum += c.get(i);
				} else {
					m2Sum += greatestDiff;
				}
			}
			System.out.println("Case #" + counter + ":" + " " + m1Sum + " " + m2Sum);
			counter++;
		}
	}

}
