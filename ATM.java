package jav;

import java.lang.Math;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    int Acc,dec=5,draw,deposit, c=0;;
        String balance;
    
    Scanner sc=new Scanner(System.in);
    void deposit() throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://D:\\OOP\\Practice\\new.accdb") ;
                            {
                        Statement s = conn.createStatement();     
                               
                       ResultSet rs= s.executeQuery("select * from ATM  where Account="+Acc);              
                            while(rs.next())
                   {
                        balance=rs.getString("Balanced");
                        c=Integer.parseInt(balance);
                   }
                                       c+=deposit;
                         String rst= ("Update ATM Set Balanced ='"+c+"'       WHERE Account = "+Acc);              
                         int ex=s.executeUpdate(rst);    
                         System.out.println("\n\n\t Your Have SucceSsefuly Deposit Rs : "+deposit);
                   
                            }
                    
    }
    void fast() throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://D:\\OOP\\Practice\\new.accdb") ;
                            {
                       Statement s = conn.createStatement();            
                       ResultSet rs= s.executeQuery("select * from ATM  where Account="+Acc);              
                            while(rs.next())
                   {
                        balance=rs.getString("Balanced");
                        c=Integer.parseInt(balance);
                   }        
                            if(c>=draw)  
                            {
                                System.out.println("\n\n You Done WithDraw Successfully Rs : "+draw);
                            c-=draw;
                            String rst= ("Update ATM Set Balanced = "+c +"      WHERE Account = "+Acc);              
                            int ex=s.executeUpdate(rst); 
                            }
                            else
                            System.out.println("\n\n \t You Doen't Done WithDraw Successfully b/c You have less fund from Entered amount  ");
                            
                            }

    }
    void Balanced() throws SQLException{   
        String pin; 
        char ye;      
        char op;
         c=0;
        L2: for(int ss=1;ss<10;ss++){  
            System.out.println("\n\n\t\t Please Select the Option below ");
            System.out.println("\n\tB: Balance Inquuiry ");
             System.out.println("\n\tP:Pin Change ");
             System.out.println("\n\tC: Cash WithDrawal ");
             System.out.println("\n\tD: Deposit ");
             System.out.println("\n\tF: Fast Cash ");
                          System.out.println("\n\tE: Exit ");
             System.out.print("\n\n\n\t\tOption====>  ");
                op=sc.next().charAt(0);
                if(op=='B')
                {
                Connection conn = DriverManager.getConnection("jdbc:ucanaccess://D:\\OOP\\Practice\\new.accdb") ;
                            {
                        Statement s = conn.createStatement();            
                        ResultSet rs= s.executeQuery("select * from ATM  where Account="+Acc);              
                            while(rs.next())
                   {
                       System.out.println("\n\n\t  Your Balanced Is Rs:  "+rs.getString("Balanced"));
                   }
                            }
                }           
                else if(op=='P')
                {
                       System.out.print("\n\tEnter Your New Pin ");
                           pin=sc.next();
                      System.out.print("\n\tEnter  Confirm Pin  ");
                        String     cpin = sc.next();
                        for(int in=0;in<7;in++)
                            {
                                if(pin.equals(cpin))
                                    break;
                        System.out.println("\n\tPin doesn't Match ");
                        System.out.println("\n\tEnter  again Pin ");
                          pin = sc.next();
                          System.out.println("\n\tEnter again  Confirm Pin ");
                            cpin = sc.next();
                            }
                Connection conn = DriverManager.getConnection("jdbc:ucanaccess://D:\\OOP\\Practice\\new.accdb") ;
                            {
                        Statement s = conn.createStatement();            
                        String rs= ("Update ATM Set Pin ='"+pin+"'       WHERE Account = "+Acc);              
                        int ex=s.executeUpdate(rs);    
                       System.out.println("\n\nYour Pin Is SucceSsefuly Changed ");
                   
                            }
                    
                }
                  else if(op=='C')
                  {
                      System.out.print("\n\tEnter Amount That you want to With Draw : ");
                        draw=sc.nextInt();
                  fast();

                  }
                
                        
                  
                  else if(op=='D')
                  {
                         System.out.print("\n\tEnter Amount That you want to Deposit : ");
                        deposit=sc.nextInt();
                   deposit(); 
                   
                  }
                  else if(op=='F')
                  {
                              System.out.println("\n\t\t1: Amount 1000     ");
                                System.out.println("\n\t\t2: Amount 2000     ");
                                 System.out.println("\n\t\t3: Amount 5000     ");
                                  System.out.println("\n\t\t4: Amount 10000     ");
                                   System.out.println("\n\t\t5: Amount 20000     ");
                System.out.print("\n\n\n\t\tOption====>  ");
                  draw=sc.nextInt();
                  
                  if(draw==1){
                      draw=1000;
                      fast();
                  }
                  if(draw==2)                  {
                      draw=2000;
                      fast();
                  }
                  if(draw==3)                  {
                      draw=5000;
                      fast();
                  }
                  if(draw==4){                  
                      draw=10000;
                      fast();
                  }
                  else if(draw==5){
                      draw=20000;
                      fast();
                  }
                  }
                  else if(op=='E')
                      break L2;
                System.out.println("\n\n\t\tr: For repeat Transaction    ");
                                 System.out.println("\n\n\t\tE:  for Exit the System    ");
                    ye=sc.next().charAt(0);
                    if(ye=='r')
                        continue L2;
                    else if (ye=='E')
                        break L2;
                            
    }
    }
    
    void creating_account()
    {       
          System.out.print("\n\tEnter First Name : ");
          String fname = sc.next();
                 
          System.out.print("\n\tEnter Last Name : ");
          String     lname = sc.next();
    
          System.out.print("\n\tEnter Contact Number : ");
          Long    contact = sc.nextLong();
          
          System.out.print("\n\tEnter Address   Using Underscore between words  ==> ");
          String     address = sc.next();
          
          System.out.print("\n\tEnter  Pin for Login ");
          String     npin = sc.next();
          
          System.out.print("\n\tEnter  confirm pin ");
          String     cpin = sc.next();
          for(int in=0;;in++)
          {
              if(npin.equals(cpin))
                  break;
                        System.out.println("\n\tPin doesn't Match ");
          System.out.println("\n\tEnter  again Pin ");
               npin = sc.next();
          
          System.out.println("\n\tEnter again  Confirm Pin ");
               cpin = sc.next();
          }
          System.out.print("\n\tJust noteDown your Account For Further Processing==> ");
                Random rdnm= new Random();
		int Acc[]=new int[6];
	                 for (int a=1;a<Acc.length;a++)
                {
			Acc[a]= rdnm.nextInt();
		}
                         Acc[1]+=1000000000;
                            System.out.print(Math.abs(Acc[1]));
           try {       
                String stt="aaa";
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://D:\\OOP\\Practice\\new.accdb") ;
                            {
                        Statement s = conn.createStatement();            
                        String rs= "insert into ATM (first_name,last_name,Contact,Address,Pin,Account) VALUES ('"+fname+"','"+lname+"',"+contact+",'"+address+"','"+npin+"',"+Math.abs(Acc[1])+")";   
                   
                        int exe = s.executeUpdate(rs);
      //                  int ex = s.executeUpdate(stt);
                        System.out.println("\n\n\t\t**********Insertion  Complete*********");
//                          System.out.println("\n\n\t\tThanks For Using");
                        System.out.print("\n\tEnter Amount That you want to Deposit @Starting ");
                        deposit=sc.nextInt();   
                         String rst= ("Update ATM Set Balanced ='"+deposit+"'       WHERE Account = "+Math.abs(Acc[1]));              
                         int ex=s.executeUpdate(rst);    
                         System.out.println("\n\n\tYour Have SucceSsefuly Deposit "+deposit);
                        }
                }
            catch (SQLException e) 
        {
                                        System.out.println("\n\n\t\tInsertion NOT Done");
                                        //System.out.println( e.getMessage());
        }  
           
    }
    void sign_in()
    {    
        char yes;
                String pass;
        pass = "Done";
        label: for(int o=1;o<=5;o++){ 
            
           try {  Connection conn = DriverManager.getConnection("jdbc:ucanaccess://D:\\OOP\\Practice\\new.accdb") ;
                            {
                        Statement s = conn.createStatement();            
            System.out.print("\n\t\t Please Enter Your ACCOunt Number ");
              Acc=sc.nextInt();
    //            System.out.print("\n\t\t Enter PAssword       ");
  //           pass=sc.next();        
             ResultSet se=s.executeQuery("select * from ATM where Account = "+Acc);//Password ="+pass+"and 
               System.out.println("\n\n\t\t\t Correct PAss:  ");
                            Balanced();
                            break label;
                            }
                            
            }
           catch (Exception e)
           {
            System.out.println("\n\t\t !!!!! Wrong   Pass    ");
           }
           
           dec--;
                   System.out.println("\n\n\t\t You have "+dec+" Chances to Enter your Correct Account Number \n");
                    System.out.println("\n\t\t Do you want to sign in AGain   y/n");
                    yes=sc.next().charAt(0);
                    if(yes=='y')
                        continue label ;
                    else if (yes=='n')
                        break label;
        }
        //           while(dec<=0);
    }
  
 public static void main(String arg[])
 {
     ATM a=new ATM();
       System.out.println("\t\t****** Welcome Our ATM Management System ****** \n\n");
               Scanner sc=new Scanner(System.in);
               int t=0;
                char st;
               loop1: 
               for(int r=1;r<15;r++)
               { 
                   System.out.println("\n\t\t 1: Create Account (Sign up) ");
                   System.out.println("\n\t\t 2:        ( Sign In  )       ");
                   System.out.println("\n\t\t 3:        ( For Exit )       ");
                   System.out.print("\n\n\n\t\t\t OPTION ====> ");    
                   st=sc.next().charAt(0);
                   
                   
                   if (st=='1')
                   {
                        a.creating_account();
                        System.out.print("\n\n\t\t Do you Want to Go into Main Menu  y/n.... ");
                        st=sc.next().charAt(0);
                        if(st=='y')
                          continue loop1;
                        else 
                           break loop1;
                   }
                   else if (st=='2')
                   {
                       a.sign_in();
                       
                       System.out.print("\n\n\t\t Do you Want to Go into Main Menu  y/n.... ");
                       st =sc.next().charAt(0);
                        
                        if(st=='y')
                               continue loop1; 
                        else
                                break loop1;
                   }
                       else if(st=='E')
                                break loop1;
                   //else if(st=="E&&st!='1'&&st!='2')
                       else 
                     System.out.println("\n\t\t        Plz Enter Correct Option      \n\n  ");
                         continue loop1;
                   
               }
//               while(st.equals("E"));
               System.out.println("\n\n\t\t ****** Thanks For USing Our System ******\n");
                   
 }
}
