package googlejam3.p464;
import java.io.*;
class hit{
	public static void main(String arg[]) throws IOException{
		BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(obj.readLine());
		int t1=t;
		while(t>0){
			String s[]=obj.readLine().split(" ");
			int r=Integer.parseInt(s[0]);
			int c=Integer.parseInt(s[1]);
			int w=Integer.parseInt(s[2]);
			int ans=0;
			if(c%w==0){
				ans=c/w -1 + w;
			}
			else{
				ans=c/w + w;
			}
			System.out.println("Case #"+ (t1-t+1) + ": " + ans);
			t--;
		}
	}
}