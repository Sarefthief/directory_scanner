# Directory scanner
java version: 10.0.1
### How to build and run jar file:
1. Install IntelliJ IDEA from https://www.jetbrains.com/idea/download
2. Open project in IDEA
3. Build -> Builds Artifacts -> directory_scanner:jar -> Build
4. Open cmd.exe
5. Run jar file:
```
java -jar C:\path\to\project\out\artifacts\directory_scanner_jar\directory_scanner.jar
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
