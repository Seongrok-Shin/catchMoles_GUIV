/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject1CUI;

/**
 *
 * @author OEM
 */
public class Mole {

    private final int index;
    private MoleState state;

    public Mole(int index) {
        this.index = index;
        this.state = MoleState.INVISIBLE;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isVisible() {
        return state.equals(MoleState.VISIBLE);
    }

    public void setState(MoleState state) {
        this.state = state;
    }

    public MoleState getState() {
        return this.state;
    }

    public void nextState() {
        switch (this.state) {
            case SLIGHTLY_VISIBLE:
                this.state = MoleState.ALMOST_VISIBLE;
                break;
            case ALMOST_VISIBLE:
                this.state = MoleState.VISIBLE;
                break;
            case VISIBLE:
                this.state = MoleState.MISSED;
                break;
            case MISSED:
                this.state = MoleState.INVISIBLE;
                break;
            case DEAD:
                this.state = MoleState.INVISIBLE;
                break;
        }
    }
    
    public void prepare(){
        this.state = MoleState.SLIGHTLY_VISIBLE;
    }
    
    @Override
    public String toString() {
        if (isVisible()) {
            return "[O]";
        } else {
            return "[_]";
        }
    }
}
