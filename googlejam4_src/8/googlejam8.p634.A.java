package googlejam8.p634;
import java.util.*;
import java.io.*;
public class A{
	public static void main(String args[])throws IOException{
		
		//Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("input.in"));
		PrintWriter pw=new PrintWriter(new FileWriter(new File("output.out")));
		//PrintWriter pw=new PrintWriter(System.out);
		int T=in.nextInt();
		for(int t=1;t<=T;t++){				
				int n,arr[];
				n=in.nextInt();
				arr=new int[n];
				for(int i=0;i<n;i++)
					arr[i]=in.nextInt();
				pw.print("Case #"+t+": ");
				int cnt=n;
				while(cnt!=0){
					/*if(checkCase(arr)){
						System.out.println("Case"+t);
						System.out.println(Arrays.toString(arr));
					}*/
					
					int max=-1,pos=-1;
					if(cnt==2){
						int tmp=0,tarr[]=new int[2],same=0;
						for(int i=0;i<n;i++)
							if(arr[i]>0){
								tarr[tmp]=i;
								tmp++;
							}
							
						if(arr[tarr[0]]==arr[tarr[1]]){
							pw.print((char)((int)'A'+tarr[0])+""+(char)((int)'A'+tarr[1])+" ");
							arr[tarr[0]]--;
							arr[tarr[1]]--;
							if(arr[tarr[0]]==0){
								cnt-=2;
							}
							continue;
						}
						
					}
					for(int i=0;i<n;i++){
						if(arr[i]>=max){
							max=arr[i];
							pos=i;
						}
					}
					pw.print((char)((int)'A'+pos)+" ");
					if(max==1){
						cnt--;
					}
					arr[pos]--;
				}
				pw.println();
				//System.out.println("Case #"+t+": "+res);
				
		}
		System.out.println("DONE");
		pw.close();
		
	}
}