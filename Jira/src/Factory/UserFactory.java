package Factory;

import models.User;

public class UserFactory {

    public static User getUser(int id, String name){
        return new User(id,name);
    }
}
