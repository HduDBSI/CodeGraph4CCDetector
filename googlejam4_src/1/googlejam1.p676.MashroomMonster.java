package googlejam1.p676;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class MashroomMonster {
	public static void main(String[] args) {
		MashroomMonster mM = new MashroomMonster();
		try{
			BufferedReader br=new BufferedReader(new FileReader("A-small-attempt0.in"));
			BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));
			String s;
			
			if((s=br.readLine())!=null){
				int noLines = Integer.parseInt(s);
				if(noLines!=0){
					for (int index = 0; index < noLines; index++) {
						if ((s = br.readLine()) != null) {
							String outputString = "Case #" + (index + 1) + ": ";
							String[] tokenizer = s.trim().split(" ");
							if (tokenizer.length == 1) {
								if ((s = br.readLine()) != null) {
									tokenizer = s.trim().split(" ");
									int[] inputArr = new int[tokenizer.length];
									for (int j = 0; j < tokenizer.length; j++) {
										inputArr[j] = Integer.parseInt(tokenizer[j]);
									}
									int retrnNumber = 0;
									for(int i=1;i<inputArr.length;i++){
										if(inputArr[i-1]>inputArr[i]){
											retrnNumber+= inputArr[i-1]-inputArr[i];
										}
									}
									int output1 = retrnNumber;
									int maxDifference=0;
									for(int i=1;i<inputArr.length;i++){
										if(inputArr[i-1]>inputArr[i] && inputArr[i-1]-inputArr[i] > maxDifference){
											maxDifference = inputArr[i-1]-inputArr[i];
										}
									}
									int eatCount=0;
									for(int i=0;i<inputArr.length-1;i++){
										if(inputArr[i]<maxDifference)
											eatCount += inputArr[i];
										else
											eatCount += maxDifference;
									}
									int output2 = eatCount;
									outputString += output1 + " " + output2;
									System.out.println(outputString);
									out.write(outputString);
									out.newLine();
								}
							}
						}
					}
				}
			}
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
