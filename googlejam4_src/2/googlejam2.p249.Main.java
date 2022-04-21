package googlejam2.p249;
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
		int[] list1 = new int[1000001];
		list1[0] = 0;
		list1[1] = 1;
		for (int i2=2; i2<1000001; i2++) {
			list1[i2] = 9999999;
		}
		
		for (int i1=1; i1<1000001; i1++) {
			String strI = Integer.toString(i1);
			int reverseI = 0;
			for (int k=strI.length()-1; k>=0; k--) {
				reverseI *= 10;
				reverseI += Integer.parseInt("" + strI.charAt(k));
			}
		
			if (i1 != 1000000) list1[i1+1] = Math.min(list1[i1+1], list1[i1] + 1);
			if (reverseI <= 1000000) list1[reverseI] = Math.min(list1[reverseI], list1[i1] + 1);
		}
		int[] list = list1;
		for (int i=0; i<T; i++){
			int N = Integer.parseInt(br.readLine());
			System.out.println("Case #" + (i + 1) + ": " + list[N]);
		}
	}
}

