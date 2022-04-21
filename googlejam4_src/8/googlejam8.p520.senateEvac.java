package googlejam8.p520;


import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by Brijesh on 08-05-2016.
 */
public class senateEvac {
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Downloads/A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n];
            st=new StringTokenizer(br.readLine());
            int sum=0;
            for(int j=0;j<n;j++){
                arr[j]=Integer.parseInt(st.nextToken());
                sum+=arr[j];
            }
            String str="";
            while(sum>0){
                Vector<Integer> v=new Vector<Integer>();
                int max=0,oldmax=0;
                for(int j=0;j<n;j++){
                    if(arr[j]>max){
                        oldmax=max;
                        max=arr[j];
                        v.clear();
                        v.add(j);
                    }
                    else if(arr[j]==max)
                        v.add(j);
                    else if(arr[j]>oldmax)
                        oldmax=arr[j];
                }
                if(v.size()%2==0){
                    for(int k=1;k<=max-oldmax;k++){
                        for(int j=0;j<v.size();j+=2){
                            char a=(char)(v.elementAt(j)+65);
                            char b=(char)(v.elementAt(j+1)+65);
                            arr[v.elementAt(j)]--;
                            arr[v.elementAt(j+1)]--;
                            str+=a;
                            str+=b;
                            str+=" ";
                            sum-=2;
                        }
                    }
                }
                else{
                    for(int k=1;k<=max-oldmax;k++){
                        char c=(char)(v.elementAt(0)+65);
                        str+=c;
                        str+=" ";
                        sum--;
                        arr[v.elementAt(0)]--;
                        for(int j=1;j<v.size();j+=2){
                            char a=(char)(v.elementAt(j)+65);
                            char b=(char)(v.elementAt(j+1)+65);
                            arr[v.elementAt(j)]--;
                            arr[v.elementAt(j+1)]--;
                            str+=a;
                            str+=b;
                            str+=" ";
                            sum-=2;
                        }
                    }
                }
            }
            System.out.println("Case #"+i+": "+str.trim());
        }
    }
}
