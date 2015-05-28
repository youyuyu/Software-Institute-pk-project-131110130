package ChineseChess;
//人机对战AI设计模块
import javax.swing.JOptionPane;

public class AI {
	static String[][] man = new String[10][9];
	static char turn = Control.turn;
	static int noteoldi = 0;
	static int noteoldj = 0;
	static int notei = 0;
	static int notej = 0;
	static int treedepth;
	static boolean gameOver = false;
	static int num = 0;
	static boolean game=false;

	public static void AI(CheseMan[][] cheseman) {

		for (int i = 0; i < man.length; i++) {
			for (int j = 0; j < man[i].length; j++) {
				man[i][j] = cheseman[i][j].getCheseman();
				if (!man[i][j].contentEquals("kkk")) {
					num = num + 1;
				}
			}
		}

		
		if (num < 26) {
			long time = System.currentTimeMillis();
			for (treedepth = 2;; treedepth = treedepth + 1) {
				AlphaBeta(treedepth, -99999, 99999);
				if (System.currentTimeMillis() - time > 6000) {
					System.out.println(treedepth);
					break;
				}
			}
		} else {
			treedepth = 4;
			AlphaBeta(treedepth, -99999, 99999);
		}
		num = 0;
		if (cheseman[notei][notej].getCheseman().toCharArray()[1] == 'b') {
			gameOver = true;
		}
		cheseman[notei][notej].setCheseman(cheseman[noteoldi][noteoldj]
				.getCheseman());

		cheseman[notei][notej].setIsman(true);
		cheseman[notei][notej].repaint();
		cheseman[noteoldi][noteoldj].setCheseman("kkk");
		cheseman[noteoldi][noteoldj].setIsman(false);
		cheseman[noteoldi][noteoldj].repaint();
		if (gameOver) {
			JOptionPane.showMessageDialog(null, "AI WIN!!");
		}

	}

