package models;

public class DiceRoll {
    int noOfDice;

    public DiceRoll(int i){
       this.noOfDice=i;
    }

    public int roll(){
        int num;
        if(noOfDice==1){
            num=(int)((Math.random() * 6) + 1);
        }
        else{num = (int) ((Math.random() * 12) + 1);}
        return num;
    }

}
