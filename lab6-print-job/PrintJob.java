/**
 * Represents a single document to be printed.
 */

class PrintJob {
    private String documentName;
    private int pageCount;

    // TODO: Implement the constructor
    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // TODO: Implement the toString method to return a descriptive string
    // e.g., "PrintJob[Document: report.docx, Pages: 15]"
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]"; // Placeholder
    }
}