package googlejam6.p374;


import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.*;

/**
 * Created by AmesingFlank on 4/16/16.
 */
public class RankFile {

    public static void main(String [] args){
        LinkedList<String> s=new LinkedList<String>();
		
		
		try {
		    String encoding="GBK";
		    File file=new File("/Users/AmesingFlank/Downloads/qbtest.in");
		    if(file.isFile() && file.exists()){ //判断文件是否存在
		        InputStreamReader read = new InputStreamReader(
		                new FileInputStream(file),encoding);//考虑到编码格式
		        BufferedReader bufferedReader = new BufferedReader(read);
		        String lineTxt = null;
		        while((lineTxt = bufferedReader.readLine()) != null){
		            s.add(lineTxt);
		        }
		        read.close();
		    }
		} catch (Exception e) {
		    System.out.println("读取文件内容出错");
		    e.printStackTrace();
		}
		
		String[] ans1=new String[s.size()];
		for (int i1 = 0; i1 < s.size(); i1++) {
		    ans1[i1]=s.get(i1);
		}
		String raw[] = ans1;
        int cases=Integer.valueOf(raw[0]);

        int index=1;
        String[] ans=new String[cases];
        for (int i = 0; i < cases; i++) {
            int N=Integer.valueOf(raw[index]);
            String vals[]=new String[2*N-1];
            for (int j = index+1; j <index+1+2*N-1 ; j++) {
                vals[j-index-1]=raw[j];
            }
            index+=2*N;
            ans[i]=solveOne(N,vals);
        }
        try {
		
		    int trial=ans.length;
		    File file = new File("/Users/AmesingFlank/cj2016/QuestionB-test.txt");
		    BufferedWriter ow = new BufferedWriter(new FileWriter(file));
		
		    for(int i=0;i<trial;i++){
		
		        String temp="Case "+"#"+String.valueOf(i+1)+": "+ans[i];
		        System.out.println(temp);
		        ow.write(temp);
		
		        ow.newLine();
		    }
		
		    ow.close();
		    System.out.println("Finished Writing");
		
		} catch (IOException e) {
		    e.printStackTrace();
		}
    }

    public static String solveOne(int N,String[] files){
        HashMap<Integer,Integer> counts=new HashMap<>();
        for (int i = 0; i <files.length ; i++) {
            int[] arr=getarr(files[i]);
            for (int j = 0; j < arr.length; j++) {
                //counts[arr[j]]++;
                if (counts.get(arr[j])==null){
                    counts.put(arr[j],1);
                }
                else
                counts.put(arr[j],counts.get(arr[j])+1);
            }
        }

        LinkedList<Integer> ansArr=new LinkedList<>();

        Iterator iter =counts.keySet().iterator();
        while (iter.hasNext()){
            Integer key=(Integer) iter.next();
            Integer value=counts.get(key);
            if (value%2!=0){
                ansArr.add(key);
            }
        }

        Collections.sort(ansArr);
        String ans="";
        for (int i = 0; i <ansArr.size() ; i++) {
            if(i==ansArr.size()-1){
                ans+=String.valueOf(ansArr.get(i));
            }
            else
            ans+=String.valueOf(ansArr.get(i))+" ";
        }
        return ans;
    }
}
