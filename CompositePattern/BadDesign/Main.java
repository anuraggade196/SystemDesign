package CompositePattern.BadDesign;

import java.util.*;

class File {
    private String name;
    private int size;
    
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }
    
    public void printStructure(String indent) {
        System.out.println(indent + name);
    }
    
    public void delete() {
        System.out.println("Deleting file: " + name);
    }
}

class Folder {
    private String name;
    private List<Object> contents = new ArrayList<>();
    
    public Folder(String name) {
        this.name = name;
    }
    
    public void add(Object item) {
        contents.add(item);
    }
    
    public int getSize() {
        int total = 0;
        for (Object item : contents) {
            if (item instanceof File) {
                total += ((File) item).getSize();
            } else if (item instanceof Folder) {
                total += ((Folder) item).getSize();
            }
        }
        return total;
    }
    
    public void printStructure(String indent) {
        System.out.println(indent + name + "/");
        for (Object item : contents) {
            if (item instanceof File) {
                ((File) item).printStructure(indent + "  ");
            } else if (item instanceof Folder) {
                ((Folder) item).printStructure(indent + "  ");
            }
        }
    }
    
    public void delete() {
        for (Object item : contents) {
            if (item instanceof File) {
                ((File) item).delete();
            } else if (item instanceof Folder) {
                ((Folder) item).delete();
            }
        }
        System.out.println("Deleting folder: " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRATING BAD DESIGN (WITHOUT COMPOSITE PATTERN) ===\n");
        
        // Create files
        File file1 = new File("document.txt", 100);
        File file2 = new File("image.jpg", 500);
        File file3 = new File("video.mp4", 2000);
        File file4 = new File("music.mp3", 300);
        
        // Create folders
        Folder root = new Folder("Root");
        Folder documents = new Folder("Documents");
        Folder media = new Folder("Media");
        Folder videos = new Folder("Videos");
        Folder music = new Folder("Music");
        
        // Build hierarchy
        documents.add(file1);  // Adding file to documents
        media.add(file2);       // Adding image to media
        media.add(videos);      // Adding folder to media
        media.add(music);       // Adding folder to media
        videos.add(file3);      // Adding video to videos folder
        music.add(file4);       // Adding music to music folder
        root.add(documents);    // Adding documents to root
        root.add(media);        // Adding media to root
        
        // Problem 1: Inconsistent interface - need to know type to call methods
        System.out.println("Problem 1: Different methods for different types");
        System.out.println("File size: " + file1.getSize());  // Direct call for File
        System.out.println("Folder size: " + root.getSize()); // Direct call for Folder
        // Can't treat them uniformly - this would fail:
        // Object obj = file1;
        // obj.getSize(); // ERROR! Object doesn't have getSize()
        
        System.out.println("\n--- File Structure ---");
        root.printStructure("");
        
        // Problem 2: Type checking everywhere (instanceof)
        System.out.println("\nProblem 2: Type checking with instanceof everywhere");
        System.out.println("Total size: " + root.getSize() + " KB");
        
        // Problem 3: Can add any object type (unsafe)
        System.out.println("\nProblem 3: No type safety - can add anything");
        root.add("This is a string!");        // Can add String
        root.add(123);                         // Can add Integer
        root.add(new Object());                 // Can add any Object
        
        System.out.println("\n--- After adding invalid objects ---");
        root.printStructure("");
        
        // This will cause ClassCastException at runtime!
        try {
            System.out.println("\nProblem 4: Runtime errors when accessing invalid objects");
            System.out.println("Trying to calculate size with invalid objects...");
            System.out.println("Total size: " + root.getSize() + " KB"); // Will throw exception
        } catch (ClassCastException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("The program crashed because we added non-File/non-Folder objects!");
        }
        
        // Problem 5: Cannot treat leaf and composite uniformly
        System.out.println("\nProblem 5: Cannot treat File and Folder uniformly");
        System.out.println("Want to process all items? Need separate code paths:");
        
        // This is what we'd have to do without Composite Pattern
        System.out.println("\nManual processing without uniform interface:");
        processItem(root);     // Works for Folder
        processItem(file1);    // Works for File
        // But this requires overloaded methods or instanceof checks
        
        System.out.println("\n=== KEY PROBLEMS WITH THIS DESIGN ===");
        System.out.println("1. ❌ No common interface - File and Folder are unrelated types");
        System.out.println("2. ❌ Type checking everywhere (instanceof) - brittle and error-prone");
        System.out.println("3. ❌ No type safety - can add any Object to Folder");
        System.out.println("4. ❌ Runtime errors instead of compile-time errors");
        System.out.println("5. ❌ Duplicate code in every operation (getSize, printStructure, delete)");
        System.out.println("6. ❌ Cannot extend easily - adding new type requires modifying all classes");
        System.out.println("7. ❌ Client code must know whether it's dealing with File or Folder");
    }
    
    // Problem 6: Need separate methods or instanceof checks
    private static void processItem(File file) {
        System.out.println("Processing file: " + file.getSize() + " KB");
    }
    
    private static void processItem(Folder folder) {
        System.out.println("Processing folder with size: " + folder.getSize() + " KB");
    }
}