package com.Services;

import com.context.Context;
import com.entities.User;

public class UserService {

    public static void Login(Context ctx){
        ctx.getSc().nextLine();
        System.out.print("enter name : ");
        String name = ctx.getSc().nextLine();

        System.out.print("enter password : ");
        String password = ctx.getSc().nextLine();

        User user = ctx.getUserRepo().GetUserByName(name);
        if(user.getRole().equals("admin")) {
            ctx.setUser(user);
            System.out.println("Login as " + user.getRole());
        }
        else if(user.getName().equals(name) && user.getPassword().equals(password)){
            System.out.println("login successful");
            ctx.setUser(user);
        }else{
            System.out.println("wrong username and password!!!! please try again");
        }
        System.out.print("\033c");
    }


    public static void SignUp(Context ctx){
        ctx.getSc().nextLine();
        System.out.print("enter name : ");
        String name = ctx.getSc().nextLine();

        System.out.print("enter password : ");
        String password = ctx.getSc().nextLine();

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setRole("user");
        user.setCredit(0);
        ctx.getUserRepo().createUser(user);

    }

    public static void Logout(Context ctx){
        ctx.setUser(null);
        System.out.println("Logged out");
    }

    
    public static boolean Exit(){
        boolean a = false;
        return a;
    }
}
