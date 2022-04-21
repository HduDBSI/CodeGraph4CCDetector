package googlejam1.p071;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class R1A_A {
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
				int N=Integer.parseInt(s);
				s=fr.readLine();
				String[] tok=s.split(" ");
				int mx=0;
				int tdif=0;
				int[] vs=new int[N]; 
				for (int j = 0; j < N; j++) {
					vs[j]=Integer.parseInt(tok[j]);
					if (j>0){
						mx=Math.max(mx, vs[j-1]-vs[j]);
						tdif+=Math.max(0, vs[j-1]-vs[j]);
					}
				}
				int me=0;
				for (int j = 0; j < N-1; j++)
					me+=Math.min(mx, vs[j]);
				s=tdif+" "+me;
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