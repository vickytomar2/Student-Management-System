import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testing {
    public testing(){
        JFrame f = new JFrame() ;
        //f.setSize(400,400);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        f.setSize(width/2, height/2);

        // here's the part where i center the jframe on screen
        f.setLocationRelativeTo(null);
        JButton p1 = new JButton("ADMIN LOGIN") ;
        JButton p2 = new JButton("TEACHER LOGIN") ;
        p1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                new AdminLogin();
            }
        });
        p2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                new jassca();
            }
        });
        JPanel p3 = new JPanel() ;
        p3.add(p1);
        p3.add(p2) ;
        f.add(p3);
        //f.add(p2) ;

        // f.setLayout(new FlowLayout(FlowLayout.CENTER));
        Container contentPanel = f.getContentPane();
        GroupLayout groupLayout = new GroupLayout(p3);
        f.getContentPane().setLayout(new GridBagLayout());

        p3.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(p1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)

                                .addComponent(p2,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)));

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(p1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)

                        .addComponent(p2,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE));
        // groupLayout.linkSize(SwingConstants.HORIZONTAL, p1, p2);

        //f.pack();

        f.setVisible(true);
//        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        new testing() ;
    }
}
