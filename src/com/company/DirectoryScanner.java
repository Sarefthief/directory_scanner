package com.company;
import java.io.File;

public class DirectoryScanner
{
    public void scan(String path)
    {
        File folder = new File(path);
        File[] listOfFiles  = folder.listFiles();
        FileInfo[] myFiles = new FileInfo[listOfFiles.length];

        for (int i = 0; i < listOfFiles.length; i++){
            myFiles[i] = new FileInfo(listOfFiles[i]);  //создаем потоки для каждого файла в директории
        }
        for (FileInfo thread: myFiles){
            try {
                thread.t.join();    //главный поток ждет все побочные
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
            }
        }
        for (FileInfo file: myFiles){
            System.out.println("Name: " + file.name + "\t\t Size: " + file.size + "MB" + "\t\t Directory: " + file.isDir);
        }
    }
}
