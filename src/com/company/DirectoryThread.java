package com.company;
import java.io.File;

public class DirectoryThread implements Runnable
{

    private File file;
    private FileInfo fileInfo = new FileInfo();

    /**
     * @param file file object
     */
    DirectoryThread(File file)
    {
        this.file = file;
        Thread t = new Thread (this);
    }

    /**
     * @return fileInfo object
     */
    public FileInfo getFileInfo()
    {
        return fileInfo;
    }

    /**
     * @param file file object
     * @return size of the file or directory in bytes
     */
    public long getFolderSize(File file)
    {
        long size = 0;
        File[] fileList = file.listFiles();
        for (File fileCounter: fileList) {
            if (fileCounter.isDirectory()) {
                size += getFolderSize(fileCounter);
            } else {
                size += fileCounter.length();
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
