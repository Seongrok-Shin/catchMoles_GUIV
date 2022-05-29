/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject1CUI;

/**
 *
 * @author ssr7324
 */
public class Score {

    private int score;

    /**
     *
     * @param score
     */
    public Score(int score) {
        this.score = score;
    }

    public Score() {
        this(0);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return ", Score : " + score +"]"; 
    }
}
