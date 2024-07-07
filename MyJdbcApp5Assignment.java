//PreparedStatement DYNAMIC QUERY Taking Input At RunTime
import java.sql.*;
import java.util.Scanner;
class MyJdbcApp5Assignment
{
public static void main(String[]args)
{
Connection conn=null;
Scanner kb=new Scanner(System.in);
try
{
Class.forName("oracle.jdbc.OracleDriver");
System.out.println("Driver Loaded Successfully");
conn=DriverManager.getConnection("jdbc:oracle:thin:@//AvinashKumar:1521/XE","advjavabatch5","mystudents");
System.out.println("Connection to DB open Successfully");
PreparedStatement ps=conn.prepareStatement("Insert into emp values(?,?,?,?,?)");
String result;
do{
System.out.println("Enter emp_no ");
int eno=kb.nextInt();

System.out.println("Enter emp_name ");
kb.nextLine();
String name=kb.nextLine();

System.out.println("Enter emp_sal ");
double sal=kb.nextInt();

System.out.println("Enter emp_dptno ");
int dptno=kb.nextInt();


System.out.println("Enter emp_HireDate ");
kb.nextLine();
String hireDate=kb.nextLine();

ps.setInt(1,eno);
ps.setString(2,name);
ps.setDouble(3,sal);
ps.setInt(4,dptno);
ps.setString(5,hireDate);

int ans=ps.executeUpdate();

System.out.println("Rec inserted "+ans);

System.out.println("Do you want to enter more records (Yes/No)");
result=kb.next();
}while(result.equalsIgnoreCase("Yes"));
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


