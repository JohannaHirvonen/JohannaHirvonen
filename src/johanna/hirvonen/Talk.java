package johanna.hirvonen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import resources.ResourceLoader;


public class Talk extends JPanel implements ActionListener {
	public Talk next;
	public Talk noTalk;
	JTextArea talking;
	JLabel picture;
	public CustomButton yesLink;
	public CustomButton noLink;
	public JButton details = new JButton();
	public CustomButton reconsider;
	Timer countdown = new Timer(1000, this);
	int hours = 24;
	int minutes = 0;
	int secounds = 0;
	JLabel timeLabel = new JLabel();
	
	public Talk(String text, String image){
		setBackground(Color.WHITE);
		if(text != null && image != null){
			setLayout(new GridLayout(2, 1));
			styleTalking(text);
			talking.setFont(new Font("Arial", Font.PLAIN, 26));
			add(talking);
			
			picture = new JLabel(new ImageIcon(ResourceLoader.getImage(image)));
			add(picture);
		}
		else if(image == null){
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 1));
		styleTalking(text);
		talking.setFont(new Font("Arial", Font.PLAIN, 26));
		add(talking);
		}
		else if(text == null){
			setLayout(new GridLayout(1, 1));
			picture = new JLabel(new ImageIcon(ResourceLoader.getImage(image)));
			add(picture);
		}
	}
	
	public Talk(String text){
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 1));
		styleTalking(text);
		talking.setFont(new Font("Arial", Font.PLAIN, 60));
		add(talking);
	}
	
	public Talk(String text, String text2, boolean bool){
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2, 1));
		styleTalking(text);
		talking.setFont(new Font("Arial", Font.PLAIN, 22));
		add(talking);

		styleTalking(text2);
		talking.setFont(new Font("Arial", Font.BOLD, 18));
		add(talking);
	}
	
	public Talk(String text1, String link1, String text2, String link2, String link3){
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		styleTalking(text1);
		talking.setFont(new Font("Arial", Font.PLAIN, 26));
		add(talking, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new GridLayout(3, 1));
		panel.setBorder(new EmptyBorder(0, 40, 0, 40));
		add(panel);
		
		yesLink  = new CustomButton(link1);
		panel.add(yesLink);
		JLabel or = new JLabel(text2);
		
		panel.add(or);
		or.setHorizontalAlignment(SwingConstants.CENTER);
		
		noLink  = new CustomButton(link2);
		panel.add(noLink);
		
		details.setBorderPainted(false);
		details.setContentAreaFilled(false);
		add(details, BorderLayout.SOUTH);
		details.setForeground(Color.BLUE);
		details.setText("<html><u>The details</u></html>");
		details.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public Talk(String text, String button, String text2){
		setBackground(Color.WHITE);
		setLayout(new GridLayout(3, 1));
		styleTalking(text);
		talking.setFont(new Font("Arial", Font.PLAIN, 18));
		add(talking);
		
		reconsider  = new CustomButton(button);
		add(reconsider);
		
		add(timeLabel);
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setFont(new Font("Arial", Font.PLAIN, 44));
		drawTime();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == countdown){
			secounds --;
			if(secounds < 0){
				secounds = 59;
				minutes --;
				if(minutes < 0){
					minutes = 59;
					hours --;
					if(hours < 0){
						countdown.stop();
						hours = 0;
						minutes = 0;
						secounds = 0;
					}
				}
			}
			drawTime();
		}
	}
	
	public void drawTime(){
		String sHours = "" + hours;
		String sMinutes = "" + minutes;
		String sSecounds = "" + secounds;
			
		if(hours < 10){
			sHours = "0" + hours;
		}
		if(minutes < 10){
			sMinutes = "0" + minutes;
		}
		if(secounds < 10){
			sSecounds = "0" + secounds;
		}
	
		String time = sHours + ":" + sMinutes + ":" + sSecounds;		
		timeLabel.setText(time);
	}
	
	private void styleTalking(String text){
		talking = new JTextArea();
		talking.setLineWrap(true);
		talking.setWrapStyleWord(true);
		talking.setText(text);
		
	}
}
