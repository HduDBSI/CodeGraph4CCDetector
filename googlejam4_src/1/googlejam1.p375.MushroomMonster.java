package googlejam1.p375;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MushroomMonster {

	private static final String FILES_PATH = "E:\\DL\\gcj\\2015\\round1A\\";
	private static final String IN_EXT = ".in";
	private static final String OUT_EXT = ".out";
	
	private static final String FILE_NAME = "A-large";

	public static void main(String[] args) throws IOException {
		
		 Scanner in = new Scanner(new File(FILES_PATH + FILE_NAME + IN_EXT));
		 FileWriter fw = new FileWriter(new File(FILES_PATH + FILE_NAME + OUT_EXT));
		 
		 int nbTests = in.nextInt();
		 in.nextLine();
		 
		 int nbEtapes, rate, nbM1, nbM2;
		 int[] tab;
		 
		 for(int i = 0; i < nbTests; i++) {
			 
			 nbEtapes = in.nextInt();
			 in.nextLine();
			 
			 tab = new int[nbEtapes];
			 nbM1 = 0;
			 nbM2 = 0;
			 
			 rate = 0;
			 
			 for(int j = 0; j < nbEtapes; j++) {
				 tab[j] = in.nextInt();
			 }
			 
			 for(int j = 0; j < nbEtapes - 1; j++) {
				 rate = Math.max(rate, tab[j] - tab[j + 1]);
			 }
			 
			 for(int j = 1; j < nbEtapes; j++) {
				 if(tab[j] < tab[j - 1]) {
					 nbM1 += tab[j - 1] - tab[j];
				 }
				 nbM2 += Math.min(rate, tab[j - 1]);
			 }
			 
			 fw.write("Case #" + (i+1) + ": " + nbM1 + " " + nbM2 + "\n");
			 in.nextLine();
		 }
		
		 fw.close();
		 in.close();
		 
	}
	
}
