package googlejam8.p370;
// @author:debverine | 08-May-2016 | 2:39:01 pm
import java.io.*;
import java.util.*;

class R1C_A {

	
	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		BufferedReader br=new BufferedReader(new FileReader("A-large.in"));
		PrintWriter pw=new PrintWriter(new FileWriter("A-large.out"));
		
		int t,total,tc,n,i,arr[],M,c,twice;
		String inp[],character="";
		t = Integer.parseInt(br.readLine().trim());
		for(tc=1;tc<=t;tc++){
			total=0;
			character="";
			n=Integer.parseInt(br.readLine().trim());
			arr=new int[n];
			inp=br.readLine().trim().split(" ");
			for(i=0;i<n;i++){
				arr[i]=Integer.parseInt(inp[i]);
				total+=arr[i];
			}
			while(total>0){
				character+=" ";
				int M1,i1;
				for(M1=0,i1=1;i1<arr.length;i1++)
					if(arr[M1]<arr[i1])
						M1=i1;
				M=arr[M1];
				int i2,c1;
				for(i2=c1=0;i2<arr.length;i2++)
					if(arr[i2]==M)
						c1++;
				c=c1;
				if(c==2){//end case 
					//remove 2 at a time
					twice=2;
					for(i=0;i<n && twice >0 ;i++){
						if(arr[i]==M && twice>0){
							character+=(char)(65+i) +"";
							arr[i]--;
							total--;
						}
					}					
				}
				else{
					for(i=0;i<n;i++){
						if(arr[i]==M){
							character+=(char)(65+i) +"";
							arr[i]--;
							total--;
							break;
						}
					}
						
				}
			}
			
			
			
			
			
			pw.println("Case #"+tc+":"+character);
		}
		pw.flush();
		pw.close();

	}

}
