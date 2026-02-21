public class Song {
    private String title;
    private String artist;

    public Song(String t, String a) {
        title = t;
        artist = a;
    }

    public String getTitle() {
        return title; // get title of this song
    }

    public String getArtist() {
        return artist; // get artist of this song
    }

    // Since Playlist class will require printing details of the songs, I create a toString() method to simply that process
    @Override
    public String toString() {
        return title + " by " + artist; // ie, "Golden by KPop Demon Hunters"
    }
}
