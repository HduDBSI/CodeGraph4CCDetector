package googlejam3.p184;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;


public class ASol {


	public static void main(String[] args) {
		
		Date d1 = new Date();
		//solveA("a.in", "a2.out");
		//solveA("A-small-attempt0.in", "A-small-attempt02.out");
		try {
			
			FileWriter fw = new FileWriter("A-large.out");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Scanner sc = new Scanner(new File("A-large.in"));
		
			long t = sc.nextLong();
			sc.nextLine();
			
			//System.out.println(t);
			for (long i2 = 0; i2 < t; i2++) {
				
				int r = sc.nextInt();
				int c = sc.nextInt();
				int w = sc.nextInt();
				int result = w;
				if (w == 1) {
					result = c*r;
				} else {
					result = (c/w)*r+(w-1);
					if (c % w != 0) {
						result += 1;
					}
					
				}
				
		
				
				
				
				
				String rez = ""+result;
				//System.out.println("result: " + rez);
				bw.write("Case #" + (i2+1) + ": " + rez + "\n");
				
			}
			
			
			bw.flush();
			bw.close();
			fw.close();
			sc.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} finally {
			
		}		
		
		Date d2 = new Date();
		System.out.println("time: " + (d2.getTime() - d1.getTime()));
		
		
		
		


	}


	












}
