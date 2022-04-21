package googlejam8.p879;
import java.util.*;
import java.lang.*;
import java.io.*;

class codejam3
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int testcases; int hash;
		testcases = in.nextInt(); hash = testcases+1;
		while(testcases>0){
			int n;
			n = in.nextInt();
			int arr[] = new int[n];
			String result="";
			for(int i=0;i<n;i++){
				arr[i] = in.nextInt();
			}
			while(arr[0]!=0){
				int m1=-1; int m2=-1; int t1=0; int t2=0;
				for(int i=0;i<n;i++){
					if(arr[i]>m1){
						m1 = arr[i];
						t1 = i;
					}
				}
				for(int i=0;i<t1;i++){
					if(arr[i]==m1){
						m2 = m1;
						t2 = i;
					}
				}
				if(m1==3){
					int temp1 = arr[t1]-(m1/2);
					arr[t1] = (m1/2);
					while(temp1!=0){
						if(t1==0){
							result = result + "A";
						}
						else if(t1==1)
							result = result+ "B";
						else 
							result = result+ "C";
						temp1--;
					}
					result = result+" ";
				}
				else{
					if(m1!=-1 && m2!=-1){
					int temp1 = arr[t1]-(m1/2);
					arr[t1] = (m1/2);
					int temp2 = arr[t2]-(m2/2);
					arr[t2] = (m2/2);
						while(temp1!=0){
							if(t1==0){
								result = result + "A";
							}
							else if(t1==1)
								result = result+ "B";
							else 
								result = result+ "C";
							temp1--;
						}
						while(temp2!=0){
							if(t2==0){
								result = result + "A";
							}
							else if(t2==1)
								result = result+ "B";
							else 
								result = result+ "C";
							temp1--;
						}
						result = result+" ";
					}
					else{
						int temp1 = arr[t1]-(m1/2);
						arr[t1] = (m1/2);
						while(temp1!=0){
							if(t1==0){
								result = result + "A";
							}
							else if(t1==1)
								result = result+ "B";
							else 
								result = result+ "C";
							temp1--;
						}
						result = result+" ";
					}
				}
			}
			System.out.println("Case #"+(hash-testcases)+":  "+ result);
			testcases--;
		}
	}
}
