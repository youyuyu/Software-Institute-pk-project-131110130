package ChineseChess;
//总体调用模块
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChineseChese extends JFrame {
	public static int AI=-1;
	static CheseMap chesemap=new CheseMap();
	public CheseMan[][]cheseman=chesemap.getCheseman();
	

	public ChineseChese() {
		
		add(chesemap);
		for(int i=0;i<cheseman.length;i++){
			for(int j=0;j<cheseman[i].length;j++){
				cheseman[i][j].addMouseListener(new Controller(cheseman,chesemap));
			}
		}
		
		
		
	}

	public static void main(String[] args) {
		
		Object[] possibleValues = { "人机对战", "双人对战" }; 
		String selectedValue = (String)JOptionPane.showInputDialog(null, "对战方式", "对战模式选择", 
		JOptionPane.INFORMATION_MESSAGE, null, 
		possibleValues, possibleValues[0]);
		ChineseChese frame = new ChineseChese();
		if(selectedValue.contentEquals("人机对战")){
			AI=1;
		}
		frame.setResizable(false);
		frame.setTitle("中国象棋");
		frame.setSize(507, 590);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	}

}
