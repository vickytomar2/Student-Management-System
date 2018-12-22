import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Vikrant on 16-12-2018.
 */
public class ViewTeacher {

    JFrame frame;

    ViewTeacher() {
        frame = new JFrame("View Teacher");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width / 2, height / 2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("VIEW TEACHER");
        title.setFont(new Font("Tahoma", 0, 20));
        title.setForeground(Color.DARK_GRAY);
        JPanel p1 = new JPanel();
        p1.setBorder(new EmptyBorder(5, 5, 5, 5));
        p1.add(title);

        JPanel p2 = new JPanel();
        JLabel enterName = new JLabel("Enter the name of Teacher: ");
        JTextField name = new JTextField(20);
        JButton view = new JButton("VIEW");
        p2.add(enterName);
        p2.add(name);
        p2.add(view);
        p2.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel p3 = new JPanel();
        JPanel p5= new JPanel();
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        p5.add(l1);
        p5.add(l2);

        JPanel p6= new JPanel();
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();

        p6.add(l3);
        p6.add(l4);

        p3.add(p5);
        p3.add(p6);
        p3.setBorder(new EmptyBorder(5, 5, 5, 5));
        p3.setLayout(new GridBagLayout());

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String searchName = name.getText();
                Connection conn;
                Statement stmt;

                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/teacher3", "root", "piyush8010827159");

                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from teacher2 where username = '" + searchName+"'");
                    while (rs.next()) {
                        l1.setText("Name: "+ rs.getString(1));
                        l2.setText("Password: "+ rs.getString(2));
                        l3.setText("Email id: "+ rs.getString(3));
                        l4.setText("Contact No: " + rs.getString(4));
                    }
                    conn.close();


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JPanel p4 = new JPanel();
        JButton back = new JButton("BACK");
        p4.add(back);
        p4.setBorder(new EmptyBorder(5, 5, 5, 5));

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AdminSection();
            }
        });


        Container p = frame.getContentPane();
        GroupLayout gl = new GroupLayout(p);
        p.setLayout(gl);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(p1).addComponent(p2).addComponent(p3).addComponent(p4));

        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(p1).addComponent(p2).addComponent(p3).addComponent(p4));

        frame.setVisible(true);

    }


    public static void main(String[] args) {
        new ViewTeacher();
    }
}
