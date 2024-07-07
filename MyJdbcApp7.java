import java.sql.*;
import java.util.Scanner;
class MyJdbcApp7
{
	public static void main(String [] args)
	{
		 Connection conn=null;
               Scanner kb=new Scanner(System.in);
                try
                {
                     Class.forName("oracle.jdbc.OracleDriver");
                     System.out.println("Driver loaded successfully!");
                    conn=DriverManager.getConnection("jdbc:oracle:thin:@//AvinashKumar:1521/XE","advjavabatch5","mystudents");
                     System.out.println("Connection opened to the DB successfully!");
                     PreparedStatement ps=conn.prepareStatement("Update allbooks set bookprice=bookprice+? where subject=?");
                     
                     System.out.println("Enter subject name:");
                     String subj=kb.nextLine();
                     
                    System.out.println("Enter amount:");
                    double amt=kb.nextDouble();
                    
                    ps.setDouble(1,amt);
                    ps.setString(2,subj);

                    int ans=ps.executeUpdate();
                   if(ans!=0)
                        System.out.println("Total books updated:"+ans);
                  else
                         System.out.println("No books updated!");                
                                 
                    
               }
               catch(ClassNotFoundException cnf)
                {
                    System.out.println("Cannot load the driver class:"+cnf.getMessage());
                }
               catch(SQLException sqlex)
                {
                    System.out.println("Problem in DB:"+sqlex.getMessage());
                }
		finally
		{
			  try
                        {
                         if(conn!=null)
                         {
                         	conn.close();
                         	System.out.println("Connection closed successfully!");
                         }
                        }
                         catch(SQLException sqlex)
                	{
                    	     System.out.println("Problem in closing the connection:"+sqlex.getMessage());
                	}
               }
       }
}