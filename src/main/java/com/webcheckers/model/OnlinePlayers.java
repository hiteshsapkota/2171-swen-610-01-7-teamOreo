package com.webcheckers.model;

import java.util.ArrayList;

public class OnlinePlayers {

    public static ArrayList<OnlinePlayers> onlineList = new ArrayList<>();
    private String name;
    private boolean isFree;


    public String getName()
    {
        return name;
    }

    public OnlinePlayers(String name, boolean isFree)
    {
        this.name = name;
        this.isFree = isFree;

    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isFree()
    {
        return isFree;
    }

    public void setFree(boolean free)
    {
        isFree=free;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OnlinePlayers that = (OnlinePlayers) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public String toString()
    {
        return this.getName();
    }
}
