package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by alexandr on 25.01.16.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {
        String fileName = f.getName().toLowerCase();
        return fileName.endsWith(".html") || fileName.endsWith(".htm") || f.isDirectory();
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
