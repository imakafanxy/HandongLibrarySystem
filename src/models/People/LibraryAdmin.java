package models.People;

import models.Borrowable.Book;

public class LibraryAdmin extends User{
    public LibraryAdmin(String ID, String PW, String name, UserLevel userLevel) {
        super(ID, PW, name, userLevel, 0);
    }

    // TODO: Please implement here. If book needs to fix, lib admin can fix it.
    // TODO: 도서관 관리자는 책을 수리(수선)할 필요가 있다면 이 함수를 사용하여 수리(수선)할 수 있습니다.
    public boolean fixBook(Book book) {
        return true;
    }

    // TODO: Please implement here. If someone ask new book, lib admin can add it.
    // TODO: 도서관 관리자는 누군가가 요청한 책을 추가할 수 있습니다.
    public boolean addBook(Book book) {
        return true;
    }
}
