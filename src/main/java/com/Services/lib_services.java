package com.Services;

import com.context.Context;

public class lib_services {
    public static void LibSystem(Context ctx) {
        int option;
        boolean a;
        do {
            a = true;
            if(ctx.getUser() != null && ctx.getUser().getRole().equals("admin")) {
                ShowMenuService.showMenuAdmin();
                System.out.print("enter option : ");
                option = ctx.getSc().nextInt();

                System.out.print("\033c");

                switch (option) {
                    case 1:
                        BookService.ViewBooks(ctx);
                        break;
                    case 2:
                        AuthorService.SearchBookByAuthor(ctx);
                        break;
                    case 3:
                        BookService.AddNewBook(ctx);
                        break;
                    case 4:
                        AuthorService.CreateAuthor(ctx);
                        break;
                    case 5:
                        BookService.Remove(ctx);
                        break;

                    case 6:
                        BorrowService.ViewBorrowList(ctx);
                        break;
                    case 7:
                        UserService.Logout(ctx);
                        break;
                    case 8:
                        UserService.Exit();
                        return;
                    default:
                        break;
                }
            }else if(ctx.getUser() != null && ctx.getUser().getRole().equals("user")) {
                ShowMenuService.showMenuUser();
                System.out.print("enter option : ");
                option = ctx.getSc().nextInt();
                System.out.print("\033c");
                switch (option) {
                    case 1:
                        BookService.ViewBooks(ctx);
                        break;
                    case 2:
                        AuthorService.SearchBookByAuthor(ctx);
                        break;
                    case 3:
                        BorrowService.BorrowBook(ctx);
                        break;
                    case 4:
                        UserService.Logout(ctx);
                        break;
                    case 5:
                        UserService.Exit();
                        return;
                        
                    default:
                        break;
                }

            }else{
                ShowMenuService.showMenu();
                System.out.print("enter option : ");
                option = ctx.getSc().nextInt();
                System.out.print("\033c");
                switch (option) {
                    case 1:
                        BookService.ViewBooks(ctx);
                        break;
                    case 2:
                        AuthorService.SearchBookByAuthor(ctx);
                        break;
                    case 3:
                        UserService.Login(ctx);
                        break;
                    case 4:
                        UserService.SignUp(ctx);
                        break;
                    case 5:
                        UserService.Exit();
                        return;
                    default:
                        break;
                }

            }
            
        } while (a == true);
        System.out.println("good bye");
     
    }
}
