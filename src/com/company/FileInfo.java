package com.company;

public class FileInfo
{
    private String name;
    private long size;
    private boolean dirStatus;

    /**
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return size
     */
    public long getSize()
    {
        return size;
    }

    /**
     * @return is file a directory
     */
    public boolean getDirStatus()
    {
        return dirStatus;
    }

    /**
     * @param name name of file
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @param size size of file
     */
    public void setSize(long size)
    {
        this.size = size;
    }

    /**
     * @param dirStatus is file a directory
     */
    public void setDirStatus(boolean dirStatus)
    {
        this.dirStatus = dirStatus;
    }
}
