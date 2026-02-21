import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Playlist playlist = new Playlist();
        
        boolean running = true;
        while (running) {
            System.out.println("Welcome to your playlist!");
            System.out.println("Would you like to (1) add songs, (2) display your playlist, (3) play the current song, (4) remove a song, or (5) exit this program?");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // add new songs
                    scanner.nextLine();
                    System.out.println("Please add some songs (input exit to stop): ");
                    int counter = 1;
                    while (true) {
                        System.out.println("Add song " + counter + " name: ");
                        String name = scanner.nextLine();
                        if (name.equals("exit")) { break;}

                        System.out.println("Add song " + counter + " artist: ");
                        String artist = scanner.nextLine();
                        if (artist.equals("exit")) { break;}

                        Song newest = new Song(name, artist);
                        playlist.addSong(newest);
                        counter++;
                    }

                    break;
                case 2: // display the playlist
                    playlist.displayPlaylist();
                    break;
                case 3:
                    String response;
                    scanner.nextLine();
                    do {
                        playlist.playNext(); //play next song
                        System.out.println("Would you like to play the next song as well? Yes or No: ");
                        response = scanner.nextLine();
                    } while (response.equals("Yes")); //see if next song afterwards should be played as well
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Please input the title of the song you would like to remove: ");
                    String remove = scanner.nextLine();
                    playlist.removeSong(remove);
                    break;
                case 5:
                    running = false;
                    break;

            }
        }



    }
}
