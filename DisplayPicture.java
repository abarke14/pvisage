import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Container;
/**
 * Write a description of class DisplayPicture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 public class DisplayPicture
{
 JFrame window;
 Container con;
 JPanel picturePanel;
 JLabel pictureLabel;
 ImageIcon image;

 public static void main(String[] args) {
    new DisplayPicture();
  }

 public DisplayPicture()
 {
        window = new JFrame();
        window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        
        pictureLabel = new JLabel();
        
        picturePanel = new JPanel();
        picturePanel.setBounds(150, 100, 500, 300);
        picturePanel.setBackground(Color.blue);
        con.add(picturePanel);
        
        pictureLabel = new JLabel();
        
        image = new ImageIcon();
        
        pictureLabel.setIcon(image);
        picturePanel.add(pictureLabel);
        
        

 }
}
