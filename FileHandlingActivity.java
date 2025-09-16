import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandlingActivity {
    public static void main(String[] args) throws IOException {
        // Your code here

        // a. Create main directory
        File dirMain = new File("JavaFileSystem");
        dirMain.mkdir();
        // b. Create three text files
        File notes = new File("JavaFileSystem/notes.txt");
        notes.createNewFile();
        File data = new File("JavaFileSystem/data.txt");
        data.createNewFile();
        File log = new File("JavaFileSystem/log.txt");
        log.createNewFile();
        // c. Write messages to files
        Files.writeString(Path.of("JavaFileSystem/notes.txt"), "Aiden");
        Files.writeString(Path.of("JavaFileSystem/data.txt"), "Yasharian");
        Files.writeString(Path.of("JavaFileSystem/log.txt"), "AY");
        // d. Read and display file contents
        String contents = Files.readString(Path.of("JavaFileSystem/notes.txt"));
        String all = contents;
        System.out.println(contents);
        contents = Files.readString(Path.of("JavaFileSystem/data.txt"));
        all = all.concat("\n" + contents);
        System.out.println(contents);
        contents = Files.readString(Path.of("JavaFileSystem/log.txt"));
        all = all.concat("\n" + contents);
        System.out.println(contents);
        // e. Create backup directory
        File dirBackUp = new File("JavaFileSystem/Backup");
        dirBackUp.mkdir();
        // f. Copy contents to backup file
        File backup = new File("JavaFileSystem/Backup/backup.txt");
        backup.createNewFile();
        Files.writeString(Path.of("JavaFileSystem/Backup/backup.txt"), all);
        // g. List all files in both directories
        System.out.println("notes.txt\ndata.txt\nlog.txt\nbackup.txt");
        debugFileOperation();
    }
    
    public static void debugFileOperation() {
        try {
    // Creating a file with an invalid name (forward slash is invalid for file names on many OS)
    File file = new File("fileName.txt");
    
    // Attempting to write to the invalid file
    FileWriter writer = new FileWriter(file);
    writer.write("Will this fail?");
    writer.close();
} catch (IOException e) {
    System.out.println("An error occurred: " + e.getMessage());
    e.printStackTrace(); 
}
    }
}