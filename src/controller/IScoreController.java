package controller;

import model.player.IPlayer;

public interface IScoreController {
    void run();
    void bet(int bet, IPlayer player);

}
