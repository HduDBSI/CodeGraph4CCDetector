package googlejam6.p634;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by xy on 4/15/16.
 */
public class RankAndFile {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("in.txt");
        Scanner in = new Scanner(input);
        PrintWriter writer = new PrintWriter("out.txt");
        int T = in.nextInt();
        in.nextLine();
        RankAndFile r = new RankAndFile();
        for (int i = 1; i<= T; i++){


            writer.print("Case #"+i+": ");
            int N = in.nextInt();
			in.nextLine();
			HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();
			for (int row = 0; row < 2*N-1; row++){
			    for (int i3 = 0; i3 < N; i3++){
			        int tmp = in.nextInt();
			        if (m.containsKey(tmp))
			            m.put(tmp, m.get(tmp) + 1);
			        else
			            m.put(tmp,1);
			    }
			    in.nextLine();
			}
			
			List<Integer> l = new LinkedList<Integer>();
			for (int i1 : m.keySet()){
			    if (m.get(i1)%2 == 1)
			        l.add(i1);
			}
			Collections.sort(l);
			for (int i2 = 0; i2 < N; i2++){
			    if (i2 < N-1)
			        writer.print(l.get(i2)+" ");
			    else
			        writer.println(l.get(i2));
			}

        }


        in.close();
        writer.close();
    }

}
