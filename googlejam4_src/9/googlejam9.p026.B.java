package googlejam9.p026;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;

public class B {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("B-small-attempt1.in"));
//        PrintWriter pw = new PrintWriter(new File("B-small.out"));
        BufferedReader br = new BufferedReader(new FileReader("B-large.in"));
        PrintWriter pw = new PrintWriter(new File("B-large.out"));
        int T = Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++){
        	String[] l = br.readLine().split(" ");
        	int B = Integer.parseInt(l[0]);
        	long M = Long.parseLong(l[1]);
        	BigInteger x = BigInteger.valueOf(2);
        	if(BigInteger.valueOf(M).compareTo(x.pow(B-2))>0){
        		pw.println("Case #"+i+": IMPOSSIBLE");
        		continue;
        	}
        	pw.println("Case #"+i+": POSSIBLE");
        	if(BigInteger.valueOf(M).compareTo(x.pow(B-2))==0){
        		String s = Long.toString(M-1, 2);
        		int le = s.length();
        		for(int b=0;b<B-le-2;b++)
        			s = "0"+s;
        		pw.println("0"+(M==1?"":s)+"1");
        	}
        	else{
        		String s = Long.toString(M, 2);
        		int le = s.length();
        		for(int b=0;b<B-le-2;b++)
        			s = "0"+s;
        		pw.println("0"+s+"0");
        	}
        	for(int j=1;j<B;j++){
        		String s = "";
        		for(int z=0;z<j+1;z++)
        			s+="0";
        		for(int o=B-2-j;o>=0;o--)
        			s+="1";
        		pw.println(s);
        	}
        }
        pw.close();
        br.close();
	}
}
