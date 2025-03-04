import Models.Auction;
import Models.FlipBidder;
import Models.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        FlipBidder flipBidder =  FlipBidder.getInstance();
        User seller1 = flipBidder.createSeller("seller1");
        User buyer1 = flipBidder.createBuyer("buyer1");
        User buyer2 = flipBidder.createBuyer("buyer2");
        User buyer3 = flipBidder.createBuyer("buyer3");
        Auction A1 = flipBidder.createAuction(10,20,1, seller1);
        flipBidder.createBid(A1,buyer1,15);
        flipBidder.createBid(A1,buyer2,18);
        flipBidder.createBid(A1,buyer3,19);
        flipBidder.withdrawFromAuction(A1,buyer3);
        flipBidder.closeAuction(A1);

    }
}