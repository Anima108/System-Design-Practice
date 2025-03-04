package Factory;

import Models.User;

public class UserFactory {
    private static int userId = 0;
    private static int sellerId = 0;

    public User getSeller(String name){
        return new User(sellerId++,name,true);
    }

    public User getBuyer(String name){
        return new User(userId++,name,false);
    }
}
