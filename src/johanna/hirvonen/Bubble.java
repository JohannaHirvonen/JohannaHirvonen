package johanna.hirvonen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import extra.Mail;

import resources.ResourceLoader;

public class Bubble extends JPanel implements ActionListener{
	Timer bubbleTimer = new Timer(3500, this);
	JButton beginButton = new JButton();
	JLabel beginLabel = new JLabel();
	JPanel beginPanel = new JPanel();
	public Talk currentTalk;
	Image background = ResourceLoader.getImage("/theBubble.jpg");
	public TalkList list = new TalkList();
	boolean running = false;
	boolean atBeginning = true;
	int stickCounter;

	public Bubble(){
		list.makeTalks();
		setLayout(new CardLayout());
		setBorder(new EmptyBorder(70, 85, 70, 35));
		currentTalk = list.first;
		add(currentTalk);
		startStory();
		list.last.yesLink.addActionListener(this);
		list.last.noLink.addActionListener(this);
		list.last.details.addActionListener(this);
		list.noChoice.reconsider.addActionListener(this);
	}
	
	public void paintComponent(Graphics g) {
			g.drawImage(background, 0, 0, getSize().width, getSize().height, this);
		}
	
	public void startStory(){
		currentTalk.setVisible(false);
		running = false;
		atBeginning = true;
		bubbleTimer.stop();
		add(beginPanel);
		beginPanel.setBorder(new EmptyBorder(80, 30, 70, 30));
		beginPanel.setLayout(new GridLayout(2, 1));
		beginPanel.setBackground(Color.WHITE);
		beginPanel.add(beginButton);
		beginButton.setBorderPainted(false);	
		beginButton.setContentAreaFilled(false);
		beginButton.addActionListener(this);
		beginButton.setFont(new Font("Arial", Font.PLAIN, 16));
		beginButton.setForeground(Color.BLUE);
		beginButton.setText("<html><u>Click here</u></html>");
		beginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		beginPanel.add(beginLabel);
		beginLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		beginLabel.setText("to hear my story");
		beginPanel.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == beginButton){
			begin();
		}
		else if(event.getSource() == bubbleTimer){
			currentTalk.setVisible(false);
			currentTalk = currentTalk.next;
			remove(currentTalk);
			add(currentTalk);
			currentTalk.setVisible(true);
					
			if(currentTalk == list.last){
				bubbleTimer.stop();
			}
		}
		else if(event.getSource() == list.last.yesLink){
			currentTalk.setVisible(false);
			currentTalk = currentTalk.next;
			remove(currentTalk);
			add(currentTalk);
			currentTalk.setVisible(true);
			
			SendMail sendYes = new SendMail();
			sendYes.setMessage("DEAL");
			sendYes.start();
		}
		else if(event.getSource() == list.last.noLink){
			currentTalk.setVisible(false);
			currentTalk = currentTalk.noTalk;
			remove(currentTalk);
			add(currentTalk);
			currentTalk.setVisible(true);
			
			SendMail sendNo = new SendMail();
			sendNo.setMessage("NO DEAL");
			sendNo.start();
			
			list.last.noTalk.countdown.start();
		}
		else if(event.getSource() == list.last.details){
			Details details = new Details();
		}
		else if(event.getSource() == list.noChoice.reconsider){
			currentTalk.setVisible(false);
			currentTalk = currentTalk.next;
			remove(currentTalk);
			add(currentTalk);
			currentTalk.setVisible(true);
		}
	}
	
	public void begin(){
		stickCounter ++;
		currentTalk.setVisible(false);
		remove(currentTalk);
		beginPanel.setVisible(false);
		remove(beginPanel);
		currentTalk = list.first;
		add(currentTalk);
		currentTalk.setVisible(true);
		bubbleTimer.start();
		running = true;
		atBeginning = false;
		
		SendMail sendBegin = new SendMail();
		sendBegin.setMessage("The presentation has started");
		sendBegin.start();
	}
}
