package AbstractFactory.Baddesign;

/*
    This is an example of a poor design.

    Issues:
    1. Client directly instantiates concrete classes.
    2. Object creation logic is tightly coupled with business logic.
    3. Adding new OS requires modifying this class.
    4. Violates Open/Closed Principle.
*/


// ================= WINDOWS CLASSES =================

class WindowButton {

    void paint() {
        System.out.println("Windows button");
    }
}

class WindowsCheckbox {

    void paint() {
        System.out.println("Windows checkbox");
    }
}


// ================= MAC CLASSES =================

class MacButton {

    void paint() {
        System.out.println("Mac button");
    }
}

class MacCheckButton {

    void paint() {
        System.out.println("Mac checkbox");
    }
}


// ================= CLIENT CODE =================

public class design {   // Must match file name: design.java

    public static void main(String[] args) {

        String os = "Mac";

        if (os.equalsIgnoreCase("Mac")) {

            MacButton macButton = new MacButton();
            macButton.paint();

            MacCheckButton macCheckbox = new MacCheckButton();
            macCheckbox.paint();

        } else {

            WindowButton windowButton = new WindowButton();
            windowButton.paint();

            WindowsCheckbox windowsCheckbox = new WindowsCheckbox();
            windowsCheckbox.paint();
        }
    }
}
