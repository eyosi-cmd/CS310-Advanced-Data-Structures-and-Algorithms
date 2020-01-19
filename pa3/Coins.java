import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
public class Coins {
    private ArrayList<Integer> list;

    private static int min(int a, int c) {
	return (a <= c) ? a : c;
    }
    public int dominations(int goal, int [] coins) {
        list = new  ArrayList<Integer>();
        int M = goal + 1;
        int [] totalCoins = new int[M];
        int [] right = new int[M];
        totalCoins[0] = 0;

        for (int i = 1; i <= goal; i++) {
            totalCoins[i] = Integer.MAX_VALUE - 1;
            right[i] = -1;
        }
        int size = 0;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= goal; i++) {
                if (i >= coins[j] && totalCoins[i - coins[j]] + 1 < totalCoins[i]) {
                        totalCoins[i] = 1 + totalCoins[i - coins[j]];
                        right[i] = j;
                }
            }
          size = right.length - 1;
        }
        int indx = 0;
        for (int i = size; i > 0; i = i - coins[indx]) {
            indx = right[i];
            list.add(coins[indx]);

        }
        return totalCoins[goal];
    }

public static void main(String[] args) throws Exception {
        Coins c = new Coins();
		FileReader txt = null;
		Scanner sc = null;
    if (args.length > 0) {
       txt = new FileReader(args [0]);
	    sc = new Scanner(txt);

    }
    String [] token = new String[2];
        if (sc.hasNextLine()) {
            token[0] = sc.nextLine();
        }
        int goal = 0;
     if (sc.hasNextLine()) {
            goal = Integer.parseInt(token[0]);
           token[1] = sc.nextLine();
     }

    String [] coinString = new String[token[1].length() + 1];
        coinString = token[1].split(" ");
	int [] coinInt = new int[coinString.length];
	for (int i = 0; i < coinString.length; i++) {
	    coinInt[i] = Integer.parseInt(coinString[i]);

    	}
int td = c.dominations(goal, coinInt);
int count = 0;

     Map<Integer, Integer> map = new HashMap<>();
     map.put(c.list.get(0), count);
        System.out.println(goal + ": " + td + " coins");
        for (int i = 0; i < c.list.size(); i++) {

        if (map.containsKey(c.list.get(i))) {  count++; }
        else {
            System.out.println(c.list.get(i - 1) + " * " + count);
            map.put(c.list.get(i), count);
            count = 1;
        }

    }
    System.out.println(c.list.get(c.list.size() - 1) + " * " + count);
}




}