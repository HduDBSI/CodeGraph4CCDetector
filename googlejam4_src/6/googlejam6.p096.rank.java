package googlejam6.p096;
import java.io.*;
import java.util.*;

public class rank {

    public static void main (String[] args) {

	Scanner in = new Scanner(System.in);

	int count = in.nextInt();
	for (int l = 0; l < count; l++) {

	    int n = in.nextInt();

	    int[] array = new int[2501];
	    for (int i = 0; i < 2501; i++) {
		array[i] = 0;
	    }

	    for (int j = 0; j < ((2*n*n)-n); j++) {
		int next = in.nextInt();
		array[next] = array[next]+1;
	    }

	    System.out.print("Case #" + (l+1) + ":");

	    for (int i = 0; i < 2501; i++) {
		if (array[i]%2 == 1)
		    System.out.print(" " + i);
	    }

	    System.out.println();


	}

    }

}
