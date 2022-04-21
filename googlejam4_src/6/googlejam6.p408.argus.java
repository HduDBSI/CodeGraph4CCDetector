package googlejam6.p408;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;


public class argus {
	
	public static void main(String args[]){
		File input=new File("F:\\CodeJam\\argusIn.txt");
		File output=new File("F:\\CodeJam\\argusOut.txt");
		BufferedWriter out=null;
		Scanner s1;
		try {
			s1 = new Scanner(input);
			String x=s1.nextLine();
			long t=Long.parseLong(x);
			try{
				out=new BufferedWriter(new FileWriter(output));
				for(int i=0;i<t;i++){
					out.write("Case #"+(i+1)+": ");
					//out.newLine();
					int n=s1.nextInt();
					HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
					for(int j=0;j<((2*n)-1)*n;j++){
						int temp=s1.nextInt();
						//System.out.println(temp);
						if(a.containsKey(temp)){
							a.put(temp, (a.get(temp))+1);
						}
						else{
							a.put(temp, 1);
						}
						
					}
					int arr[]=new int[n];
					int ct=0;
					for(int p:a.keySet()){
						if(a.get(p)%2==1){
							System.out.println(p);
							arr[ct]=p;
							ct++;
						}
					}
					Arrays.sort(arr);
					for(int k=0;k<n;k++){
						out.write(arr[k]+" ");
					}
					out.newLine();
				}
					
				out.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
}
