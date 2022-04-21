package googlejam1.p613;
import java.io.*;
import java.util.LinkedList;

/**
 * Created by ldfrank533 on 15/4/18.
 */
public class MushroomMonster {
    public static void main(String[] args) {
        LinkedList<String> s=new LinkedList<String>();


        try {
            String encoding="GBK";
            File file=new File("/Users/ldfrank533/b.txt");
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


        int trial=Integer.valueOf(s.get(0));
        String[] raw=new String[trial*2+1];
        // int[][] resf=new int[trial][0];

        for (int i=0;i<s.size();i++){
            raw[i]=s.get(i);
        }

        for(String x:raw){
            System.out.println(x);
        }

        System.out.println("--------------------------------------------------------------------");
        int[] intervals=new int[trial];
        int[][] data=new int[trial][0];
        for(int i=0;i<trial;i++){
            intervals[i]=Integer.valueOf(raw[2*i+1]);
			String[] numbers = raw[2*i+2].split("\\s+");
			int[] ints = new int[numbers.length];
			for (int i1 = 0; i1 < ints.length; i1++)
			    ints[i1] = Integer.parseInt(numbers[i1]);
            data[i]=ints;
        }
//        for(int i:data[data.length-1]){
//            System.out.println(i);
//        }
        int[][] res=new int[trial][2];
        for(int i=0;i<trial;i++){
            int[] in = data[i];
			int res1=0;
			for(int i1=0;i1<in.length-1;i1++){
			    if(in[i1]>in[i1+1]){
			        res1+=in[i1]-in[i1+1];
			    }
			}
			res[i][0]=res1;
			int[] in1 = data[i];
			int maxdif=0;
			int res2=0;
			for(int i2=0;i2<in1.length-1;i2++){
			    if(in1[i2]>in1[i2+1]){
			        if(in1[i2]-in1[i2+1]>maxdif){
			            maxdif=in1[i2]-in1[i2+1];
			        }
			    }
			}
			for(int i1=0;i1<in1.length-1;i1++){
			    if(in1[i1]<maxdif){
			       res2+=in1[i1];
			    }
			    else{
			        res2+=maxdif;
			    }
			}
            res[i][1]=res2;
        }


        try {


            String path = "/Users/ldfrank533/Mushroom0.txt";//文件保存路径、名字
            File file = new File(path);
            BufferedWriter ow = new BufferedWriter(new FileWriter(file));

            for(int i=0;i<trial;i++){

                String temp="Case "+"#"+String.valueOf(i+1)+": "+res[i][0]+" "+res[i][1];

                ow.write(temp);

                ow.newLine();
            }

            ow.close();
            System.out.println("Finished Writing");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
