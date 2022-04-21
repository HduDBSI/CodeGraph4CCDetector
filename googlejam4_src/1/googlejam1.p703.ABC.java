package googlejam1.p703;
import java.util.*;
import java.io.*;
public class ABC{
	public static void main(String args[]) throws Exception{
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		int inc=1;
		while(t-->0){
			int n=Integer.parseInt(bf.readLine());
			String str=bf.readLine();
			String s[]=str.split("\\s+");
			long com1=0,com2=0;
			for(int i=1;i<s.length;i++){
				int p=Integer.parseInt(s[i-1])-Integer.parseInt(s[i]);
				if(p>0){
					com1=com1+p;
				}
				if(i==(s.length-1)){
					if(p>0)
						com2=com2+p;
				}else{
					com2=com2+Integer.parseInt(s[i-1]);
				}
			}
			
			System.out.println("Case #"+inc+": "+com1+" "+com2);
			inc++;
		}
	}

}