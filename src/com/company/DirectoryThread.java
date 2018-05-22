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
            long size = FileUtils.sizeOfDirectory(file);
            size /= 1024*1024;
            fileInfo.setSize(size);
        } else {
            fileInfo.setDirStatus(false);
            long size = file.length();
            size /= 1024*1024;
            fileInfo.setSize(size);
        }
    }
}
