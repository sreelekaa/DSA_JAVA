package Swings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class q1 {
	public static void main(String[] args)
	{
		JFrame jf =new JFrame("test");
		JButton jb=new JButton("Click");
		jb.setBounds(100,50,100,50);
		jf.add(jb);
		jb.addActionListener(new ActionListener()
		{
			
	      public void actionPerformed(ActionEvent e)
	      {
	    	  JOptionPane.showMessageDialog(jf, "Hello,Swings!");
	      }
		
		}
				
	);
		
	
	jf.setSize(400,400);
	jf.setLayout(null);
	jf.setVisible(true);
	}
}
