package Models;

import java.util.*;

public class AuctionImpl implements Auction{
    Map<User, Integer> bids;
    Map<Integer,Integer> frequency;
    int minBid;
    int maxBid;
    int participationCost;
    Boolean isClosed;
    User seller;

    public AuctionImpl(){
        System.out.println("Invalid object");
    }

    public AuctionImpl(int min, int max , int partCost,User seller){
        bids = new HashMap<>();
        frequency = new TreeMap<>(Comparator.reverseOrder());
        this.maxBid = max;
        this.minBid = min;
        this.participationCost = partCost;
        this.isClosed = false;
        this.seller = seller;

    }

    private Boolean isValidBid(int amount){
        if(amount<minBid || amount> maxBid)
            return false;
        return true;
    }


    private void removeFrequency(int bid){
        int freq = frequency.get(bid);
        if(freq==1){
            frequency.remove(bid);
        }
        else{
            frequency.put(bid,freq-1);
        }
    }

    @Override
    public void createBid(User user, int amount) {
        if(isClosed){
            System.out.println("Auction closed");
            return;
        }
        if(!isValidBid(amount)){
            System.out.println("Please enter valid bid between "+minBid+"-"+maxBid);
            return;
        }
        bids.put(user,amount);
        frequency.put(amount, frequency.getOrDefault(amount,0)+1);
        System.out.println("Bid Created");
    }

    @Override
    public void updateBid(User user, int amount) {
        if(isClosed){
            System.out.println("Auction closed");
            return;
        }
        if(!isValidBid(amount)){
            System.out.println("Please enter valid bid between "+minBid+"-"+maxBid);
            return;
        }
        int exist = bids.get(user);
        bids.put(user,amount);
        frequency.put(amount, frequency.getOrDefault(amount,0)+1);
        removeFrequency(exist);
        System.out.println("Bid Updated");
    }

    @Override
    public void withdraw(User user) {
        int bid = bids.get(user);
        bids.remove(user);
        removeFrequency(bid);
        System.out.println("Withraw Successful");
    }

    @Override
    public void closeAuction() {
        isClosed = true;
        Boolean WinnerFound = false;
        for(var entry : frequency.entrySet()){
            if(WinnerFound){
                break;
            }
            if(entry.getValue()==1){
                for(var ent : bids.entrySet()){
                    if(ent.getValue() == entry.getKey()){
                        System.out.println("Winner is "+ent.getKey().getName()+" with winning bid "+ent.getValue());
                        WinnerFound = true;
                    }
                }
            }
        }
        if(!WinnerFound){
            System.out.println("No Winner");
        }
    }
}
