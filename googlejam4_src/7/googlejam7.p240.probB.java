package googlejam7.p240;


/**
 * Created by Ronald on 4/30/2016.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class probB{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader( new FileReader("B-small-attempt1.in"));
        int numinput = Integer.parseInt(in.readLine());
        File file = new File("output.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for( int currinput = 0; currinput < numinput; currinput++){
            System.out.print("Case #" + (1 + currinput) + ":");
            bw.write("Case #" + (1 + currinput) + ":");
            String[] input = in.readLine().split(" ");
            String coders = input[0];
            String jammers = input[1];
            int rannumc = 0;
            int rannumj = 0;

            ArrayList<Integer> codersindex = new ArrayList<>();
            ArrayList<Integer> jammersindex = new ArrayList<>();

            for( int i =coders.length() -1; i !=-1; i--){
                if(coders.charAt(i) == '?'){
                    rannumc++;
                    codersindex.add(i);
                    coders = coders.substring(0,i) +'0'+coders.substring(i+1);
                }

            }
            for( int i = jammers.length() -1; i!= -1;i--){
                if(jammers.charAt(i) == '?'){
                    rannumj++;
                    jammersindex.add(i);
                    jammers = jammers.substring(0,i) + '0' + jammers.substring(i+1);
                }
            }
            int index  =0;
            int minjammers = Integer.parseInt(jammers);
            int mincoders = Integer.parseInt(coders);
            String jammerstr = jammers;
            String codersstr = coders;
            int min = Integer.parseInt(coders) - Integer.parseInt(jammers);
            if(min <0){
                min= 0-min;
            }
            while(index <rannumc + rannumj){
                boolean overflow = false;
                int addindex = 0;
                while (overflow == false) {
                    overflow = true;
                    if(addindex>  rannumc+rannumj){
                        break;
                    }
                    if(addindex < rannumj) {
                        if (jammers.charAt(jammersindex.get(addindex)) =='9') {
                            overflow = false;
                            jammers = jammers.substring(0, jammersindex.get(addindex)) +
                                    '0' +
                                    jammers.substring(jammersindex.get(addindex) + 1);
                            addindex++;
                        } else{
                            jammers = jammers.substring(0, jammersindex.get(addindex) ) +
                                    (char)((int)jammers.charAt(jammersindex.get(addindex)) + 1) +
                                    jammers.substring(jammersindex.get(addindex) + 1);
                        }
                    }
                    else{
                        if(addindex - rannumj == codersindex.size()){
                            continue;
                        }
                        if(coders.charAt(codersindex.get(addindex - rannumj )) =='9'){
                            overflow = false;
                            coders = coders.substring(0, codersindex.get(addindex - rannumj)) +
                                    '0' +
                                    coders.substring(codersindex.get(addindex-rannumj) +1);
                            addindex++;
                        }
                        else{
                            coders = coders.substring(0, codersindex.get(addindex- rannumj)) +
                                    (char)((int)coders.charAt(codersindex.get(addindex-rannumj)) + 1)+
                                    coders.substring(codersindex.get(addindex - rannumj) + 1);
                        }
                    }
                    index = addindex;
                }
                int currjammer = Integer.parseInt(jammers);
                int currcoders = Integer.parseInt(coders);
                int currnum= currjammer - currcoders;
                if(currnum <0)
                    currnum = 0-currnum;
                if(currnum <min){
                    min = currnum;
                    minjammers = currjammer;
                    mincoders = currcoders;
                    jammerstr= jammers;
                    codersstr = coders;
                }
            }
            String output = " " + codersstr + " " + jammerstr+ "\n";
            System.out.print(output);
            bw.write(output);


        }
        bw.close();
    }
}
