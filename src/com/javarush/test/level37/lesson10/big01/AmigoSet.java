package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;


import java.io.Serializable;
import java.util.*;

/**
 * Created by alexandr on 28.01.16.
 */
public class AmigoSet <E> extends AbstractSet<E> implements Serializable,Cloneable, Set<E>
{
    private transient static final Object PRESENT =  new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet()
    {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection)
    {
        map = new HashMap<>((int)Math.max(16,collection.size()/.75f));
        this.addAll(collection);
    }

    @Override
    public boolean add(E e)
    {
        try
        {
            map.put(e,PRESENT);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public Iterator<E> iterator()
    {
        return map.keySet().iterator();
    }

    @Override
    public int size()
    {
        return map.keySet().size();
    }

    @Override
    public boolean isEmpty()
    {
        return map.keySet().isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return map.keySet().contains(o);
    }

    @Override
    public void clear()
    {
        map.keySet().clear();
    }

    @Override
    public boolean remove(Object o)
    {

        return  map.keySet().remove(o);
    }
    @Override
    public Object clone()
    {
        AmigoSet<E> amigoSet = new AmigoSet<>();
        try
        {
            amigoSet.addAll(this);
            amigoSet.map.putAll(this.map);
        }catch (Exception ex){
            throw new InternalError();
        }
        return amigoSet;
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException
    {
        s.defaultWriteObject();
        HashSet<E> set = new HashSet<>();
        set.addAll(map.keySet());
        s.writeObject(set);
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException
    {
        s.defaultReadObject();

        HashSet<E> set = (HashSet<E>) s.readObject();

        int capacity = (int)s.readObject();
        float loadFactor = (float)s.readObject();

        map = new HashMap<>(capacity, loadFactor);
        for (E e : set) {
            map.put(e, PRESENT);
        }
    }
}
