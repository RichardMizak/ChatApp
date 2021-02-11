package sk.kosickaakademia.app;

import java.sql.*;

public class Database {
        private String url="jdbc:mysql://itsovy.sk:3306/chat2021";
        private String username="mysqluser";
        private String password="Kosice2021!";
        private final String insertNewUser="INSERT INTO user (login, password) VALUES (?, ?) ";
        private final String loginUser="SELECT * FROM user WHERE login LIKE ? AND password LIKE ? ";

        private Connection getConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,username,password);
            return conn;
        }

        public boolean insertNewUser(String login, String password){
            if(login==null || login.equals("") || password==null || password.length()<6)
                return false;

            String hpwd= new Util().MD5(password);
            try{
                Connection conn=getConnection();
                if (conn==null){
                    System.out.println("error");
                    return false;
                }else{
                    PreparedStatement ps=conn.prepareStatement(insertNewUser);
                    ps.setString(1,login);
                    ps.setString(2, hpwd);
                    int result=ps.executeUpdate();
                    conn.close();
                    if (result==0)
                        return false;
                    else {
                        return true;
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return true;
        }
        public Users loginUser(String login,String password){
            if(login==null || login.equals("") || password==null || password.length()<6)
                return null;
            String hpwd=new Util().MD5(password);
            try {
                Connection conn=getConnection();
                if (conn==null){
                    System.out.println("error");
                    return null;
                }
                PreparedStatement ps= conn.prepareStatement(loginUser);
                ps.setString(1, login);
                ps.setString(2, hpwd);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    System.out.println("logged");
                    int id=rs.getInt("id");
                    Users user=new Users(login, hpwd, id);
                    conn.close();
                    return user;
                }else{
                    conn.close();
                    return null;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }

}
