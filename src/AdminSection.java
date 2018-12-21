import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vikrant on 16-12-2018.
 */
public class AdminSection {
    JFrame frame;

    AdminSection(){
        frame = new JFrame("Admin Login");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width/2, height/2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("ADMIN SECTION");
        title.setFont(new Font("Tahoma",0,20));
        title.setForeground(Color.DARK_GRAY);
        JPanel p2= new JPanel();
        p2.setBorder(new EmptyBorder(5,5,5,5));
        p2.add(title);

        JButton addTeacher= new JButton("Add Teacher");

        JPanel p3= new JPanel();
        p3.setBorder(new EmptyBorder(5,5,5,5));
        p3.add(addTeacher);

        addTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new addTeacher();
            }
        });

        JButton viewTeacher = new JButton("View Teacher details");
        JPanel p4= new JPanel();
        p4.setBorder(new EmptyBorder(5,5,5,5));
        p4.add(viewTeacher);

        viewTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ViewTeacher();
            }
        });


        JButton logout= new JButton("Logout");
        JPanel p6= new JPanel();
        p6.setBorder(new EmptyBorder(5,5,5,5));
        p6.add(logout);

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AdminLogin();
            }
        });

        JPanel p1= new JPanel();
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        //p1.add(p5);
        p1.add(p6);

        Container myPanel = frame.getContentPane();
        myPanel.setLayout(new GridBagLayout());

        GroupLayout gl= new GroupLayout(p1);
        p1.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(
                gl.createSequentialGroup().addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(p2).addComponent(p3).addComponent(p4).addComponent(p6))
        );

        gl.setVerticalGroup(
                gl.createSequentialGroup().addComponent(p2).addComponent(p3).addComponent(p4)
                        .addComponent(p6)
        );

        frame.add(p1);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new AdminSection();
    }
}
