package googlejam7.p171;
import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class A {
	public static void main(String[] args) throws IOException {
    String        pb        = "A";
    Scanner       sc        = new Scanner(new FileReader(new File(pb+".in")));
    PrintWriter   out       = new PrintWriter(new File(pb+".out"));
		StringBuilder resultat  = new StringBuilder("");
		//long time = System.currentTimeMillis();
		
		//TEST CASES----------------------------------------------------
		int TC = sc.nextInt();
		sc.nextLine();
    for (int tc = 1; tc <= TC; tc++) {
      if(tc!=1) resultat.append("\n");
      resultat.append("Case #"+tc+": ");
    
      //READ----------------------------------------------------
      String[] scores = sc.nextLine().split(" ");
      ArrayList<Integer> scoreA = new ArrayList<Integer>();
      ArrayList<Integer> scoreB = new ArrayList<Integer>();
      
      
      String score1 = scores[0];
      ArrayList<String> scoreStrA = new ArrayList<String>();
      scoreStrA.add(score1);
      for (int i = 0; i < score1.length(); i++)
      {
        if(score1.charAt(i)!='?')
          continue;
        ArrayList<String> scoreStrANew = new ArrayList<String>();
        for (int j = 0; j <= 9; j++)
        {
          for (int k = 0; k < scoreStrA.size(); k++)
          {
            scoreStrANew.add(scoreStrA.get(k).substring(0, i)+j+scoreStrA.get(k).substring(i+1));
          }
        }
        scoreStrA = scoreStrANew;
        //System.out.println(scoreStrA);
      }
      
      for (int i = 0; i < scoreStrA.size(); i++)
      {
        scoreA.add(Integer.parseInt(scoreStrA.get(i)));
      }
      
      
      
      
      
      String score2 = scores[1];
      ArrayList<String> scoreStrB = new ArrayList<String>();
      scoreStrB.add(score2);
      for (int i = 0; i < score2.length(); i++)
      {
        if(score2.charAt(i)!='?')
          continue;
        ArrayList<String> scoreStrBNew = new ArrayList<String>();
        for (int j = 0; j <= 9; j++)
        {
          for (int k = 0; k < scoreStrB.size(); k++)
          {
            scoreStrBNew.add(scoreStrB.get(k).substring(0, i)+j+scoreStrB.get(k).substring(i+1));
          }
        }
        scoreStrB = scoreStrBNew;
        //System.out.println(scoreStrB);
      }
      
      
      for (int i = 0; i < scoreStrB.size(); i++)
      {
        scoreB.add(Integer.parseInt(scoreStrB.get(i)));
      }
      
      
      Collections.sort(scoreB);
      Collections.sort(scoreA);
      
      
      int diff = Integer.MAX_VALUE;
      int sb = 0;
      int sa = 0;
      for (int i = 0; i < scoreB.size(); i++)
      {
        for (int j = 0; j < scoreA.size(); j++)
        {
          int d = Math.abs(scoreA.get(j)-scoreB.get(i));
          if(d<diff || 
              (d==diff && (scoreB.get(i)+scoreA.get(j))<(sa+sb)) ||  
              (d==diff && (scoreB.get(i)+scoreA.get(j))==(sa+sb) && scoreB.get(i)<sb )){
            diff = d;
            sa = scoreA.get(j);
            sb = scoreB.get(i);
          }
        }
      }
      
      
      
      
      
			//SOLVE----------------------------------------------------
      String scoreAA = sa+"";
      while(scoreAA.length()<score1.length()){
        scoreAA = "0"+scoreAA;
      }
      
      String scoreBB = sb+"";
      while(scoreBB.length()<score2.length()){
        scoreBB = "0"+scoreBB;
      }
      
      resultat.append(scoreAA+" "+scoreBB);
			
			
      //PRINT--------------------------------------------------
			System.out.println(scoreAA+" "+scoreBB);
			//resultat.append(str);
//			System.out.println("Finished testcase " + tc + ", time = " + (System.currentTimeMillis() - time));
			
		}
		
    //CLOSE----------------------------------------------------
		out.print(resultat);
		out.close(); sc.close();
	}

}