package Models;

public class User {
    int userid;
    String name;
    Boolean isSeller;

    public User(int id, String name, Boolean isSeller ){
        this.name = name;
        this.userid=id;
        this.isSeller=isSeller;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }
}
