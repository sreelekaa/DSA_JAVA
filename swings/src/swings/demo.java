package swings;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class demo {
	public static void main(String args[])
	{
		JFrame jf=new JFrame("JFrame along with Label");
		JLabel label=new JLabel("My first Lable");
		JButton button =new JButton("Click");
		JTextField jtf=new JTextField();
		label.setBounds(30,30,100,50);
		jtf.setBounds(100,150,100,50);
		button.setBounds(150,250,100,50);
		jf.add(label);
		jf.add(jtf);
		jf.add(button);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setSize(400,400);
	}
}
