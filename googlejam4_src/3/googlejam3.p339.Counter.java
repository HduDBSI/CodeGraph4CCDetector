package googlejam3.p339;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Counter {

		List<Integer> cases = new ArrayList<Integer>();
		List<Integer> R =  new ArrayList<Integer>();
		List<Integer> C =  new ArrayList<Integer>();
		List<Integer> W =  new ArrayList<Integer>();
		List<Integer> res =  new ArrayList<Integer>();
		public static void main(String[] args)
		{
			Counter so = new Counter();
			
			//so.readFile("A-large.in");
			Scanner scanner;
			try {
				scanner = new Scanner(new File("A-large.in"));
			
				int testCases = scanner.nextInt();
			
				scanner.nextLine();
				for(int i=0; i<testCases; ++i)
				{
					so.R.add(scanner.nextInt());
					so.C.add(scanner.nextInt());
					so.W.add(scanner.nextInt());
					
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			for(int i1=0; i1<so.W.size(); ++i1)
			{
				int w = so.W.get(i1);
				int r = so.R.get(i1);
				int c = so.C.get(i1);
				
				int val;
				
				int valami;
				int utolso;
				
				if(c%w == 0)
				{
					valami = 0;
					utolso = 0;
				} else 
				{
					valami = 2*w - (w-1+1+(c%w))+1;
					//utolso = valami + (w-valami)-1;
					utolso = 1;
				}
				
				//System.out.println("valami: " + valami);
				//System.out.println("utolso: " + utolso);
				
				if(c*r==w)
				{
					val = w;
					so.res.add(val);
					continue;
				}
						
				if(r==1){
					val = (int) ((Math.floor(c / w) + (w -1))) + utolso; 
					so.res.add(val);
					continue;
				}
				
				if(r>1){
					val = (int) ((r-1) * (Math.floor(c / w))) + (int)(Math.floor(c / w) +  (w -1)) + utolso; 
					
					so.res.add(val);
					continue;
				}
				
			}
			
			PrintWriter writer;
			try {
				writer = new PrintWriter("A-large.out");
				
				int counter = 0;
				for(int i=0; i<so.res.size();++i)
				{
					writer.print("Case #" + (++counter) + ": " + so.res.get(i));
					if(counter<so.res.size())
					{
						writer.println();
					}
				}
				
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

}
