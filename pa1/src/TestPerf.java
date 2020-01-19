import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.In;

public class TestPerf {
    private static int length, size, times;
    private static String unique;

    // returns the running time of ST
    public static long sttimer(ST<String, Integer> st, String [] texts) {
	Integer count = 1;
	long ti = System.currentTimeMillis();
	for (int i = 0; i < texts.length; i++) {
	    if (!st.contains(texts[i]))
		st.put(texts[i], 1);

	    else {
		count = st.get(texts[i]);
		st.put(texts[i], ++count);

	    }

	}
	long tf = System.currentTimeMillis();
	return tf - ti;
    }
    //returns the running time of Separate Chaining Hash Table
    public static long shstimer(SeparateChainingHashST<String, Integer> shst, String [] texts) {
	Integer count = 1;
	long ti = System.currentTimeMillis();
	for (int i = 0; i < texts.length; i++) {
	    if (shst.contains(texts[i])) {
		count = shst.get(texts[i]);
		shst.put(texts[i], ++count);

	    }

	    else {
		shst.put(texts[i], 1);

	    }

	}
	long tf = System.currentTimeMillis();
	return tf - ti;
    }

    public static long lptimer(LinearProbingHashST<String, Integer> lpst, String [] texts) {
	Integer count = 1;
	long ti = System.currentTimeMillis();
	for (int i = 0; i < texts.length; i++) {
	    if (lpst.contains(texts[i])) {
		count = lpst.get(texts[i]);
		lpst.put(texts[i], ++count);

  }

else {
      lpst.put(texts[i], 1);

    }

 }
long tf = System.currentTimeMillis();
 return tf - ti;
}
public static long sqsttimer(SequentialSearchST<String, Integer> sqst, String [] texts) {
Integer count = 1;
long ti = System.currentTimeMillis();
for (int i = 0; i < texts.length; i++) {
  if (sqst.contains(texts[i])) {
    count = sqst.get(texts[i]);
    sqst.put(texts[i], ++count);

  }

  else {
      sqst.put(texts[i], 1);

    }

 }
long tf = System.currentTimeMillis();
 return tf - ti;
}
public static void setStats(int getLen, int getSize, String getUniq, int getTimes) {

  length = getLen;
  size = getSize;
  unique = getUniq;
  times = getTimes;
}
public static void printStats() {
      System.out.println(length);
      System.out.println(size);
      System.out.println(unique + " " + times);
 }

//Run Test
public static void main(String[] args) {

  LinearProbingHashST<String, Integer> lpst = new LinearProbingHashST<String, Integer>();
  SequentialSearchST<String, Integer> sqst = new SequentialSearchST<String, Integer>();
  ST<String, Integer> st = new ST<String, Integer>();
  SeparateChainingHashST<String, Integer> shst = new SeparateChainingHashST<String, Integer>();
  String [] texts;
  String findT;
  int count;
  In in = new In(args[0]);
  texts = in.readAllStrings();

  System.out.println(sttimer(st, texts));
  System.out.println(shstimer(shst, texts));
  System.out.println(lptimer(lpst, texts));
  System.out.println(sqsttimer(sqst, texts));

  findT = "";
  count = 0;

  for (int i = 0; i < texts.length; i++) {

    if (st.get(texts[i]) > count) {
      findT = texts[i];
      count = st.get(texts[i]);
    }
  }
      setStats(texts.length, st.size(), findT, count);
      printStats();
  }
}