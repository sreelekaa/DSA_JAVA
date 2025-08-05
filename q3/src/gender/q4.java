package gender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class q4 {
	public static void main(String[] arg)
	{
	JFrame jf=new JFrame("select a gender");
	JLabel jl=new JLabel();
	JRadioButton rd1=new JRadioButton("Male");
	JRadioButton rd2=new JRadioButton("Female");
	JButton jb=new JButton("Click");
	rd1.setBounds(100,200, 100,100);    
	rd2.setBounds(100,300, 100,100);
	jb.setBounds(100,400,150,50);
	jb.addActionListener((ActionListener) new ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
	if(rd1.isSelected())
	{
		JOptionPane.showMessageDialog(jf,"You are Male.");   
	}
	else
	{
		JOptionPane.showMessageDialog(jf,"You are Female.");
	}
	}
	});
	jf.add(rd1);
	jf.add(rd2);
	jf.add(jb);
	jf.getContentPane().add(jl);
	jf.setSize(500,500);
	jf.setVisible(true);
	}
 
}
