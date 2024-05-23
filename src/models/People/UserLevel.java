package models.People;

public enum UserLevel {
    USER_STUDENT(0, "00"),
    USER_PROFESSOR(1, "01"),
    ADMIN_LIBRARY(2, "10"),
    ADMIN_SERVER(3, "11");

    private final int combobox_selected;
    private final String level;

    private UserLevel(int combobox_selected, String level) {
        this.combobox_selected = combobox_selected;
        this.level = level;
    }

    public int getCombobox_selected() {
        return combobox_selected;
    }

    public String getLevel() {
        return level;
    }
}
