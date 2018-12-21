
import java.sql.*;

class databaseDemo {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/TEACHER", "root", "Vikrant@2");

//            System.out.println("Creating database...");
            stmt = conn.createStatement();
//
//            stmt.executeUpdate("Create database TEACHER");
//            System.out.println("Success");

           // stmt.execute("create table teacher (Name varchar(20), Password varchar(20), emailId varchar(20), " +
            //        "ContactNo varchar(10))");

//            stmt.execute("insert into teacher values ('Rajesh', 'rajesh123', 'rajesh@gmail.com','8984324435')");
//            stmt.execute("insert into teacher values ('Shivam', 'shivam123', 'shivam@gmail.com','9884324435')");
//            stmt.execute("insert into teacher values ('Priya Kumari', 'pk123', 'priya@gmail.com','9984324435')");
//            stmt.execute("insert into teacher values ('Sonika', 'sonika123', 'sonika@gmail.com','9911894944')");

            ResultSet rs= stmt.executeQuery("select * from teacher");
            while(rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " +
                        rs.getString(3)+" "+ rs.getString(4));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
