package googlejam8.p213;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SenateEvacuation {

	static PrintWriter writer;
	
	public static void main(String[] args) throws IOException {
		
		writer = new PrintWriter("out.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("A-large (1).in"));
			String line = br.readLine();
		    int Num = Integer.parseInt(line);
		    for(int i = 0; i < Num; ++i) {
		    	line = br.readLine();
		    	int party = Integer.parseInt(line);
		    	line = br.readLine();
		    	String bufs[] = line.split(" ");
		    	int[] sena = new int[30];
		    	for(int j = 0; j < party; ++j){
		    		sena[j] = Integer.parseInt(bufs[j]);
		    	}
		    	
		    	String output = "";
		    	
		    	while(true) {
		    		int min = -1;
					int index1 = -1;
					int count = 0;
					int another1 = -1;
					for(int i1 = 0; i1 < party; ++i1) {
						if(sena[i1] > 0 &&(min == -1 || sena[i1] > min)) {
							min = sena[i1];
							index1 = i1;
							count = 1;
							another1 = -1;
						}
						else if(sena[i1] > 0 &&(min == -1 || sena[i1] == min)){
							count ++;
							another1 = i1;
						}
					}
					
					if(count == 2 && another1 > -1) {
						index1 += another1 * 100;
					}
					int index =  index1;
		    		if(index == -1) {
		    			break;
		    		}
		    		if(index < 30) { 
			    		sena[index] --;
			    		char a = (char) (index + 'A');
			    		output += (a + " ");
		    		}
		    		else {
		    			int another = index / 100;
		    			index = index % 100;

			    		sena[index] --;
			    		char a = (char) (index + 'A');
			    		char s = (char) (another + 'A');
			    		output += a;
			    		output += (s+ " ");
			    		sena[another] --;
		    		}
		    	}
		    	writer.println("Case #" + (i + 1) + ": " + output);
		    }
		} finally {
		    br.close();
			writer.close();
		}
	}
	
}
