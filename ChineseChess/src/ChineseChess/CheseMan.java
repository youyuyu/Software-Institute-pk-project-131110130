package ChineseChess;
//棋子实现模块
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CheseMan extends JButton {

	
	private String cheseman = "kkk";
	private boolean isman=false;
	private boolean select = false;
	
	
	public void paint(Graphics g) {
		super.paint(g);
		this.draw(g, cheseman);
	}

	public CheseMan(String cheseman) {
		this.cheseman = cheseman;
		if(!cheseman.contentEquals("kkk")){
			this.setIsman(true);
		}
		
	}

	public void draw(Graphics g, String cheseman) {
		ImageIcon imageIcon = new ImageIcon("img/r_box.png");
		Image image = imageIcon.getImage();

		char[] chese = cheseman.toCharArray();
		if (chese[0] == 'k') {
			if (select) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		} else {
			if (select) {

				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

			}
			if (chese[0] == 'b' && chese[1] == 'j') {
				g.drawImage(new ImageIcon("img/b_c.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'r' && chese[1] == 'j') {
				g.drawImage(new ImageIcon("img/r_c.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'b' && chese[1] == 'm') {
				g.drawImage(new ImageIcon("img/b_m.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'r' && chese[1] == 'm') {
				g.drawImage(new ImageIcon("img/r_m.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'b' && chese[1] == 'p') {
				g.drawImage(new ImageIcon("img/b_p.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'r' && chese[1] == 'p') {
				g.drawImage(new ImageIcon("img/r_p.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'b' && chese[1] == 'x') {
				g.drawImage(new ImageIcon("img/b_x.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'r' && chese[1] == 'x') {
				g.drawImage(new ImageIcon("img/r_x.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'b' && chese[1] == 's') {
				g.drawImage(new ImageIcon("img/b_s.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'r' && chese[1] == 's') {
				g.drawImage(new ImageIcon("img/r_s.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'b' && chese[1] == 'b') {
				g.drawImage(new ImageIcon("img/b_j.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'r' && chese[1] == 'b') {
				g.drawImage(new ImageIcon("img/r_j.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'b' && chese[1] == 'z') {
				g.drawImage(new ImageIcon("img/b_z.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
			if (chese[0] == 'r' && chese[1] == 'z') {
				g.drawImage(new ImageIcon("img/r_z.png").getImage(), 0, 0,
						getWidth(), getHeight(), this);
			}
		}
	}

	public boolean getSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isIsman() {
		return isman;
	}

	public String getCheseman() {
		return cheseman;
	}

	public void setCheseman(String cheseman) {
		this.cheseman = cheseman;
	}

	public void setIsman(boolean isman) {
		this.isman = isman;
	}
	

	

}
