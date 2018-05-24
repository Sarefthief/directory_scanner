package com.company;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DirectoryScanner
{
    /**
     * @param path full path to directory
     * @return array of fileInfo objects
     */
    public ArrayList<FileInfo> scan(String path)
    {
        File folder = new File(path);
        File[] listOfFiles  = folder.listFiles();
        ArrayList<DirectoryThread> directoryThreads = new ArrayList<>();
        ArrayList<FileInfo> filesInfo = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        for (File file: listOfFiles){
            DirectoryThread a = new DirectoryThread(file);
            directoryThreads.add(a);  //создаем потоки для каждого файла в директории
            pool.execute(a);
        }
        pool.shutdown();
        try{
            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch(InterruptedException e) {
            System.out.println("Thread pool is terminated");
        }
        for (DirectoryThread thread: directoryThreads){
            filesInfo.add(thread.getFileInfo());
        }

        return filesInfo;
    }
}
