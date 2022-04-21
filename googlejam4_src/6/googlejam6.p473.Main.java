package googlejam6.p473;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//-----------------------------------------------------------
		int casos=Integer.parseInt(br.readLine()), N;
		
		String rta, aux[];
		LinkedList<Integer> soldados=new LinkedList<Integer>(), segunda=new LinkedList<Integer>();
		
		for(int c=1; c<=casos; c++)
		{
			N=Integer.parseInt(br.readLine());
			soldados.clear();
			segunda.clear();
			rta="";
			
			for(int i=0; i<2*N-1; i++)
			{
				aux=br.readLine().split("\\s+");
				for(int j=0; j<N; j++)
					soldados.add(Integer.parseInt(aux[j]));
			}
			
			Collections.sort(soldados);
			while(!soldados.isEmpty())
			{
				int este=soldados.poll();
				if(!soldados.isEmpty())
				{
					int otro=soldados.peek();
					if(este==otro) soldados.poll();
					else segunda.add(este);
				}
				else segunda.add(este);
			}
			
			rta=segunda.toString();
			rta=rta.substring(1, rta.length()-1).replaceAll(",","");
			
			System.out.printf("Case #%d: %s\n", c, rta);
		}
		//-----------------------------------------------------------
		br.close();
	}
}
