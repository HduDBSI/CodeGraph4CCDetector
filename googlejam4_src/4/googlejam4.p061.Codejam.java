package googlejam4.p061;


import java.util.*;
import java.io.*;
import java.math.*;


class Codejam {
	
	
	
    public static void main(String args[]) {
        Scanner in = null;
		try {
			in = new Scanner(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new File("output.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer> ();
		map.put('<', 1);
		map.put('^', 2);
		map.put('>', 4);
		map.put('v', 8);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			//in.nextLine();
			int r = in.nextInt();
			int c = in.nextInt();
			String ar[] = new String[r];
			in.nextLine();
			for (int i = 0 ; i < r; i++) ar[i] = in.nextLine();
			
			int ne[][] = new int[r][c];
			
			for (int i = 0; i < r; i++) {
				int l = -1;
				int p = -1;
				for (int j = 0; j < c; j++) {
					if (ar[i].charAt(j) != '.') {
						if (l == -1) {
							l = j;
							ne[i][j] += 1;
						}
						p = j;
					}
				}
				if (p != -1) {
					ne[i][p] += map.get('>');
				}
			}
			
			for (int j = 0; j < c; j++) {
				int u = -1;
				int d = -1;
				for (int i = 0; i < r; i++) {
					if (ar[i].charAt(j) != '.') {
						if (u == -1) {
							u = i;
							ne[i][j] += map.get('^');
						}
						d = i;
					}
				}
				if (d != -1) {
					ne[d][j] += map.get('v');
				}
			}
			
			int count = 0;
			for (int i = 0; i < r; i++) {
				if (count == -1) {
					break;
				}
				for (int j = 0; j < c; j++) {
					if (ar[i].charAt(j) != '.') {
						if (ne[i][j] != 0) {
							char ch = ar[i].charAt(j);
							if (ne[i][j] == 15) {
								count = -1;
								break;
							} else {
								if ((map.get(ch) & ne[i][j]) != 0) {
									count ++;
								}
							}
						}
					}
				}
				if (count == -1) {
					break;
				}
			}
			
			System.out.println("Case #" + t + ": " + (count == -1 ? "IMPOSSIBLE" : count));
		}
    }
 
}