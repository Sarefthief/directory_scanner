package com.company;
import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;


public class DirectoryThread implements Runnable
{
    Thread t;
    File file;
    long size = 0;
    String result;

    DirectoryThread(File file)
    {
        this.file = file;
        t = new Thread ( this);
        t.start() ;
    }

    @Override
    public void run()
    {
        if (file.isDirectory()){
            size = FileUtils.sizeOfDirectory(file);
            size /= 1024*1024;
            result = "Name: " + file.getName() + "\t\t Size: " + size + "MB" + "\t\t Directory: true";
        } else {
            size = file.length();
            size /= 1024*1024;
            result = "Name: " + file.getName() + "\t\t Size: " + size + "MB" + "\t\t Directory: false";
        }

    }
}
