package com.lld.service;

import com.lld.model.Board;
import com.lld.model.Die;
import com.lld.model.Ladder;
import com.lld.model.Player;
import com.lld.model.Snake;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Yash Chaturvedi
 */
public class GameService {

    private Board board;
    private Queue<Player> players;
    private Map<String, Integer> playerPos;
    private Die die;
    private int dieCount;

    public GameService(Board board, List<Player> playerList, Die die, int dieCount) {
        this.board = board;
        this.players = new LinkedList<>();
        this.playerPos = new HashMap<>();
        for(Player p : playerList) {
            players.add(p);
            playerPos.put(p.getId(), 0);
        }
        this.die = die;
        this.dieCount = dieCount;
    }

    public void startGame() {
        if(this.players.size() == 0) {
            System.out.println("Please add at least 1 player to play");
            return;
        }
        while (!checkIfGameOver()) {
            Player player = players.poll();
            int pos = getNextPosition(player);
            boolean playerWon = checkIfPlayerWon(pos);
            if(playerWon) {
                System.out.println("Player " + player.getName() + " wins the game");
            } else {
                players.add(player);
            }
        }
    }

    private boolean checkIfGameOver() {
        return this.players.size() != playerPos.size();
    }

    private int getNextPosition(Player player) {
        int oldPos = playerPos.get(player.getId());
        int steps = rollDie();
        int newPos = oldPos + steps;
        if(newPos > board.getSize()) return oldPos;
        newPos = checkForSnakesAndLadders(newPos);
        playerPos.put(player.getId(), newPos);
        printTurn(player, oldPos, newPos, steps);
        return newPos;
    }

    private int rollDie() {
        int steps = 0;
        for(int i=0; i<dieCount; i++) {
            steps += die.roll();
        }
        return steps;
    }

    private int checkForSnakesAndLadders(int curPos) {
        int newPos = 0;
        while(curPos != newPos) {
            newPos = curPos;
            for(Snake s : board.getSnakes()) {
                if(s.getHead() == curPos) {
                    newPos = s.getTail();
                    break;
                }
            }
            for(Ladder l : board.getLadders()) {
                if(l.getStart() == curPos) {
                    newPos = l.getEnd();
                    break;
                }
            }
            curPos = newPos;
        }
        return newPos;
    }

    private void printTurn(Player player, int oldPos, int newPos, int steps) {
        System.out.println("Player : " + player.getName() + " rolled a " + steps + " and moved from "
                + oldPos + " to " + newPos);
    }

    private boolean checkIfPlayerWon(int pos) {
        return pos == board.getSize();
    }

}















