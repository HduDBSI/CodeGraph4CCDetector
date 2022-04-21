package googlejam6.p681;
import java.util.*;

public class B {
    final Scanner sc = new Scanner(System.in);

    Integer n;
    HashMap<Integer,Integer> counter;
    
    public static void main (String[] args) {
        B r = new B();
		final int cn = r.sc.nextInt();
		r.sc.nextLine();
		for (int ci = 1; ci <= cn; ci++) {
		    r.counter = new HashMap<Integer,Integer>();
			r.n = Integer.parseInt(r.sc.nextLine());
			int length = 2*r.n-1;
			for(int i = 0; i < length; i++){
			    String[] nums = r.sc.nextLine().split(" ");
			    for(String num: nums){
			        int ni = Integer.parseInt(num);
			        if(r.counter.containsKey(ni)) {
			            r.counter.put(ni, r.counter.get(ni)+1);
			        } else {
			            r.counter.put(ni, 1);
			        }
			    }
			}
		    System.out.printf("Case #%d: ", ci);
		    ArrayList<Integer> result = new ArrayList<Integer>();
			for(Map.Entry<Integer,Integer> entry: r.counter.entrySet()){
			    if(entry.getValue() % 2 == 1){
			        result.add(entry.getKey());
			    }
			}
			Collections.sort(result);
			for(int i = 0; i < result.size(); i++){
			    if(i !=0 ){
			        System.out.print(" ");
			    }
			    System.out.print(result.get(i));
			}
			System.out.println();
		}
    }
}
