package com.company;
import java.io.File;
import java.util.ArrayList;

public class DirectoryScanner
{
    public ArrayList<FileInfo> scan(String path)
    {
        File folder = new File(path);
        File[] listOfFiles  = folder.listFiles();
        ArrayList<DirectoryThread> directoryThreads = new ArrayList<>();
        ArrayList<FileInfo> filesInfo = new ArrayList<>();

        for (File file: listOfFiles){
            directoryThreads.add(new DirectoryThread(file));  //создаем потоки для каждого файла в директории
        }
        for (DirectoryThread thread: directoryThreads){
            try {
                thread.t.join();    //главный поток ждет все побочные
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
            }
        }
        for (DirectoryThread thread: directoryThreads){
            filesInfo.add(thread.getFileInfo());
        }

        return filesInfo;
    }
}
