import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {

    Album album1=new Album("Sid sriram SOngs","Sid Sriram");
    album1.addSongtoAlbum("srivalli",4.04);
        album1.addSongtoAlbum("Ravana",5.04);


        Album album2=new Album("DSP SOngs","DSP");
        album2.addSongtoAlbum("Poonakaalu Loading",4.04);
        album2.addSongtoAlbum("jalsa",5.04);


        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("srivalli"));

        LinkedList<Song> myPlayList=new LinkedList<>();
        album2.addtoPlayListFromAlbum("jalsa",myPlayList);
        album2.addtoPlayListFromAlbum("Poonakaalu Loading",myPlayList);
        album1.addtoPlayListFromAlbum("Ravana",myPlayList);

        Song sample=new Song("Gaallo",4);
        System.out.println(sample);

        play(myPlayList);
    }
    public static void play(LinkedList<Song> playList){
        Scanner sc=new Scanner(System.in);
        ListIterator<Song> itr=playList.listIterator();

        boolean isForword=false;

        if(playList.size()>0){
            System.out.println("Currently playing: ");
            System.out.println(itr.next());
            isForword=true;
        }else{
            System.out.println("PlayList is Empty");
            return;
        }
        System.out.println("Enter your choice");
        printMenu();

        boolean quit = false;
        while(!quit){
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    if(isForword == false){
                        itr.next();
                        isForword = true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }else{
                        System.out.println("You have reached end of the playList");
                        isForword = false;
                    }
                    break;
                case 2:
                    if(isForword == true){
                        itr.previous();
                        isForword = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }else{
                        System.out.println("You are at the start of playList");
                        isForword = true;
                    }
                    break;
                case 3:
                    if(isForword == true){
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isForword = false;
                        }
                    }
                    else{
                        if ((itr.hasNext())){
                            System.out.println(itr.next());
                            isForword = true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printsongs(playList);
                    break;
                case 7:
                    quit =true;
                    break;
            }
        }
    }
    public static void printsongs(LinkedList<Song> playList){
        for (Song song:playList){
            System.out.println(song);
            return;
        }
    }
    public static void printMenu(){

        System.out.println("1 - Play next Song");
        System.out.println("2 - Play previous Song");
        System.out.println("3 - Repeat the current Song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current Song");
        System.out.println("6 - Print All the songs in PlayList");
        System.out.println("7 - Exit");
    }
}