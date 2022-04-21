package googlejam9.p151;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class B {

	public static void main(String[] args) {

//		String in = "/Users/Moshin/Code Jam//small.in";
//		String out = "/Users/Moshin/Code Jam/small.out";
		String in = "/Users/Moshin/Code Jam/large.in";
		String out = "/Users/Moshin/Code Jam/large.out";

		try {

			BufferedReader bufferedReader = new BufferedReader(new FileReader(in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out));

			// Total number of test cases
			int noOfTestCases = Integer.valueOf(bufferedReader.readLine());
			
			
		
			for (int t = 0; t < noOfTestCases; t++){
				String bm = bufferedReader.readLine();
				int b = Integer.parseInt(bm.split(" ")[0]);
				long m = Long.parseLong(bm.split(" ")[1]);
				long tempM = m;
				long tempMax;
				String result = "";
				String first = "0";
				
				for(int i=2;i<b;i++){
					result += first;

					for(int j=1;j<b;j++){
						
						if(i<=j)
							result += "1";
						else
							result += "0";
						
					}

					result += "\n";

				}
				for(int j=0;j<b;j++){
					
						result += "0";
					
				}
				
				boolean tempA[]  = new boolean[b-1];
//				for(int i = 0; i < (b-1); i++){
//					tempA[i] = false;
//					
//				}
				long maxPossible = (long) Math.pow(2, (b-2));
				System.out.println("  maxPossible  " + maxPossible);
				if(b == 2 && m == 1){
					
	                bufferedWriter.write("Case #" + (t + 1) + ": " + "POSSIBLE" + "\n");
	                bufferedWriter.write("01" + "\n");
	                bufferedWriter.write("00" + "\n");
	                System.out.println("Case #" + (t + 1) + ": " + "POSSIBLE" + "\n");
	                System.out.println("01" + "\n");
	                System.out.println("00" + "\n");

				}else if(m > maxPossible){
					

	                bufferedWriter.write("Case #" + (t + 1) + ": " + "IMPOSSIBLE" + "\n");
	                System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE" + "\n");
					
				}else{
					
	                bufferedWriter.write("Case #" + (t + 1) + ": " + "POSSIBLE" + "\n");

					tempMax = maxPossible/2;
					for(int i = 0; i < (b-1); i++){
						
						if(tempM == 0)
							break;
						
						if(tempM >= tempMax){
							
							tempA[i] = true;
							tempM -= tempMax;
							
						}
						tempMax /=2;
						
					}
					String tempresult = "0";

					for(int i = 0; i < (b-1); i++){
						if(tempA[i]){
							tempresult = tempresult + "1";
						}else{
							tempresult = tempresult + "0";
						}
						
					}	
					
					result = tempresult + "\n" + result;

					
					System.out.println(result);

	                bufferedWriter.write(result + "\n");

				}


                

            }
                
            bufferedReader.close();
            bufferedWriter.close();

		}catch (Exception exception) {
			
			exception.printStackTrace();
		
		}

	}


}
