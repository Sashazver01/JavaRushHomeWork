package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alexandr on 26.01.16.
 */
public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }
    public GameObjects getLevel(int level)
    {
        int currentLevel = (level%60==0)?60:level%60;
        String currentLevelString = "Maze: "+currentLevel;
        List<String> listLevel = new ArrayList<>();
        try(BufferedReader raf = new BufferedReader(new FileReader(levels.toFile()))){
            String currentLine = "";
            while (!currentLevelString.equals(currentLine)){
                currentLine = raf.readLine();
            }
            for (int i = 0; i < 7; i++)
            {
                currentLine = raf.readLine();
            }
            while (!"".equals(currentLine)){
                listLevel.add(currentLine);
                currentLine = raf.readLine();
            }

        }catch (IOException e){}


        Set<Wall> walls =  new HashSet<Wall>();
        Set<Box> boxes =  new HashSet<Box>();
        Set<Home> homes =  new HashSet<Home>();
        Player player = null;
        for (int i = 0; i < listLevel.size(); i++)
        {
            String curentLinelevel = listLevel.get(i);
            for (int j = 0; j <curentLinelevel.length() ; j++)
            {

                int x  = (j==0)? Model.FIELD_SELL_SIZE / 2: Model.FIELD_SELL_SIZE / 2+(j)*Model.FIELD_SELL_SIZE;
                int y  = (i==0)? Model.FIELD_SELL_SIZE / 2: Model.FIELD_SELL_SIZE / 2+(i)*Model.FIELD_SELL_SIZE;
                char s = curentLinelevel.charAt(j);
                switch (s){
                    case '*':
                        boxes.add(new Box(x, y));
                        break;
                    case '.':
                        homes.add(new Home(x,y));
                        break;
                    case '&':
                        boxes.add(new Box(x, y));
                        homes.add(new Home(x,y));
                        break;
                    case 'X':
                        walls.add(new Wall(x,y));
                        break;
                    case '@':
                        player = new Player(x,y);
                        break;
                }
            }
        }



        GameObjects gameObjects = new GameObjects(walls,boxes,homes,player);

        return gameObjects;
    }
}
