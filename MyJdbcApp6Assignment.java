//PreparedStatement DYNAMIC QUERY Taking Input At RunTime
import java.sql.*;
import java.util.Scanner;
class MyJdbcApp6Assignment
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
PreparedStatement ps=conn.prepareStatement("Insert into allbooks values(?,?,?,?)");
String result;
int count=0;
do{
System.out.println("Enter Book_Id ");
int bId=kb.nextInt();

System.out.println("Enter Book_name ");
kb.nextLine();
String bName=kb.nextLine();

System.out.println("Enter Book_Price ");
double bPrice=kb.nextInt();

System.out.println("Enter Subject ");
kb.nextLine();
String bSub=kb.nextLine();



ps.setInt(1,bId);
ps.setString(2,bName);
ps.setDouble(3,bPrice);
ps.setString(4,bSub);

int ans=ps.executeUpdate();
if(ans!=0)
count++;

System.out.println("Total Books Inserted  "+count);

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


