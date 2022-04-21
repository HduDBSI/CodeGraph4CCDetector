package googlejam6.p584;
import java.util.*;
public class B {

	public static void main(String args[]){
		
		Scanner s = null;
		try{
			s = new Scanner(System.in);
			int T = s.nextInt();
			int N;
			
			int index=0;
			ArrayList<TreeSet<Integer>> output = new ArrayList<TreeSet<Integer>>();
			while(index<T){				
				N = s.nextInt();
				int innerIndex=0;
				TreeSet<Integer> heightSet = new TreeSet<Integer>();
				int height;
				while(innerIndex< ((2*N)-1)*N){
					height = s.nextInt();
					if(heightSet.contains(height))
						heightSet.remove(height);
					else
						heightSet.add(height);
					
					innerIndex++;
					//System.out.println(innerIndex);
				}
				output.add(heightSet);
				index++;				
			}
			index=0;
			while(index<T){
				TreeSet<Integer> heightSet = output.get(index);
				System.out.print("Case #"+(index+1)+":");
				
				for(Integer height:heightSet){
					System.out.print(" "+height);
				}
				System.out.println();
				index++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			s.close();
		}
		
		
	}	
	
}
