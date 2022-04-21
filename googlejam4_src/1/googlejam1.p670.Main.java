package googlejam1.p670;


import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "A-large";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;

    public static void main(String args[]) throws Exception {
        Main r = new Main();
		r.out = new PrintStream(new FileOutputStream(Main.OUT));
		int t = r.sc.nextInt();
		
		for (int i = 1; i <= t; i++) 
		{
		    r.out.print("Case #" + i + ": ");
		    int met1 = 0;
			int met2 = 0;
			
			
			int nInter = r.sc.nextInt();
			//int[] diferencias = new int[nInter-1];
			int[] hongos = new int[nInter];
			
			if(nInter>0)
			{
				
				int first = r.sc.nextInt();
				hongos[0] = first;
			    int second = 0;
			    
			    int maxDifer = 0;
			    int difer = 0;
			    
			
			    for (int i1 = 0; i1 < nInter-1; i1++) 
			    {
					second = r.sc.nextInt();
					hongos[i1+1] = second;
					
					if(second < first)
					{
						difer = (first - second);
						//diferencias[i] = difer;
						
						met1 += difer;
						
						if(difer > maxDifer)
						{
							maxDifer = difer;
						}
						
					}
					
					first = second;
				}
			    
			    for (int i2 = 0; i2 < nInter-1; i2++) 
			    {
					if(hongos[i2] < maxDifer)
					{
						met2+=hongos[i2];
					}
					else
					{
						met2+=maxDifer;
					}
					//out.println(diferencias[i]);
				}
			    
			    //out.println(maxDifer);
			
			}
			r.out.println(met1 + " " + met2);
		}
		
		r.sc.close();
		r.out.close();
    }

}