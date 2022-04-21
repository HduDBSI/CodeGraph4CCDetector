package googlejam4.p080;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class R2A {
public static void main(String[] args) {
		String prblm="A"; boolean fl=true;
		String filein=prblm+"-"+((fl)?"large":"small")+".in.txt";
		String fileout=prblm+"-"+((fl)?"large":"small")+".out.txt";
		try {
			BufferedReader fr= new BufferedReader(new FileReader(filein));
			BufferedWriter fw= new BufferedWriter(new FileWriter(fileout));
			String s=fr.readLine();
			int T=Integer.parseInt(s);
			for (int i = 1; i <= T; i++) {
				s=fr.readLine();
				String[] tok=s.split(" ");
				int R=Integer.parseInt(tok[0]);
				int C=Integer.parseInt(tok[1]);
				int[][] mt=new int[R][C];
				for (int j = 0; j < R; j++) {
					s=fr.readLine();
					for (int h = 0; h < C; h++) {
						switch (s.charAt(h)){
						case '^': mt[j][h]=1; break;
						case '<': mt[j][h]=2; break;
						case 'v': mt[j][h]=3; break;
						case '>': mt[j][h]=4; break;
						}
					}
				}
				int nch=0;
				int[][] mtd=new int[R][C];
				for (int h = 0; h < C; h++) {
					int k=0;
					while (k<R && mt[k][h]==0) k++;
					if (k<R) { mtd[k][h]++;
						if (mt[k][h]==1) nch++;
					}
					k=R-1;
					while (k>=0 && mt[k][h]==0) k--;
					if (k>=0) { mtd[k][h]++;
						if (mt[k][h]==3) nch++;
					}					
				}
				for (int j = 0; j < R; j++) {
					int k=0;
					while (k<C && mt[j][k]==0) k++;
					if (k<C) { mtd[j][k]++;
						if (mt[j][k]==2) nch++;
					}
					k=C-1;
					while (k>=0 && mt[j][k]==0) k--;
					if (k>=0) { mtd[j][k]++;
						if (mt[j][k]==4) nch++;
					}
				}
				boolean f=false;
				for (int j = 0; j < R && !f; j++) {
					for (int h = 0; h < C && !f; h++) {
						if (mtd[j][h]==4) f=true;
					}
				}
				if (f) s="IMPOSSIBLE";
				else s=""+nch;
				System.out.println(s);
				fw.write("Case #"+i+": "+ s  +"\n");
			}
			fr.close();
			fw.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
}