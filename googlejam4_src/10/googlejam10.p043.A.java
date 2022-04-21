package googlejam10.p043;
import java.io.*;
import java.util.*;
import java.math.*;

public class A {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/A-large.in"))));

		String output = "";
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			int p = sc.nextInt();
			int s = sc.nextInt();
			ArrayList<String> poss = new ArrayList<String>();
			
			String ans = "P";
			int ar = 0;
			int ap = 0;
			int as = 0;
			for (int j = 0; j < n; j++) {
				StringBuilder next = new StringBuilder();
				for (char c : ans.toCharArray()) {
					if (c=='P')
						next.append("PR");
					if (c=='S')
						next.append("PS");
					if (c=='R')
						next.append("RS");
				}
				ans = next.toString();
			}
			for (char c : ans.toCharArray()) {
				if (c=='P')
					ap++;
				if (c=='R')
					ar++;
				if (c=='S')
					as++;
			}
			if (ap==p&&ar==r&&as==s) {
				for (int j = 0; j < n; j++) {
					StringBuilder fa = new StringBuilder();
					int step = 1<<j;
					for (int k = 0; k < ans.length(); k += step*2) {
						if (ans.substring(k, k+step).compareTo(ans.substring(k+step, k+step*2)) < 0) {
							fa.append(ans.substring(k, k+step*2));
						} else {
							fa.append(ans.substring(k+step, k+step*2));
							fa.append(ans.substring(k, k+step));
						}
					}
					ans = fa.toString();
				}
				poss.add(ans);
			}
			
			ans = "R";
			ar = 0;
			ap = 0;
			as = 0;
			for (int j = 0; j < n; j++) {
				StringBuilder next = new StringBuilder();
				for (char c : ans.toCharArray()) {
					if (c=='P')
						next.append("PR");
					if (c=='S')
						next.append("PS");
					if (c=='R')
						next.append("RS");
				}
				ans = next.toString();
			}
			for (char c : ans.toCharArray()) {
				if (c=='P')
					ap++;
				if (c=='R')
					ar++;
				if (c=='S')
					as++;
			}
			if (ap==p&&ar==r&&as==s) {
				for (int j = 0; j < n; j++) {
					StringBuilder fa = new StringBuilder();
					int step = 1<<j;
					for (int k = 0; k < ans.length(); k += step*2) {
						if (ans.substring(k, k+step).compareTo(ans.substring(k+step, k+step*2)) < 0) {
							fa.append(ans.substring(k, k+step*2));
						} else {
							fa.append(ans.substring(k+step, k+step*2));
							fa.append(ans.substring(k, k+step));
						}
					}
					ans = fa.toString();
				}
				poss.add(ans);
			}
			
			ans = "S";
			ar = 0;
			ap = 0;
			as = 0;
			for (int j = 0; j < n; j++) {
				StringBuilder next = new StringBuilder();
				for (char c : ans.toCharArray()) {
					if (c=='P')
						next.append("PR");
					if (c=='S')
						next.append("PS");
					if (c=='R')
						next.append("RS");
				}
				ans = next.toString();
			}
			for (char c : ans.toCharArray()) {
				if (c=='P')
					ap++;
				if (c=='R')
					ar++;
				if (c=='S')
					as++;
			}
			if (ap==p&&ar==r&&as==s) {
				for (int j = 0; j < n; j++) {
					StringBuilder fa = new StringBuilder();
					int step = 1<<j;
					for (int k = 0; k < ans.length(); k += step*2) {
						if (ans.substring(k, k+step).compareTo(ans.substring(k+step, k+step*2)) < 0) {
							fa.append(ans.substring(k, k+step*2));
						} else {
							fa.append(ans.substring(k+step, k+step*2));
							fa.append(ans.substring(k, k+step));
						}
					}
					ans = fa.toString();
				}
				poss.add(ans);
			}
			
			if (poss.size() == 0)
				output += "Case #" + i + ": " + "IMPOSSIBLE" + "\n";
			else {
				Collections.sort(poss);
				output += "Case #" + i + ": " + poss.get(0) + "\n";
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/A-large.out"), "utf-8"));
		bw.write(output);
		bw.close();
	}
}