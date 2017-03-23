package cn.edu.scuec.ssm.po;

public class Musicgarage {
    private Integer id;

    private String songtitle;

    private String singer;

    private String album;

    private String songaddress;

    private Integer capacity;

    private Integer playtime;

    private String albumimgadr;

    private String lyric;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongtitle() {
        return songtitle;
    }

    public void setSongtitle(String songtitle) {
        this.songtitle = songtitle == null ? null : songtitle.trim();
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer == null ? null : singer.trim();
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album == null ? null : album.trim();
    }

    public String getSongaddress() {
        return songaddress;
    }

    public void setSongaddress(String songaddress) {
        this.songaddress = songaddress == null ? null : songaddress.trim();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Integer playtime) {
        this.playtime = playtime;
    }

    public String getAlbumimgadr() {
        return albumimgadr;
    }

    public void setAlbumimgadr(String albumimgadr) {
        this.albumimgadr = albumimgadr == null ? null : albumimgadr.trim();
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric == null ? null : lyric.trim();
    }
}