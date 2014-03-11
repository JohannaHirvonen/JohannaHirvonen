package johanna.hirvonen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

	public class TheFrame extends JFrame implements ActionListener{
		StickMe stick = new StickMe();
		public Bubble bubble = new Bubble();
		JPanel bubblePanel = new JPanel();
		JMenuBar menu = new JMenuBar();
		JButton paus = new JButton();
		JButton startOver = new JButton();
		int stickCounter = 0;
		SendMail sendMail = new SendMail();
		
		public TheFrame(){
			setSize(600, 400);
			setResizable(false);
			setLayout(new GridLayout(1, 2));
			bubble.bubbleTimer.addActionListener(this);
			add(stick);
			add(bubblePanel);
			bubblePanel.setLayout(new BorderLayout());
			bubblePanel.add(bubble, BorderLayout.CENTER);
			bubblePanel.add(menu, BorderLayout.SOUTH);
			menu.setBackground(Color.WHITE);
			menu.add(paus);
			styleButton(paus, "paus");
			menu.add(startOver);
			styleButton(startOver, "start over");
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == bubble.bubbleTimer){
				stickCounter ++;
				System.out.println(stickCounter);
				stick.updateImage(stickCounter);
			}
			else if(event.getSource() == paus){
				if(!bubble.atBeginning){
					if(bubble.running){
						bubble.bubbleTimer.stop();
						bubble.running = false;
						paus.setText("resume");
					}
					else{
						bubble.bubbleTimer.start();
						bubble.running = true;
						paus.setText("pause");
					}
				}
			}
			else if(event.getSource() == startOver){
				if(!bubble.atBeginning){
				bubble.startStory();
				stick.startStick();
				stickCounter = 0;
				paus.setText("pause");
				bubble.atBeginning = true;
				}
				else{
					bubble.begin();
				}
			}
		}
		
		private void styleButton(JButton button, String text){
			button.addActionListener(this);
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusable(false);
			button.setText(text);
			button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		public static void main(String[] args){
			TheFrame frame = new TheFrame();
		}
	}
