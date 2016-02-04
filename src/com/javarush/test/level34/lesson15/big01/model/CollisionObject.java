package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by alexandr on 25.01.16.
 */
public abstract class CollisionObject extends GameObject
{
    @Override
    public void draw(Graphics graphics)
    {

    }

    public CollisionObject(int x, int y)
    {
        super(x, y);
    }
    public boolean isCollision(GameObject gameObject, Direction direction){
        int newx = getX();
        int newy = getY();
        switch (direction)
        {
            case LEFT:
                newx = newx - Model.FIELD_SELL_SIZE;
                break;
            case RIGHT:
                newx = newx + Model.FIELD_SELL_SIZE;
                break;
            case UP:
                newy = newy - Model.FIELD_SELL_SIZE;
                break;
            case DOWN:
                newy = newy + Model.FIELD_SELL_SIZE;
                break;


        }
        return (newx == gameObject.getX() && newy == gameObject.getY());
    }
}
