//Insert Data in emp and based on the department number update the amount in expenses
import java.sql.*;
import java.util.Scanner;
class MyJdbcApp_InsertDataIn_Emp_UpdateIn_Expenses
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
PreparedStatement ps=conn.prepareStatement("Insert into emp values(?,?,?,?)");
PreparedStatement psExp=conn.prepareStatement("Update  expenses set amount=amount+? where dptno=?");

String result;
do{
System.out.println("Enter emp number ");
int eno=kb.nextInt();

System.out.println("Enter emp name ");
kb.nextLine();
String ename=kb.nextLine();

System.out.println("Enter emp sal ");
double esal=kb.nextDouble();

System.out.println("Enter emp dptno ");
int dptno=kb.nextInt();

ps.setInt(1,eno);
ps.setString(2,ename);
ps.setDouble(3,esal);
ps.setInt(4,dptno);


int ans=ps.executeUpdate();
if(ans!=0){
System.out.println("Rec inserted "+ans);
psExp.setDouble(1,esal);
psExp.setInt(2,dptno);
int update=psExp.executeUpdate();
if(update!=0)
System.out.println("Number of book whose price updated "+update);
else 
System.out.println("No books updated "+update);
}
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


