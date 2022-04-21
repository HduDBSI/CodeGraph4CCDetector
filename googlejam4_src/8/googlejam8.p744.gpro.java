package googlejam8.p744;
import java.util.*;

class gpro{
	public static void main(String arg[]){
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		for(int j=1;j<=t;j++){
			int p=in.nextInt();
			int arr[]=new int[p];
			int count=0;
			int max1=0;
			int max2=0;
			int loc1=-1;
			int loc2=-1;
			for(int i=0;i<p;i++){
				arr[i]=in.nextInt();
				count+=arr[i];
			}
			System.out.print("Case #"+j+":");
			while(count>0){
				max1=0;
				max2=0;
				loc1=-1;
				loc2=-1;
				for(int i=0;i<p;i++){
					if(arr[i]>max1){
						max2=max1;
						loc2=loc1;
						max1=arr[i];	
						loc1=i;
					}
					else if(arr[i]>max2){
						max2=arr[i];
						loc2=i;
					}			
				}
				if((max2<(count-2)/2 && count!=1 && count!=3 )|| ((max2==(count-2)/2 || max2==max1) && count!=1 && count!=3)){
					System.out.printf(" %c%c",(loc1+65),(loc2+65));
					count-=2;
					arr[loc1]-=1;
					arr[loc2]-=1;
				}
				else if((count!=1)&& count!=3){
					System.out.printf(" %c%c",(loc1+65),(loc1+65));
					count-=2;
					arr[loc1]-=2;
				}
				else{
					System.out.printf(" %c",(loc1+65));
					arr[loc1]-=1;
					count-=1;
				}
			}
			System.out.println();
		}
	}
}