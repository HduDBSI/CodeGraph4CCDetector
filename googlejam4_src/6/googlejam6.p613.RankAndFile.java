package googlejam6.p613;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RankAndFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		//		scan.nextLine();
		for(int i=1;i<=T;i++){
			int n=scan.nextInt();
			HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>(); 
			for(int j=0;j<(2*n*n)-n;j++){
				int input=scan.nextInt();
				if(hm.containsKey(input)){
					hm.put(input, hm.get(input)+1);
				}
				else{
					hm.put(input,1);
				}
			}
			Iterator it = hm.entrySet().iterator();
			ArrayList<Integer> aList=new ArrayList();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        if(((int)pair.getValue())%2==1){
		        	aList.add((int)pair.getKey());
		        }
		        it.remove(); 
		    }
		    Collections.sort(aList);
		    String s="";
		    while(!aList.isEmpty()){
		    	s=s+aList.remove(0)+" ";
		    }
		    System.out.print("Case #"+i+": "+s.trim()+"\n");
		}

	}

}
