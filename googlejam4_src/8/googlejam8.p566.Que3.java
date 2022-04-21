package googlejam8.p566;

import java.util.*;
 class Que3 {
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			int [] store = new int [n];
			int sum=0;
			for(int j=0;j<n;j++){
				store[j]=s.nextInt();
				sum=sum+store[j];
			}
			System.out.print("Case #");
			System.out.print(i+1);
			System.out.print(": ");
			while(sum>3){
				int max1=0;
				int max2=0;
				int index=-1;
				int index2=-1;
				for(int j=0;j<n;j++){
					if(store[j]>max1){
						max1=store[j];
						index=j;
					}
				}
				for(int j=0;j<n;j++){
					if(store[j]>max2 && index!=j){
						max2=store[j];
						index2=j;
					}
				}
				store[index]=store[index]-1;
				store[index2]=store[index2]-1;
				int dummy1=65+index;
				int dummy2=65+index2;
				System.out.print((char)(dummy1));
				System.out.print((char)(dummy2));
				System.out.print(" ");
				sum=sum-2;
			}
			if(sum==2){
				int max1=0;
				int max2=0;
				int index=-1;
				int index2=-1;
				for(int j=0;j<n;j++){
					if(store[j]>max1){
						max1=store[j];
						index=j;
					}
				}
				for(int j=0;j<n;j++){
					if(store[j]>max2 && index!=j){
						max2=store[j];
						index2=j;
					}
				}
				store[index]=store[index]-1;
				store[index2]=store[index2]-1;
				int dummy1=65+index;
				int dummy2=65+index2;
				System.out.print((char)(dummy1));
				System.out.print((char)(dummy2));
				System.out.print(" ");
			
			}
			else{
				int max1=0;
				int max2=0;
				int index=-1;
				int index2=-1;
				for(int j=0;j<n;j++){
					if(store[j]>max1){
						max1=store[j];
						index=j;
					}
				}
				store[index]=store[index]-1;
				int dummy1=65+index;
				System.out.print((char)(dummy1));
				
				System.out.print(" ");
				 max1=0;
				 max2=0;
				 index=-1;
				 index2=-1;
				for(int j=0;j<n;j++){
					if(store[j]>max1){
						max1=store[j];
						index=j;
					}
				}
				for(int j=0;j<n;j++){
					if(store[j]>max2 && index!=j){
						max2=store[j];
						index2=j;
					}
				}
				store[index]=store[index]-1;
				store[index2]=store[index2]-1;
				 dummy1=65+index;
				int dummy2=65+index2;
				System.out.print((char)(dummy1));
				System.out.print((char)(dummy2));
				
			}
			System.out.println();
		}
	}
}
