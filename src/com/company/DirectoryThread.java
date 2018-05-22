package com.company;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class DirectoryThread implements Runnable
{
    Thread t;
    private File file;
    private FileInfo fileInfo = new FileInfo();

    DirectoryThread(File file)
    {
        this.file = file;
        t = new Thread (this);
        t.start() ;
    }

    public FileInfo getFileInfo()
    {
        return fileInfo;
    }

    @Override
    public void run()
    {
        fileInfo.setName(file.getName());
        if (file.isDirectory()){
            fileInfo.setDirStatus(true);
            fileInfo.setSize(FileUtils.sizeOfDirectory(file)/(1024*1024));
        } else {
            fileInfo.setDirStatus(false);
            fileInfo.setSize(file.length()/(1024*1024));
        }
    }
}
