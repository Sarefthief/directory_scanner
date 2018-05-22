package com.company;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class FileInfo implements Runnable
{
    Thread t;
    File file;
    String name;
    long size;
    boolean isDir;

    FileInfo(File file)
    {
        this.file = file;
        t = new Thread (this);
        t.start() ;
    }

    @Override
    public void run()
    {
        name = file.getName();
        if (file.isDirectory()){
            isDir = true;
            size = FileUtils.sizeOfDirectory(file);
            size /= 1024*1024;
        } else {
            isDir = false;
            size = file.length();
            size /= 1024*1024;
        }
    }
}
