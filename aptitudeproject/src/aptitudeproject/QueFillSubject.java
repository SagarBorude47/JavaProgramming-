package aptitudeproject;

import java.awt.Choice;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QueFillSubject extends JFrame implements ActionListener {

	JPanel pan,pan2,pan3;
	JButton ok;
	JLabel lab;
	static Choice sub;
	static String subject;
	
	public QueFillSubject(String ttl)
	{
		super(ttl);
		
		setLayout(new GridLayout(3,1));
		pan2=new JPanel();

		pan=new JPanel();

		lab=new JLabel("Select Subject ");
		lab.setFont(new Font("",Font.BOLD,15));
		pan.add(lab);
		sub=new Choice();
		sub.setFont(new Font("",Font.BOLD,15));
		//sub.addItemListener(this);
		sub.add("C Programming");
		sub.add("Data Structure");
		sub.add("C++ Programming");
		sub.add("Java Programming");
		sub.add("C# Programming");
		pan.add(sub);

		pan3=new JPanel();

		ok=new JButton("Continue");
		ok.addActionListener(this);
		pan3.add(ok);

		add(pan2);
		add(pan);
		add(pan3);

		setVisible(true);
		setSize(300,300);
		setLocation(350,250);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		setVisible(false);
		new QuestionFillGUI("Fill Questions");
	}

	public static String getSubject()
	{
		subject=sub.getItem(sub.getSelectedIndex());
		return subject;
	}
	
	public static void main(String[] args) 
	{
//		new QueFillSubject("Fill Questions");
//		
//		 String selectedSubject = QueFillSubject.getSubject();
//	        if (selectedSubject != null) {
//	            System.out.println("Selected Subject: " + selectedSubject);
//	        } else {
//	            System.out.println("No subject selected.");
//	        }
		new QueFillSubject("QueFillSubject");
	}
}

