package johanna.hirvonen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Details extends JFrame implements ActionListener{
	JTextArea text = new JTextArea();
	JMenuItem bottomButton = new JMenuItem();
	String text1;
	String text2;

	public Details(){
		setLayout(new BorderLayout());
		setSize(500, 250);
		add(bottomButton, BorderLayout.SOUTH);
		bottomButton.setBackground(Color.WHITE);
		bottomButton.addActionListener(this);
		bottomButton.setText("The Internship");

		text1 = "A couple of years ago I found the field of work I want to devote myself to. " +
				"That is why I am now going to school with the aim of becoming a java developer. " +
				"I have found that I get a great sense of satisfaction in succeeding in writing " +
				"efficient and clean code that do exactly what I want. More than once I have raised " +
				"my arms high from the keyboard calling out \"YES!\" as I have succeeded in turning my " +
				"line of thought into reality (and at the same time wondered if this is really normal..?). " +
				"I love the challenge in working out the logic structures of a java based program and I " +
				"have a hunger to always learn more. I want to be awesome at what I do and I know that I am " +
				"only at the beginning of that path. That is why I am really excited about what the future might hold." +
				"\n\nYou can reach my Linkedin profile at this address:\n" +
				"se.linkedin.com/pub/johanna-hirvonen/8b/4a0/289";
		
		text2 = "I am currently taking a one year long education at EC Utbildning. \n" +
				"\nMore information at this link: \n" +
				"http://www.ecutbildning.se/Utbildningar/Yrkesutbildningar/Javautvecklare/?id=19358\n" +
				"\n The internship course is the last course in this education and it runs for six weeks," +
				" from 28th of April until 5th of June. After that I am free as a bird and there is allways " +
				"the possibility of me continuing to work for you if you want me to stay :)";
		
		add(text);
		text.setColumns(30);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setFont(new Font("Arial", Font.PLAIN, 12));
		text.setText(text1);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(bottomButton.getText() == "The Internship"){
			bottomButton.setVisible(false);
			bottomButton.setText("go back");
			text.setVisible(false);
			text.setText(text2);
			remove(bottomButton);
			add(bottomButton);
			remove(text);
			add(text);
			text.setVisible(true);
			bottomButton.setVisible(true);
		}
		else if(bottomButton.getText() == "go back"){
			bottomButton.setVisible(false);
			bottomButton.setText("The Internship");
			text.setVisible(false);
			text.setText(text1);
			remove(bottomButton);
			add(bottomButton);
			remove(text);
			add(text);
			text.setVisible(true);
			bottomButton.setVisible(true);
		}
	}
}
