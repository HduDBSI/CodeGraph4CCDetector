package googlejam8.p674;
//package codejamround1c;

import java.io.File;
import java.util.Scanner;

public class senateevac {
	public static void main(String args[]){
		try{
			Scanner fr=new Scanner(new File("A-large.in"));
			int inp=fr.nextInt();	
			for(int i=0;i<inp;i++){
				int n=fr.nextInt();
				int arr[]=new int[n];
				for(int j=0;j<n;j++){
					arr[j]=fr.nextInt();
				}
				System.out.print("Case #"+(i+1)+": ");
						func(arr);
			}
			}catch(Exception e){
				
			}
	}
	public static void func(int arr[]){
		while(true){
			int max=arr[0];
			int equaltomax=1;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
				equaltomax=1;
			}
			else if(arr[i]==max){
				equaltomax++;
			}
		}
		if(max==0){
			System.out.println();
			return;
		}
		int nikcount=0;
		//System.out.print("max = "+max);
		if(equaltomax%2==0){
			
			for(int i=0;i<arr.length;i++){
				if(arr[i]==max){
					System.out.print(Character.toString ((char) (i+65)));
					arr[i]--;
					nikcount++;
					if(nikcount==2){
						i=arr.length;
					}
				}
			}
		}
		else if (equaltomax%2!=0){
			for(int i=0;i<arr.length;i++){
				if(arr[i]==max){
					System.out.print(Character.toString ((char) (i+65)));
					arr[i]--;
					nikcount++;
					if(nikcount==1){
						i=arr.length;
					}
				}
			}
		}
		System.out.print(" ");
		}
		
	}
}
