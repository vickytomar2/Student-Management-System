import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_student {

    public add_student(){
        JFrame f = new JFrame() ;
        JPanel p1 = new JPanel() ;
        JPanel p2 = new JPanel() ;
        JPanel p3 = new JPanel() ;
        JPanel p4 = new JPanel() ;
        JPanel p5 = new JPanel() ;
        JPanel p6 = new JPanel() ;
        JPanel p8 = new JPanel() ;

        JLabel l = new JLabel("ADD STUDENT") ;
        l.setFont(new Font("Tahoma", 0, 20));
        l.setForeground(Color.DARK_GRAY);
        p8.add(l) ;
        //  JPanel p7 = new JPanel() ;
        JLabel l1 = new JLabel("NAME") ;
        JTextField t1 = new JTextField() ;
        t1.setColumns(20);

        JLabel l2 = new JLabel("ROLL No.") ;
        JTextField t2 = new JTextField() ;
        t2.setColumns(20);

        JLabel l3 = new JLabel("STANDARD") ;
        JTextField t3 = new JTextField() ;
        t3.setColumns(20);

        JLabel l4 = new JLabel("FATHER'S NAME") ;
        JTextField t4 = new JTextField() ;
        t4.setColumns(20);

        JLabel l5 = new JLabel("MOTHER'S NAME") ;
        JTextField t5 = new JTextField() ;
        t5.setColumns(20);

        JLabel l6 = new JLabel("MOBILE No.") ;
        JTextField t6 = new JTextField() ;
        t6.setColumns(20);

        JButton add_b = new JButton("ADD") ;
        JButton back = new JButton("BACK") ;

        JPanel p7 = new JPanel() ;
        JPanel p9 = new JPanel() ;

        p9.add(back) ;
        p9.add(add_b) ;
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
             //   new Main(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText());
                new teacher_logged_in();
            }
        });
        add_b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                new Main(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText());
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");

                // new teacher_logged_in();
            }
        });
        p1.add(l1);
        p1.add(t1);
        p2.add(l2);
        p2.add(t2);
        p3.add(l3);
        p3.add(t3);
        p4.add(l4);
        p4.add(t4);
        p5.add(l5);
        p5.add(t5);
        p6.add(l6);
        p6.add(t6);

        //p7.add(p8) ;
        p7.add(p1) ;
        p7.add(p2) ;
        p7.add(p3) ;
        p7.add(p4) ;
        p7.add(p5) ;
        p7.add(p6) ;
        p7.add(p9) ;
        f.add(p8,BorderLayout.PAGE_START) ;
        f.add(p7,BorderLayout.CENTER) ;
        //f.getContentPane().setLayout(new BorderLayout());

        GroupLayout groupLayout = new GroupLayout(p7);
        //frame.getContentPane().setLayout(new GridBagLayout());
        p7.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            //    .addComponent(p8,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addComponent(p1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addComponent(p2,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addComponent(p3,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addComponent(p4,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addComponent(p5,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addComponent(p6,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addComponent(p9,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)));

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        //.addComponent(p8,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addComponent(p1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addComponent(p2,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addComponent(p3,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addComponent(p4,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addComponent(p5,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addComponent(p6,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addComponent(p9,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100, 100, 500, 500);
    }
    public static void main(String args[]){
        new add_student();
    }
}
