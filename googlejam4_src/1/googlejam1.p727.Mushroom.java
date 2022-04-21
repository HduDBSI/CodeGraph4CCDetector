package googlejam1.p727;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Mushroom {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:/Users/puneet/Desktop/test.txt");
		Scanner in = new Scanner(file);
		int total = in.nextInt();
		
		for(int i=1;i<=total;i++){
			int mCount = in.nextInt();
			int arr[] = new int[mCount];
			
			for(int j=0;j<mCount;j++){
				arr[j] = in.nextInt();
			}
			
			int min1 = 0;
			int min2 = 0;
			
			int curr = 0;
			int maxDiff = 0;
			for(int a=1;a<mCount;a++){
				if(arr[a]<arr[a-1]){
					min1+=(arr[a-1]-arr[a]);
				}
				
				if((arr[a-1]-arr[a])>maxDiff)
					maxDiff = arr[a-1]-arr[a];
				
			}
			
			for(int b=0;b<(mCount-1);b++){
				
				if(arr[b]>maxDiff)
					min2=min2+maxDiff;
				else
					min2=min2+arr[b];
			}
			//System.out.println(maxDiff);
			System.out.println("Case #"+i+": "+ min1+" "+min2);

	}
	}
}
