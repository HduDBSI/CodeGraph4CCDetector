package googlejam3.p379;



import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;
import java.util.Arrays.*;

public class Happy {

    public static void main(String[] args) {
        Happy r = new Happy();
		BufferedReader in = null;
		BufferedWriter out = null;
		
		try{
		    in = new BufferedReader(new FileReader("A-large.in"));
		    out = new BufferedWriter(new FileWriter("A-large.out"));
		    //in = new BufferedReader(new FileReader("test.in"));
		    //out = new BufferedWriter(new FileWriter("test.out"));
		    int T = Integer.parseInt(in.readLine());
		    System.out.println("T="+T);
		    for(int i=0;i<T;i++){
		        System.out.print("Case #"+(i+1)+": ");
		        out.write("Case #"+(i+1)+": ");
		
		
		
		        String[] line = in.readLine().split(" ");
		        int R = Integer.parseInt(line[0]);
		        int C = Integer.parseInt(line[1]);
		        int W = Integer.parseInt(line[2]);
		        int ans = 0;
		
		        if(W==1){
		            ans = C * R;
		        } else if(W==2){
		            ans = ans + (C/W)*R;
		            if(C%W==0){
		                ans = ans + 1;
		            } else {
		                ans = ans + 2;
		            }
		        } else {
		            ans = ans + (C/W)*R;
		            int ret = C%W;
		            if(ret==0){
		                ans = ans + W - 1;
		            } else{
		                ans = ans + W - 1 + 1;
		            }
		        }
		
		        
		
		
		        System.out.print(ans+"\n");
		        out.write(ans+"\n");
		
		
		    }
		
		    in.close();
		    out.close();
		}catch(Exception e){
		    e.printStackTrace();
		    try{
		        in.close();
		        out.close();
		    }catch(Exception ee){
		        ee.printStackTrace();
		    }
		}
		System.out.print("Ha Ha :D\n");
    }

}

