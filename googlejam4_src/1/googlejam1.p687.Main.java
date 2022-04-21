package googlejam1.p687;

import java.util.Scanner;

public class Main {

    static Scanner stdin = new Scanner(System.in);    
    
    public static void main(String[] args) {
        int cases = stdin.nextInt();
        for (int i = 0; i < cases; i++) {
            Main mt = new Main();
            mt.n = Main.stdin.nextInt();
			mt.m = new Integer[mt.n];
			for (int i1 = 0; i1 < mt.n; i1++) {
			    mt.m[i1] = Main.stdin.nextInt();
			}
            Integer eaten=0;
			for (int i1 = 1; i1 < mt.n; i1++) {
			    if (mt.m[i1]<mt.m[i1-1]){
			        eaten += mt.m[i1-1]-mt.m[i1];
			    }
			    
			}
			mt.solution = eaten.toString();
			Integer eaten1 = 0;
			Integer max=0;
			for (int i1 = 1; i1 < mt.n; i1++) {
			    if (mt.m[i1-1]-mt.m[i1]>max){
			        max=mt.m[i1-1]-mt.m[i1];
			    }
			}
			for (int i2 = 1; i2 < mt.n; i2++) {
			    if (mt.m[i2-1]>max){
			        eaten1 = eaten1 + max;
			    }else{
			        eaten1 = eaten1 + mt.m[i2-1];
			    }
			}
			
			mt.solution = mt.solution + " " + eaten1.toString();
            System.out.println("Case #"+(1+i)+": "+mt.solution);
        }
    }    


    Integer n;
    Integer[] m;
    String solution;
    
}
