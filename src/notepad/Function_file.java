/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author HP
 */
public class Function_file {
    GUI gui;
    String file;
    String address;
    public Function_file(GUI gui)
    {
        this.gui=gui;
      
    }
    public void newFile()
    {
        gui.textArea.setText("");
      gui.window.setTitle("New");
      file=null;
      address=null;
    }
    public void openFile()
    {
        FileDialog fd=new FileDialog(gui.window,"Open",FileDialog.LOAD);
        fd.setVisible(true);
        
        if(fd.getFile()!=null)
        {
            file=fd.getFile();
            address=fd.getDirectory();
            gui.window.setTitle(file);

        }
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(address + file));
                    String line=null;
            gui.textArea.setText("");
            while((line=br.readLine())!=null)
            {
                gui.textArea.append(line+ "\n");
            }
            br.close();
        } 
        catch (Exception ex)
        {
            System.out.println("File not opened");

        }          
    }
    public void save()
    {
        if(file==null)
        {
            saveas();
            
        }
        else
        {
            try{
                FileWriter fw=new FileWriter(address + file );
        fw.write(gui.textArea.getText());
        fw.close();
                    gui.window.setTitle(file);

                
            }
            catch(Exception e)
            {
                    System.out.println("File not opened");     
   
            }
        }
        
        
    }
    public void saveas()
    {
        FileDialog fd=new FileDialog(gui.window,"save",FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile()!=null)
        {
            file=fd.getFile();
            address=fd.getDirectory();
            gui.window.setTitle(file);
        }
        try{
        
        FileWriter fw=new FileWriter(address + file );
        fw.write(gui.textArea.getText());
        fw.close();
        }
        catch(Exception e)
        {
                        System.out.println("File not opened");     
        }
        
        
        
    }
    public void exitFile()
    {
        System.exit(0);
    }
    
}
