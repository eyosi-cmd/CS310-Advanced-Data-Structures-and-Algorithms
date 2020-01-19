
import java.util.Scanner;
import java.io.FileReader;
public class EditDistance {
public static void main(String[] args) throws Exception {
String [] token = new String[2];

		int i = 0;
		 FileReader txt = null;
		Scanner sc = null;
    if (args.length > 0) {
       txt = new FileReader(args [0]);
	    sc =	new Scanner(txt);

    }

    while (sc.hasNextLine())
		{
           token[i] = sc.nextLine();
           i++;
		}

		sc.close();
        Match s = new Match();
        int min = 0;
        int s1 = token[0].length();
        int s2 = token[1].length();
        Path path = s.match(token[0].substring(0, s1), token[1].substring(0, s2));
		System.out.println("Edit Distance " + path.getCost());
	while (path.getPath() != null) {
			System.out.print(token[0].charAt(path.getRow()) + " ");
		   if (path.getCol() == path.getPath().getCol())
		            System.out.print("-" + " ");
		      else
		        System.out.print(token[1].charAt(path.getCol()) + " ");
                min = path.getCost() - path.getPath().getCost();
			System.out.println(min);
		path = path.getPath();
	}
    }
}