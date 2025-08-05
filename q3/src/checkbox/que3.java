package checkbox;

import java.awt.Checkbox;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class que3 {
	public static void main(String[] args)
	{
	JFrame jf=new JFrame();
	JLabel L=new JLabel("select known language");
	L.setBounds(30,50,150,50);
	jf.add(L);

	Checkbox ch1=new Checkbox("Telugu");
	ch1.setBounds(100,100,80,50);
	jf.add(ch1);

	Checkbox ch2=new Checkbox("English");
	ch2.setBounds(100,150,80,50);
	jf.add(ch2);

	Checkbox ch3=new Checkbox("Tamil");
	ch3.setBounds(100,200,80,50);
	jf.add(ch3);

	Checkbox ch4=new Checkbox("Malayalam");
	ch4.setBounds(100,250,80,50);
	jf.add(ch4);

	jf.setSize(800,800);
	jf.setLayout(null);
	jf.setVisible(true);

	} 
}
