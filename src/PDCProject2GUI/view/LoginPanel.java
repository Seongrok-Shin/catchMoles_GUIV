//view for login page
package PDCProject2GUI.view;

import PDCProject2GUI.Program;
import static PDCProject2GUI.Program.jFrame;
import PDCProject2GUI.controller.LoginController;
import PDCProject2GUI.controller.ScoreController;
import PDCProject2GUI.data.Data;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements Observer {

    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    public JTextField unInput = new JTextField(15);
    public JTextField pwInput = new JTextField(15);
    private JLabel wrongName = new JLabel("Wrong username or passwork!");

    private JButton loginButton = new JButton("Log in");
    public JLabel message = new JLabel("Welcome", JLabel.CENTER);

    public LoginPanel() {

        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.white);
        //setLayout(new GridLayout(2 , 3));
        uName.setBounds(300, 30, 300, 60);
        unInput.setBounds(300, 50, 300, 60);
        pWord.setBounds(300, 70, 300, 60);
        pwInput.setBounds(300, 90, 300, 60);
        loginButton.setBounds(300, 100, 300, 60);
        message.setBounds(600, 30, 300, 60);
        
        add(uName);
        add(unInput);
        add(pWord);
        add(pwInput);
        add(loginButton);
        add(message);
  
    }

    public void startGame() {

        Program.jFrame.getContentPane().removeAll();
        Program.jFrame.getContentPane().add(Program.homePanel);
        Program.jFrame.repaint();

    }

    public void addActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
    }

    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg; //contain the instance of Data
//        if (!data.loginFlag) { // loginFlage = false, user need to put input again.
//            this.unInput.setText("");
//            this.pwInput.setText("");
//            this.message.setText("Invalid username or password.");
//        } else if (!this.started) { // If the game has not started, then start the game.
//            this.startQuiz(); // Change the interface of the frame.
//            this.started = true;
//            this.setQuestion(data.num1, data.num2); // Show the question on the interface.
//            
//        } else if (data.quitFlag) { // display current score when user quits
//            this.quitGame(data.currentScore);
//        } //else { // Otherwise, update a new question for the user.
//            //this.setQuestion(data.num1, data.num2);
//        //}
    }

}
