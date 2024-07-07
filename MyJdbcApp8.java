import java.sql.*;
import java.util.Scanner;
class MyJdbcApp8
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
                     PreparedStatement ps=conn.prepareStatement("delete from allbooks where subject=?");
                     
                     System.out.println("Enter subject name:");
                     String subj=kb.nextLine();
                     
                   
                    
                     ps.setString(1,subj);

                    int ans=ps.executeUpdate();
                  
                         System.out.println("Number of  books deleted! "+ans);                
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