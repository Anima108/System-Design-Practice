package Models;

import Factory.UserFactory;
import java.util.*;

public class FlipBidder {

    private UserFactory userFactory;
    List<User> sellers;
    List<User> buyers;
    List<Auction> auctions;

    public static FlipBidder getInstance(){
        return new FlipBidder();
    }

    private FlipBidder(){
        userFactory = new UserFactory();
        sellers= new ArrayList<>();
        buyers = new ArrayList<>();
        auctions = new ArrayList<>();
    }

    public User createSeller(String name){
        User seller = userFactory.getSeller(name);
        sellers.add(seller);
        System.out.println("Seller Created");
        return seller;
    }

    public User createBuyer(String name){
        User buyer = userFactory.getBuyer(name);
        buyers.add(buyer);
        System.out.println("Bidder Created");
        return buyer;
    }

    public Auction createAuction(int min, int max, int partCost, User seller){
        if(!sellers.contains(seller)){
            System.out.println("User doesn't exist");
            return new AuctionImpl();
        }
        Auction auction = new AuctionImpl(min,max,partCost,seller);
        auctions.add(auction);
        System.out.println("Auction created");
        return auction;
    }

    public void createBid(Auction a, User u, int amount){
        a.createBid(u,amount);
    }

    public void updateBid(Auction a, User u, int amount){
        a.updateBid(u,amount);
    }

    public void withdrawFromAuction(Auction a, User u){
        a.withdraw(u);
    }

    public void closeAuction(Auction a){
        a.closeAuction();
    }


}
