package googlejam6.p609;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=1;i<=T;i++){
			int N=sc.nextInt();
			Hashtable<Integer,Integer> numbers=new Hashtable<Integer,Integer>();
			for(int iter=0;iter<(2*N*N-N);iter++){
				int input=sc.nextInt();
				int count=0;
				if(numbers.containsKey(input)){
					count=numbers.get(input);
				}
				numbers.put(input, count+1);
			}
			int[] finalList=new int[N];
			int index=0;
			 Set<Integer> keys = numbers.keySet();
		        for(Integer key: keys){
		            int counter=numbers.get(key);
		            if(counter%2!=0){
		            	finalList[index++]=key;
		            }
		        }
		        Arrays.sort(finalList);
		        String output=("Case #"+i+":");
		        
		        for(int k:finalList){
		        	output+=(" "+k);	
		        }
		        System.out.println(output);
		}
		//Large();
		
		
		
		
	}

}
