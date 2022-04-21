package googlejam1.p203;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class MushroomMonster {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int cn=1;cn<=T;cn++){
			int N=Integer.parseInt(br.readLine());
			int m[]=new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				m[i]=Integer.parseInt(st.nextToken());
			}
			int ans1=0, maxd=0;
			for(int i=1;i<N;i++){
				int diff=Math.max(0,m[i-1]-m[i]);
				ans1+=diff;
				maxd=Math.max(maxd, diff);
			}
			int ans2=0;
			for(int i=0;i<N-1;i++){
				int diff=Math.min(m[i],maxd);
				ans2+=diff;
			}

			bw.append("Case #"+cn+": "+ans1+" "+ans2+"\n");
		}
		bw.flush();
	}

}
