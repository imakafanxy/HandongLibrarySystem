package models.People;

public class ServerAdmin extends User{
    public ServerAdmin(String ID, String PW, String name, UserLevel userLevel) {
        super(ID, PW, name, userLevel,0);
    }
}
