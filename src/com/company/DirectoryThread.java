package com.company;
import java.io.File;

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

    public long getFolderSize(File file)
    {
        long size = 0;
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory()) {
                size += getFolderSize(fileList[i]);
            } else {
                size += fileList[i].length();
            }
        }
        return size;
    }

    @Override
    public void run()
    {
        fileInfo.setName(file.getName());
        if (file.isDirectory()){
            fileInfo.setDirStatus(true);
            fileInfo.setSize(getFolderSize(file)/(1024*1024));
        } else {
            fileInfo.setDirStatus(false);
            fileInfo.setSize(file.length()/(1024*1024));
        }
    }
}
