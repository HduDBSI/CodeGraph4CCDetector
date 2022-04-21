package googlejam8.p992;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;


public class MainRoundC {
	public static void main(String[] args) throws IOException {
			File f = new File ("A-small-attempt0.inahawaa");
			FileWriter fw = new FileWriter (f);
			InputStream ips=new FileInputStream("A-small-attempt0.in"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne = br.readLine();
			String out;
			int hhh = 0;
			while ((ligne=br.readLine())!=null){
				ligne=br.readLine();
				try{
					hhh++;
					String s = ligne;
					
					
					String[] elements = s.split(" ");
					Vector<Integer> output = new Vector<Integer>() ; 
					Vector<Character> outputL = new Vector<Character>() ; 
					String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
					for (int i = 0 ;i<elements.length;i++){
						output.add(Integer.parseInt(elements[i]));
						outputL.add(letters.charAt(i));
						System.out.println(output.elementAt(i)+"  "+outputL.elementAt(i));	
					}
					
					boolean estnull = true;
					for(int z = 0; z< output.size();z++){
						System.out.print(output.elementAt(z));
						if(output.elementAt(z) != 0){
							estnull = false;
							break;
						}
						
					}
						
					String ch = "";
					while(!estnull){
						ch = ch + " ";
					int maxIndex = 0;
					for (int i = 1; i < output.size(); i++){
					   int newnumber = output.elementAt(i);
					   if (newnumber > output.elementAt(maxIndex)){
					   maxIndex = i;
					  }
					}
					//System.out.println(outputL.elementAt(maxIndex));
					
					int maxIndex2 = 0;
					int k = output.elementAt(maxIndex);
					int occ = Collections.frequency(output, k);
					if(occ != output.size()){
					while(output.elementAt(maxIndex2) == output.elementAt(maxIndex)){
						maxIndex2++;
					}
					
					
					for (int i = maxIndex2+1; i < output.size(); i++){
						
						if(output.elementAt(i) != k){
						   int newnumber = output.elementAt(i);
						   //System.out.println("new nubr :"+newnumber);
						   if (newnumber > output.elementAt(maxIndex2)){
							  // System.out.println("haw output[i] : "+output.elementAt(i)+"  haw output[maxindex2] :"+output.elementAt(maxIndex2));
						   maxIndex2 = i;
						  }
						}
					} 
					//System.out.println(outputL.elementAt(maxIndex2));
					
					
					}
					
					
					 if(occ==1 && occ != output.size()){
						int dif = output.elementAt(maxIndex)-output.elementAt(maxIndex2);
						if(dif == 1){
							ch = ch+outputL.elementAt(maxIndex);
							System.out.println(outputL.elementAt(maxIndex));
							output.set(maxIndex, output.elementAt(maxIndex)-1);
						}else if(dif >= 2){
							//System.out.println("slt");
							ch = ch+outputL.elementAt(maxIndex)+outputL.elementAt(maxIndex);
							System.out.print(outputL.elementAt(maxIndex));
							System.out.println(outputL.elementAt(maxIndex));
							output.set(maxIndex, output.elementAt(maxIndex)-2);
						}
					}else if(occ >= 2 && occ != output.size()){
						ch = ch+outputL.elementAt(maxIndex);
						System.out.print(outputL.elementAt(maxIndex));
						output.set(maxIndex, output.elementAt(maxIndex)-1);
						int y = maxIndex;
						while(y< output.size()){
							y++;
							if(output.elementAt(y) == k){
								ch = ch+outputL.elementAt(y);
								System.out.println(outputL.elementAt(y));
								output.set(y, output.elementAt(y)-1);
								break;
							}
						}
						
					}else if(occ > 2 && occ == output.size()){
						ch = ch+outputL.elementAt(maxIndex);
						System.out.println(outputL.elementAt(maxIndex));
						output.set(maxIndex, output.elementAt(maxIndex)-1);
					}
					else if(occ == 2 && occ == output.size()){
						ch = ch+outputL.elementAt(maxIndex);
						System.out.print(outputL.elementAt(maxIndex));
						output.set(maxIndex, output.elementAt(maxIndex)-1);
						int y = maxIndex;
						while(y< output.size()){
							y++;
							if(output.elementAt(y) == k){
								ch = ch+outputL.elementAt(y);
								System.out.println(outputL.elementAt(y));
								output.set(y, output.elementAt(y)-1);
								break;
							}
						}
					}
					else if( occ != output.size()){
						ch = ch+outputL.elementAt(maxIndex);
						System.out.println(outputL.elementAt(maxIndex));
						output.set(maxIndex, output.elementAt(maxIndex)-1);
					}
					System.out.println("ahawaaaaa  "+ch);
					estnull = true;
					for(int z = 0; z< output.size();z++){
						System.out.print(output.elementAt(z));
						if(output.elementAt(z) != 0){
							estnull = false;
							//break;
						}
						
					}
					System.out.println();
					
					}
					
				 fw.write ("Case #" + hhh + ": " + ch +"\r\n");
				}catch(Exception e){
					
				}
			}
			br.close(); 
			fw.close();

	}

}
