package googlejam1.p241;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(new InputStreamReader(System.in));

	public static void main (String[] args) throws java.lang.Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++){
			int N = Integer.parseInt(br.readLine());
			int[] ms = new int[1000];
			StringTokenizer data = new StringTokenizer(br.readLine(), " ");
			for (int i3=0; i3<N; i3++) {
				ms[i3] = Integer.parseInt(data.nextToken());
			}
			
			int ansY = 0;
			int angle = 0;
			for (int i1=1; i1<N; i1++) {
				ansY += Math.max(0, ms[i1-1] - ms[i1]);
				angle = Math.max(angle, ms[i1-1] - ms[i1]);
			}
			
			int ansZ = 0;
			for (int i2=1; i2<N; i2++) {
				ansZ += Math.min(ms[i2-1], angle);
			}
			
			System.out.println("Case #" + (i+1) + ": " + ansY + " " + ansZ);
		}
	}
}
