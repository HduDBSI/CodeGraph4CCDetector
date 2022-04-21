package googlejam1.p763;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class Mushroom {
	public static void main(String args[]){
		try{
			System.setIn(new FileInputStream("C:\\Users\\Kumar BN\\Desktop\\A-large.in"));
			System.setOut(new PrintStream("C:\\Users\\Kumar BN\\Desktop\\outputmushrromlarge.txt"));
		}
		catch(Exception e)
		{
			System.out.print("asdasd");
		}
		int t;
		Scanner in=new Scanner(System.in);
		t=in.nextInt();
		for(int i=0;i<t;i++){
			int n,max=0;
			n=in.nextInt();
			int a[]=new int[n];
			for(int j=0;j<n;j++){
				a[j]=in.nextInt();
				if(max<a[j])
					max=a[j];
			}
			int sum=0;
			for(int j=0;j<n-1;j++){
				if(a[j]>a[j+1]){
					sum=sum+(a[j]-a[j+1]);
				}
			}
			int minimum=0;int sum1=0,mushrooms=0,runningsum=0;
			/*for(int k=1;k<max;k++){
				for(int j=0;j<n;j++){
					mushrooms=0;
					for(int clock=0;clock<10;clock++){
						mushrooms=mushrooms+1*k;
					}
					if(mushrooms<=a[j])
						runningsum=runningsum+mushrooms;
					else{
						if(minimum>runningsum)
							minimum=runningsum;
					}	
				}
				runningsum=0;
			}*/
			int maxdifference=0;int difference;
			for(int k=0;k<n-1;k++){
				if(a[k]>a[k+1]){
				difference=a[k]-a[k+1];
				//System.out.println("Difference="+difference);
				if(Math.abs(difference)>maxdifference)
					maxdifference=difference;
				}
			}
			//System.out.println("Max difference="+maxdifference);
			/*if(maxdifference<0){
				int rate=-(maxdifference);
				for(int k=0;k<n;k++){
					if((rate)>=a[k])
						runningsum=runningsum+a[k];
					else{
						runningsum=runningsum+rate;
						break;
				}
				minimum=runningsum;
				runningsum=0;
			}
			}*/
			//else{
				int rate=Math.abs(maxdifference);
				//System.out.println("The rate is"+rate);
				for(int k=0;k<n-1;k++){
					if((rate)>=a[k])
						runningsum=runningsum+a[k];
					else{
						runningsum=runningsum+(rate);
						//break;
				}
			}
			minimum=runningsum;
			runningsum=0;
		//}
		System.out.println("Case #"+(i+1)+": "+sum+" "+minimum);
	}
}
}
