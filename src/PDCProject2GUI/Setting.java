/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI;

import java.awt.Color;

/**
 *
 * @author ssr7324
 */
public class Setting {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    
    public static final int CURSOR_WIDTH = 32;
    public static final int CURSOR_HEIGHT = 32;
    
    public static final int CHOSEN_MENU_NUMBER = 4;
    public static final String[] MENU = {"Game Start", "Scoreboard", "Tutorial",  "Exit"};
    
    public static final int START = 0;
    public static final int SCOREBOARD = 1;
    public static final int TUTORIAL = 2;
    public static final int EXIT = 3;
    public static final int NOTHING = 4;
    
    public static final Color EXIT_HEAD = Color.cyan;
    public static final Color EXIT_TAIL = Color.white;
    public static final Color ENTER_HEAD = Color.BLUE;
    public static final Color ENTER_TAIL = Color.BLACK;

    public static final int REFRESH_RATE_MS = 1000;
    public static final int TIMER = 60;
    public static final int ADD_SCORE = 10;
    public static final int REMOVE_SCORE = -10;
    public static final int NUMBER_LIFE = 5;
}
