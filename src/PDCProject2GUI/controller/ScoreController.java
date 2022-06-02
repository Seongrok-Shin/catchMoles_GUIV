
package PDCProject2GUI.controller;

import PDCProject1CUI.Score;
import PDCProject2GUI.data.ScoreModel;
import PDCProject2GUI.view.ScorePanel;
import java.util.ArrayList;
import java.util.List;


public class ScoreController {

    private final ScorePanel scorePanel;
    private final ScoreModel scoreModel;

    public List<Score> getScores() {
        return new ArrayList<>();
    }
    
    public ScoreController(ScorePanel scorePanel, ScoreModel scoremodel) {
        this.scorePanel = scorePanel;
        this.scoreModel = scoremodel;
    }

    public void setupData() {
       this.scoreModel.setupData(); 
        
    }
}
