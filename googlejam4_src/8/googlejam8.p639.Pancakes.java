package googlejam8.p639;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Pancakes {
	
	static char giveMeTheOppositePlease(char c){
		if (c == '-')
			return '+';
		return '-';
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("C:\\Users\\Adrien\\eclipseWorkspace\\google\\input.in"));
		FileWriter fileWriter = new FileWriter(new File("C:\\Users\\Adrien\\eclipseWorkspace\\google\\output.out"));
		int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
		  char[] n = in.nextLine().toCharArray();
		  ArrayDeque<Character> pancakeDeque = new ArrayDeque<Character>(), tempDeque = new ArrayDeque<Character>();
		  for (int j = 0; j < n.length; j++) {
			pancakeDeque.addLast(n[j]);
		  }
		  int count = 0;
		  while (pancakeDeque.contains('-')) {
			  count++;
			char charCour = pancakeDeque.removeFirst();
			tempDeque.add(Pancakes.giveMeTheOppositePlease(charCour));
			while (!pancakeDeque.isEmpty() && pancakeDeque.getFirst() == charCour) {
				tempDeque.addLast(Pancakes.giveMeTheOppositePlease(pancakeDeque.removeFirst()));
			}
			while(!tempDeque.isEmpty()){
				pancakeDeque.addFirst(tempDeque.removeFirst());
			}
		  }
		  fileWriter.write("Case #" + i + ": " + count +"\n");
		}
		in.close();
		fileWriter.close();
	}
}
