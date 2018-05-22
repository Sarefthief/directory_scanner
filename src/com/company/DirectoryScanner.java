package com.company;
import java.io.File;

public class DirectoryScanner
{
    public FileInfo[] scan(String path)
    {
        File folder = new File(path);
        File[] listOfFiles  = folder.listFiles();
        DirectoryThread[] directoryThreads = new DirectoryThread[listOfFiles.length];
        FileInfo[] filesInfo = new FileInfo[listOfFiles.length];

        for (int i = 0; i < listOfFiles.length; i++){
            directoryThreads[i] = new DirectoryThread(listOfFiles[i]);  //создаем потоки для каждого файла в директории
        }
        for (DirectoryThread thread: directoryThreads){
            try {
                thread.t.join();    //главный поток ждет все побочные
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
            }
        }
        for (int i = 0; i < filesInfo.length; i++){
            filesInfo[i] = directoryThreads[i].getFileInfo();
        }

        return filesInfo;
    }
}
