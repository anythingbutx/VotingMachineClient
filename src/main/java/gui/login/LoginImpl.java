package gui.login;

import javafx.scene.control.Button;



public class LoginImpl extends Login {
    

    
    public LoginImpl () {
        super();
    }
 
    @Override
    public String getVoterID() {
        String str = this.idField.getText();
        this.idField.setText("");
        return str;
    }

    @Override
    public Button getLoginBtn() {
        return this.btnLogin;
    }

}
