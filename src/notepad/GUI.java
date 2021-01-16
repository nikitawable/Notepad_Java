package notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;


public final class GUI implements ActionListener {
        boolean wordWrapOn;

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu,editMenu,formatMenu,colorMenu,font,fontsize;
    JMenuItem New,open,save,saveas,exit,wordwrap,arial,times_new_roman,comic_sans_sms,s8,s12,s16,s24,s28,undoText,redoText;
    
    JMenuItem color1,color2,color3;
    UndoManager um=new UndoManager();
    Function_file file=new Function_file(this);
    Function_format format=new Function_format(this);
    Function_Color color=new Function_Color(this);
    Function_Edit edit=new Function_Edit(this);
    
    public GUI()
    {
        createWindow();
        createTextArea();
        createMenuBar();
        createMenuItems();
        createColorMenu();
        format.selectedFont="Arial";
        format.createFont(16);
        format.wordWrapFunction();
        color.changeColor("White");
        window.setVisible(true);
        
        
    }
    public void createWindow()
    {
        window=new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea()
    {
        textArea=new JTextArea();
        textArea.getDocument().addUndoableEditListener((UndoableEditEvent e) -> {
            um.addEdit(e.getEdit());
        });
        scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
                        window.add(scrollPane);

    }
    public void createMenuBar()
    {
        menuBar=new JMenuBar();
        window.setJMenuBar(menuBar);
        fileMenu=new JMenu("File");
        menuBar.add(fileMenu);
        editMenu=new JMenu("Edit");
        menuBar.add(editMenu);
        formatMenu=new JMenu("Format");
        menuBar.add(formatMenu);
        colorMenu=new JMenu("Color");
        menuBar.add(colorMenu);
        
        
    }
    public void createMenuItems()
    {
        New=new JMenuItem("New");
        New.addActionListener(this);
        New.setActionCommand("New");
        fileMenu.add(New);
        open=new JMenuItem("Open");
        open.addActionListener(this);
        open.setActionCommand("Open");
        fileMenu.add(open);
        save=new JMenuItem("Save");
        save.addActionListener(this);
        save.setActionCommand("Save");
        fileMenu.add(save);
        saveas=new JMenuItem("SaveAs");
        saveas.addActionListener(this);
        saveas.setActionCommand("SaveAs");
        fileMenu.add(saveas);
        exit=new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setActionCommand("Exit");
        fileMenu.add(exit);
        
        wordwrap=new JMenuItem("Word Wrap");
        wordwrap.addActionListener(this);
        wordwrap.setActionCommand("Word Wrap");
        formatMenu.add(wordwrap);
        
        font=new JMenu("Font");
        formatMenu.add(font);
        fontsize=new JMenu("Font Size");
        formatMenu.add(fontsize);
        
        arial=new JMenuItem("Arial");
        arial.addActionListener(this);
        arial.setActionCommand("Arial");
        font.add(arial);
        
        times_new_roman=new JMenuItem("Times New Roman");
        times_new_roman.addActionListener(this);
        times_new_roman.setActionCommand("Times New Roman");
        font.add(times_new_roman);
        
        comic_sans_sms=new JMenuItem("Comic Sans MS");
        comic_sans_sms.addActionListener(this);
        comic_sans_sms.setActionCommand("Comic Sans MS");
        font.add(comic_sans_sms);
        
                s8=new JMenuItem("8");
                 s8.addActionListener(this);
                s8.setActionCommand("size8");
                        fontsize.add(s8);
                        
                        s12=new JMenuItem("12");
                        s12.addActionListener(this);
                s12.setActionCommand("size12");
                fontsize.add(s8);
        
                s16=new JMenuItem("16");
                s16.addActionListener(this);
                s16.setActionCommand("size16");
                fontsize.add(s16);
        
                s24=new JMenuItem("24");
                s24.addActionListener(this);
                s24.setActionCommand("size24");
                fontsize.add(s24);
        
                s28=new JMenuItem("28");
                s28.addActionListener(this);
                s28.setActionCommand("sixe28");
                fontsize.add(s28);
                
                undoText=new JMenuItem("Undo");
                undoText.addActionListener(this);
                undoText.setActionCommand("Undo");
                editMenu.add(undoText);

                redoText=new JMenuItem("Redo");
                redoText.addActionListener(this);
                redoText.setActionCommand("Redo");
                editMenu.add(redoText);  
    }
    public void createColorMenu()
    {
        color1=new JMenuItem("White");
        color1.addActionListener(this);
        color1.setActionCommand("White");
        colorMenu.add(color1);
        color2=new JMenuItem("Black");
        color2.addActionListener(this);
        color2.setActionCommand("Black");
        colorMenu.add(color2);
        color3=new JMenuItem("Blue");
        color3.addActionListener(this);
        color3.setActionCommand("Blue");
        colorMenu.add(color3);    
    }
    
    public static void main(String args[])
    {
       GUI gui=new GUI();
               
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command;
        command=e.getActionCommand();
        switch(command)
        {
            case "New":file.newFile();
                break;
            case "Open":file.openFile();
                break;
                case "Save":file.save();
                break;
                case "SaveAs":file.saveas();
                break;
                    case "Exit":file.exitFile();
                break;
                        case "Word Wrap":format.wordWrapFunction();
                break;
            case "Arial":format.setFont(command);
                break;
             case "Times New Roman":format.setFont(command);
                break;
            case "Comic Sans MS":format.setFont(command);
                break;
            case "size8":format.createFont(8);
                break;
            case "size12":format.createFont(12);
                break;
            case "size16":format.createFont(16);
                break;
            case "size24":format.createFont(24);
                break;
            case "size28":format.createFont(28);
                break;
                case "White":color.changeColor(command);
                break;
                    case "Black":color.changeColor(command);
                break;
                        case "Blue":color.changeColor(command);
                break;
                        case "Undo":
                            edit.undo();
                            break;
                        case "Redo":
                            edit.redo();
                            break;
                            
                            
              
        }
    }
    
    
}
