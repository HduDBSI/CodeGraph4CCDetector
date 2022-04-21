package googlejam8.p640;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner in = null;
		A a = new A();
		try {
			in = new Scanner(System.in);
			int count = in.nextInt();
			for (int test = 1; test <= count; test++) {
				int N = in.nextInt();
				int[] sen = new int[N];
				int totalNum = 0;
				for (int i = 0; i < N; i++) {
					sen[i] = in.nextInt();
					totalNum += sen[i];
				}
				int totalNum1 = totalNum;
				StringBuilder result1 = new StringBuilder();
				int start = 'A';
				while (totalNum1 > 0) {
					int max1 = 0;
					int max2 = 0;
					int max3 = 0;
					int maxSen1 = 0;
					int maxSen2 = 0;
					for (int i = 0; i < N; i++) {
						if (sen[i] > max1) {
							maxSen1 = i;
							max1 = sen[i];
						}
					}
					sen[maxSen1]--;
					for (int i = 0; i < N; i++) {
						if (sen[i] > max2) {
							maxSen2 = i;
							max2 = sen[i];
						}
					}
					sen[maxSen2]--;
					if (totalNum1 > 2) {
						max3 = 0;
						for (int i = 0; i < N; i++) {
							if (sen[i] > max3) {
								max3 = sen[i];
							}
						}
						if (max3 == max2) {
							char x = (char) (start + maxSen1);
							result1.append(x);
							totalNum1--;
							sen[maxSen2]++;
						} else {
							char x = (char) (start + maxSen1);
							result1.append(x);
							totalNum1--;
							x = (char) (start + maxSen2);
							result1.append(x);
							totalNum1--;
						}
					} else {
						if (max1 == max2 || maxSen1 == maxSen2) {
							char x = (char) (start + maxSen1);
							result1.append(x);
							totalNum1--;
							x = (char) (start + maxSen2);
							result1.append(x);
							totalNum1--;
						} else {
							char x = (char) (start + maxSen1);
							result1.append(x);
							totalNum1--;
							sen[maxSen2]++;
						}
					}
					result1.append(" ");
				}
				String result = result1.toString();
				System.out.println("Case #" + test + ": " + result);
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
