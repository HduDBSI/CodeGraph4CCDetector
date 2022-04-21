package googlejam8.p611;
/**
 * Created by xc9pd on 5/8/2016.
 */
import java.io.*;
import java.util.*;

public class A implements Comparator<A>, Comparable<A>{

    String name;
    int value;
    public A(char se,int value){
        this.name=""+se;
        this.value=value;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            System.out.print("Case #" + i + ":");
            char se='A';
            ArrayList<A> sensor=new ArrayList<A>();
            int total=0;
            for(int j=0;j<n;j++){
                int s=in.nextInt();

                A node=new A(se,s);
                se++;
                total+=s;
                sensor.add(node);
            }

            Collections.sort(sensor);
            while(sensor.get(0).value>0){

                if((double)sensor.get(1).value/(double)(total-1)<=0.5){
                    sensor.get(0).value--;
                    total--;
                    System.out.print(" "+sensor.get(0).name);
                }
                else {
                    sensor.get(0).value--;
                    sensor.get(1).value--;
                    total-=2;
                    System.out.print(" "+sensor.get(0).name+sensor.get(1).name);
                }
                //System.out.print(" total: " +total);
                Collections.sort(sensor);
            }
            System.out.println("");

        }

    }
}
