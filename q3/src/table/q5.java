package table;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class q5 {
	public static void main(String arg[])
	{
	Object[][] data={{101,"amit",670000},
	                 {102,"jai",5400000},
	                 {101,"sachin",720000}};
	String[] cl={"ID","NAME","SALARY"};
	DefaultTableModel tm=new DefaultTableModel(data,cl);
	JTable jt=new JTable(tm);
	JScrollPane jsp=new JScrollPane(jt);
	JPanel jp=new JPanel();
	jp.add(jsp);
	JFrame jf=new JFrame("Employee Details");
	jf.getContentPane().add(jp);
	jf.setSize(500,500);
	jf.setVisible(true);
	} 
}
