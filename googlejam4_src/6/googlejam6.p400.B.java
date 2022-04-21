package googlejam6.p400;
import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {

            Set<Integer> set = new TreeSet<>();
            int k = in.nextInt();
//            Set<Integer> set = new HashSet<>();
            for(int l=0; l< (k *2)-1; l++ ){
//                int[] array = new int[k];

                for(int n =0; n<k;n++){
                    int num = in.nextInt();
                    boolean remove = false;

                    for(int a : set){
                        if(a == num){
                            remove = true;
                            break;
                        }
                    }

                    if(remove){
                        set.remove(num);
                    }else{
                        set.add(num);
                    }

                }


            }
            String str = "";
            for(int n : set){

               str += " " + n;
            }

            System.out.println("Case #" + i + ": " + str.trim());
        }
    }

}
