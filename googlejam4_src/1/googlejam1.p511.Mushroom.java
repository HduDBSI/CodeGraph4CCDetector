package googlejam1.p511;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Mushroom{
	int testNum, n, answer1, answer2, maxGap;
	int[] myList;
	boolean activate;
	public static void main(String[] args){
		try{
			Mushroom myMushroom = new Mushroom();
			int i, j, testcase;
			Integer myInt;
			try{
				Scanner fin = new Scanner(new File("A-large.in"));
				BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));
				myMushroom.testNum = fin.nextInt();
				for (testcase = 1; testcase <= myMushroom.testNum; testcase++){
					myMushroom.n = fin.nextInt();
					myMushroom.myList = new int[myMushroom.n];
					myMushroom.activate = false;
					myMushroom.maxGap = 0;
					for (i = 0; i < myMushroom.n; i++){
						myMushroom.myList[i] = fin.nextInt();
						if (i > 0 && myMushroom.myList[i] < myMushroom.myList[i-1]){
							myMushroom.activate = true;
							if (myMushroom.myList[i-1] - myMushroom.myList[i] > myMushroom.maxGap)
								myMushroom.maxGap = myMushroom.myList[i-1] - myMushroom.myList[i];
						}
					}
					myMushroom.answer1 = myMushroom.answer2 = 0;
					if (!myMushroom.activate){
						myMushroom.answer1 = myMushroom.answer2 = 0;
					}
					else
					{
						for (i = 1; i < myMushroom.n; i++){
							if (myMushroom.myList[i-1] > myMushroom.myList[i]){
								myMushroom.answer1 += (myMushroom.myList[i-1] - myMushroom.myList[i]);
							}
							if (myMushroom.myList[i-1] < myMushroom.maxGap){
								myMushroom.answer2 += myMushroom.myList[i-1];
							}
							else
							{
								myMushroom.answer2 += myMushroom.maxGap;
							}
						}
					}
					myInt = testcase;
					fout.write("Case #"+myInt.toString()+": ");
					myInt = myMushroom.answer1;
					fout.write(myInt.toString()+" ");
					myInt = myMushroom.answer2;
					fout.write(myInt.toString());
					fout.newLine();
				}
				fin.close();
				fout.close();
			}catch (Exception e){
				
			}
		}catch (Exception e){
			
		}
	}
}