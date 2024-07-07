//Create Table
import java.sql.*;
class MyJdbcApp_CreateTable_Emp
{
public static void main(String[]args)
{
Connection conn=null;
try
{
Class.forName("oracle.jdbc.OracleDriver");
System.out.println("Driver Loaded Successfully");
conn=DriverManager.getConnection("jdbc:oracle:thin:@//AvinashKumar:1521/XE","advjavabatch5","mystudents");
System.out.println("Connection to DB open Successfully");
Statement st=conn.createStatement();
System.out.println("Statement Object created Successfully");
int ans=st.executeUpdate("create table emp(eno number(3), ename varchar2(20), sal number(7,2), dptno number(3))");
System.out.println("Rec inserted "+ans);
}
catch(ClassNotFoundException cnf)
{
System.out.println("Class not loaded "+cnf.getMessage());
}
catch(SQLException sqlex)
{
System.out.println("Problem in DB "+sqlex.getMessage());
}
finally
{
try
{
if(conn!=null)
{
conn.close();
System.out.println("Connection close to DB Successfully");
 }
}catch(SQLException sqlex)
{
System.out.println("Problem in Closing the connection  "+sqlex.getMessage());
}
}
}
}


