package com.Services;


import java.util.List;

import com.context.Context;
import com.entities.Book;
import com.entities.Borrow;
import com.entities.User;

public class BorrowService {
    public static void BorrowBook(Context ctx) {


        BookService.ShowBorrow(ctx);

        System.out.print("Choose book id : ");
        long book_id = ctx.getSc().nextLong();

        ctx.getSc().nextLine();

        
        Borrow borrow = new Borrow();
        User user = ctx.getUser();
        user.setCredit(user.getCredit() + 10);
        ctx.getUserRepo().UpdateUser(user);
        Book book = ctx.getBookRepo().GetBookById(book_id);

        book.setAvailable(0);
        ctx.getBookRepo().UpdateBook(book);

        borrow.setBook(book);
        borrow.setUser(user);
        ctx.getBorrowRepo().CreateBorrow(borrow);
        System.out.println("Borrow successful");
    }

    public static void ViewBorrowList(Context ctx) {
        List<Borrow> borrows = ctx.getBorrowRepo().ViewBorrowList();
        for(Borrow borrow : borrows) {
            System.out.println(borrow.getId() + "\t" + borrow.getUser().getName() + "\t" + borrow.getStartDate() + "\t" + borrow.getReturnDate() + "\t" + borrow.getBook().getTitle());
        }
    }

    public static void RemoveBorrowList(Context ctx, Book book){
        Borrow borrow = ctx.getBorrowRepo().GetBorrowListByBook(book);
        ctx.getBorrowRepo().RemoveBorrowList(borrow);
        
    }
}
