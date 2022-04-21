package googlejam6.p351;
import java.util.ArrayList;
import java.util.Scanner;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> hash = new ArrayList<Integer>();
		for(int aux=0;aux<2501;aux++){
			hash.add(0);
		}
		int numCases = input.nextInt();
		for(int n =0;n<numCases;n++){
			
			Integer num = input.nextInt();
			//RESET
			for(int aux=0;aux<2501;aux++){
				hash.set(aux,0);
			}
			for(int i =0;i<num*2-1;i++){
				for(int j =0;j<num;j++){
					Integer numerito = input.nextInt();
					
					hash.set(numerito,hash.get(numerito)+1);
					
				}
			}
			ArrayList<Integer> lista = new ArrayList<Integer>();
			for(int aux=0;aux<2501;aux++){
				if(hash.get(aux) % 2 == 1){
					lista.add(aux);
					
					}
			}
			
			lista.sort(null);
			
			System.out.printf("Case #"+(n+1)+":");
			for (Integer jojo:lista){
				System.out.print(" "+jojo);
			}
			System.out.println();
			}
		
	}

}
