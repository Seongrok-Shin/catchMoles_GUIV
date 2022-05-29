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
    private boolean isVisible;

    public boolean isVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
   
    @Override
    public String toString(){
        if(isVisible){
            return "[O]";
        }else{
            return "[_]";
        }
    }
}
