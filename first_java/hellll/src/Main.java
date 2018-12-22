import java.sql.*;
class Main{
    public Main(String name,String roll,String standard,String fname,String mname,String mno){
        try{
            PreparedStatement pst,cst;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student","root","piyush8010827159");
//here sonoo is database name, root is username and password
            cst = con.prepareStatement("select * from student where rollno=?");
            cst.setString(1,roll);
            ResultSet rs = cst.executeQuery() ;
            int count = 0 ;
            while(rs.next()){
                System.out.println("already present roll number");
                count++;
            }
            if(count==0) {
                pst = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
                pst.setString(1, name);
                pst.setString(2, roll);
                pst.setString(3, standard);
                pst.setString(4, fname);
                pst.setString(5, mname);
                pst.setString(6, mno);
                boolean b = pst.execute();
                //Statement stmt=con.createStatement();
                //ResultSet rs=stmt.executeQuery();
                //while(rs.next())
                System.out.println("added succes" + b);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    Main(){

    }
    public static void main(String[] args){
        new Main() ;
    }
}