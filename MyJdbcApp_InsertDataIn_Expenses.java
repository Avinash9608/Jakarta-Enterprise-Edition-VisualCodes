//Create Table
import java.sql.*;
import java.util.Scanner;
class MyJdbcApp_InsertDataIn_Expenses
{
public static void main(String[]args)
{
Scanner kb=new Scanner(System.in);
Connection conn=null;
try
{
Class.forName("oracle.jdbc.OracleDriver");
System.out.println("Driver Loaded Successfully");
conn=DriverManager.getConnection("jdbc:oracle:thin:@//AvinashKumar:1521/XE","advjavabatch5","mystudents");
System.out.println("Connection to DB open Successfully");
Statement st=conn.createStatement();
System.out.println("Statement Object created Successfully");
PreparedStatement ps=conn.prepareStatement("Insert into expenses values(?,?)");
String result;
do{
System.out.println("Enter department number ");
int dptno=kb.nextInt();
System.out.println("Enter amount ");
double amt=kb.nextDouble();

ps.setInt(1,dptno);
ps.setDouble(2,amt);

int ans=ps.executeUpdate();
if(ans!=0)
System.out.println("Rec inserted "+ans);
else
System.out.println("No Record Inserted");

System.out.println("Do you want to insert more record (Yes/No)");
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


