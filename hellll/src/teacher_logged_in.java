import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class teacher_logged_in {
    public teacher_logged_in(){
        JFrame f = new JFrame("WELCOME!!") ;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        f.setSize(width/2, height/2);
        JLabel l = new JLabel("SELECT ACTION") ;
        l.setFont(new Font("Tahoma", 0, 20));
        l.setForeground(Color.DARK_GRAY);
        JButton b1 = new JButton("ADD STUDENT") ;
        JButton b2 = new JButton("SEARCH STUDENT") ;
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                new add_student();
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                new search_student();
            }
        });
        JPanel p1 = new JPanel() ;
        JPanel p2 = new JPanel() ;
        p1.add(b1) ;
        p1.add(b2) ;
        p2.add(l) ;
        p2.add(p1) ;
        f.add(p2) ;
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GroupLayout groupLayout = new GroupLayout(p2);
        f.getContentPane().setLayout(new GridBagLayout());
        p2.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(l,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(50)
                                .addComponent(p1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)));

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(l,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addGap(50)
                        .addComponent(p1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE));

    }

}
