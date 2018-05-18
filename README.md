# Directory scanner
java version: JDK 10.0.1
### How to build and run jar file:
1. Open cmd.exe
2. Go to the class folder:
```
cd path_to_directory\directory_scanner\scr\com\company
```
3. Build jar file:
```
javac DirectoryScanner.java

jar cfm DirectoryScanner.jar path_to_directory\directory_scanner\scr\META-INF\MANIFEST.MF DirectoryScanner.class
```
4. Run jar file:
```
java -jar path_to_directory\out\artifacts\directory_scanner_jar\directory_scanner.jar
```

### Input and Output examples:
Input:
```
E:\webserver
```
Output:
```
Name: Apache		 Size: 42MB		 Directory: true
Name: cssmanual2008.pdf		 Size: 31MB		 Directory: false
Name: PHP		 Size: 58MB		 Directory: true
Name: www		 Size: 429MB		 Directory: true
```
