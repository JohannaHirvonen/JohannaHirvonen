package johanna.hirvonen;

import java.awt.*;
import javax.swing.*;

import resources.ResourceLoader;

public class StickMe extends JPanel{ 
	
	ImageIcon start = new ImageIcon(ResourceLoader.getImage("/stickMe3.jpg"));
	ImageIcon hello = new ImageIcon(ResourceLoader.getImage("/stickMeHello.jpg"));
	ImageIcon love = new ImageIcon(ResourceLoader.getImage("/stickMeLove.jpg"));
	ImageIcon pants = new ImageIcon(ResourceLoader.getImage("/stickMePants.jpg"));
	ImageIcon shirt = new ImageIcon(ResourceLoader.getImage("/stickMeshirt.jpg"));
	ImageIcon shoes = new ImageIcon(ResourceLoader.getImage("/stickMeShoes.jpg"));
	ImageIcon cardigan = new ImageIcon(ResourceLoader.getImage("/stickMeCardigan.jpg"));
	ImageIcon more = new ImageIcon(ResourceLoader.getImage("/stickMeMore.jpg"));
	ImageIcon awesome = new ImageIcon(ResourceLoader.getImage("/stickMeAwesome.jpg"));
	ImageIcon deal = new ImageIcon(ResourceLoader.getImage("/stickMeDeal.jpg"));
	
	JLabel image = new JLabel(hello);
	
	public StickMe(){
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 1));
		add(image);
		setVisible(true);
	}
	
	public void updateImage(int counter){
		image.setVisible(false);
		switch(counter){
		case 1:
			image.setIcon(start);
			break;
		case 6:
			image.setIcon(love);
			break;
		case 7:
			image.setIcon(start);
			break;
		case 8:
			image.setIcon(pants);
			break;
		case 9:
			image.setIcon(shirt);
			break;
		case 10:
			image.setIcon(shoes);
			break;
		case 11:
			image.setIcon(cardigan);
			break;
		case 13:
			image.setIcon(more);
			break;
		case 14:
			image.setIcon(awesome);
			break;
		case 15:
			image.setIcon(cardigan);
			break;
		}
		remove(image);
		add(image);
		image.setVisible(true);
	}
	
	public void startStick(){
		image.setVisible(false);
		image.setIcon(hello);
		remove(image);
		add(image);
		image.setVisible(true);
	}
}
