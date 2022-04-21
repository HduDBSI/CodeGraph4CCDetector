package googlejam6.p555;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by saikat on 16/4/16.
 */
public class Rank_File {

    public static void main(String arg[]) throws IOException {
        FileReader f = new FileReader("B-large(1).in");
        BufferedReader br = new BufferedReader(f);
        FileWriter fw = new FileWriter("output");

        int T,N,t,n;
        String[] temp;
        int[] arr;
        T=Integer.parseInt(br.readLine());
        t=T;
        while(T-->0){
            arr=new int[2500];
            N=Integer.parseInt(br.readLine());
            n=2*N-1;
            fw.write("Case #" + (t - T) + ": ");

            while(n-->0) {
                //System.out.println("n = "+n);
                temp = br.readLine().split(" ");
                for (String s : temp) {
                    //System.out.println(s);
                    arr[Integer.parseInt(s)-1]++;
                }
            }

            for(int i=0;i<2500;i++){
                //System.out.print("  "+(arr[i]));
                if(arr[i]%2!=0){
                    fw.write(" "+(i+1));
                }
                arr[i]=0;
            }
            fw.write("\n");
        }
        fw.close();
    }
}
