package googlejam10.p189;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class A {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("A-small-attempt0.in"));
        PrintWriter pw = new PrintWriter(new File("A-small.out"));
//        BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
//        PrintWriter pw = new PrintWriter(new File("A-large.out"));
        int T = Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++){
        	String[] l = br.readLine().split(" ");
        	int n = Integer.parseInt(l[0]);
        	int r = Integer.parseInt(l[1]);
        	int p = Integer.parseInt(l[2]);
        	int s = Integer.parseInt(l[3]);
        	int max = Math.max(p,Math.max(r,s));
        	if(n==1){
        		if(max>1){
	        		pw.println("Case #"+i+": IMPOSSIBLE");
	        		continue;
        		}
        		if(p==1&&r==1){
        			pw.println("Case #"+i+": PR");
        			continue;
        		}
        		if(p==1&&s==1){
        			pw.println("Case #"+i+": PS");
        			continue;
        		}
        		if(s==1&&r==1){
        			pw.println("Case #"+i+": RS");
        			continue;
        		}
        	}
        	if(n==2){
        		if(max>=3||p*r*s==0){
	        		pw.println("Case #"+i+": IMPOSSIBLE");
	        		continue;
        		}
        		if(p==1&&r==1){
        			pw.println("Case #"+i+": PSRS");
        			continue;
        		}
        		if(p==1&&s==1){
        			pw.println("Case #"+i+": PRRS");
        			continue;
        		}
        		if(s==1&&r==1){
        			pw.println("Case #"+i+": PRPS");
        			continue;
        		}
        	}
        	if(n==3){
        		if(max>=4||p*r*s==0){
	        		pw.println("Case #"+i+": IMPOSSIBLE");
	        		continue;
        		}
        		if(p==3&&r==3){
        			pw.println("Case #"+i+": PRPSPRRS");
        			continue;
        		}
        		if(p==3&&s==3){
        			pw.println("Case #"+i+": PRPSPSRS");
        			continue;
        		}
        		if(s==3&&r==3){
        			pw.println("Case #"+i+": PRRSPSRS");
        			continue;
        		}
        	}
        }
        pw.close();
        br.close();
	}
}
