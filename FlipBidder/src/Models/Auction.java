package Models;

public interface Auction {

    public void createBid(User user, int amount);

    public void updateBid(User user, int amount);

    public void withdraw(User user);

    public void closeAuction();
}