	static int[][] c = { { 206, 208, 207, 213, 214, 213, 207, 208, 206 },
			{ 206, 212, 209, 216, 233, 216, 209, 212, 206 },
			{ 206, 208, 207, 214, 216, 214, 207, 208, 206 },
			{ 206, 213, 213, 216, 216, 216, 213, 213, 206 },
			{ 208, 211, 211, 214, 215, 214, 211, 211, 208 },

			{ 208, 212, 212, 214, 215, 214, 212, 212, 208 },
			{ 204, 209, 204, 212, 214, 212, 204, 209, 204 },
			{ 198, 208, 204, 212, 212, 212, 204, 208, 198 },
			{ 200, 208, 206, 212, 200, 212, 206, 208, 200 },
			{ 194, 206, 204, 212, 200, 212, 204, 206, 194 } };
	static int[][] m = { { 90, 90, 90, 96, 90, 96, 90, 90, 90 },
			{ 90, 96, 103, 97, 94, 97, 103, 96, 90 },
			{ 92, 98, 99, 103, 99, 103, 99, 98, 92 },
			{ 93, 108, 100, 107, 100, 107, 100, 108, 93 },
			{ 90, 100, 99, 103, 104, 103, 99, 100, 90 },

			{ 90, 98, 101, 102, 103, 102, 101, 98, 90 },
			{ 92, 94, 98, 95, 98, 95, 98, 94, 92 },
			{ 93, 92, 94, 95, 92, 95, 94, 92, 93 },
			{ 85, 90, 92, 93, 78, 93, 92, 90, 85 },
			{ 88, 85, 90, 88, 90, 88, 90, 85, 88 } };
	static int[][] p = { { 100, 100, 96, 91, 90, 91, 96, 100, 100 },
			{ 98, 98, 96, 92, 89, 92, 96, 98, 98 },
			{ 97, 97, 96, 91, 92, 91, 96, 97, 97 },
			{ 96, 99, 99, 98, 100, 98, 99, 99, 96 },
			{ 96, 96, 96, 96, 100, 96, 96, 96, 96 },

			{ 95, 96, 99, 96, 100, 96, 99, 96, 95 },
			{ 96, 96, 96, 96, 96, 96, 96, 96, 96 },
			{ 97, 96, 100, 99, 101, 99, 100, 96, 97 },
			{ 96, 97, 98, 98, 98, 98, 98, 97, 96 },
			{ 96, 96, 97, 99, 99, 99, 97, 96, 96 } };
	static int[][] x = { { 0, 0, 20, 0, 0, 0, 20, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 23, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 20, 0, 0, 0, 20, 0, 0 },

			{ 0, 0, 20, 0, 0, 0, 20, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 18, 0, 0, 0, 23, 0, 0, 0, 18 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 20, 0, 0, 0, 20, 0, 0 } };
	static int[][] s = { { 0, 0, 0, 20, 0, 20, 0, 0, 0 },
			{ 0, 0, 0, 0, 23, 0, 0, 0, 0 }, { 0, 0, 0, 20, 0, 20, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 20, 0, 20, 0, 0, 0 }, { 0, 0, 0, 0, 23, 0, 0, 0, 0 },
			{ 0, 0, 0, 20, 0, 20, 0, 0, 0 } };
	static int[][] b = { { 0, 0, 0, 8884, 8888, 8884, 0, 0, 0 },
			{ 0, 0, 0, 8873, 8873, 8873, 0, 0, 0 }, { 0, 0, 0, 8872, 8872, 8872, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 8872, 8872, 8872, 0, 0, 0 },
			{ 0, 0, 0, 8873, 8873, 8873, 0, 0, 0 },
			{ 0, 0, 0, 8884, 8888, 8884, 0, 0, 0 } };
	static int[][] z = { { 9, 9, 9, 11, 13, 11, 9, 9, 9 },
			{ 19, 24, 34, 42, 44, 42, 34, 24, 19 },
			{ 19, 24, 32, 37, 37, 37, 32, 24, 19 },
			{ 19, 23, 27, 29, 30, 29, 27, 23, 19 },
			{ 14, 18, 20, 27, 29, 27, 20, 18, 14 },

			{ 7, 0, 13, 0, 16, 0, 13, 0, 7 }, { 7, 0, 7, 0, 15, 0, 7, 0, 7 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	private static int value() {
		int val = 0;
		int red = 0;
		int black = 0;
		for (int i = 0; i < man.length; i++) {
			for (int j = 0; j < man[i].length; j++) {
				if (man[i][j].toCharArray()[0] == 'r') {
					if (man[i][j].toCharArray()[1] == 'c') {
						red = red + c[9 - i][8 - j];
					} else if (man[i][j].toCharArray()[1] == 'm') {
						red = red + m[9 - i][8 - j];
					} else if (man[i][j].toCharArray()[1] == 'p') {
						red = red + p[9 - i][8 - j];
					} else if (man[i][j].toCharArray()[1] == 'x') {
						red = red + x[9 - i][8 - j];
					} else if (man[i][j].toCharArray()[1] == 's') {
						red = red + s[9 - i][8 - j];
					} else if (man[i][j].toCharArray()[1] == 'b') {
						red = red + b[9 - i][8 - j];
					} else if (man[i][j].toCharArray()[1] == 'z') {
						red = red + z[9 - i][8 - j];
					}
				} else if (man[i][j].toCharArray()[0] == 'b') {
					if (man[i][j].toCharArray()[1] == 'c') {
						black = black + c[i][j];
					} else if (man[i][j].toCharArray()[1] == 'm') {
						black = black + m[i][j];
					} else if (man[i][j].toCharArray()[1] == 'p') {
						black = black + p[i][j];
					} else if (man[i][j].toCharArray()[1] == 'x') {
						black = black + x[i][j];
					} else if (man[i][j].toCharArray()[1] == 's') {
						black = black + s[i][j];
					} else if (man[i][j].toCharArray()[1] == 'b') {
						black = black + b[i][j];
					} else if (man[i][j].toCharArray()[1] == 'z') {
						black = black + z[i][j];
					}
				}
			}
		}

		val = red - black;
		return val;
	}

	private static int AlphaBeta(int depth, int alpha, int beta) {

		if (depth == 0||game) {
			game=false;
			return value();
			
		}

		for (int oldi = 0; oldi < man.length; oldi++) {
			for (int oldj = 0; oldj < man[oldi].length; oldj++) {

				for (int i = 0; i < man.length; i++) {
					for (int j = 0; j < man[i].length; j++) {
						if (canMove(oldi, oldj, i, j)) {
							if(man[i][j].toCharArray()[1]=='b'){
								game=true;
							}
							String newman = man[i][j];
							move(oldi, oldj, i, j);
							changeTurn();
							int val = -AlphaBeta(depth - 1, -beta, -alpha);
							unMove(newman, oldi, oldj, i, j);
							changeTurn();
							if (val >= beta) {
								return beta;

							}
							if (val > alpha) {

								alpha = val;

								if (treedepth == depth) {

									noteoldi = oldi;
									noteoldj = oldj;
									notei = i;
									notej = j;

								}
							}

						}
					}

				}

			}
		}
		return alpha;

	}

	private static void move(int oldi, int oldj, int i, int j) {

		man[i][j] = man[oldi][oldj];
		man[oldi][oldj] = "kkk";

	}

	private static void unMove(String newman, int oldi, int oldj, int i, int j) {
		man[oldi][oldj] = man[i][j];
		man[i][j] = newman;
	}

	/*
	 * private static boolean IsGameOver(int notei,int notej) {
	 * 
	 * return false; }
	 */

	private static boolean canMove(int oldi, int oldj, int newi, int newj) {
		char[] chese = man[oldi][oldj].toCharArray();
		boolean move = false;
		if (chese[1] == 'j') {
			int k = 0;
			if (oldi == newi) {
				if (newj > oldj) {
					for (int i = oldj + 1; i < newj; i++) {
						if (man[oldi][i].toCharArray()[0] != 'k') {
							k++;
						}
					}
				} else if (newj < oldj) {
					for (int i = newj + 1; i < oldj; i++) {
						if (man[oldi][i].toCharArray()[0] != 'k') {
							k++;
						}
					}
				} else if (oldj == newj) {
					k++;
				}
				if (k == 0) {
					move = true;
					if (chese[0] == man[newi][newj].toCharArray()[0]) {
						move = false;
					}
				}
			} else if (oldj == newj) {
				if (newi > oldi) {
					for (int i = oldi + 1; i < newi; i++) {
						if (man[i][oldj].toCharArray()[0] != 'k') {
							k++;
						}
					}
				} else if (newi < oldi) {
					for (int i = newi + 1; i < oldi; i++) {
						if (man[i][oldj].toCharArray()[0] != 'k') {
							k++;
						}
					}
				} else if (oldi == newi) {
					k++;
				}
				if (k == 0) {
					move = true;
					if (chese[0] == man[newi][newj].toCharArray()[0]) {
						move = false;
					}
				}
			}
		}
		if (chese[1] == 'm') {
			if ((newi - oldi) == 1 && (newj - oldj) == -2
					&& !(man[oldi][oldj - 1].toCharArray()[0] != 'k')) {
				move = true;
			} else if ((newi - oldi) == 1 && (newj - oldj) == 2
					&& !(man[oldi][oldj + 1].toCharArray()[0] != 'k')) {
				move = true;
			} else if ((newi - oldi) == -1 && (newj - oldj) == -2
					&& !(man[oldi][oldj - 1].toCharArray()[0] != 'k')) {
				move = true;
			} else if ((newi - oldi) == -1 && (newj - oldj) == 2
					&& !(man[oldi][oldj + 1].toCharArray()[0] != 'k')) {
				move = true;
			} else if ((newi - oldi) == 2 && (newj - oldj) == -1
					&& !(man[oldi + 1][oldj].toCharArray()[0] != 'k')) {
				move = true;
			} else if ((newi - oldi) == 2 && (newj - oldj) == 1
					&& !(man[oldi + 1][oldj].toCharArray()[0] != 'k')) {
				move = true;
			} else if ((newi - oldi) == -2 && (newj - oldj) == -1
					&& !(man[oldi - 1][oldj].toCharArray()[0] != 'k')) {
				move = true;
			} else if ((newi - oldi) == -2 && (newj - oldj) == 1
					&& !(man[oldi - 1][oldj].toCharArray()[0] != 'k')) {
				move = true;
			}
			if (move && man[newi][newj].toCharArray()[0] == chese[0]) {
				move = false;
			}
		}
		if (chese[1] == 'p') {
			int k = 0;
			if (oldi == newi) {
				if (newj > oldj) {
					for (int i = oldj + 1; i < newj; i++) {
						if (man[oldi][i].toCharArray()[0] != 'k') {
							k++;
						}
					}
				} else if (newj < oldj) {
					for (int i = newj + 1; i < oldj; i++) {
						if (man[oldi][i].toCharArray()[0] != 'k') {
							k++;
						}
					}
				} else if (oldj == newj) {
					k++;
				}
				if (k == 0 && man[newi][newj].contentEquals("kkk")) {
					move = true;
				} else if (k == 1
						&& chese[0] != man[newi][newj].toCharArray()[0]
						&& man[newi][newj].toCharArray()[0] != 'k') {
					move = true;
				}
			} else if (oldj == newj) {
				if (newi > oldi) {
					for (int i = oldi + 1; i < newi; i++) {
						if (man[i][oldj].toCharArray()[0] != 'k') {
							k++;
						}
					}
				} else if (newi < oldi) {
					for (int i = newi + 1; i < oldi; i++) {
						if (man[i][oldj].toCharArray()[0] != 'k') {
							k++;
						}
					}
				}

				if (k == 0 && man[newi][newj].contentEquals("kkk")) {
					move = true;
				} else if (k == 1
						&& chese[0] != man[newi][newj].toCharArray()[0]
						&& man[newi][newj].toCharArray()[0] != 'k') {
					move = true;
				}
			}
		}
		if (chese[1] == 'x') {

			if (chese[0] == 'b' && newi > 4) {

				if ((newi - oldi) == 2 && (newj - oldj) == 2
						&& man[oldi + 1][oldj + 1].toCharArray()[0] == 'k') {
					move = true;
				} else if ((newi - oldi) == 2 && (newj - oldj) == -2
						&& man[oldi + 1][oldj - 1].toCharArray()[0] == 'k') {
					move = true;

				} else if ((newi - oldi) == -2 && (newj - oldj) == -2
						&& man[oldi - 1][oldj - 1].toCharArray()[0] == 'k') {
					move = true;

				} else if ((newi - oldi) == -2 && (newj - oldj) == 2
						&& man[oldi - 1][oldj + 1].toCharArray()[0] == 'k') {
					move = true;
				}
			} else if (chese[0] == 'r' && newi <= 4) {
				if ((newi - oldi) == 2 && (newj - oldj) == 2
						&& man[oldi + 1][oldj + 1].toCharArray()[0] == 'k') {
					move = true;
				} else if ((newi - oldi) == 2 && (newj - oldj) == -2
						&& man[oldi + 1][oldj - 1].toCharArray()[0] == 'k') {
					move = true;
				} else if ((newi - oldi) == -2 && (newj - oldj) == -2
						&& man[oldi - 1][oldj - 1].toCharArray()[0] == 'k') {
					move = true;

				} else if ((newi - oldi) == -2 && (newj - oldj) == 2
						&& man[oldi - 1][oldj + 1].toCharArray()[0] == 'k') {
					move = true;
				}
			}

			if (move && man[newi][newj].toCharArray()[0] == chese[0]) {
				move = false;
			}
		}
		if (chese[1] == 's') {
			if (chese[0] == 'b' && newi >= 7 && newi <= 9 && newj >= 3
					&& newj <= 5) {
				if (Math.abs(newi - oldi) == 1 && Math.abs(newj - oldj) == 1) {
					move = true;
				}
			} else if (chese[0] == 'r' && newi >= 0 && newi <= 2 && newj >= 3
					&& newj <= 5) {
				if (Math.abs(newi - oldi) == 1 && Math.abs(newj - oldj) == 1) {
					move = true;
				}
			}
			if (move && chese[0] == man[newi][newj].toCharArray()[0]) {
				move = false;
			}
		}
		if (chese[1] == 'b') {
			int k=0;
			
			if (chese[0] == 'b' && newi >= 7 && newi <= 9 && newj >= 3
					&& newj <= 5) {
				if ((oldi == newi && Math.abs(newj - oldj) == 1)
						|| (oldj == newj && Math.abs(newi - oldi) == 1)) {
					move = true;
				}
			} else if (chese[0] == 'r' && newi >= 0 && newi <= 2 && newj >= 3
					&& newj <= 5) {
				if ((oldi == newi && Math.abs(newj - oldj) == 1)
						|| (oldj == newj && Math.abs(newi - oldi) == 1)) {
					move = true;
				}
			}
			if (move && chese[0] == man[newi][newj].toCharArray()[0]) {
				move = false;
			}
			if(newj==oldj&&man[newi][newj].toCharArray()[1]=='b'&&man[newi][newj].toCharArray()[0]!=chese[0]){
				if(newi>oldi){
					for(int i=oldi+1;i<newi;i++){
						if(!man[i][newj].contentEquals("kkk")){
							k++;
						}
					}
				}else if(newi<oldi){
					for(int i=newi+1;i<oldi;i++){
						if(!man[i][newj].contentEquals("kkk")){
							k++;
						}
					}
				}
				if(k==0){
					move=true;
				}
			}
		}
		if (chese[1] == 'z') {

			if (chese[0] == 'b') {
				if ((newi - oldi) == -1 && newj == oldj && oldi > 4) {
					move = true;

				} else if (oldi == newi && Math.abs(newj - oldj) == 1
						&& oldi <= 4) {
					move = true;

				} else if (oldj == newj && (newi - oldi) == -1 && oldi <= 4) {
					move = true;
				}

			} else if (chese[0] == 'r') {
				if ((newi - oldi) == 1 && newj == oldj && oldi <= 4) {
					move = true;

				} else if (oldi == newi && Math.abs(oldj - newj) == 1
						&& oldi > 4) {
					move = true;

				} else if (oldj == newj && (newi - oldi) == 1 && oldi > 4) {
					move = true;

				}
			}
			if (move && chese[0] == man[newi][newj].toCharArray()[0]) {
				move = false;
			}
		}
		if (chese[0] != turn) {
			move = false;
		}
		return move;
	}

	public static void changeTurn() {
		if (turn == 'b') {
			turn = 'r';
		} else if (turn == 'r') {
			turn = 'b';
		}
	}

	public static boolean isMan(String man) {
		if (man.toCharArray()[0] != 'k') {
			return true;
		} else {
			return false;
		}
	}

}
