import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Vikrant on 16-12-2018.
 */
public class ViewTeacher {
    public static void main(String[] args) {
        JFrame frame= new JFrame("View Teacher");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width/2, height/2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("VIEW TEACHER");
        title.setFont(new Font("Tahoma",0,20));
        title.setForeground(Color.DARK_GRAY);
        JPanel p1= new JPanel();
        p1.setBorder(new EmptyBorder(5,5,5,5));
        p1.add(title);

        JPanel p2= new JPanel();
        JLabel enterName= new JLabel("Enter the name of Teacher: ");
        JTextField name= new JTextField(20);
        JButton view = new JButton("VIEW");
        p2.add(enterName);
        p2.add(name);
        p2.add(view);
        p2.setBorder(new EmptyBorder(5,5,5,5));

        Container p = frame.getContentPane();
        GroupLayout gl = new GroupLayout(p);
        p.setLayout(gl);

        gl.setHorizontalGroup(gl.createSequentialGroup().addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
        .addComponent(p1).addComponent(p2)));

        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(p1).addComponent(p2));



//        frame.add(p1);
//        frame.add(p2);
        frame.setVisible(true);

    }
}
