package org.example.LLDDesigns.SnakeAndLadder;

import org.example.HashMap.Entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    HashMap<Integer, Player> players;
    int currentPlayerIndex;
    Board board;
    Dice dice;
    int rank;

    public Game() {
        this.players = new HashMap<>();
        this.currentPlayerIndex = 1;
        this.board = new Board(10,10);
        this.dice = new Dice(6);
        this.rank = 1;
        initializePlayers();
    }

    private void initializePlayers(){
        this.players.put(1,new Player(Color.Orange,"Sudhakar",1));
        this.players.put(2,new Player(Color.Red,"Rohith",2));
        this.players.put(3,new Player(Color.Yellow,"Prasanna",3));
    }

    void addPlayer(int playerIndex,Player player){
        this.players.put(playerIndex,player);
    }

    void deletePlayer(int playerIndex){
       this.players.remove(playerIndex);
    }

    public void playGame(){
        Player currentPlayer = this.players.get(this.currentPlayerIndex);
        int getValue = this.dice.rollDice();
        int currentPosition = currentPlayer.getCurrentPosition();
       currentPosition += getValue;
       boolean isUpdated = false;
       if(currentPosition == 100){
           System.out.println(currentPlayer.getName() + "has won at " + this.rank + "place");
           this.deletePlayer(currentPlayerIndex);
           this.rank +=1;
       }
       for(Map.Entry<Integer, Integer> entry: this.board.getSnakes().entrySet()){
           if(currentPosition == entry.getKey()){
               currentPlayer.setCurrentPosition(entry.getValue());
               isUpdated = true;
           }
       }
        for(Map.Entry<Integer, Integer> entry: this.board.getLadders().entrySet()){
            if(currentPosition == entry.getKey()){
                currentPlayer.setCurrentPosition(entry.getValue());
                isUpdated = true;
            }
        }
        if(!isUpdated){
            currentPlayer.setCurrentPosition(currentPosition);
        }


        for(Integer entry: this.players.keySet()){
            if(entry > currentPlayerIndex){
                this.currentPlayerIndex = entry;
                return;
            }
        }

        for(Integer entry: this.players.keySet()){
            if(entry < currentPlayerIndex){
                this.currentPlayerIndex = entry;
            }
        }

    }

    public void startGame(){
        while(this.rank != players.size()){
            playGame();
        }
    }



}
