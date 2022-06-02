
package PDCProject2GUI.controller;

import PDCProject2GUI.data.Database;
import PDCProject2GUI.data.LoginModel;
import PDCProject2GUI.view.LoginPanel;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.Test;


public class LoginControllerTest {
    
    @Test
    public void validateUsernameAndPassword_whenUsernameIsShorterThan3Chars_thenExpectAnErrorMessage() {
        LoginModel loginModel = new LoginModel(new Database());
        LoginPanel loginPanel = new LoginPanel();
        LoginController loginController = new LoginController(loginPanel, loginModel);
        
        String errorMessage = loginController.validateUsernameAndPassword("aa", "aa");
        
        assertEquals("Username must be at least 3 characters", errorMessage);
    }
    
    
    @Test
    public void validateUsernameAndPassword_whenUsernameIsempty_thenExpectAnErrorMessage() {
        LoginModel loginModel = new LoginModel(new Database());
        LoginPanel loginPanel = new LoginPanel();
        LoginController loginController = new LoginController(loginPanel, loginModel);
        
        String errorMessage = loginController.validateUsernameAndPassword("", "");
        
        assertEquals("Username must not be empty", errorMessage);
    }
    
     @Test
    public void validateUsernameAndPassword_whenPasswordIsempty_thenExpectAnErrorMessage() {
        LoginModel loginModel = new LoginModel(new Database());
        LoginPanel loginPanel = new LoginPanel();
        LoginController loginController = new LoginController(loginPanel, loginModel);
        
        String errorMessage = loginController.validateUsernameAndPassword("cooluser", "");
        
        assertEquals("Password must not be empty", errorMessage);
    }
    
     @Test
    public void validateUsernameAndPassword_whenPasswordIsShorterThan3Chars_thenExpectAnErrorMessage() {
        LoginModel loginModel = new LoginModel(new Database());
        LoginPanel loginPanel = new LoginPanel();
        LoginController loginController = new LoginController(loginPanel, loginModel);
        
        String errorMessage = loginController.validateUsernameAndPassword("cooluser", "aa");
        
        assertEquals("Password must be at least 3 characters", errorMessage);
    }
    
     @Test
    public void validateUsernameAndPassword_whenUsernameAndPasswordAreBothOver3Char_thenExpectNullErrorMessage() {
        LoginModel loginModel = new LoginModel(new Database());
        LoginPanel loginPanel = new LoginPanel();
        LoginController loginController = new LoginController(loginPanel, loginModel);
        
        String errorMessage = loginController.validateUsernameAndPassword("cooluser", "12345");
        
        assertNull(errorMessage);
    }
    
}
