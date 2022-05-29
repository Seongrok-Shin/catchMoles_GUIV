/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject1CUI;

import java.util.TimerTask;

/**
 *
 * @author OEM
 */
public class UpdateBoardTask extends TimerTask{
    Gameboard gameboard;
    
    public UpdateBoardTask(Gameboard gameboard){
        this.gameboard = gameboard;
    }
    
    @Override
    public void run(){
        gameboard.showOneMole();
    }
}
