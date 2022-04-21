package googlejam1.p622;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\aschonfe\\Desktop\\tmp.out"));
        String firstLine = scan.nextLine();
        Boolean isFile = !Character.isDigit(firstLine.charAt(0));
        int T;
        if(isFile){
            scan = new Scanner(new FileReader(firstLine));
            T = scan.nextInt();
        }else{
            T = Integer.parseInt(firstLine);
        }
        for(int t=1;t<=T;t++){
            int N = scan.nextInt();
            int[] m = new int[N];
            
            for(int n=0;n<N;n++){
            	m[n] = scan.nextInt();
            }
            
            //method 1
            int method1 = 0;
            int prev = m[0];
            for(int n=0;n<N;n++){
            	if(m[n] > prev){
            		prev = m[n];
            	}else{
            		method1 += prev - m[n];
            		prev = m[n];
            	}
            }
            
            //method 2
            int rate = 0;
            for(int n=1;n<N;n++){
            	if((m[n-1] - m[n]) > rate){
            		rate = m[n-1] - m[n];
            	}
            }
            int method2 = 0;
            for(int n=0;n<N-1;n++){
            	if(m[n] > rate){
            		method2 += rate;
            	}else{
            		method2 += m[n];
            	}
            }

            System.out.printf("Case #%d: %d %d%n", t, method1, method2);
            out.write(String.format("Case #%d: %d %d%n", t, method1, method2));
        }
        if(isFile){
            scan.close();
        }
        out.close();
    }
}
