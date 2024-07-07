//executeUpdate Insert data in table Dyanmically
import java.sql.*;
import java.util.Scanner;
class MyJdbcApp4
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

Scanner kb=new Scanner(System.in);
System.out.println("Enter emp_no ");
int eno=kb.nextInt();

System.out.println("Enter emp_name ");
kb.nextLine();
String name=kb.nextLine();

System.out.println("Enter emp_sal ");
int sal=kb.nextInt();

System.out.println("Enter emp_dptno ");
int dptno=kb.nextInt();


System.out.println("Enter emp_HireDate ");
kb.nextLine();
String hireDate=kb.nextLine();

int ans=st.executeUpdate("insert into emp values("+eno+",'"+name+"',"+sal+","+dptno+",'"+hireDate+"')");
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


