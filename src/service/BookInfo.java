package service;

public class BookInfo {
    private String label;
    private String value;
    
    private String notInfo = "정보없음";

    public BookInfo(String label, String value) {
        this.label = label;
        this.value = value != null ? value : notInfo;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
    
    public String getTitle() {
        if (label.equals("Title")) {
            return value;
        }
        return notInfo;
    }
    
    public String getType() {
        if (label.equals("Type")) {
            return value;
        }
        return notInfo;
    }
    
    public String getAuthor() {
        if (label.equals("Author")) {
            return value;
        }
        return notInfo;
    }
    
    public String getPublisher() {
        if (label.equals("Publisher")) {
            return value;
        }
        return notInfo;
    }
    
    public String getPublishDate() {
        if (label.equals("Publish Date")) {
            return value;
        }
        return notInfo;
    }
    
    public String getISBN() {
        if (label.equals("ISBN")) {
            return value;
        }
        return notInfo;
    }
    
    public String getNotes() {
        if (label.equals("Notes")) {
            return value;
        }
        return notInfo;
    }
    
    public String getClassNo() {
        if (label.equals("Class No")) {
            return value;
        }
        return notInfo;
    }
    
    public String getLanguage() {
        if (label.equals("Language")) {
            return value;
        }
        return notInfo;
    }
    
    public String getCallNo() {
        if (label.equals("Call No")) {
            return value;
        }
        return notInfo;
    }
    
    public String getLocation() {
        if (label.equals("Location")) {
            return value;
        }
        return notInfo;
    }
}
