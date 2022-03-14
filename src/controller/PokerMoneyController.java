package controller;

import model.player.IPlayer;

import java.util.List;


/**
 * Classe gérant la modification du score des joueurs
 * Cette classe gère aussi les blinds.
 *
 */
public class PokerMoneyController implements IScoreController {

    private List<IPlayer> players;
    private int smallBlind;
    private int bigBlind;
    private int pot = 0;
    private int call = 0;
    private int bet = 0;
    private int raise = 0;

    public PokerMoneyController(List<IPlayer> players, int smallBlind)   {
        this.players = players;
        this.smallBlind = smallBlind;
        this.bigBlind = 2 * smallBlind;

    }

    @Override
    public void firstRound() {
        // TODO à supprimer et implémenter dans RoundController
        for (IPlayer player : players)  {
            if (player.isBigBlind())    {
                player.setMoney(player.getMoney() - bigBlind);
            }
            else if (player.isSmallBlind()) {
                player.setMoney(player.getMoney() - smallBlind);
            }
        }
        pot = bigBlind + smallBlind;
        call = bigBlind;
    }

    @Override
    public void bet(int bet, IPlayer player) {
        // miser une certaine valeur
        player.setMoney(player.getMoney() - bet);       // met à jour l'argent du joueur
        this.bet = bet;         // la mise augmente
        this.call = bet;        // pour suivre il faut s'aligner sur la mise
        this.raise = bet;      // pour relancer il faut jouer 2 fois la mise
        this.pot += bet;        // augmente le pot
    }

    @Override
    public void call(int call, IPlayer player) {
        // s'aligne à la mise la plus haute
        //TODO à modifier
        bet(call, player);
    }

    @Override
    public void raise(int raise, IPlayer player) {
        // relancer d'une certaine valeur
        //TODO à modifier
        bet(raise, player);
    }
}
