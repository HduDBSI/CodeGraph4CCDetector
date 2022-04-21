package googlejam6.p543;

	import java.util.*;
	import java.io.*;

	public class  Round1AProblemB {
		public static void main(String[] args) throws Exception {
			Round1AProblemB r = (new  Round1AProblemB());
			Scanner sc = new Scanner(new FileReader("input.in"));
			PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
			int T = sc.nextInt();
			for (int t=0; t<T; t++) {
				String ans = "";
				List<Integer> list = new ArrayList<Integer>();
				System.out.println("Now case " + (t+1));
				int N = sc.nextInt();
				for(int i=0; i<(2*N-1)*N;i++){
					String s = sc.next();
					if(list.contains(Integer.valueOf(s))){
						list.remove(list.indexOf(Integer.valueOf(s)));
					}else{
						list.add(Integer.valueOf(s));
					}
				}
				Collections.sort(list);
				pw.print("Case #" + (t+1) + ":");
			    Iterator<Integer> it = list.iterator();
			    while (it.hasNext()) {
			        pw.print( " " + it.next());
			    }
				pw.println();
			}
			pw.flush();
			pw.close();
			sc.close();
		}
	}



