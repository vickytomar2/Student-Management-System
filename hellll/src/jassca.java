import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class jassca {


        public jassca(){
            JFrame frame = new JFrame("Login as Teacher");
              frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 450, 300);
            JPanel panel0 = new JPanel();
            panel0.setBorder(new EmptyBorder(5, 5, 5, 5));
            JPanel panel1 = new JPanel();
            panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
            JPanel panel2 = new JPanel();
            panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
            JPanel panel3 = new JPanel();
            panel3.setBorder(new EmptyBorder(5, 5, 5, 5));
            JPanel panel4 = new JPanel();
           // panel3.setBorder(new EmptyBorder(5, 5, 5, 5));
            JLabel lblAccountantLogin = new JLabel("TEACHER LOGIN");
            lblAccountantLogin.setFont(new Font("Tahoma", 0, 20));
            lblAccountantLogin.setForeground(Color.DARK_GRAY);
            panel0.add(lblAccountantLogin) ;
            JLabel lblName = new JLabel("NAME:");
            JTextField textfield = new JTextField();
            textfield.setColumns(10);
            JLabel lblPassword = new JLabel("PASSWORD:");
            JPasswordField passwordField = new JPasswordField();
            passwordField.setColumns(10);
            panel1.add(lblName) ;
            panel1.add(textfield) ;
            panel2.add(lblPassword) ;
            panel2.add(passwordField) ;
            JButton Login = new JButton("LOGIN");
            Login.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    frame.dispose();
                    new teacher_logged_in();
                }
            });
            JButton Back = new JButton("BACK");
            Back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    frame.dispose();
                    new testing();
                }
            });

            panel3.add(Back) ;
            panel3.add(Login) ;
            panel4.add(panel0) ;
            panel4.add(panel1) ;
            panel4.add(panel2) ;
            panel4.add(panel3) ;
            frame.add(panel4) ;

            Container contentPanel = frame.getContentPane();
            GroupLayout groupLayout = new GroupLayout(panel4);
            frame.getContentPane().setLayout(new GridBagLayout());
            panel4.setLayout(groupLayout);
            groupLayout.setAutoCreateGaps(true);
            groupLayout.setAutoCreateContainerGaps(true);

            groupLayout.setHorizontalGroup(
                    groupLayout.createSequentialGroup()
                            .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(panel0,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panel1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panel2,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panel3,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)));

            groupLayout.setVerticalGroup(
                    groupLayout.createSequentialGroup()
                            .addComponent(panel0,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel2,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel3,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE));



        }

        public static void main(String args[]){
            new jassca() ;
        }

}
