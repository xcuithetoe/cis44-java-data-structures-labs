
public class CompanyTreeDriver {
    public static void main(String[] args) {
        // 1. Build the Tree
        // Create the root node (e.g., "CEO")
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // Create department heads (children of root)
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");
        root.addChild(vpSales);
        root.addChild(vpEngineering);

        // --- TO BE COMPLETED BY STUDENT ---
        // Add more nodes to build the following hierarchy:
        //
        // CEO
        //  |-- VP of Sales
        //  |    |-- Sales Manager (NA)
        //  |    |-- Sales Manager (EU)
        //  |
        //  |-- VP of Engineering
        //       |-- Dev Team Lead
        //       |    |-- Developer 1
        //       |    |-- Developer 2
        //       |
        //       |-- QA Team Lead

        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);
        
        // ... add children for "VP of Engineering" ...
        GeneralTreeNode devLead = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode dev1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode dev2 = new GeneralTreeNode("Developer 2");
        vpEngineering.addChild(devLead);
        devLead.addChild(dev1);
        devLead.addChild(dev2);
        GeneralTreeNode qaLead = new GeneralTreeNode("QA Team Lead");
        vpEngineering.addChild(qaLead);
        
        // 2. Perform Traversals
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();

        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}
