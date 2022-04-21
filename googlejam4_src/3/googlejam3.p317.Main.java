package googlejam3.p317;

import java.util.Scanner;

public class Main {

    static Scanner stdin = new Scanner(System.in);    
    
    public static void main(String[] args) {
        int cases = stdin.nextInt();
        for (int i = 0; i < cases; i++) {
            Main mt = new Main();
            mt.r = Main.stdin.nextInt();
			mt.c = Main.stdin.nextInt();
			mt.w = Main.stdin.nextInt();
            int full = mt.c/mt.w;
			int first = full*mt.r;
			mt.result = first + mt.w - 1 + (mt.c%mt.w==0?0:1);
            System.out.println("Case #"+(1+i)+": "+""+mt.result);
        }
    }    

    int r,c,w,result;
    
}
