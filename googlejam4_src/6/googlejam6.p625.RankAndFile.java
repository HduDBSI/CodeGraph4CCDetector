package googlejam6.p625;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RankAndFile {

	public RankAndFile() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		RankAndFile yessir=new RankAndFile();
		FileReader fr;
		try {
			fr = new FileReader("B-large.in");
			BufferedReader br=new BufferedReader(fr);
			FileWriter fw=new FileWriter("data-B-large.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			int inputs=Integer.parseInt(br.readLine());
			for(int i=0; i<inputs; i++){
				int rows=Integer.parseInt(br.readLine());
				ArrayList<Integer> list=new ArrayList<Integer>();
				for (int j=0; j<rows*2-1; j++){
					String[] line=br.readLine().split(" ");
					for(String x: line){
						list.add(Integer.parseInt(x));
					}
				}
				StringBuilder output1=new StringBuilder();
				ArrayList<Integer> missingRow=new ArrayList<Integer>();
				ArrayList<Integer> distinctHeights=new ArrayList<Integer>();
				Iterator<Integer> theIter=list.iterator();
				while(theIter.hasNext()){
					int next=theIter.next();
					if(distinctHeights.contains(next)){
						continue;
					}
					else{
						distinctHeights.add(next);
					}
				}
				//System.out.println(distinctHeights.toString());
				Collections.sort(distinctHeights);
				int index=0;
				while (missingRow.size()<rows){
					int currentHeight=distinctHeights.get(index);
					int parity=0;
					for(int i1=0; i1<list.size(); i1++){
						int x=list.get(i1);
						if(x==currentHeight){
							parity++;
						}
					}
					if (parity%2==1){
						missingRow.add(currentHeight);
					}
					index++;
				}
				
				for(int i2=0; i2<missingRow.size(); i2++){
					System.out.print(missingRow.get(i2)+" ");
					output1.append(missingRow.get(i2)+" ");
				}
				String output=output1.toString();
				
				bw.write("Case #"+(i+1)+": ");
				bw.write(output+"\n");
			}
			br.close();
			bw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
