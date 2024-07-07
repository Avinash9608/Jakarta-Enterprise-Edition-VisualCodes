//Update price of books 
import java.sql.*;
import java.util.Scanner;
class MyJdbcApp7
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
PreparedStatement ps = conn.prepareStatement("UPDATE allbooks SET bookprice = bookprice + ? WHERE subject = ?");

System.out.println("Enter Subject name which you want to update");
String bSub=kb.nextLine();

System.out.println("Enter amount by how much it increase");
double bPrice=kb.nextDouble();

ps.setDouble(1,bPrice);
ps.setString(2,bSub);

int ans=ps.executeUpdate();
if(ans!=0)
System.out.println("Total books updated:"+ans);
else
System.out.println("No books updated!");   

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
