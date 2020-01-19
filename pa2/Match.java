
public class Match {
// return the min of 3 integers
private static int min(int a, int b, int c) {
	int min1 = ((a <= b) ? a : b);
	return (min1 <= c) ? min1 : c;
}
public Path match(String a, String b) {
		int subsol1, subsol2, subsol3;
		int M = a.length();
		int N = b.length();
		Path[][] opt = new Path[M + 1][N + 1];

		for (int i = 0; i <= M; i++) {
			for (int j = 0; j <= N; j++) {
			opt[i][j] = new Path(i, j);
				opt[i][j].setRow(i);
				opt[i][j].setCol(j);
				if (i < M && j < N) {
                opt[i][j].setCharA(a.charAt(i));
                opt[i][j].setCharB(b.charAt(j));

				}
			}
		}

		opt[M][N].setCost(0);
		opt[M][N].setPath(null);
		int min = 0;


		 for (int i = M - 1; i >= 0; i--) {

			opt[i][N].setCost(opt[i + 1][N].getCost() + 2);
			for (int j = N - 1; j >= 0; j--) {
				opt[M][j].setCost(opt[M][j + 1].getCost() + 2);
				int zero = (opt[i + 1][j + 1].getCost() + 0);
				int one = (opt[i + 1][j + 1].getCost() + 1);

			if (opt[i][j].getCharA() == opt[i][j].getCharB()) subsol1 = zero;
			else  subsol1 = one;
			subsol2 = opt[i + 1][j].getCost() + 2;
            subsol3 = opt[i][j + 1].getCost() + 2;
            opt[i][j].setCost(min(subsol1, subsol2, subsol3));
            min = opt[i][j].getCost();
            if (min == subsol1) {
                opt[i][j].setPath(opt[i + 1][j + 1]);
					continue;
            }
        	if (min == subsol2) {
                opt[i][j].setPath(opt[i + 1][j]);
            		 continue;

            }
			if (min == subsol3) {
                opt[i][j].setPath(opt[i][j + 1]);
            }
		}
   }

		return opt[0][0];
}
static void main(String[] args) {
		Match m = new Match();
          Path path = m.match("AACAGTTACC", "TAAGGTCA");
          for (Path p = path; p != null; p = p.getPath())
              System.out.println(p.getRow() + " " + p.getCol());
  }

}