package ChineseChess;
//规范象棋规则模块
public class Control {
	public static char turn = 'b';

	public static boolean canMove(CheseMan[][] cheseman, int oldi, int oldj,
			int newi, int newj) {
		boolean move = false;
		CheseMan man = cheseman[oldi][oldj];
		char[] chese = man.getCheseman().toCharArray();
		if (chese[1] == 'j') {
			int k = 0;
			if (oldi == newi) {
				if (newj > oldj) {
					for (int i = oldj + 1; i < newj; i++) {
						if (cheseman[oldi][i].isIsman()) {
							k++;
						}
					}
				} else if (newj < oldj) {
					for (int i = newj + 1; i < oldj; i++) {
						if (cheseman[oldi][i].isIsman()) {
							k++;
						}
					}
				} else if (oldj == newj) {
					k++;
				}
				if (k == 0) {
					move = true;
					if (chese[0] == cheseman[newi][newj].getCheseman()
							.toCharArray()[0]) {
						move = false;
					}
				}
			} else if (oldj == newj) {
				if (newi > oldi) {
					for (int i = oldi + 1; i < newi; i++) {
						if (cheseman[i][oldj].isIsman()) {
							k++;
						}
					}
				} else if (newi < oldi) {
					for (int i = newi + 1; i < oldi; i++) {
						if (cheseman[i][oldj].isIsman()) {
							k++;
						}
					}
				} else if (oldi == newi) {
					k++;
				}
				if (k == 0) {
					move = true;
					if (chese[0] == cheseman[newi][newj].getCheseman()
							.toCharArray()[0]) {
						move = false;
					}
				}
			}
		}
		if (chese[1] == 'm') {
			if ((newi - oldi) == 1 && (newj - oldj) == -2
					&& !cheseman[oldi][oldj - 1].isIsman()) {
				move = true;
			} else if ((newi - oldi) == 1 && (newj - oldj) == 2
					&& !cheseman[oldi][oldj + 1].isIsman()) {
				move = true;
			} else if ((newi - oldi) == -1 && (newj - oldj) == -2
					&& !cheseman[oldi][oldj - 1].isIsman()) {
				move = true;
			} else if ((newi - oldi) == -1 && (newj - oldj) == 2
					&& !cheseman[oldi][oldj + 1].isIsman()) {
				move = true;
			} else if ((newi - oldi) == 2 && (newj - oldj) == -1
					&& !cheseman[oldi + 1][oldj].isIsman()) {
				move = true;
			} else if ((newi - oldi) == 2 && (newj - oldj) == 1
					&& !cheseman[oldi + 1][oldj].isIsman()) {
				move = true;
			} else if ((newi - oldi) == -2 && (newj - oldj) == -1
					&& !cheseman[oldi - 1][oldj].isIsman()) {
				move = true;
			} else if ((newi - oldi) == -2 && (newj - oldj) == 1
					&& !cheseman[oldi - 1][oldj].isIsman()) {
				move = true;
			}
			if (move
					&& cheseman[newi][newj].getCheseman().toCharArray()[0] == chese[0]) {
				move = false;
			}
		}
		if (chese[1] == 'p') {
			int k = 0;
			if (oldi == newi) {
				if (newj > oldj) {

					for (int i = oldj + 1; i < newj; i++) {
						if (cheseman[oldi][i].isIsman()) {
							k++;
						}
					}
				} else if (newj < oldj) {
					for (int i = newj + 1; i < oldj; i++) {
						if (cheseman[oldi][i].isIsman()) {
							k++;
						}
					}
				} else if (oldj == newj) {
					k++;
				}
				if (k == 0
						&& cheseman[newi][newj].getCheseman().contentEquals(
								"kkk")) {
					move = true;
				} else if (k == 1
						&& chese[0] != cheseman[newi][newj].getCheseman()
								.toCharArray()[0]
						&& cheseman[newi][newj].getCheseman().toCharArray()[0] != 'k') {
					move = true;
				}

			} else if (oldj == newj) {

				if (newi > oldi) {
					for (int i = oldi + 1; i < newi; i++) {
						if (cheseman[i][oldj].isIsman()) {
							k++;
						}
					}
				} else if (newi < oldi) {
					for (int i = newi + 1; i < oldi; i++) {
						if (cheseman[i][oldj].isIsman()) {
							k++;
						}
					}
				}

				if (k == 0
						&& cheseman[newi][newj].getCheseman().contentEquals(
								"kkk")) {
					move = true;
				} else if (k == 1
						&& chese[0] != cheseman[newi][newj].getCheseman()
								.toCharArray()[0]
						&& cheseman[newi][newj].getCheseman().toCharArray()[0] != 'k') {
					move = true;
				}
			}
		}
		if (chese[1] == 'x') {

			if (chese[0] == 'b' && newi > 4) {

				if ((newi - oldi) == 2 && (newj - oldj) == 2
						&& !cheseman[oldi + 1][oldj + 1].isIsman()) {
					move = true;
				} else if ((newi - oldi) == 2 && (newj - oldj) == -2
						&& !cheseman[oldi + 1][oldj - 1].isIsman()) {
					move = true;

				} else if ((newi - oldi) == -2 && (newj - oldj) == -2
						&& !cheseman[oldi - 1][oldj - 1].isIsman()) {
					move = true;

				} else if ((newi - oldi) == -2 && (newj - oldj) == 2
						&& !cheseman[oldi - 1][oldj + 1].isIsman()) {
					move = true;
				}
			} else if (chese[0] == 'r' && newi <= 4) {
				if ((newi - oldi) == 2 && (newj - oldj) == 2
						&& !cheseman[oldi + 1][oldj + 1].isIsman()) {
					move = true;
				} else if ((newi - oldi) == 2 && (newj - oldj) == -2
						&& !cheseman[oldi + 1][oldj - 1].isIsman()) {
					move = true;
				} else if ((newi - oldi) == -2 && (newj - oldj) == -2
						&& !cheseman[oldi - 1][oldj - 1].isIsman()) {
					move = true;

				} else if ((newi - oldi) == -2 && (newj - oldj) == 2
						&& !cheseman[oldi - 1][oldj + 1].isIsman()) {
					move = true;
				}
			}

			if (move
					&& cheseman[newi][newj].getCheseman().toCharArray()[0] == chese[0]) {
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
			if (move
					&& chese[0] == cheseman[newi][newj].getCheseman()
							.toCharArray()[0]) {
				move = false;
			}
		}
		if (chese[1] == 'b') {
			int k = 0;
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
			if (move
					&& chese[0] == cheseman[newi][newj].getCheseman()
							.toCharArray()[0]) {
				move = false;
			}
			if (newj == oldj
					&& cheseman[newi][newj].getCheseman().toCharArray()[1] == 'b'
					&& cheseman[newi][newj].getCheseman().toCharArray()[0] != chese[0]) {

				if (newi > oldi) {
					for (int i = oldi + 1; i < newi; i++) {
						if (!cheseman[i][newj].getCheseman().contentEquals(
								"kkk")) {
							k++;
						}
					}
				} else if (newi < oldi) {
					for (int i = newi + 1; i < oldi; i++) {
						if (!cheseman[i][newj].getCheseman().contentEquals(
								"kkk")) {
							k++;
						}
					}
				}

				if (k == 0) {

					move = true;
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
			if (move
					&& chese[0] == cheseman[newi][newj].getCheseman()
							.toCharArray()[0]) {
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
}
