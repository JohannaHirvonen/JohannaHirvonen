package resources;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ResourceLoader {

	static ResourceLoader rl = new ResourceLoader();
	
	public static Image getImage(String name){
	return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource(name));
	}
	
	public static ImageIcon getImageIcon(String name){
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource(name)));
		return icon;
	}
}
