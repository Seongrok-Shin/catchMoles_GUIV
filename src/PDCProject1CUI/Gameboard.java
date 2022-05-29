/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject1CUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author OEM
 */
public class Gameboard {

    private final Random rand = new Random();
    private final List<Mole> moles;
    private final Size size;

    public Gameboard(Size size) {
        this.size = size;
        this.moles = new ArrayList<>();
        initializeBoard(size);
    }

    public Size getSize() {
        return this.size;
    }

    private void initializeBoard(Size size) {
        for (int i = 0; i < size.getRow() * size.getCol(); i++) {
            this.moles.add(new Mole(i));
        }
    }

    public void showOneMole() {
        reset();
        moles.get(rand.nextInt(moles.size()))
                .setState(MoleState.VISIBLE);
    }

    public void nextMolesState() {
        int randIdx = rand.nextInt(moles.size());
        boolean isDisplayed = false;

        if (this.moles.get(randIdx).getState() == MoleState.INVISIBLE) {
            moles.get(randIdx).prepare();
            isDisplayed = true;
        }

        for (int i = 0; i < moles.size(); i++) {
            if (!(i == randIdx && isDisplayed)){
                moles.get(i).nextState();
            }
        }
    }

    private void reset() {
        for (int i = 0; i < moles.size(); i++) {
            moles.get(i).setState(MoleState.INVISIBLE);
        }
    }

    public void printBoard() {
        for (int i = 0; i < moles.size(); i++) {
            System.out.print(moles.get(i));
            if ((i + 1) % size.getRow() == 0) {
                System.out.println();
            }
        }
    }

    public boolean isMoleVisibleAtIndex(int index) {
        return this.moles.get(index).isVisible();
    }

    public Mole getMoleAtIndex(int index) {
        return this.moles.get(index);
    }
}
