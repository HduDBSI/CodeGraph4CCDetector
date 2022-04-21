package googlejam6.p326;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BRank_File {
	static Scanner reader;
	static PrintWriter outWrite;
	static int n,res[],m,a[][];
	static int c[]=new int[3000];
	public static void main(String[] args) throws Exception {
		reader=new Scanner(new File("B-large.in"));
		outWrite=new PrintWriter(new File("B-output.txt"));
		int nTest=reader.nextInt();
		int i,j;
		for (int test=1;test<=nTest;test++){
			n=reader.nextInt();
			m=(2*n)-1;
			a=new int[m][n];
			for (i=0;i<m;i++){
				for (j=0;j<n;j++) 
					a[i][j]=reader.nextInt();
			}
			if (test>1) outWrite.println();
			int i1,j1;
			Arrays.fill(c, 0);
			res=new int[n];
			for (i1=0;i1<m;i1++)for (j1=0;j1<n;j1++)
				c[a[i1][j1]]++;
			j1=0;
			for (i1=0;i1<c.length;i1++){
				if ((c[i1]%2)==1){
					res[j1]=i1; j1++;
				}
			}
			outWrite.print("Case #" + test+": ");
			for (j=0;j<res.length;j++){
				if (j>0) outWrite.print(" ");
				outWrite.print(res[j]);
			}
		}
		outWrite.close();

	}

}
