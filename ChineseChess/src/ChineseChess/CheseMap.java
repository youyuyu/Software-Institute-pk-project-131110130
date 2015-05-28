package ChineseChess;
//∆Â≈Ã µœ÷ƒ£øÈ
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CheseMap extends JPanel {
	private int oldX = -1;
	private int oldY = -1;
	private int newX = -1;
	private int newY = -1;
	private CheseMan[][] cheseman = new CheseMan[10][9];

	public  CheseMan[][] getCheseman() {
		return cheseman;
	}

	public void paintComponent(Graphics g) {
		ImageIcon c = new ImageIcon("img/bg.png");
		Image map = c.getImage();
		if (map != null) {
			g.drawImage(map, 0, 0, 507, 567, this);

		}
	}

	public CheseMap() {
		setLayout(new GridLayout(10, 9, 0, 0));
		cheseman[0][0] = new CheseMan("rj0");
		cheseman[0][1] = new CheseMan("rm0");
		cheseman[0][2] = new CheseMan("rx0");
		cheseman[0][3] = new CheseMan("rs0");
		cheseman[0][4] = new CheseMan("rb0");
		cheseman[0][5] = new CheseMan("rs1");
		cheseman[0][6] = new CheseMan("rx1");
		cheseman[0][7] = new CheseMan("rm1");
		cheseman[0][8] = new CheseMan("rj1");
		cheseman[2][1] = new CheseMan("rp0");
		cheseman[2][7] = new CheseMan("rp1");
		cheseman[3][0] = new CheseMan("rz0");
		cheseman[3][2] = new CheseMan("rz1");
		cheseman[3][4] = new CheseMan("rz2");
		cheseman[3][6] = new CheseMan("rz3");
		cheseman[3][8] = new CheseMan("rz4");
		cheseman[6][0] = new CheseMan("bz0");
		cheseman[6][2] = new CheseMan("bz1");
		cheseman[6][4] = new CheseMan("bz2");
		cheseman[6][6] = new CheseMan("bz3");
		cheseman[6][8] = new CheseMan("bz4");
		cheseman[7][1] = new CheseMan("bp0");
		cheseman[7][7] = new CheseMan("bp1");
		cheseman[9][0] = new CheseMan("bj0");
		cheseman[9][1] = new CheseMan("bm0");
		cheseman[9][2] = new CheseMan("bx0");
		cheseman[9][3] = new CheseMan("bs0");
		cheseman[9][4] = new CheseMan("bb0");
		cheseman[9][5] = new CheseMan("bs1");
		cheseman[9][6] = new CheseMan("bx1");
		cheseman[9][7] = new CheseMan("bm1");
		cheseman[9][8] = new CheseMan("bj1");
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 8; j++) {
				if (cheseman[i][j] == null) {
					cheseman[i][j] = new CheseMan("kkk");
				}
			}
		}

		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 8; j++) {
				cheseman[i][j].setContentAreaFilled(false);
				cheseman[i][j].setBorder(null);
				// cheseman[0][2].setSelect(true);
				add(cheseman[i][j]);
			}
		}

	}

	public int getOldX() {
		return oldX;
	}

	public void setOldX(int oldX) {
		this.oldX = oldX;
	}

	public int getOldY() {
		return oldY;
	}

	public void setOldY(int oldY) {
		this.oldY = oldY;
	}

	public int getNewX() {
		return newX;
	}

	public void setNewX(int newX) {
		this.newX = newX;
	}

	public int getNewY() {
		return newY;
	}

	public void setNewY(int newY) {
		this.newY = newY;
	}

}
