package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by alexandr on 24.01.16.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view)
    {
        this.view = view;
    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public void init(){
        createNewDocument();
    }
    public void exit(){
        System.exit(0);
    }

    public static void main(String[] args)
    {
        View viewMain = new View();
        Controller controller = new Controller(viewMain);
        viewMain.setController(controller);
        viewMain.init();
        controller.init();

    }

    public void resetDocument(){
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();

    }

    public void setPlainText(String text){
        try
        {
            resetDocument();
            StringReader stringReader = new StringReader(text);
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.read(stringReader, document, 0);
        }catch (Exception e){ExceptionHandler.log(e);}

    }
    public String getPlainText(){

        try
        {
            StringWriter stringWriter = new StringWriter();
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());
            return stringWriter.toString();
        }catch (Exception e){ExceptionHandler.log(e);}
        return null;
    }

    public void createNewDocument()
    {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument()
    {
        view.selectHtmlTab();
        JFileChooser fileopen = new JFileChooser();
        fileopen.setFileFilter(new HTMLFileFilter());
        int ret = fileopen.showOpenDialog(view);
        if (ret == JFileChooser.APPROVE_OPTION) {
            currentFile = fileopen.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader reader = new FileReader(currentFile))
            {
                new HTMLEditorKit().read(reader, document, 0); //Вызови метод read() из класса HTMLEditorKit, который вычитает данные из реадера в документ document.

            }
            catch (Exception e)
            {
                ExceptionHandler.log(e); //Проследи, чтобы метод не кидал исключения. Их необходимо просто логировать.
            }
            view.resetUndo();
        }

    }

    public void saveDocumentAs()
    {
        try {
            view.selectHtmlTab();
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new HTMLFileFilter());
            jFileChooser.setDialogTitle("Save File");
            int n = jFileChooser.showSaveDialog(view);
            if (n == JFileChooser.APPROVE_OPTION) {
                currentFile = jFileChooser.getSelectedFile();
                view.setTitle(currentFile.getName());
                try (FileWriter writer = new FileWriter(currentFile)) {
                    new HTMLEditorKit().write(writer, document, 0, document.getLength());
                }
            }
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }


    }

    public void saveDocument()
    {
        try
        {
            view.selectHtmlTab();
            if (currentFile != null)
            {
                try (FileWriter writer = new FileWriter(currentFile)) {
                    new HTMLEditorKit().write(writer, document, 0, document.getLength());
                }
            } else saveDocumentAs();
        }catch (Exception e){ExceptionHandler.log(e);}
    }
}
