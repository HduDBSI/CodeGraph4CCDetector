package googlejam1.p218;
import java.util.Scanner;


public class MushroomMonster {
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int testCases = reader.nextInt();
		for(int t = 0; t < testCases; t++){
			int size = reader.nextInt();
			int last = 0;
			int first = 0;
			int maxdif = 0;
			int[] stuff = new int[size];
			for(int i = 0; i < size; i++){
				int buff = reader.nextInt();
				stuff[i] = buff;
				if(i == 0){
					last = buff;
				}else{
					int add = last - buff;
					if(add > 0){
						first += add;
						if(add > maxdif){
							maxdif = add;
						}
					}
					last = buff;
				}
			}
			int second = 0;
			for(int i = 0; i < size-1; i++){
				if(stuff[i] > maxdif){
					second += maxdif;
				}else{
					second += stuff[i];
				}
			}
			
			System.out.println("Case #" + (t+1) + ": " + first + " " + second);
		}
		reader.close();
	}

}
