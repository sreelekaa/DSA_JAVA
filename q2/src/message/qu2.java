package message;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class qu2 {
	public static void main(String args[])
	{
		JFrame jf=new JFrame();
		JLabel jl=new JLabel("Enter the text : ");
        JTextField jtf=new JTextField();
		JButton jb=new JButton("Click ");
		jl.setBounds(30, 50, 150, 50);
		jtf.setBounds(180,50,150,50);
		jb.setBounds(100,200,150,50);
		jb.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(jf,jtf.getText());
			}
		});
		jf.add(jl);
		jf.add(jtf);
		jf.add(jb);
		jf.setLayout(null);
		jf.setSize(400,400);
		jf.setVisible(true);
	}

}
