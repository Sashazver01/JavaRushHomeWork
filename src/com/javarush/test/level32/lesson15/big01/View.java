package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;
import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alexandr on 24.01.16.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public void setUndoListener(UndoListener undoListener)
    {
        this.undoListener = undoListener;
    }

    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String comand = actionEvent.getActionCommand();
        switch (comand){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                this.showAbout();
                break;
        }
    }
    public void init()
    {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        this.setVisible(true);
    }
    public void exit(){
        controller.exit();
    }
    public void initMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,menuBar);
        MenuHelper.initEditMenu(this,menuBar);
        MenuHelper.initStyleMenu(this,menuBar);
        MenuHelper.initAlignMenu(this,menuBar);
        MenuHelper.initColorMenu(this,menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);
    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane1ForHtmlTextPane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", jScrollPane1ForHtmlTextPane);
        JScrollPane jScrollPaneForPlainTextPane= new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", jScrollPaneForPlainTextPane);
        tabbedPane.setPreferredSize(new Dimension(800, 600));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui()
    {
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){
       if (tabbedPane.getSelectedIndex() == 0)
       {
           String text = plainTextPane.getText();
           controller.setPlainText(text);
       }
        if (tabbedPane.getSelectedIndex() == 1){
            String text = controller.getPlainText();
            plainTextPane.setText(text);
        }
        resetUndo();
    }

    public View()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public boolean canUndo(){
        return undoManager.canUndo();
    }
    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public void undo()
    {

        try
        {
            undoManager.undo();
        }catch (CannotRedoException e){ExceptionHandler.log(e);}
    }
    public void redo()
    {
        try
        {
            undoManager.redo();
        }catch (CannotRedoException e){ExceptionHandler.log(e);}
    }
    public void resetUndo()
    {

        try{
            undoManager.discardAllEdits();
        }catch (CannotRedoException e){ExceptionHandler.log(e);}

    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update(){
        Document document = controller.getDocument();
        htmlTextPane.setDocument(document);
    }
    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(), "Creator - Sabynin Evgeni", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
