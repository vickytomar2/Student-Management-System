import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminLogin {

    JFrame frame;

    AdminLogin(){

        frame= new JFrame("Admin Login");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width/2, height/2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Admin Login");
        title.setFont(new Font("Tahoma",0,20));
        title.setForeground(Color.DARK_GRAY);
        //title.setBounds(60, 50, 100, 50);
        JPanel p1= new JPanel();
        p1.setBorder(new EmptyBorder(5,5,5,5));
        p1.add(title);

        JPanel namePanel = new JPanel();
        JLabel username = new JLabel("Username: ");
        JTextField nameField= new JTextField();
        nameField.setColumns(30);
        namePanel.add(username);
        namePanel.add(nameField);
        namePanel.setBorder(new EmptyBorder(5,5,5,5));

        JPanel passPanel = new JPanel();
        JLabel password = new JLabel("Password: ");
        JPasswordField passwordField= new JPasswordField();
        passwordField.setColumns(30);
        passPanel.add(password);
        passPanel.add(passwordField);
        passPanel.setBorder(new EmptyBorder(5,5,5,5));

        JPanel p3= new JPanel();
        JButton login = new JButton("LOGIN");
        JButton exit = new JButton("EXIT");
        p3.add(login);
        p3.add(exit);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameField.getText().equals("Admin") && passwordField.getText().equals("admin123")){
                    frame.dispose();

                    new AdminSection();
                }else{

                    JDialog dialog= new JDialog();
                    dialog.setSize(300,200);
                    dialog.setLayout(new GridBagLayout());
                    JLabel text= new JLabel("Invalid Username or Password");
                    JButton b= new JButton("TRY AGAIN");

                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dialog.setVisible(false);
                        }
                    });

                    dialog.add(text);
                    dialog.add(b);
                    dialog.setVisible(true);
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        JPanel p4= new JPanel();
        p4.add(p1);
        p4.add(namePanel);
        p4.add(passPanel);
        p4.add(p3);

        Container myPanel = frame.getContentPane();
        myPanel.setLayout(new GridBagLayout());

        GroupLayout groupLayout = new GroupLayout(p4);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        p4.setLayout(groupLayout);

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(p1)
                                .addComponent(namePanel)
                                .addComponent(passPanel)
                                .addComponent(p3)));
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(p1)
                        .addComponent(namePanel)
                        .addComponent(passPanel)
                        .addComponent(p3));



        frame.add(p4);
//        frame.add(namePanel);
//        frame.add(passPanel);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new AdminLogin();

    }
}
