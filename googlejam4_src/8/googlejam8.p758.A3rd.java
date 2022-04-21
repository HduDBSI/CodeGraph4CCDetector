package googlejam8.p758;

import java.util.Arrays;
import java.util.Scanner;

public class A3rd {
static String chr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++){
			String per="";
		
		int n = sc.nextInt();
		int [] p = new int[n];
		for(int k = 0;k<n;k++){
			p[k]= sc.nextInt();
		}
		//Arrays.sort(p);
		boolean ok = false;
		int last=0;
		do{
			
		
		int max =0;
		ok = false;
		for(int k = 0;k<n;k++){
			if(0<p[k])
				ok = true;
		}
		if(ok){
			for(int k = 0;k<n;k++){
				if(p[max]<p[k])
					{
					max = k;
					last=0;
					}
			
			}
			per  = per + chr.charAt(max);
			p[max]--;	
		}
		ok = false;
		for(int k = 0;k<n;k++){
			if(0<p[k])
				ok = true;
		}
		max =0;
		if(ok){
			for(int k = 0;k<n;k++){
				if(p[max]<p[k])
					{
					max = k;
					last = 1;
					}
			}
			per  = per + chr.charAt(max)+" ";
			p[max]--;	
		}
		
		
		}while(ok);
		//System.out.println("Casejjk #"+i+": "+per.charAt(per.length()-2));
		
		if(last==0)
		{
			
			//System.out.println("Case #"+i+": "+per);
			
			//System.out.println("Case #"+i+": "+per);
			String s = per.substring(0, per.length()-4);
			//System.out.println("Case #"+i+": "+s);
			String u = per.substring(per.length()-4);
			//System.out.println("Case #"+i+": "+u);
			StringBuilder ss = new StringBuilder(u);
			u = ss.reverse().toString();
			//System.out.println("Case #"+i+": "+u);
			per=s+u;
			//System.out.println("Case #"+i+": "+per);
		//	s= per.substring(0,per.length()-2)+" "+per.substring(per.length()-2);
		//s=per;
		}
	per=	per.trim();
		System.out.println("Case #"+i+": "+per);
		}

	}

}
