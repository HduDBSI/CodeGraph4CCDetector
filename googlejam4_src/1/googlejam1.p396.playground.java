package googlejam1.p396;


import java.io.*;
import java.util.*;

public class playground {
	
	public static void main(String[] args) throws IOException{
		playground r = new playground();
		File file = new File("A-large.in");
		File outFile = new File("A-large.out");
		//File file = new File("F:\\A-large-practice.in");
		//File outFile = new File("F:\\A-large-practice.out");
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		int testCases = Integer.parseInt(br.readLine());
		for(int t=1;t<=testCases;t++){
		    br.readLine();
		    String[] s=br.readLine().split(" ");
			int[] igr=new int[s.length];
			for(int i=0;i<s.length;i++){
				igr[i]=Integer.parseInt(s[i]);
			}
		    int[] pieces=igr;
			int sum=0;
			for(int i=1;i<pieces.length;i++){
				if(pieces[i]>=pieces[i-1]){
					continue;
				}
				else{
					sum+=pieces[i-1]-pieces[i];
				}
			}
		    int solution1=sum;
			int sum1=0;
			int max=0;
			for(int i=0;i<pieces.length-1;i++){
				max=(int)Math.max(pieces[i]-pieces[i+1],max);
			}
			for(int i=0;i<pieces.length-1;i++){
				sum1+=(int)Math.min(max, pieces[i]);
			}
		    int solution2=sum1;
		    bw.write("Case #" + t +": "+solution1+" "+solution2+"\r");
		}
		br.close();
		bw.close();
//		int[] a={80,37, 90, 66, 60, 97, 57, 84, 87};
//		System.out.println(solve2(a));
//		int num=2;
//		int[] a={9,8};
//		System.out.println(solve(2,a));
	}
}
