package googlejam3.p259;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class A {

    private static final String PATH_INPUT = "src/main/resources/input/A-large.in";

    private static final String PATH_OUTPUT = "src/main/resources/output/A-large.out";

    public static void main(String[] args) throws IOException {
	List<String> tokens1 = new ArrayList<>();
		
		try (BufferedReader reader = Files.newBufferedReader(Paths
		        .get(PATH_INPUT))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
			for (String token : line.split("\\s")) {
			    if (!token.isEmpty()) {
				tokens1.add(token);
			    }
			}
		    }
		}
	List<String> tokens = tokens1;

	int t = Integer.valueOf(tokens.remove(0));
	for (int i = 0; i < t; i++) {
	    long r = Long.valueOf(tokens.remove(0));
	    long c = Long.valueOf(tokens.remove(0));
	    long w = Long.valueOf(tokens.remove(0));

	    long res = (c / w) * r;
	    if (c % w == 0) {
		res += w - 1;
	    } else {
		res += w;
	    }
	    tokens.add("" + res);
	}

	try (BufferedWriter writer = Files.newBufferedWriter(Paths
	        .get(PATH_OUTPUT))) {
	    for (int i = 0; i < tokens.size(); i++) {
		writer.write("Case #" + (i + 1) + ": " + tokens.get(i));
		if (i < tokens.size() - 1) {
		    writer.newLine();
		}
	    }
	}

	System.out.println("Done");
    }
}
