package googlejam3.p159;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(new InputStreamReader(System.in));

	public static void main (String[] args) throws java.lang.Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int count = (int)(W + Math.ceil(((double)(C-W)/W)));
			
			int putout = (int)(Math.floor(((double)(C/W)))) * (R-1);
			System.out.println("Case #" + (i+1) + ": " + (count + putout));
		}
	}
}

