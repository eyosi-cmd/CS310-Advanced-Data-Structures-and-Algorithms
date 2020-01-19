
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
		System.out.println("Edit Distance " + path.cost);
		while (path.next != null) {
			System.out.print(token[0].charAt(path.row) + " ");
		   if (path.col == path.next.col)
		            System.out.print("-" + " ");
		      else
		        System.out.print(token[1].charAt(path.col) + " ");
                min = path.cost - path.next.cost;
			System.out.println(min);
			path = path.next;
		}
    }
}