import java.sql.*;

public class jdbc2 {
    public static void main(String args[]){
        
        try{
            //Load driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //creating connection
            String url="jdbc://localhost:3306/java1";
            String Username="root";
            String Password = "root";

            Connection con=DriverManager.getConnection(url, Username, Password);

            if(con.isClosed()){
                System.out.println("Connection closed");
            }else{
                System.out.println("Connection Created");
            }
        }
        catch( Exception e){
            e.printStackTrace();
        }
    }
}
