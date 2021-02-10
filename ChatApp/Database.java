package sk.kosickaakademia.app;

import java.util.ArrayList;

public class Database {
        private String url="jdbc:mysql://localhost:3306/world_x";
        private String username="root";
        private String password="";

        ArrayList<Users> registeredUsers;
        ArrayList<Users> loggedUsers;

        public void registerAndLogin() {
            loggedUsers = new ArrayList<Users>();
            registeredUsers = new ArrayList<Users>();
        }
            public void register(String username,String password){
                Users registeredUsers=new Users(username,password);

            }
            public void login(String username,String password){
                Users loggedUsers=new Users(username,password);

            }
}
