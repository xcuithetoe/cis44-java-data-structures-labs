public class TextEditor {
    private static class Node {
        private String textState;
        private Node prev;
        private Node next;
        
        public Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }

        public void setPrev(Node p) {
            prev = p;
        }

        public void setNext(Node n) {
            next = n;
        }

        public String getTextState() {
            return textState;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // Start with an initial empty string state.
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

    public void add(String newText) {
        // Create a new node with the updated text.
        // Set its 'prev' to the current node.
        // Set the current node's 'next' to this new node.
        // Finally, update currentNode to point to the new node.

        Node newestNode = new Node(currentNode.getTextState() + newText, currentNode, null);
        newestNode.setPrev(currentNode);
        currentNode.setNext(newestNode);
        currentNode = newestNode;
    }

    public String undo() {
        // Check if currentNode.prev is not null.
        // If it is, move currentNode back and return the text.
        // Otherwise, you can't undo.

        if (currentNode.getPrev() == null) {
            System.out.println("No history exists so undo tool is unavailable.");
            return currentNode.getTextState();
        } else {
            currentNode = currentNode.getPrev();
            return currentNode.getTextState();
        }
    }
    
    public String redo() {
        // Check if currentNode.next is not null.
        // If it is, move currentNode forward and return the text.
        if (currentNode.getNext() == null) {
            System.out.println("You are on the most recent text so redo tool is unavailable.");
            return currentNode.getTextState();
        } else {
            currentNode = currentNode.getNext();
            return currentNode.getTextState();
        }
    }
    
    public void printCurrent() {
        System.out.println(currentNode.textState);
    }
}