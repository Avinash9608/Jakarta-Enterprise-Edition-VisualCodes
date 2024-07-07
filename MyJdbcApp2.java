//Improved and correct way of Advjava code
import java.sql.*;
class MyJdbcApp2
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
ResultSet rs=st.executeQuery("Select ename, sal from emp");
while(rs.next())
{
String name=rs.getString(1);
int sal=rs.getInt(2);
System.out.println("Name-> "+name+"\t"+"salary->"+sal);
}
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


