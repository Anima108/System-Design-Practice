package models;

import java.util.List;

public class Game {
    DiceRoll dice;
    List<Player> players;
    List<Snake> snakes;
    List<Ladder> ladders;
    int boardSize;
    int noOfPlayer;

    public Game(int dice, List<Player> players, List<Snake> snakes, List<Ladder> ladders, int boardSize) {
        this.dice = new DiceRoll(dice);
        this.players = players;
        this.snakes = snakes;
        this.ladders = ladders;
        this.boardSize = boardSize;
        this.noOfPlayer = players.size();
    }

    public void play(){
        int num = dice.roll();
        if(num!=6)

    }





}
