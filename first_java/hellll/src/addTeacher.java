import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Vikrant on 16-12-2018.
 */
public class addTeacher {
    JFrame frame;

    addTeacher() {
        frame = new JFrame("Add Teacher");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width / 2, height / 2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("ADD TEACHER");
        title.setFont(new Font("Tahoma", 0, 20));
        title.setForeground(Color.DARK_GRAY);
        JPanel p1 = new JPanel();
        p1.setBorder(new EmptyBorder(5, 5, 5, 5));
        p1.add(title);

        JPanel p2 = new JPanel();
        JLabel name = new JLabel("Name:            ");
        JTextField nameField = new JTextField(20);
        p2.add(name);
        p2.add(nameField);
        p2.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel p3 = new JPanel();
        JLabel password = new JLabel("Password:    ");
        JTextField passField = new JTextField(20);
        p3.add(password);
        p3.add(passField);
        p3.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel p4 = new JPanel();
        JLabel email = new JLabel("Email Id:        ");
        JTextField emailField = new JTextField(20);
        p4.add(email);
        p4.add(emailField);
        p4.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel p5 = new JPanel();
        JLabel contact = new JLabel("Contact No.: ");
        JTextField contactField = new JTextField(20);
        p5.add(contact);
        p5.add(contactField);
        p5.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel p6 = new JPanel();
        JButton add = new JButton("ADD TEACHER");
        JButton back = new JButton("BACK");
        p6.add(back);
        p6.add(add);
        p6.setBorder(new EmptyBorder(5, 5, 5, 5));

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String pswrd = passField.getText();
                String id = emailField.getText();
                String num = contactField.getText();

                Connection conn;
                Statement stmt;

                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/teacher3", "root", "piyush8010827159");

                    stmt = conn.createStatement();

                    stmt.execute("insert into teacher2 values ('" + name + "','" + pswrd + "','" + id + "','" + num + "')");
                    //System.out.println("success");
                    conn.close();

                    frame.dispose();
                    JDialog dialog= new JDialog();
                    dialog.setSize(300,200);
                    dialog.setLayout(new GridBagLayout());
                    JLabel text= new JLabel("Added successfully");
                    JButton b= new JButton("OK");

                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dialog.setVisible(false);
                            new AdminSection();
                        }
                    });

                    dialog.add(text);
                    dialog.add(b);
                    dialog.setVisible(true);

                    // new AdminSection();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AdminSection();
            }
        });

        JPanel p7 = new JPanel();
        p7.add(p1);
        p7.add(p2);
        p7.add(p3);
        p7.add(p4);
        p7.add(p5);
        p7.add(p6);

        //frame.add(p7);

        Container p = frame.getContentPane();
        p.setLayout(new GridBagLayout());

        GroupLayout gl = new GroupLayout(p7);
        p7.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup().addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(p1).addComponent(p2, -1, -1, -2).addComponent(p3, -1, -1, -2).
                        addComponent(p4, -1, -1, -2).addComponent(p5, -1, -1, -2)
                .addComponent(p6)));

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(p1).addComponent(p2, -1, -1, -2).addComponent(p3, -1, -1, -2)
                .addComponent(p4, -1, -1, -2).addComponent(p5, -1, -1, -2)
                .addComponent(p6, -1, -1, -2));

        frame.add(p7);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new addTeacher();
    }
}
