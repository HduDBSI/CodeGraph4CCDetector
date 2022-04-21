package googlejam6.p226;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class Main {
	
	public static void main(String[] args) throws Exception {
		PrintWriter pr = new PrintWriter(System.out, true);

	//	FileInputStream fin=new FileInputStream("C:/Users/4dm1n/Desktop/B-large(1).in");
	//	File myfile=new File("C:/Users/4dm1n/Desktop/A.out");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	//	RandomAccessFile rand=new RandomAccessFile(myfile,"rw");
		
		int t,n,m,j,l,i,c,r,tt,ht[];
		long nm;
		char ch[];
		String s[];
		StringBuilder sb;
		t=Integer.parseInt(br.readLine());
		for(tt=1;tt<=t;tt++){
			sb=new StringBuilder("Case #"+tt+": ");ht=new int[2600];
			n=Integer.parseInt(br.readLine());
			m=2*n-1;
			for(i=0;i<m;i++){
				s=br.readLine().split(" ");
				for(j=0;j<n;j++){
					ht[Integer.parseInt(s[j])]++;
				}
			}
			for(i=0;i<2502;i++){
				if((ht[i]&1)>0) sb.append(i+" ");
			}
			sb.append("\n");
		//	rand.writeBytes(sb.toString());
			System.out.print(sb);
		}
	}
}