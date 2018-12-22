import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;


public class search_student {
    public search_student(){
        JFrame f = new JFrame() ;
        JPanel p1 = new JPanel() ;
        JPanel p2 = new JPanel() ;
        JPanel p3 = new JPanel() ;
        JPanel p4 = new JPanel() ;
        JPanel p5 = new JPanel() ;
        JPanel p6 = new JPanel() ;
        JPanel p8 = new JPanel() ;

        JLabel l = new JLabel("SEARCH STUDENT") ;
        l.setFont(new Font("Tahoma", 0, 20));
        l.setForeground(Color.DARK_GRAY);
        p8.add(l) ;
        //  JPanel p7 = new JPanel() ;
        JLabel l1 = new JLabel("NAME") ;
        JTextField t1 = new JTextField() ;
        t1.setColumns(20);
        t1.setEditable(false);

        JLabel l2 = new JLabel("ENTER ROLL No.") ;
        JTextField t2 = new JTextField() ;
        t2.setColumns(20);
        //t.setEditable(false);

        JLabel l3 = new JLabel("STANDARD") ;
        JTextField t3 = new JTextField() ;
        t3.setColumns(20);
        t3.setEditable(false);

        JLabel l4 = new JLabel("FATHER'S NAME") ;
        JTextField t4 = new JTextField() ;
        t4.setColumns(20);
        t4.setEditable(false);

        JLabel l5 = new JLabel("MOTHER'S NAME") ;
        JTextField t5 = new JTextField() ;
        t5.setColumns(20);
        t5.setEditable(false);

        JLabel l6 = new JLabel("MOBILE No.") ;
        JTextField t6 = new JTextField() ;
        t6.setColumns(20);
        t6.setEditable(false);

        JButton add_b = new JButton("SEARCH") ;
        JButton back = new JButton("BACK") ;

        JPanel p7 = new JPanel() ;
        JPanel p9 = new JPanel() ;

        p9.add(back) ;
        p9.add(add_b) ;
        //JPanel p7 = new JPanel() ;
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                new teacher_logged_in();
            }
        });

        p1.add(l2);
        p1.add(t2);
        p2.add(l1);
        p2.add(t1);
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
        f.setBounds(100, 100, 450, 400);


        add_b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //f.dispose();
                String roll3 = t2.getText();
                search s = new search();
                ArrayList<String> s10 = new ArrayList<>();
                System.out.println(roll3);
                s10 = s.search2(roll3);
                if (s10.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No such student","Failed!!",
                            JOptionPane.ERROR_MESSAGE);
                    t1.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                } else {
                    //new teacher_logged_in();
                    t1.setText(s10.get(1));
                    t3.setText(s10.get(2));
                    t4.setText(s10.get(3));
                    t5.setText(s10.get(4));
                    t6.setText(s10.get(5));
                }
            }
        });
    }
    public static void main(String args[]){
        new search_student() ;

    }

}
class search{
    public ArrayList<String> search2(String roll){

        try{
            ArrayList<String> res = new ArrayList<>();
            PreparedStatement ct;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student","root","piyush8010827159");
//here sonoo is database name, root is username and password
            ct = con.prepareStatement("select * from student where rollno=? ");
            ct.setString(1,roll);
            ResultSet rs = ct.executeQuery() ;
            System.out.println(roll);
            //int count = 0 ;
            if(rs.next()){
                System.out.println(" found roll number");
                //count++;
                String roll1 = rs.getString("rollno");
                String name = rs.getString("s_name");
                String standard = rs.getString("standard");
                String father = rs.getString("f_name");
                String mother = rs.getString("m_name");
                String mobno = rs.getString("mob_no");
                System.out.println(roll1+" "+name+" "+standard+" ");
                res.add(roll1);
                res.add(name);
                res.add(standard);
                res.add(father);
                res.add(mother);
                res.add(mobno);
                //count++;
                return res ;

            }
            con.close();
            return res ;
        }catch(Exception e){
            ArrayList<String> res =new ArrayList<>();
            System.out.println(e);
            return res ;
        }

    }
}

