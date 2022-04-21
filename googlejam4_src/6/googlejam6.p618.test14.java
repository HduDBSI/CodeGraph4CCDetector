package googlejam6.p618;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class test14 {
	public static void main(String[] arg) throws Exception{
		FileInputStream fis=new FileInputStream("B-large.in");  
        System.setIn(fis); 
        PrintStream ps=new PrintStream(new FileOutputStream("Output2"));  
        System.setOut(ps);
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();		
		for(int i=0;i<N;i++){
			int numsize = sc.nextInt();
			int[] nums = new int[(2*numsize-1)*numsize];
			for(int j=0;j<nums.length;j++){
				nums[j]=sc.nextInt();
			}
			System.out.print("Case #"+(i+1)+": ");
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			for(int i1 = 0; i1 < nums.length; i1++){
			    if(!map.containsKey(nums[i1])){
			        map.put(nums[i1],1);
			    }else{
			        map.put(nums[i1],map.get(nums[i1])+1);
			    }
			}
			Iterator it= map.keySet().iterator();
			int sizeone = 0;
			while(it.hasNext())
			{
				int key = (int)it.next();
			    if(map.get(key)%2==1){sizeone+=1;}
			}
			int[] res1=new int[sizeone];
			int k=0;
			Iterator it2= map.keySet().iterator();
			while(it2.hasNext())
			{
			    int key2 = (int)it2.next();
			    if(map.get(key2)%2==1){
			        res1[k]=key2;
			        ++k;
			    }
			}
			int[] res=res1;
			Arrays.sort(res);
			for(int j=0;j<res.length;j++){
				System.out.print(res[j]+" ");
			}
			System.out.println();
		}
	}

}
