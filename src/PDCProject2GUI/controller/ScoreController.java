
package PDCProject2GUI.controller;

import PDCProject1CUI.Score;
import PDCProject1CUI.User;
import PDCProject2GUI.data.ScoreModel;
import PDCProject2GUI.view.ScorePanel;
import java.util.Map;


public class ScoreController {

    private final ScorePanel scorePanel;
    private final ScoreModel scoreModel;
    
    public ScoreController(ScorePanel scorePanel, ScoreModel scoremodel) {
        this.scorePanel = scorePanel;
        this.scoreModel = scoremodel;
    }

    public void setupData() {
       this.scoreModel.setupData(); 
        
    }

    public Map<User, Score> getScores() {
        return scoreModel.getUserScores();
    }
}
