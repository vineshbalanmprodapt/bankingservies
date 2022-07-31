package bankingServices;

import java.sql.*;
import java.util.Scanner;

public class BankServices {
	
	public void adminlogin() throws Exception {
		Scanner sc1=new Scanner(System.in);
		Connection acon=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniprojectfinal","root","root");
		
		
		System.out.println("ADMIN LOGIN:-");
		System.out.println("____________________________________________________________________");
		
		 System.out.println("Enter The Username:");
		 String ausername=sc1.next();
		 System.out.println("Enter Your Password");
		 String apass=sc1.next();
		 Statement ast=acon.createStatement();
		 ResultSet ars=ast.executeQuery("select * from admindetails");
		 int t=0;
		 String au=ausername.toUpperCase();
		
		 System.out.println("____________________________________________________________________");
		 while(ars.next()) {
			 if((ars.getString(2).equals(ausername)) && (ars.getString(3).equals(apass))) {
				 
				
				 System.out.println("Welcome "+au+",Your Account is Successfully Logged In........");
			   t++;}
			  
			 
			 }
		
if(t==0) {
	System.out.println("loginfail");
}


if(t==1){
		System.out.println("ADMIN SERVICES:-");
		System.out.println("1)Update User Records");
		System.out.println("2)Delete User Records");
		int aservice=sc1.nextInt();
		 System.out.println("______________________________________________________________________________________");
		switch(aservice) {
		case 1:
		{
			 
			 Statement ust=acon.createStatement();
			 ResultSet urs=ust.executeQuery("select * from userdetails");
			
			 while(urs.next()) {
				 System.out.println("| Name:"+urs.getString(1)+" | AccountNumber:"+urs.getString(2)+" | Branch: "+urs.getString(3)+" | Phone: "+urs.getString(4)+" | Ifsc_code: "+urs.getString(5)+" | password: "+urs.getString(6)+" | balance: "+urs.getString(7)+" |");
			 }
			 System.out.println("____________________________________________________________________");
			 System.out.println("Type The Username Which You Want To Update");
			 String user=sc1.next();
			 ResultSet urs1=ust.executeQuery("select * from userdetails");
			 while(urs1.next()) {
				 if(urs1.getString(1).equals(user)) {
			    System.out.println("Enter The Details.......");
				System.out.println("____________________________________________________________________");
				System.out.println("Name:");
				String unn=sc1.next();
				System.out.println("AccountNumber:");
				String uaa=sc1.next();
				System.out.println("Branch:");
				String ubb=sc1.next();
				System.out.println("Phone:");
				String upp=sc1.next();
				System.out.println("Ifsc_Code:");
				String uii=sc1.next();
				System.out.println("Password:");
				String upa=sc1.next();
				System.out.println("Balance:");
				String uba=sc1.next();
				
				
			 PreparedStatement aps=acon.prepareStatement("update userdetails set Name=?,AccountNumber=?,Branch=?,Phone=?,Ifsc_code=?,password=?,balance=? where name=?;");
			 aps.setString(1,unn);
			 aps.setString(2,uaa);
			 aps.setString(3,ubb);
			 aps.setString(4,upp);
			 aps.setString(5,uii);
			 aps.setString(6,upa);
			 aps.setString(7,uba);
			 aps.setString(8,user);
			aps.executeUpdate();
			System.out.println("Account Details Updated Successfully!!!!!....");
			break;
			 
		}}}
		case 2:
		{
			Statement ust=acon.createStatement();
			 ResultSet urs=ust.executeQuery("select * from userdetails");
			
			 while(urs.next()) {
				 System.out.println("| Name:"+urs.getString(1)+" | AccountNumber:"+urs.getString(2)+" | Branch: "+urs.getString(3)+" | Phone: "+urs.getString(4)+" | Ifsc_code: "+urs.getString(5)+" | password: "+urs.getString(6)+" | balance: "+urs.getString(7)+" |");
			 }
			 System.out.println("_______________________________________________________________________________________________________");
			System.out.println("Enter the Username to delete the record");
			String deluser=sc1.next();
			 
			 Statement dst=acon.createStatement();
			
			 ResultSet drs=dst.executeQuery("select * from userdetails");
			 while(drs.next()) {
				 if(drs.getString(1).equals(deluser)) {
					 PreparedStatement dps=acon.prepareStatement("delete from userdetails where Name=?");
					 dps.setString(1, deluser);
					 dps.executeUpdate();
					 System.out.println("Record Is Deleted Successfuly....");
					 System.out.println("____________________________________________________________________");
				 }
			
		}
			
				
		break;	
		}}
		
	}
	}
	public static void main(String[] args) {
		try {
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniprojectfinal","root","root");
		System.out.println("<--------------------------------------------------->");
		System.out.println("|---------Welcome--To---Banking---Service-----------|");
		System.out.println("<--------------------------------------------------->");
		System.out.println("Press 1 To Go To Admin Login");
		System.out.println("Press 2 To Go To User Login");	
		int role=sc.nextInt();
		switch(role) {
		case 1:{
			BankServices bs=new BankServices();
			bs.adminlogin();
			
		break;
		}
		case 2:{
			
		
	
		 System.out.println("Type '1' to Proceed Your Account Creation........");
		 System.out.println("Type '2' to Proceed Your Account Login........");
		 
		 
			System.out.println("____________________________________________________________________");
        
		 int request=sc.nextInt();

		 
		 
if(request==1) {
			 
		 
		   PreparedStatement ps=con.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?);");
		
			System.out.println("<<<<Complete The Follwing Details To Open Your Account>>>> ");
			System.out.println("____________________________________________________________________");
			System.out.println("Full Name:");
			String u1=sc.next();
			System.out.println("Enter Your Phone Number:");
			String u2=sc.next();
			System.out.println("Branch :");//new user read
			String u3=sc.next();
			System.out.println("Create new Password:");
			String u5=sc.next();
			System.out.println("Re-enter the Password");
			String u6=sc.next();
			System.out.println("Enter the Amount to Deposit For The First Time:");
			String deposit=sc.next();
			
			
			if(u5.equals(u6)) {
			ps.setString(1, u1);
			ps.setString(2, "155534"+u2.charAt(0)+""+u2.charAt(u2.length()-1)+""+u2.charAt(2));
			ps.setString(3, u3);
			ps.setString(4, u2);
			String ifsc="SAO1"+u1.charAt(0)+""+u1.charAt(u1.length()-1);
			String temp=ifsc.toUpperCase();
			ps.setString(5,temp);
			ps.setString(6, u5);
			ps.setString(7,deposit);
		    ps.executeUpdate();
		    
		    
		    System.out.println("Your Account Is Opened Successfully");
		    System.out.println("____________________________________________________________________");
		    
			}
		 else {
			 
		 System.out.println("Please Provide The Valid Number And Try Again");
		 System.out.println(System.lineSeparator());
		 System.out.println("<------<>----<>----Thank-----you-----<>-----<>------>");
		 }
			System.out.println(System.lineSeparator());
		 System.out.println("Account Is Ready! Now Login Below With Your Details....");

			System.out.println(System.lineSeparator());
  }
		
		 System.out.println("Are You Sure Want To Login Into Your Account");
		 System.out.println("Yes or No");
		 String req=sc.next();
	
		 if(req.equalsIgnoreCase(req)) {
		   
			    
			 
			 System.out.println("Enter The Username:");
			 String username=sc.next();
			 System.out.println("Enter Your Password:");
			 String pass=sc.next();
			 Statement st=con.createStatement();
			 ResultSet rs=st.executeQuery("select * from userdetails");
			 int balanceuser=(int)0;
			 System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			 int c=0;
			 while(rs.next()) {
				 if((rs.getString(1).equals(username)) && (rs.getString(6).equals(pass))) {
					 
					 balanceuser=Integer.parseInt(rs.getString(7));
					 System.out.println("Welcome\t"+username+", Your Account is Successfully Logged In........");
					  c=2;
					 }
				 else {
					 System.out.println("Login Failed.........");
				 }
					
			 }  
			 System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		 		
		    if(c==2) {
		    	    System.out.println(System.lineSeparator());
					 System.out.println("BANKING SERVICES:");
					 System.out.println("____________________________________________________________________");
					 System.out.println("1)Withdraw");
					 System.out.println("2)Deposit");
					 System.out.println("3)Check Balance");
					 System.out.println("4)Account Details");
					 
				 int service=sc.nextInt();
				 switch(service) {
				 
				 case 1:{
					 System.out.println("Enter The Amount to Withdraw:");
					 int withdraw=sc.nextInt();
					 System.out.println("Enter Your Password:");
					 String pass1=sc.next(); 
					 balanceuser=(int)(balanceuser-withdraw);
					 if(balanceuser>0) {
					 System.out.println("Your Balance="+balanceuser);
					 System.out.println("____________________________________________________________________");
					 PreparedStatement psbal=con.prepareStatement("update userdetails set balance=? where password=?");
					 psbal.setInt(1,balanceuser);
					 psbal.setString(2,pass1);
					 psbal.executeUpdate();
					 System.out.println(System.lineSeparator());
					 System.out.println("<------<>----<>----Thank-----you-----<>-----<>------>");
					 break;
					 }
					 else {System.out.println("Insufficent Balance");
					      break;
					 }
				 }
				 
				 case 2:{
					 System.out.println("Enter The Amount To Deposit:");
					 int dep=sc.nextInt();
					 System.out.println("Enter Your Password:");
					 String pass2=sc.next(); 
					 balanceuser+=dep;
					 System.out.println("____________________________________________________________________");
					 System.out.println("Amount Is Deposited Successfully...");
					 System.out.println("Your Updated Balance="+balanceuser);
					 System.out.println("____________________________________________________________________");
					 System.out.println(System.lineSeparator());
					 System.out.println("<------<>----<>----Thank-----you-----<>-----<>------>");
					 PreparedStatement psdep=con.prepareStatement("update userdetails set balance=? where password=?");
					 psdep.setInt(1,balanceuser);
					 psdep.setString(2,pass2);
					 psdep.executeUpdate();

					 break;
				 }
				 case 3:{
					 System.out.println("Your Balance="+balanceuser);
					 System.out.println("<------<>----<>----Thank-----you-----<>-----<>------>");
					 break;
				 
				 } 
				 
				 case 4:{
					 Statement st1=con.createStatement();
					 ResultSet rs1=st1.executeQuery("select * from userdetails");
					 while(rs1.next()) {
						 if(rs1.getString(1).equals(username)) {
							String accno=rs1.getString(2);
							String ifscno=rs1.getString(5);
							String balancedet=rs1.getString(7);
							String nameus=rs1.getString(1);
							String branch=rs1.getString(3);
							System.out.println("ACCOUNT DETAILS:-");
							System.out.println("____________________________________________________________________");
						 System.out.println("Username:"+nameus);
						 System.out.println("AccountNumber:"+accno);
						 System.out.println("IFSC Code:"+ifscno);
						 System.out.println("Branch:"+branch);
						 System.out.println("Balance:"+balancedet);
						 System.out.println("____________________________________________________________________");
						 System.out.println(System.lineSeparator());
						 System.out.println("<------<>----<>----Thank-----you-----<>-----<>------>");
						 break;
					 }}}
				 }	 
		     	} }
		 else {
			 System.out.println("<<-----Thank You For Using The Service------>>");
		 }
	
		 break;
		}
		
		}
		}catch(Exception e1) {
			 e1.printStackTrace();}
		
	}	
	}

	

	
	