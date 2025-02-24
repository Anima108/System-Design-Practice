package models;

public class User {
    int user_id;
    String name;

    public User(int id, String name){
        this.user_id=id;
        this.name = name;

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
