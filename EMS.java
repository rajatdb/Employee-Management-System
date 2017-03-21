import java.sql.*;
import java.util.*;
class EMS
{
	public static void main(String[] args)
	
	{
		   System.out.print("Please wait for seconds");
		for(int w=0;w<5;w++)
		{
		try{
			 	Thread.sleep(400);
				System.out.print(".");
		   }
		   catch(InterruptedException x)
		   {
		   }
		}
		   System.out.println("\n");
		   System.out.println("**********************PROJECT ON EMPLOYEE MANAGEMENT SYSTEM**********************");
		try
		{	
			for(int l=1;l>0; l++)
			{
			Scanner scn = new Scanner(System.in);
			System.out.println("\n");
			System.out.println("1. Add New Employee \n2. Show All Employee\n3. Search Employee \n4. Update Employee Information \n5. Delete Employee \n6. Login \n7. Exit");
			System.out.print("Press KEY to perform OPERATION..... ");
			int num = scn.nextInt();
			System.out.println("\n");
			if(num==1)
			{
				System.out.print("EmpID: \t");
				int empid = scn.nextInt();
				System.out.print("NAME: \t");
				String name = scn.next();
				System.out.print("GENDER: \t");
				String gender = scn.next();
				System.out.print("ADDRESS: \t");
				String address = scn.next();
				System.out.print("CITY: \t");
				String city = scn.next();
				System.out.print("MOBILE: \t");
				String mobile = scn.next();
				System.out.print("E-MAIL: \t");
				String email = scn.next();
				System.out.print("FACEBOOK-ID: \t");
				String facebookid = scn.next();
				System.out.print("WEBSITE: \t");
				String website = scn.next();
				System.out.print("BLOG: \t");
				String blog = scn.next();
				System.out.print("USERNAME: \t");
				String username = scn.next();
				System.out.print("PASSWORD: \t");
				String password = scn.next();

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","sql");
				Statement stmt = con.createStatement();
			
				String str = "insert into employee values("+empid+",'"+name+"','"+gender+"','"+address+"','"+city+"','"+mobile+"','"+email+"','"+facebookid+"','"+website+"','"+blog+"','"+username+"','"+password+"')";
				int i = stmt.executeUpdate(str);
				if(i>0)
				{
					System.out.println("Record has been Saved..!!!");
				}
			}
			if(num==2)
			{
				Class.forName("com.mysql.jdbc.Driver");
				String select = "select * from employee";
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","sql");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(select);
					while(rs.next())
					{
					System.out.println("================================");
					System.out.println("Name:        "+ rs.getString(2));
					System.out.println("EMP_ID:      "+ rs.getInt(1));
					System.out.println("GENDER:      "+ rs.getString(3));
					System.out.println("ADDRESS:     "+ rs.getString(4));
					System.out.println("CITY:        "+ rs.getString(5));
					System.out.println("MOBILE:      "+ rs.getString(6));
					System.out.println("EMAIL:       "+ rs.getString(7));
					System.out.println("FACEBOOK_ID: "+ rs.getString(8));
					System.out.println("WEBSITE:     "+ rs.getString(9));
					System.out.println("BLOG:        "+ rs.getString(10));
					System.out.println("USERNAME:    "+ rs.getString(11));
					System.out.println("PASSWORD:    "+ rs.getString(12));
					System.out.println("================================");
					}
			}
			if(num==3)
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Enter the EMPLOYEE_NAME to SEARCH");
				String name1 = scn.next();
				String search1 = "select * from employee where name='"+name1+"'";
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","sql");
				Statement stmt1 = conn.createStatement();
				ResultSet rs1 = stmt1.executeQuery(search1);
				if(rs1.next())
				{
					System.out.println("\n");
					System.out.println("USERNAME IS FOUND...");
					System.out.println("\n");
				}
				else
				{
					System.out.println("SORRY !! USERNAME IS NOT FOUND...");
					break;
				}
				System.out.println("*******PLEASE LOGIN FIRST TO SEE "+name1+" DETAILS*******");
				System.out.println("------------------------");
				System.out.print("USERNAME: ");
				String usr = scn.next();
				System.out.print("PASSWORD: ");
				String pswd = scn.next();
				System.out.println("------------------------");
				System.out.println("\n");
				String login = "select * from employee where USERNAME='"+usr+"' and PASSWORD='"+pswd+"'";
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","sql");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(login);
				if(rs.next())
				{
					System.out.println("Name:        "+ rs.getString(2));
					System.out.println("EMP_ID:      "+ rs.getInt(1));
					System.out.println("GENDER:      "+ rs.getString(3));
					System.out.println("ADDRESS:     "+ rs.getString(4));
					System.out.println("CITY:        "+ rs.getString(5));
					System.out.println("MOBILE:      "+ rs.getString(6));
					System.out.println("EMAIL:       "+ rs.getString(7));
					System.out.println("FACEBOOK_ID: "+ rs.getString(8));
					System.out.println("WEBSITE:     "+ rs.getString(9));
					System.out.println("BLOG:        "+ rs.getString(10));
					System.out.println("USERNAME:    "+ rs.getString(11));
					System.out.println("PASSWORD:    "+ rs.getString(12));
				}
				else
				{
					System.out.println("BOTH USERNAME AND PASSWORD ARE NOT MATCHED...");
				}
			}
			if(num==4)
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","sql");
				Statement stmt = con.createStatement();
				System.out.println("Enter the Employee_id for UPDATING the INFORMATION");
				int id = scn.nextInt();
				System.out.println("Enter the field which to be UPDATE");
				String upd = scn.next();
				System.out.println("Enter to Change the EMPLOYEE "+upd+" for Update");
				String chng = scn.next();
				String upd2 = "update employee set "+upd+"='"+chng+"' where empid="+id+"";
				int k = stmt.executeUpdate(upd2);
				if(k>0)
				{
					System.out.println("Record has been Updated..!!!");
				}
			}
			if(num==5)
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","sql");
				Statement stmt = con.createStatement();
				System.out.println("Enter EmpID to be Deleted");
				int e = scn.nextInt();
				String str2 = "delete from employee where empid="+e+"";
				int j = stmt.executeUpdate(str2);
				if(j>0)
				{
					System.out.println("Record has been Deleted..!!!");
				}
			}
			if(num==6)
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("*******PLEASE LOGIN TO SEE EMPLOYEE_DETAILS*******");
				System.out.println("------------------------");
				System.out.print("USERNAME: ");
				String usr = scn.next();
				System.out.print("PASSWORD: ");
				String pswd = scn.next();
				System.out.println("------------------------");
				System.out.println("\n");
				String login = "select * from employee where USERNAME='"+usr+"' and PASSWORD='"+pswd+"'";
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","sql");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(login);
				if(rs.next())
				{
					System.out.println("=========================================");
					System.out.println("Name:        "+ rs.getString(2));
					System.out.println("EMP_ID:      "+ rs.getInt(1));
					System.out.println("GENDER:      "+ rs.getString(3));
					System.out.println("ADDRESS:     "+ rs.getString(4));
					System.out.println("CITY:        "+ rs.getString(5));
					System.out.println("MOBILE:      "+ rs.getString(6));
					System.out.println("EMAIL:       "+ rs.getString(7));
					System.out.println("FACEBOOK_ID: "+ rs.getString(8));
					System.out.println("WEBSITE:     "+ rs.getString(9));
					System.out.println("BLOG:        "+ rs.getString(10));
					System.out.println("=========================================");
				}
				else
				{
					System.out.println("Sorry !! INVALID USER_ID..... NOT FOUND...");
				}
				
			}
			if(num==7)
			{
				System.exit(0);
			}
			}
		}
			catch(ClassNotFoundException | SQLException ex)
			{
				ex.getMessage();
			}
	}
}