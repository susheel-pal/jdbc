package org.example;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String url = "jdbc:mysql://localhost:3306/spark";
        String username = "root";
        String password = "123456";

        try{
            //load and register
            //Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username,password);
            Statement statement = connection.createStatement();

//            while (resultSet.next()){
//                int id = resultSet.getInt("st_id");
//                String name = resultSet.getString("stname");
//                String email = resultSet.getString("email");
//                String phoneNo = resultSet.getString("phoneNo");
//
//                System.out.println(id);
//                System.out.println(name);
//                System.out.println(email);
//                System.out.println(phoneNo);
//            }

            System.out.println("enter 1 for fetch data: \nenter 2 for input data: \nenter 3 for add multiple data: \nenter 4 for delete the data: ");
            Scanner sc = new Scanner(System.in);

            int choice = sc.nextInt();
            switch (choice){

                case 1:
                    ResultSet resultSet = statement.executeQuery("select * from students");
                    Operations.fetchData(resultSet);
                    break;

                case 2:
//                        int rowCount = statement.executeUpdate("insert into students values(6,'rahul','rahul@gmail.com','5234567890');");
//                        if(rowCount > 0){
//                            System.out.println("data inserted: ");
//                        }
//                        else {
//                            System.out.println("data not inserted: ");
//                        }

                    ResultSet MaxIdResultSet = statement.executeQuery("select MAX(st_id) as max_st_id from students");
                    int max_id=0;
                    while (MaxIdResultSet.next())
                    {
                        max_id=MaxIdResultSet.getInt("max_st_id");
                        System.out.println("Max Student id:"+max_id);
                    }
                    max_id++;
                    System.out.println("Enter the name:");
                    String name=sc.next();
                    System.out.println("Enter the email");
                    String email=sc.next();
                    System.out.println("Enter the phoneno");
                    String phoneNo=sc.next();



                    int rowCount = statement.executeUpdate("insert into students values("+max_id+",'"+name+"','"+email+"','"+phoneNo+"')");
                    if(rowCount>0)
                    {
                        System.out.println("Data Inserted:");
                    }
                    else {
                        System.out.println("Data Insertion failed:");
                    }
                    break;

                case 3:
                    System.out.println("Enter the detail for batch");
                    String [] bulkQruies =new String[10];


                    // statement.addBatch();
                    //statement.executeBatch();

                    break;

                case 4:
                    System.out.println("Enter the id for delete record:");
                    int id = sc.nextInt();
                    int row = statement.executeUpdate("DELETE from students where st_id = " + id);
                    if(row>0)
                    {
                        System.out.println("Data Deleted:"+id);
                    }
                    else {
                        System.out.println("Data Deletion failed:");
                    }
                    break;

                default:
                    System.out.println("enter a valid number");
                    break;
            }
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
}
