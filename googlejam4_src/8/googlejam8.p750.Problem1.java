package googlejam8.p750;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem1 {
	public static void main(String args[]){
		List<String> inputList1 = new ArrayList<String>();
		String filePath = "/Users/zzluck/Downloads/";
		String fileName = "A-large.in.txt";
		String fullFileName = filePath + fileName;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fullFileName));
			String s;
			while ((s = in.readLine()) != null) { 
				inputList1.add(s.trim());
			}
			in.close();
		} catch (IOException e) {
		        System.err.println("Error during input process:"+e); 
		        System.exit(1);
		}
		List<String> inputList = inputList1;
		List<String> outputList = new ArrayList<String>();
		String testCaseResult = "";
		
		int testCount = Integer.valueOf(inputList.get(0));
		int curIdx =1;
		for(int i = 1; i<=testCount;i++){
			String line = inputList.get(curIdx)+" "+inputList.get(curIdx+1);
			curIdx= curIdx+2;
			String answer="";
			 String strArr[] = line.split(" ");
			 int n = Integer.valueOf(strArr[0]);
			 int p[] = new int[n];
			 char pCh[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			 int totalNum = 0;
			 String outP = "";
			 for(int i3 =0; i3<n;i3++){
				 p[i3] = Integer.valueOf(strArr[i3+1]);
				 
			 }
			 //psum
			 for (int i2 : p){
				 totalNum += i2;
			 }
			 //make answer
			 for (int i1=0; i1<totalNum;i1++){
				 int totalNum1=0;
				for (int i3 : p){
					 totalNum1 += i3;
				}
				int curNum = totalNum1;
				int max = p[0];
				int min = p[0];
				int maxIdx = 0;
				for(int i5=1; i5 < p.length ; i5++) {
				
				    if( p[i5] > max ){
				    	max = p[i5];
				    	maxIdx = i5;
				    }
				}
				 int curMaxIdx = maxIdx;
				 if (n >= curNum){
					 int max1 = p[p.length-1];
					int min1 = p[p.length-1];
					int maxIdx1 = p.length-1;
					for(int i5=p.length-2; i5 >=0 ; i5--) {
					    if( p[i5] > max1 ){
					    	max1 = p[i5];
					    	maxIdx1 = i5;
					    }
					}
					curMaxIdx = maxIdx1;
				 }
				 
				 
				 outP += pCh[curMaxIdx];
				 p[curMaxIdx]-- ;
				 
				 if(outP.length() == 2){
					 answer += outP+" ";
					 outP ="";
				 }
				int totalNum2=0;
				for (int i4 : p){
					 totalNum2 += i4;
				}
				 curNum=totalNum2;
				 if(curNum == 2&&(outP.length()!=0)){
					 answer += outP+" ";
					 outP ="";
				 }
			 }
			
			
			 answer=answer.trim();
			testCaseResult = answer;
			outputList.add("Case #"+i+": " + testCaseResult+"\n");
			
			
		}
		String filePath1 = "/Users/zzluck/Downloads/codejamOutput/";
		String fileName1 = "sol1.txt";
		String fullFileName1 = filePath1 + fileName1;
		try{
		    File file = new File(fullFileName1) ;
		    FileWriter fw = new FileWriter(file) ;
		     
		    // 파일안에 문자열 쓰기
		    for(int i=0; i<outputList.size(); i++){
		    	fw.write(outputList.get(i));
		        fw.flush();
		    }
		    // 객체 닫기
		    fw.close(); 
		     
		     
		}catch(Exception e){
		    e.printStackTrace();
		}
	}
}
