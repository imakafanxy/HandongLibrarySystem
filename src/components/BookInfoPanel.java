//package components;
//
//import service.BookInfo;
//import javax.swing.*;
//import java.awt.*;
//import java.util.List;
//
//public class BookInfoPanel extends JPanel {
//    public BookInfoPanel(List<BookInfo> bookInfoList) {
//        setLayout(new GridLayout(bookInfoList.size(), 1));
//        for (BookInfo bookInfo : bookInfoList) {
//            JLabel label = new JLabel(bookInfo.getLabel() + ": " + bookInfo.getValue());
//            add(label);
//        }
//    }
//}
