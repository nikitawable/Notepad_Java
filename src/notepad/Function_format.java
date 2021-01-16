/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.Font;

/**
 *
 * @author HP
 */
public class Function_format {
    GUI gui;
    Font arial,timesNewRoman,comicSansMS;
    String selectedFont;
    public Function_format(GUI gui)
    {
     this.gui=gui;   
    }
    public void wordWrapFunction()
    {
        if(gui.wordWrapOn==false)
                {
                    gui.wordWrapOn=true;
                    gui.textArea.setLineWrap(true);
                    gui.textArea.setWrapStyleWord(true);
                    gui.wordwrap.setText("Word Wrap:On");
                    
                }
        else if(gui.wordWrapOn==true)
                {
                    gui.wordWrapOn=false;
                    gui.textArea.setLineWrap(false);
                    gui.textArea.setWrapStyleWord(false);
                    gui.wordwrap.setText("Word Wrap:Off");
                    
                }
    }
    public void createFont(int fontSize)
    {
        arial=new Font("Arial",Font.PLAIN,fontSize);
        timesNewRoman=new Font("Times New Roman",Font.PLAIN,fontSize);
        comicSansMS=new Font("Comic Sans MS",Font.PLAIN,fontSize);
        setFont(selectedFont);
        
    }
    public void setFont(String font)
    {
        selectedFont=font;
        switch(selectedFont){
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Times New Roman":
                                gui.textArea.setFont(timesNewRoman);
                break;
            case "Comic sans MS":
                                gui.textArea.setFont(comicSansMS);

                break;
                
        }
        
        
    }
    
}
