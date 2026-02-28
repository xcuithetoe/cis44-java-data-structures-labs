public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<String>();

        // Add some initial stops
        Position<String> caltrain_sf = itinerary.addFirst("Caltrain San Francisco Station");
        Position<String> ferry_building = itinerary.addAfter(caltrain_sf, "Ferry Building");
        Position<String> golden_gate = itinerary.addAfter(ferry_building, "Golden Gate Bridge");

        // I then insert a stop between golden gate bridge and ferry building
        Position<String> palace_of_fine_arts = itinerary.addAfter(ferry_building, "Palace of Fine Arts");

        // Finally, I traverse my list with a for-each loop to demonstrate that the interater works!
        for (String stop : itinerary) {
            System.out.print(stop + " --> ");
        }
        System.out.println("Go back home!");

    }
}
