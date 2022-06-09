package com.lld;

import com.lld.model.Board;
import com.lld.model.Die;
import com.lld.model.Ladder;
import com.lld.model.Player;
import com.lld.model.Snake;
import com.lld.service.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderApplication {

    public static void main(String[] args) {

        List<Snake> snakes = new ArrayList<>();
        List<Ladder> ladders = new ArrayList<>();
        List<Player> players = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int numSnakes = sc.nextInt();
        for(int i=0; i<numSnakes; i++) {
            int head = sc.nextInt();
            int tail = sc.nextInt();
            snakes.add(new Snake(head, tail));
        }

        int numLadders = sc.nextInt();
        for(int i=0; i<numLadders; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            ladders.add(new Ladder(start, end));
        }

        int numPlayers = sc.nextInt();
        for(int i=0; i<numPlayers; i++) {
            String name = sc.next();
            players.add(new Player(name));
        }

        int dieCount = sc.nextInt();

        Board board = new Board(snakes, ladders);
        Die die = new Die();
        GameService gameService = new GameService(board, players, die, dieCount);
        gameService.startGame();
    }
}
