package controller;

import model.player.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class PokerPlayerController {
    private final List<IPlayer> players;

    public PokerPlayerController(List<IPlayer> pls)    {
        this.players = pls;
    }

    public void addPlayer(IPlayer player)   { players.add(player);}

    public void removePlayer(IPlayer player) {
        try {
            players.remove(player);
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du joueur");
        }
    }

    public List<IPlayer> getPlayers()   { return players; }
}
