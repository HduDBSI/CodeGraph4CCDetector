package googlejam8.p431;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		for(int z=1; z<=t; z++){
			System.out.print("Case #"+z+": ");
			int N=sc.nextInt();
			int count[]=new int[N];
			int people=0;
			for(int i=0; i<N; i++){
				count[i]=sc.nextInt();
				people+=count[i];
			}
			boolean flag=false;
			while(!flag){
				flag=true;
				String maxpeople="";
				int max=0;
				for(int i=0; i<N; i++){ 
					if(count[i]==0){
						//nothing to do here
					}
					else{
						flag=false;
						if(count[i]>max){
							max=count[i];
							maxpeople=i+",";
						}
						else if(count[i]==max){
							maxpeople=maxpeople+i+",";
						}
					}
				}
				if(!flag){
					//print here
					String[] maxindexes=maxpeople.split(",");
					//if there is one max term, remove it.
					// if two maxterms, remove them
					//if 3, remove 1
					//if four remove 2
					int r=maxindexes.length%2==0?2:1;
					//System.out.println(maxpeople+" "+max);
					for(int i=0; i<r; i++){
						int index=Integer.parseInt(maxindexes[i]);
						System.out.print((char)(index+'A'));
						count[index]=count[index]-1;
					}
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}
