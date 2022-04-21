package googlejam8.p280;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class r14 {
    public static void main(String[] args) {
        try {
            Scanner input=new Scanner(new File(args[0]));
            PrintWriter output=new PrintWriter(args[1]) ;
            int casenumber = input.nextInt();
            input.nextLine();
            for(int i=0;i<casenumber;i++){
                 StringBuilder result = new StringBuilder();
                int pc = input.nextInt();
                int[] pi = new int[pc];
                int total = 0;
                for(int j=0;j<pc;j++){
                    pi[j]=input.nextInt();
                    total+=pi[j];
                }
                while (total>0){
                    int[] max = new int[]{0,0};
                    int[] maxindex = new int[2];
                    for(int j=0;j<pc;j++){
                       if(pi[j]>max[0]){
                           max[1]=max[0];
                           max[0]=pi[j];
                           maxindex[1]=maxindex[0];
                           maxindex[0]=j;
                       } else if (pi[j]>max[1]){
                           max[1]=pi[j];
                           maxindex[1]=j;
                       }
                    }
                    result.append(" ");
                    result.append((char)('A'+maxindex[0]));
                    total--;
                    pi[maxindex[0]]--;
                    if(max[1]>0 && max[1]*2>total){
                        result.append((char)('A'+maxindex[1]));
                        total--;
                        pi[maxindex[1]]--;
                    }
                }
                output.println("Case #" + (i + 1) + ":"+result.toString());
            }
            output.flush();
        } catch (Exception e){
             e.printStackTrace();
        }
    }

}
