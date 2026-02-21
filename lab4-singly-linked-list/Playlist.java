public class Playlist {
    private static class Node {
        private Song song;
        private Node next;
        
        public Node(Song song, Node next) {
            this.song = song;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Song getSong() {
            return song;
        }

    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void addSong(Song song) {
        // adds to the end
        Node newest = new Node(song, null);
        if (size == 0) {
            head = newest;
            
        } else {
            tail.setNext(newest); // old tail points to new song
        }
        tail = newest; // new song becomes new tail
        size++;
    }

    public void removeSong(String title) {
        // Handle two cases: removing the head and removing from elsewhere.
        // Don't forget to update the tail if the last song is removed.


        // case 1: removing the head
        if (head.getSong().getTitle().equals(title)) {
            head = head.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }

        } else {
            // case 2: removing from elsewhere
            Node current = head.getNext();
            Node previous = head;

            int previousSize = size;
            while (current != null) {
                if (current.getSong().getTitle().equals(title)) {
                    // set the previous song's next to the current song's next.
                    previous.setNext(current.getNext());
                    if (current == tail) {
                        tail = previous;
                    }
                    size--;
                }
                previous = current;
                current = current.getNext();
            }         
            if (size == previousSize) {
                System.out.println("The song you wanted to remove does not exist within your playlist.");
            }    
        }

    }

    public void playNext() {
        // If currentNode is null, start from the head.
        // Otherwise, advance to the next node.
        // If you reach the end, loop back to the head.

        if (currentNode == null) {
            currentNode = head;
        } 

        // "play" the current song. utilize the toString() method of the Song class
        System.out.println("Now playing: " + currentNode.getSong());

        currentNode = currentNode.getNext();
        if (currentNode == null) {
            currentNode = head; // loop back to the head after reaching the end
        } 
    }
    
    public void displayPlaylist() {
        // Traverse from the head and print each song.
        if (size == 0) {
            System.out.println("Playlist is currently empty.");
            return;
        }
        Node current = head;
        int count = 1;
        System.out.println("---- Current Playlist ----");
        while (current != null) {
            System.out.println(count + ". " + current.getSong());
            current = current.getNext();
            count++;
        }
        System.out.println("---------------------------");
    }
}
       