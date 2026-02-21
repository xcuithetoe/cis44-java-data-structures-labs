import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Would you like to (1) add text, (2) undo changes, (3) redo changes, or (4) exit?");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Type in your new text state: ");
                    String text = scanner.nextLine();
                    editor.add(text);
                    break;
                
                case 2:
                    System.out.println("Full text: " + editor.undo());
                    break;
                
                case 3:
                    System.out.println("Full text: " + editor.redo());
                    break;
                
                case 4:
                    running = false;
                    break;
            }
        }

    }
}
