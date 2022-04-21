package googlejam1.p350;
import java.io.*;
public class A1_A {

	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(in.readLine());
		for(int i=1;i<=tc;++i){
			int size=Integer.parseInt(in.readLine());
			String[] ar=in.readLine().split(" ");
			int[] arr=new int[size];
			for(int j=0;j<size;++j){
				arr[j]=Integer.parseInt(ar[j]);
			}
			int met1=0,maxdiff=0,temp=0,met2=0;
			for(int j=1;j<size;++j){
				temp=arr[j-1]-arr[j];
				if(temp>maxdiff)
					maxdiff=temp;
				if(temp>0)
					met1+=temp;
			}
			for(int j=0;j<size-1;++j){
				met2+=Math.min(arr[j], maxdiff);
			}			System.out.println(met1+" "+met2);
		}
		in.close();
	}

}
