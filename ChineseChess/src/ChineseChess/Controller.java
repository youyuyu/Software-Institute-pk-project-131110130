package ChineseChess;
//¿ØÖÆÒôÐ§Ä£¿é
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Controller extends MouseAdapter {
	CheseMan[][] cheseman;
	CheseMap chesemap;
	boolean gameOver=false;

	public Controller(CheseMan[][] cheseman, CheseMap chesemap) {
		this.cheseman = cheseman;
		this.chesemap = chesemap;
	}

	public void mouseClicked(MouseEvent e) {
		
		CheseMan source = (CheseMan) e.getSource();

		int x = -1;
		int y = -1;
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 8; j++) {
				if (cheseman[i][j] == source) {

					x = i;
					y = j;
				
				}
			}
		}
		int oldi = chesemap.getOldX();
		int oldj = chesemap.getOldY();

		if (oldi != -1 && oldj != -1) {

			if (cheseman[oldi][oldj].isIsman()) {
				if (Control.canMove(cheseman, oldi, oldj, x, y)) {
					Control.changeTurn();
					if (cheseman[x][y].isIsman()) {
						play("eat");
					} else {
						play("go");
					}
					if(cheseman[x][y].getCheseman().toCharArray()[1]=='b'){
						gameOver=true;
					}
					cheseman[x][y].setCheseman(cheseman[oldi][oldj]
							.getCheseman());
					cheseman[x][y].setIsman(true);
//					cheseman[x][y].setSelect(cheseman[oldi][oldj].getSelect());
					cheseman[x][y].repaint();
					cheseman[oldi][oldj].setCheseman("kkk");
					cheseman[oldi][oldj].setIsman(false);
					cheseman[oldi][oldj].setSelect(false);
					cheseman[oldi][oldj].repaint();
					if(gameOver){
						JOptionPane.showMessageDialog(null, "YOU WIN!!"); 
					}
					chesemap.setOldX(-1);
					chesemap.setOldY(-1);
					if(ChineseChese.AI==1){
						AI.AI(cheseman);
						Control.changeTurn();
					}
					
				} else {
					
					cheseman[oldi][oldj].setSelect(false);
					cheseman[oldi][oldj].repaint();
					chesemap.setOldX(-1);
					chesemap.setOldY(-1);
				}
			}else{
				chesemap.setOldX(x);
				chesemap.setOldY(y);
			}
		}else{
			chesemap.setOldX(x);
			chesemap.setOldY(y);
			if(cheseman[x][y].isIsman()){
				cheseman[x][y].setSelect(true);
				cheseman[x][y].repaint();
			}
		}
		
		
	}

	public void play(String str) {
		try {
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(new File("res/" + str + ".wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(inputStream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
