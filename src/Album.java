import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String songName;
    private String artist;
    private List<Song> songs;

    public Album(String songName, String artist) {
        this.songName = songName;
        this.artist = artist;
        this.songs =new ArrayList<>();
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong(String title){
         for(Song s: songs){
             if(s.getTitle().equals(title)){
                 return true;
             }
         }
         return false;
    }

     public void addSongtoAlbum(String title,double duration){
        Song s=new Song(title,duration);
        if(findSong(s.getTitle())==true){
            System.out.println("Song has already Present in the Album");
        }else{
            songs.add(s);
            System.out.println("new song has been Added");
        }
        return;
     }

      public void addtoPlayListFromAlbum(String title, LinkedList<Song> playList){

         if(findSong(title)==true){
            for(Song song:songs){
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println("Song has been added your PlayList");
                    break;
                }
            }
        }else{
            System.out.println("Song is not present in the Album");
        }
        return;
      }

      public void addtoPlayListFromAlbum(int trackNo, LinkedList<Song> playList){
        int index=trackNo-1;
        if(index>=0 && index<songs.size()){
            playList.add(songs.get(index));
        }else{
            System.out.println("Invalid track number");
        }
        return;
      }

}
