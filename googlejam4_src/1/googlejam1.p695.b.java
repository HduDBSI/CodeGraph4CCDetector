package googlejam1.p695;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class b {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PrintWriter writer;
		try {
			writer = new PrintWriter("out.txt", "UTF-8");
		
			int t = Integer.parseInt(s.nextLine());
			
			for (int i = 1; i <= t; ++i){
				// solve

				int n = Integer.valueOf(s.nextLine());
				String[] times = s.nextLine().split(" ");
				int r1 = 0;
				int max_rate = 0;
				for(int j = 1; j < n; j++) {
					int x = Integer.valueOf(times[j-1]);
					int y = Integer.valueOf(times[j]);

					if(x > y) {
						r1 += x - y;
					}
					
					if(x - y > max_rate) {
						max_rate = x-y;
					}
				}
				
				int r2 = 0;
				for(int j = 0; j < n-1; j++) {
					int x = Integer.valueOf(times[j]);
					r2 += x>max_rate? max_rate: x;
				}
				
				String result = r1 + " " + r2;

				System.out.println("Case #" + i + ": " + result);
				writer.println("Case #" + i + ": " + result);
			}
			
			s.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
