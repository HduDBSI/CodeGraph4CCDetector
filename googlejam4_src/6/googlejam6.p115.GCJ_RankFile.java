package googlejam6.p115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GCJ_RankFile {

	// Global vars
	StringTokenizer st;
	BufferedReader in;
	BufferedWriter out;
	int min;
	int max;



	public static void main(String[] args) throws Exception {
		GCJ_RankFile J=new GCJ_RankFile();

		Locale.setDefault(Locale.US);
		
		
		
		
		//File inputFile=new File("B-large.in");
		File inputFile=new File("B.in");
		
		
		
		//		PrintWriter outputFile= new PrintWriter("B-large.out","UTF-8");
		PrintWriter outputFile= new PrintWriter("B.out","UTF-8");
		
		
		Scanner sc=new Scanner(inputFile);
		sc.useLocale(Locale.US);
		
		int T=sc.nextInt();
		for (int t=1;t<=T;t++){
			J.min=Integer.MAX_VALUE;
			J.max=Integer.MIN_VALUE;
		
			int N=sc.nextInt();
			int[][] list=new int[2*N-1][N];
			for (int i=0;i<2*N-1;i++){
				for (int j=0;j<N;j++) {
					int x=sc.nextInt();
					list[i][j]=x;
					if (x<J.min)
						J.min=x;
					if (x>J.max)
						J.max=x;
				}
			}
			int[] cnt=new int[2501];
			for (int i=0;i<2*N-1;i++)
				for (int j=0;j<N;j++){
					cnt[list[i][j]]++;
				}
			int[] tmp=new int[N];
			int st=0;
			for (int u=0;u<2501;u++){
				if (cnt[u]%2==1){
					tmp[st++]=u;
				}
			}
			Arrays.sort(tmp);
			String res="";
			for (int u:tmp){
				res+=u+" ";
			}
			String s=res;
		
			System.out.println("Case #"+t+": "+s);
			outputFile.println("Case #"+t+": "+s);
		
		
		}
		
		
		
		sc.close();
		outputFile.close();


	}






}
