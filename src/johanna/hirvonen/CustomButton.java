package johanna.hirvonen;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class CustomButton extends JButton{

	public CustomButton(String name){
		
		setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.ORANGE));
		setFont(new Font("Arial", Font.BOLD, 20));
		setBackground(Color.decode("#FFBB00"));
		setForeground(Color.BLACK);
		setOpaque(true);
		setText(name);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
