package googlejam8.p833;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Main {
	static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("A.in"));
		FileWriter fw = new FileWriter("A.out");
		int testCaseCount = Integer.parseInt(in.readLine());
		for(int i=0;i<testCaseCount;i++){
			int numberOfParties = Integer.parseInt(in.readLine());
			int totalNumOfSenators = 0;
			String senatorCountStr = in.readLine();
			ArrayList<Integer> senetorCount = new ArrayList<Integer>();

			String[] elements = senatorCountStr.split("\\s+");
			for(int j = 0;j<elements.length;j++){
				int count = Integer.parseInt(elements[j]);
				senetorCount.add(count);
				totalNumOfSenators += count;
			}
			String runners = "";

			while (totalNumOfSenators > 0){
				for(int j = 0;j<2;j++){
					boolean done = false;
					for(int k = 0;k<numberOfParties;k++){
						if(done){
							continue;
						}
						for(int l = 0;l<numberOfParties;l++){
							if(k == l){
								continue;
							}else{
								if(senetorCount.get(k) <= 0 || (totalNumOfSenators > 1 && ((1 == j && senetorCount.get(l)*2 > totalNumOfSenators-1) ||(0 == j && (senetorCount.get(l)-1)*2 > totalNumOfSenators-2)))){

								} else{
									boolean ok = true;
									for(int m = 0;m<numberOfParties;m++){
										if(m == k){
											continue;
										}
										boolean spentNext = false;
										if(totalNumOfSenators > 1){
											if((1 == j && senetorCount.get(m)*2 <= totalNumOfSenators-1)){

											} else if(0 == j && (!spentNext || (senetorCount.get(m))*2 <= totalNumOfSenators-1)){
												if((senetorCount.get(m))*2 <= totalNumOfSenators-1){

												} else if ((senetorCount.get(m)-1)*2 <= totalNumOfSenators-2){
													spentNext = true;
												}

											} else{
												ok = false;
												break;
											}

										} 
									}
									if(ok){
										runners += String.valueOf(alphabet[k]);
										senetorCount.set(k, senetorCount.get(k)-1);
										totalNumOfSenators--;
										done = true;
									}

								}
								break;
							}
						}
					}
				}
				if(!runners.isEmpty()){
					runners += " ";
				}
			}
			fw.write("Case #"+(i+1)+": "+runners+"\n");


		}
		in.close();
		fw.close();
	}

}
