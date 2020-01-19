import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import java.util.LinkedList;

public class MoveToFront {
// apply move-to-front encoding, reading from standard input and writing to standard output
   private static int T;
   private LinkedList<Integer> list;

   public static void encode() {
	T = 256;
	MoveToFront ft = new MoveToFront();
	ft.list = new LinkedList<Integer>();

	int count = 0;
	while (count < T) {
		ft.list.add(count);
		count++;
	}
	count = 0;
	String letters = BinaryStdIn.readString();
	char [] ch = letters.toCharArray();
	for (char c : ch) {
		BinaryStdOut.write(ft.list.indexOf((int) c), 8);
		count = ft.list.remove(ft.list.indexOf((int) c));
		ft.list.add(0, count);
	}
	BinaryStdOut.close();
}
// apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
    T = 256;
    MoveToFront ft = new MoveToFront();
	ft.list = new LinkedList<Integer>();
	int count = 0;
	while (count < T) {
		ft.list.add(count);
		count++;
	}
	String letters = BinaryStdIn.readString();
	char[] ch = letters.toCharArray();
        for (count = 0; count < ch.length; count++) {
		int c = ft.list.remove(((int) ch[count]));
            BinaryStdOut.write(c,  8);
            ft.list.add(0, c);
        }
        BinaryStdOut.close();
}
    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
    public static void main(String[] args)
{
	if (args[0].equals("-")) encode();
	if (args[0].equals("+")) decode();
}

}