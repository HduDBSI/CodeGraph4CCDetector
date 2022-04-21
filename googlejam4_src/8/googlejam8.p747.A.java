package googlejam8.p747;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws IOException {
		final Scanner sc = new Scanner(new FileReader("Ain.in"));
		final BufferedWriter w = new BufferedWriter(new FileWriter("Aout.txt"));
		String[] a = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

		final int testNumber = sc.nextInt();
		for (int test = 1; test <= testNumber; test++) {
			int N = sc.nextInt();
			String ans = "";
			int[] num = new int[N];
			int sum = 0;
			int count = 0;
			HashMap<Integer, ArrayList<String>> map = new HashMap<>();
			for (int i=0; i<num.length;i++) {
				num[i] = sc.nextInt();
				if (map.get(num[i])!=null) {
					map.get(num[i]).add(a[i]);
				} else {
					ArrayList<String> al = new ArrayList<>();
					al.add(a[i]);
					map.put(num[i], al);
				}
				sum += num[i];
			}
			while(true) {
				Arrays.sort(num);
				int last = num.length-1;
				if (num[last]>0) {
					String add = map.get(num[last]).get(map.get(num[last]).size()-1);
					ans += add;
					count++;
					map.get(num[last]).remove(add);
					num[last]--;
					if ((num[last]==0) && (num[last-1]==0)) {
						break;
					}
					if ((sum - count) == 2) {
						ans += " ";
						if (map.get(num[last])!=null) {
							map.get(num[last]).add(add);
						} else {
							ArrayList<String> al = new ArrayList<>();
							al.add(add);
							map.put(num[last], al);
						}
					} else {
						if (num[last]>= num[last-1]) {
							ans += add+" ";
							count++;
							if (map.get(num[last]-1)!=null) {
								map.get(num[last]-1).add(add);
							} else {
								ArrayList<String> al = new ArrayList<>();
								al.add(add);
								map.put(num[last]-1, al);
							}
							num[last]--;
						} else {
							if (map.get(num[last])!=null) {
								map.get(num[last]).add(add);
							} else {
								ArrayList<String> al = new ArrayList<>();
								al.add(add);
								map.put(num[last], al);
							}
							String two = map.get(num[last-1]).get(map.get(num[last-1]).size()-1);
							map.get(num[last-1]).remove(two);
							ans += two+" ";
							count++;
							if (map.get(num[last-1]-1)!=null) {
								map.get(num[last-1]-1).add(two);
							} else {
								ArrayList<String> al = new ArrayList<>();
								al.add(two);
								map.put(num[last-1]-1, al);
							}
							num[last-1]--;
						}
					}
				} else {
					break;
				}
			}
			//			ans += a[maxI]+a[max2I]+" ";
			//			num -=
			//			boolean check = true;
			//			while (check) {
			//			for (int i=0;i<num.length; i++) {
			//
			//			}
			//			}
			w.write("Case #"+test+": "+ans.trim()+"\n");
			System.out.println("Case #"+test+": "+ans);
		}
		sc.close();
		w.flush();
		w.close();
	}


}
