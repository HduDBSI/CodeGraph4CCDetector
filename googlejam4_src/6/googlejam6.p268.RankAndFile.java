package googlejam6.p268;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class RankAndFile {
    private static final String CASE = "Case #";
public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), true);

    int tcs  = Integer.parseInt(br.readLine());
    
    for(int t=1;t<=tcs;++t){
        String opFormat = CASE + t + ":";
        HashMap<Integer, Integer> heights = new HashMap<Integer, Integer>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0,iLen=((2*N)-1);i<iLen;++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                int currentHeight = Integer.parseInt(st.nextToken());
                if(heights.containsKey(currentHeight)){
                    heights.put(currentHeight, heights.get(currentHeight) + 1);
                }else{
                    heights.put(currentHeight, 1);
                }
            }
        }
            ArrayList<Integer> missingHeights = new ArrayList<Integer>(N);
            
            Iterator<Integer> heightsIterator = heights.keySet().iterator();
            while(heightsIterator.hasNext()){
                int currentHeight = heightsIterator.next();
                int currentHeightVal = heights.get(currentHeight);
                if((currentHeightVal%2)==1){
                    missingHeights.add(currentHeight);
                }
            }
            Collections.sort(missingHeights);
            pw.print(opFormat);
            for(int i=0;i<N;++i){
                pw.print(" "+missingHeights.get(i));
            }
            pw.println();
    }
    
    pw.flush();
    pw.close();
    br.close();
}
}

