package googlejam4.p140;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class P1 {

	Scanner scio=new Scanner(System.in);
	int caseNum=0;
	int[][] dir = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
		
	public static void main(String[] args) {
		P1 r = new P1();
		try {
			File file=new File("A-large.in");
			r.scio=new Scanner(file); 
		} catch (FileNotFoundException e) {}
		
		int t=r.scio.nextInt();
		String s=r.scio.nextLine();
		
		for(int i=0;i<t;++i) {
			r.caseNum=i+1;
			int n=r.scio.nextInt();
			//String sss=this.scio.nextLine();
			int m=r.scio.nextInt();
			String ss=r.scio.nextLine();
			
			
			int[][] a=new int[n+10][m+10];
			for(int i1=0;i1<n+10;++i1)
				for (int j=0;j<m+10;++j) a[i1][j]=-1;
			
			for(int i3=1;i3<=n;++i3) {
				String s1=r.scio.nextLine();
				char[] c=s1.toCharArray();
				for (int j=1;j<=m;++j) {
					if (c[j-1]=='.') a[i3][j] = 0;
					if (c[j-1]=='^') a[i3][j] = 1;
					if (c[j-1]=='v') a[i3][j] = 2;
					if (c[j-1]=='<') a[i3][j] = 3;
					if (c[j-1]=='>') a[i3][j] = 4;
				}
			}
			
			
			int cnt=0;
			for (int i2=1; i2<=n;++i2) {
				for (int j=1; j<=m; ++j) {
					if (a[i2][j]==0) continue;
					int[] good = new int[5]; 
					for (int t1=0;t1<5;++t1) good[t1]=0;
					for(int t2=1;t2<=4;++t2) {
						int x=i2; int y=j;
						while(a[x][y]!=-1) {
							x+=r.dir[t2][0];
							y+=r.dir[t2][1];
							if (a[x][y]>0) {
								good[t2]=1; ++good[0];
								break;
							}
						}
					}
					if (good[0]==0) cnt=-1 * n * m * 2;
					if (good[a[i2][j]] ==0) ++cnt;
				}
			}
			if (cnt<0) {
				System.out.println("case #"+r.caseNum+": " + "IMPOSSIBLE");			
			} else {
				System.out.println("case #"+r.caseNum+": " + cnt);
			}
		}
	}

}
