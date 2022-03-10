package model;


import model.player.IPlayer;

import java.util.List;

/**
 * Modélisation du jeu de Poker
 */
public class Game {

    private List<IPlayer> players;

    public Game(List<IPlayer> players)   {
        this.players = players;
    }

}
