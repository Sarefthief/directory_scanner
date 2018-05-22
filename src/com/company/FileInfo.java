package com.company;

public class FileInfo
{
    private String name;
    private long size;
    private boolean dirStatus;

    public String getName()
    {
        return name;
    }

    public long getSize()
    {
        return size;
    }

    public boolean getDirStatus()
    {
        return dirStatus;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

    public void setDirStatus(boolean dirStatus)
    {
        this.dirStatus = dirStatus;
    }
}
