package googlejam4.p096;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Pegman {

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
			st=new StringTokenizer(br.readLine());
			int R=Integer.parseInt(st.nextToken());
			int C=Integer.parseInt(st.nextToken());
			char arr[][]=new char[R][C];
			for(int i=0;i<R;i++){
				String str=br.readLine();
				for(int j=0;j<C;j++){
					arr[i][j]=str.charAt(j);
				}
			}
			//count how many point out
			LinkedList<Integer> list=new LinkedList<Integer>();
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++){
					int dx=0, dy=0;
					if(arr[i][j]=='.')
						continue;
					else if(arr[i][j]=='^'){
						dx=-1;dy=0;
					}
					else if(arr[i][j]=='v'){
						dx=1;dy=0;
					}
					else if(arr[i][j]=='<'){
						dx=0;dy=-1;
					}
					else if(arr[i][j]=='>'){
						dx=0;dy=1;
					}
					int cx=i+dx, cy=j+dy;
					while(cx>=0&&cx<R&&cy>=0&&cy<C){
						if(arr[cx][cy]!='.')
							break;
						cx+=dx;
						cy+=dy;
					}
					if(cx<0||cx>=R||cy<0||cy>=C){
						list.add(i*100+j);
					}
				}
			}
			//find if can change direction
			boolean okay=true;
			for(int li:list){
				int i=li/100, j=li%100;
				int dx[]={-1,1,0,0};
				int dy[]={0,0,-1,1};
				boolean found=false;
				for(int dn=0;dn<4;dn++){
					int cx=i+dx[dn], cy=j+dy[dn];
					while(cx>=0&&cx<R&&cy>=0&&cy<C){
						if(arr[cx][cy]!='.'){
							found=true;
							break;
						}
						cx+=dx[dn];
						cy+=dy[dn];
					}
				}
				if(!found)
					okay=false;
			}
			
			int ans=list.size();
			if(okay)
				bw.append("Case #"+cn+": "+ans+"\n");
			else
				bw.append("Case #"+cn+": IMPOSSIBLE\n");
		}
		bw.flush();
	}

}
