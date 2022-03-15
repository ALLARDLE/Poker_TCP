package controller;

import model.player.IPlayer;

public interface IScoreController {
    void retrievePot(IPlayer player);
    void firstRound();
    void bet(int bet, IPlayer player);
    void call(IPlayer player);
    void raise(int raise, IPlayer player);

}
