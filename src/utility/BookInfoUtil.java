package utility;

import service.BookInfo;
import models.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookInfoUtil {

    public static List<BookInfo> createBookInfoList(Book book) {
        List<BookInfo> bookInfoList = new ArrayList<>();
        bookInfoList.add(new BookInfo("Title", book.getTitle()));
        bookInfoList.add(new BookInfo("Type", book.getType()));
        bookInfoList.add(new BookInfo("Author", book.getAuthor()));
        bookInfoList.add(new BookInfo("Publisher", book.getPublisher()));
        bookInfoList.add(new BookInfo("Publish Date", book.getPublishDate()));
        bookInfoList.add(new BookInfo("ISBN", book.getISBN()));
        bookInfoList.add(new BookInfo("Notes", book.getNotes()));
        bookInfoList.add(new BookInfo("Class No", book.getClassNo()));
        bookInfoList.add(new BookInfo("Language", book.getLanguage()));
        bookInfoList.add(new BookInfo("Call No", book.getCallNo()));
        bookInfoList.add(new BookInfo("Location", book.getLocation()));
        return bookInfoList;
    }

    public static List<BookInfo> createBookInfoListFromFile(String fileName, String searchTitle) {
        List<BookInfo> bookInfoList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0].trim();

                if (title.equalsIgnoreCase(searchTitle)) {
                    for (int i = 0; i < parts.length; i++) {
                        String value = parts[i].trim();
                        if (value.isEmpty()) {  
                            value = "정보없음";
                        }
                        bookInfoList.add(new BookInfo(getLabel(i), value));
                    }
                    break;  
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return bookInfoList;
    }

    private static String getLabel(int index) {
        switch (index) {
            case 0: return "Title";
            case 1: return "Type";
            case 2: return "Author";
            case 3: return "Publisher";
            case 4: return "Publish Date";
            case 5: return "ISBN";
            case 6: return "Notes";
            case 7: return "Class No";
            case 8: return "Language";
            case 9: return "Call No";
            case 10: return "Location";
            default: return "Unknown";
        }
    }
}
