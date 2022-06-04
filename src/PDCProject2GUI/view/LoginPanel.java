//view for login page
package PDCProject2GUI.view;

import PDCProject2GUI.Program;
import PDCProject2GUI.data.LoginModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
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
    private Image imgLogin;

    public LoginPanel() {

        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        try {
            imgLogin = ImageIO.read(new File("./img/bg_log_in.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot load the image");
            System.exit(0);
        }
        uName.setFont(new Font("Segoe UI", Font.BOLD, 16));
        uName.setForeground(Color.WHITE);
        unInput.setFont(new Font("Segoe UI", Font.BOLD, 16));
        unInput.setForeground(Color.WHITE);
        pWord.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pWord.setForeground(Color.WHITE);
        pwInput.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pwInput.setForeground(Color.WHITE);
        message.setFont(new Font("Segoe UI", Font.BOLD, 16));
        message.setForeground(Color.WHITE);
        
        
        add(uName, generateNewConstraints(0, 0, 1, 1));
        add(unInput, generateNewConstraints(0, 1, 1, 1));
        add(pWord, generateNewConstraints(0, 2, 1, 1));
        add(pwInput, generateNewConstraints(0, 3, 1, 1));
        add(loginButton, generateNewConstraints(0, 4, 1, 1));
        add(message, generateNewConstraints(0, 5, 1, 1));
    }

    private GridBagConstraints generateNewConstraints(int x, int y, int width, int height) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridheight = height;
        constraints.gridwidth = width;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        return constraints;
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imgLogin, 0, 0, null);
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
