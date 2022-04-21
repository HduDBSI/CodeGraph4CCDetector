package googlejam1.p277;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 * Created by Sumedh on 11-04-2015.
 */
public class A {
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("E:/codejam/A-large.in");			//
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw =new FileWriter("E:/codejam/out.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            int T = Integer.parseInt(br.readLine());
            for(int x=0;x<T;x++){
                int N = Integer.parseInt(br.readLine());
                long first=0,second=0,diff=0,maxx_diff=0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] n = new int[N];
                for(int i=0;i<N;i++){
                    n[i] = Integer.parseInt(st.nextToken());
                }
                for(int i=0;i<N-1;i++){
                    if(n[i]>n[i+1]) {
                        diff = (n[i]- n[i+1]);
                        first += diff;
                        if(diff>maxx_diff){
                            maxx_diff=diff;
                        }
                    }
                }
                for(int i=0;i<N-1;i++){
                    if(n[i]>maxx_diff){
                        second+=maxx_diff;
                    }
                    else{
                        second+=n[i];
                    }
                }
                String ans="Case #" + (x+1)+": "+first+" "+second;
                bw.write(ans);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }catch(Exception e){e.printStackTrace();}
    }
}
