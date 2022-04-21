package googlejam8.p139;
import java.io.*;

import java.util.*;

public class codejam {

    static String i0 = "dummy.in";
    static String o0 = "dummy.out";

    static String i1 = "small.in";
    static String o1 = "small.out";

    static String i2 = "large.in";
    static String o2 = "large.out";

    public static void main(String[] args) throws Exception {

        Scanner r = null;
        FileWriter w = null;

        r = new Scanner(new FileReader(i0));
        w = new FileWriter(new File(o0));

        int t = r.nextInt();
        //r.nextLine();
        
        for (int i=0;i<t;i++){
            w.write("Case #"+(i+1)+": ");
            int n = r.nextInt();
            Map<String, Integer> mp = new HashMap<String, Integer>();
            int mn = 10001;
            for (int j=0;j<n;j++){
                int p = r.nextInt();
                if (mn > p)
                    mn = p;
                mp.put(String.valueOf((char)('A'+j)), p);
            }
            ArrayList<Map.Entry<String, Integer>> al = new ArrayList<Map.Entry<String, Integer>>(mp.entrySet());
            Collections.sort(al, (o1, o2) -> o2.getValue() - o1.getValue());
            boolean gothru = false;
            while(!gothru){
                gothru = true;
                for (int j=0;j<n;j++){
                    if (al.get(j).getValue() == mn)
                        continue;
                    else{
                        gothru = false;
                        w.write(al.get(j).getKey()+" ");
                        al.get(j).setValue(al.get(j).getValue()-1);
                    }
                }
            }
            for (int j=0;j<mn;j++){
                for (int k=0;k<n;k++){
                    if (k == n-2){
                        w.write(al.get(k).getKey());
                        w.write(al.get(k+1).getKey());
                        w.write(" ");
                        break;
                    } else {
                        w.write(al.get(k).getKey()+" ");
                    }
                }
            }
            //w.write(s1+" "+s2);
            w.write("\n");
        }
        w.close();
    }
}
