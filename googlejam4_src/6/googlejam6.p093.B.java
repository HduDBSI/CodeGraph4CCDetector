package googlejam6.p093;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class B {



    public static void main(String[] args) throws NumberFormatException, IOException {
        String name = "B";

        // TODO READER
        boolean isSmall = false;
        BufferedReader br;

        //br= new BufferedReader(new FileReader("bum.in"));
        if(isSmall) br = new BufferedReader(new FileReader(name+"-small-attempt0 (2).in"));
        else br = new BufferedReader(new FileReader(name+"-large (1).in"));

        PrintWriter pw;
        if(isSmall) pw = new PrintWriter(name+"-small.txt", "UTF-8");
        else pw = new PrintWriter(name+"-large.txt", "UTF-8");

        int T=Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] vrst = new int[2*N-1][N];
            for(int j=0;j<2*N-1;j++){
                String[] tab =br.readLine().split(" ");

                for(int k=0;k<N;k++) {
                    //System.out.println(""+j+k);
                    vrst[j][k]=Integer.parseInt(tab[k]);
                }
            }
			boolean[] bool = new boolean[2501];
			for(int i1 = 0;i1<2*N-1;i1++){
			    for(int j = 0;j<N;j++){
			        bool[vrst[i1][j]]=!bool[vrst[i1][j]];
			    }
			
			}
			StringBuilder st = new StringBuilder();
			for(int i2 = 0; i2<bool.length;i2++){
			    if(bool[i2]) st.append(i2 + " ");
			}
            String a = st.toString();


            System.out.print("Case #"+(i+1)+": "+a+"\n");
            pw.write("Case #"+(i+1)+": "+a+"\n");

        }
        pw.close();
    }
}