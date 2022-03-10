package controller;

import model.player.IPlayer;

public interface IScoreController {
    void firstRound();
    void bet(int bet, IPlayer player);
    void call(int call, IPlayer player);
    void raise(int raise, IPlayer player);

}
