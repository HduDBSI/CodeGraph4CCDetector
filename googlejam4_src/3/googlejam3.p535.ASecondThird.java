package googlejam3.p535;
import java.io.*;
import java.util.*;
public class ASecondThird {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int cases = 1; cases <= T; cases++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int ans = (int)( Math.ceil( r*c/(w*1.0) ) );
		    if (Math.min( r, c ) > 1) ans += Math.min( r, c);
		    ans += ( w-1 );
		    System.out.println("Case #" + cases + ": " + Math.min(ans, r*c));
		}
	}
}
