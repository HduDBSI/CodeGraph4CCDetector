package googlejam8.p347;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author ABDULRAHUMAN
 */
public class SenateEvacuation {
    public static void main(String args[]) throws FileNotFoundException, IOException{
        //Scanner in=new Scanner(System.in);
        Scanner in=new Scanner(new FileReader("E:\\a.in"));
        PrintWriter out=new PrintWriter(new FileWriter("E:\\a.out"));
        int t=in.nextInt();
        for(int z=1;z<=t;z++){
            int n=in.nextInt();
            int arr[]=new int[n];
            System.out.println(n);
            StringBuilder str=new StringBuilder("");
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            int count=1;
            //System.out.print("Case #"+z+": ");
            //out.print("Case #"+z+": ");
            str.append("Case #"+z+": ");
            while(true){
                if(count%3==0){
                    //System.out.print(" ");
                    //out.print(" ");
                    str.append(" ");
                    count++;
                }
                int max=Integer.MIN_VALUE;
                for(int i=0;i<n;i++){
                    if(arr[i]>max)
                        max=arr[i];
                }
                if(max==0){
                    break;
                }
                for(int i=0;i<n;i++){
                    if(arr[i]==max){
                        //System.out.print((char)(i+'A'));
                        //out.print((char)(i+'A'));
                        str.append((char)(i+'A'));
                        arr[i]--;
                        break;
                    }
                }
                count++;
            }
            if(str.charAt(str.length()-2)==' '){
                System.out.println(str);
                char ch=str.charAt(str.length()-3);
                str.replace(str.length()-3, str.length()-1, " "+ch);
            }
            
            System.out.println(str);
            out.println(str);
        }
        out.close();
    }
}
