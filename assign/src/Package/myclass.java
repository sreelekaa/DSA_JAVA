package Package;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myclass {
	 
	 private static Set<String> uniqueBookIds = new HashSet<>();
	 public static void main(String[] args) {
	 JFrame frame = new JFrame("727822TUAD051-SREELEKA.M.S");
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 // Create a JPanel with a background color
	 JPanel backgroundPanel = new JPanel() {
	 @Override
	 protected void paintComponent(Graphics g) {
	 super.paintComponent(g);
	 // Uncomment the line below if you want to set a background image
	 // ImageIcon backgroundImage = new ImageIcon("path/to/your/image.jpg");
	 // g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
	 }
	 };
	 // Set the background color
	 backgroundPanel.setBackground(new Color(231, 231, 231)); // Light Blue color
	 backgroundPanel.setLayout(null);
	 JLabel label1 = new JLabel("WELCOME TO THE BOOK STORE");
	 JLabel label4 = new JLabel("Enter the book ID");
	 JLabel label2 = new JLabel("Enter the book name to add in the store ");
	 JLabel label3 = new JLabel("Click the display button to display all the books in the store");
	 JButton button1 = new JButton("Add");
	 JButton button2 = new JButton("Display");
	 JButton button3 = new JButton("Edit");
	 JButton button4 = new JButton("Delete");
	 JTextField text1 = new JTextField();
	 JTextField text2 = new JTextField();
	 label4.setBounds(500, 150, 500, 100);
	 label1.setBounds(700, 10, 500, 200);
	 label2.setBounds(500, 200, 500, 100);
	 label3.setBounds(500, 250, 500, 100);
	 text1.setBounds(800, 230, 250, 30);
	 text2.setBounds(800, 180, 250, 30);
	 button1.setBounds(1150, 220, 100, 40);
	 button2.setBounds(850, 280, 100, 40);
	 button3.setBounds(960, 280, 100, 40);
	 button4.setBounds(1070, 280, 100, 40);
	 // Add components to the backgroundPanel instead of the frame directly
	 backgroundPanel.add(label1);
	 backgroundPanel.add(label2);
	 backgroundPanel.add(label3);
	 backgroundPanel.add(label4);
	 backgroundPanel.add(text1);
	 backgroundPanel.add(text2);
	 backgroundPanel.add(button1);
	 backgroundPanel.add(button2);
	 backgroundPanel.add(button3);
	 backgroundPanel.add(button4);
	 // Set backgroundPanel as the content pane of the frame
	 frame.setContentPane(backgroundPanel);
	 frame.setSize(1200, 500);
	 frame.setLocationRelativeTo(null);
	 frame.setVisible(true);
	 button1.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
	 try {
	 String bookId = text1.getText();
	 String bookName = text2.getText();
	 if (bookId.isEmpty() || bookName.isEmpty()) {
	 JOptionPane.showMessageDialog(null, "Please enter both book ID and book name.");
	 return;
	 }
	 if (uniqueBookIds.contains(bookId)) {
	 JOptionPane.showMessageDialog(null, "Book ID already exists.");
	 return;
	 }
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root");
	 String sql = "INSERT INTO books (book_id, book_name) VALUES (?, ?)";
	 try (PreparedStatement ps = con.prepareStatement(sql)) {
	 ps.setString(1, bookId);
	 ps.setString(2, bookName);
	 ps.executeUpdate();
	 JOptionPane.showMessageDialog(null, "Book added successfully");
	 uniqueBookIds.add(bookId);
	 }
	 } catch (ClassNotFoundException | SQLException ex) {
	 ex.printStackTrace();
	 JOptionPane.showMessageDialog(null, "Error adding book: " + ex.getMessage());
	 }
	 }
	 });
	 button2.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
	 displayBooks();
	 }
	 });
	 button3.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
	 editBook();
	 }
	 });
	 button4.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
	 deleteBook();
	 }
	 });
	 }
	 private static void displayBooks() {
	 try {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root");
	 String sql = "SELECT * FROM books";
	 try (PreparedStatement ps = con.prepareStatement(sql)) {
	 ResultSet rs = ps.executeQuery();
	 StringBuilder result = new StringBuilder("Book ID\tBook Name\n");
	 while (rs.next()) {
	 result.append(rs.getString("book_id")).append("\t").append(rs.getString("book_name")).append("\n");
	 }
	 JOptionPane.showMessageDialog(null, result.toString(), "Book Store Inventory", 
	JOptionPane.INFORMATION_MESSAGE);
	 }
	 } catch (ClassNotFoundException | SQLException ex) {
	 ex.printStackTrace();
	 JOptionPane.showMessageDialog(null, "Error displaying books: " + ex.getMessage());
	 }
	 }
	 private static void editBook() {
	 String bookId = JOptionPane.showInputDialog("Enter the book ID to edit:");
	 if (bookId != null && !bookId.isEmpty()) {
	 try {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root");
	 String sql = "SELECT * FROM books WHERE book_id=?";
	 try (PreparedStatement ps = con.prepareStatement(sql)) {
	 ps.setString(1, bookId);
	 ResultSet rs = ps.executeQuery();
	 if (rs.next()) {
	 String currentBookName = rs.getString("book_name");
	 String newBookName = JOptionPane.showInputDialog("Enter the new name for Book " + bookId + ":", 
	currentBookName);
	 if (newBookName != null) {
	 sql = "UPDATE books SET book_name=? WHERE book_id=?";
	 try (PreparedStatement updatePs = con.prepareStatement(sql)) {
	 updatePs.setString(1, newBookName);
	 updatePs.setString(2, bookId);
	 updatePs.executeUpdate();
	 JOptionPane.showMessageDialog(null, "Book updated successfully");
	 }
	 }
	 } else {
	 JOptionPane.showMessageDialog(null, "Book ID not found.");
	 }
	 }
	 } catch (ClassNotFoundException | SQLException ex) {
	 ex.printStackTrace();
	 JOptionPane.showMessageDialog(null, "Error editing book: " + ex.getMessage());
	 }
	 }
	 }
	 private static void deleteBook() {
	 String bookId = JOptionPane.showInputDialog("Enter the book ID to delete:");
	 if (bookId != null && !bookId.isEmpty()) {
	 try {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root");
	 String sql = "DELETE FROM books WHERE book_id=?";
	 try (PreparedStatement ps = con.prepareStatement(sql)) {
	 ps.setString(1, bookId);
	 int rowsDeleted = ps.executeUpdate();
	 if (rowsDeleted > 0) {
	 JOptionPane.showMessageDialog(null, "Book deleted successfully");
	 uniqueBookIds.remove(bookId);
	 } else {
	 JOptionPane.showMessageDialog(null, "Book ID not found.");
	 }
	 }
	 } catch (ClassNotFoundException | SQLException ex) {
	 ex.printStackTrace();
	 JOptionPane.showMessageDialog(null, "Error deleting book: " + ex.getMessage());
	 }
	}
	}
	}

