package Main_Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//public class Main implements ActionListener{


public class Main{
  public static void main(String[]args)
  {
	  JFrame jf=new JFrame("Simple Calculator");
	  JLabel label1 =new JLabel("Enter a first Number : ");
	  JTextField jtf1=new JTextField();
	  JLabel label2 =new JLabel("Enter a second Number : ");
	  JTextField jtf2=new JTextField();
	  JLabel label3 =new JLabel("Result : ");
	  JTextField jtf3=new JTextField();
	  JButton jb=new JButton("Add");
	  label1.setBounds(30,50,150,50);
	  label2.setBounds(30,100,150,50);
	  label3.setBounds(30,150,150,50);
	  jtf1.setBounds(180,50,150,50);
	  jtf2.setBounds(180,100,150,50);
	  jtf3.setBounds(180,150,150,50);
	  jb.setBounds(180,200,150,50);
	  jf.add(label1);
	  jf.add(jtf1);
	  jf.add(label2);
	  jf.add(jtf2);
	  jf.add(label3);
	  jf.add(jtf3);
	  jf.add(jb);
	  jb.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(jtf1.getText());
				int b=Integer.parseInt(jtf2.getText());
				int c=a+b;
				String res=String.valueOf(c);
				jtf3.setText(res);
			}
	  });
	  jf.setLayout(null);
	  jf.setSize(300,300);
	  jf.setVisible(true);
	  
  }
}
