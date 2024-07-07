import java.sql.*;
class Test
{
public static void main(String [] args)
{
try
{
Class.forName("oracle.jdbc.OracleDriver");
System.out.println("Driver loaded successfully!");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//AvinashKumar:1521/XE","advjavabatch5","mystudents");
System.out.println("Connected to oracle successfully!");
Statement st=conn.createStatement();
System.out.println("Statement Object Created successfully!");
}
catch(ClassNotFoundException cnf)
{
System.out.println("Driver class cannot be loaded!"+cnf.getMessage());
}
catch(SQLException sqlex)
{
System.out.println("Cannot connect to Oracle!"+sqlex.getMessage());
}
}
}



