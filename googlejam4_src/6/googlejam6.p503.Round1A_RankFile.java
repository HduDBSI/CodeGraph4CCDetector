package googlejam6.p503;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Round1A_RankFile {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(new File("src/Input.txt"));
		int T = Integer.parseInt(scan.nextLine());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(scan.nextLine());
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < (2*N - 1) ; j++) {
				String line = scan.nextLine();
				StringTokenizer str = new StringTokenizer(line);
				
				while(str.hasMoreTokens()) {
					String check = str.nextToken();
					
					if (list.contains(check)) {
						list.remove(check);
						
					} else {
						list.add(check);
					}
				}
			}
			
			int array[] = new int[N];
			int j = 0;
			for (String l : list) {
				array[j] = Integer.parseInt(l);
				j++;
			}
			Arrays.sort(array);
			String ans = "Case #"+i+":";
			for (int l : array) {
				ans = ans + " " + l;
			}
			System.out.println(ans);
		}
	}

}
