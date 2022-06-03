//view for login page
package PDCProject2GUI.view;

import PDCProject2GUI.Program;
import PDCProject2GUI.data.LoginModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements Observer {

    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    public JTextField unInput = new JTextField(15);
    public JTextField pwInput = new JTextField(15);
    private JLabel wrongName = new JLabel("Wrong username or passwork!");

    private JButton loginButton = new JButton("Log in");
    public JLabel message = new JLabel("Please put your Id and password If you want to start new game", JLabel.CENTER);
    private Image backgroundImg;

    public LoginPanel() {

        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.white);

        try {
            backgroundImg = ImageIO.read(new File("./img/backgroud_home.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot load the image");
            System.exit(0);
        }
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
        Program.jFrame.pack();
        Program.jFrame.setVisible(true);

    }

    public void addActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
    }

    @Override
    public void update(Observable o, Object arg) {
        LoginModel model = (LoginModel) arg;
        this.message.setForeground(Color.red);
        this.message.setText(model.getErrorMessage());

        if (model.isLoginFlag()) {
            startGame();
        }
    }
}
