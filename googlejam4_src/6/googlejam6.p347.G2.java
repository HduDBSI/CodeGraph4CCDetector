package googlejam6.p347;
import java.util.*;
import java.io.*;
public class G2{
	public static void main(String args[])throws IOException{
		//Scanner in=new Scanner(System.in);
		Scanner in=new Scanner(new File("input.in"));
		PrintWriter pw=new PrintWriter(new FileWriter(new File("output.out")));
		int T=in.nextInt();
		for(int t=1;t<=T;t++){
			int n=in.nextInt();
			HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
			for(int i=0;i<2*n-1;i++){
				for(int j=0;j<n;j++){
					int tmp=in.nextInt();
					Integer obj=new Integer(tmp);
					if(hm.containsKey(obj)){
						hm.put(obj,hm.get(obj)+1);
					}else
						hm.put(obj,1);
				}
			}
			List<Integer> list=new ArrayList<Integer>();
			for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
				if ( (Integer)entry.getValue()%2!=0) {
					list.add(entry.getKey());
				}
			}
			Collections.sort(list);
			String res=list.toString();
			//System.out.println("Case #"+t+": "+res.substring(1,res.length()-1).replaceAll(",",""));
			pw.println("Case #"+t+": "+res.substring(1,res.length()-1).replaceAll(",",""));
		}
			System.out.println("Done");
		pw.close();									   
	}
}
