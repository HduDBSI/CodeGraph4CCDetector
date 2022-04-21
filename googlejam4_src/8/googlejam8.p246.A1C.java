package googlejam8.p246;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Nejc on 08.05.2016.
 */
public class A1C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int p[] = new int[N];
            String split[] = br.readLine().split(" ");
            for(int i = 0; i < N; i++){
                p[i] = Integer.parseInt(split[i]);
            }
            int ex1 = 0;
            for(int i = 1; i < N; i++){
                if(p[i] > p[ex1]){
                    ex1 = i;
                }
            }
            int ex2 = 0;
            int max = 0;
            for(int i = 0; i < N; i++){
                if(i==ex1)continue;
                if(p[i] > max){
                    ex2 = i;
                    max = p[i];
                }
            }
            System.out.print("Case #"+t+":");
            while(p[ex1] > p[ex2]){
                System.out.print(" " + (char)('A'+ex1));
                p[ex1]--;
            }
            for(int i = 0; i < N; i++){
                if(i==ex2 || i==ex1)continue;
                while(p[i]>0){
                    System.out.print(" " + (char)('A'+i));
                    if(p[i]>1) System.out.print((char)('A'+i));
                    
                    p[i]-=2;
                }
            }
            while(p[ex1] > 0){
                System.out.print(" " + (char)('A'+ex1) + (char)('A'+ex2));
                p[ex1]--;
            }
            System.out.println();
        }
    }
}
