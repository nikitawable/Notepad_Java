/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

/**
 *
 * @author HP
 */
public class Function_Edit {
    GUI gui;
    public Function_Edit(GUI gui)
    {
        this.gui=gui;
        
    }
     void undo()
    {
     gui.um.undo();   
    }
     void redo(){
             gui.um.redo();   

        
    }

   
    
}
