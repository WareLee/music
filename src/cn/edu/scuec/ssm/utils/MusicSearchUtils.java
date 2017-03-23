package cn.edu.scuec.ssm.utils;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import cn.edu.scuec.ssm.po.Musicgarage;
/**
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public class MusicSearchUtils {
	
    private String searchValue;
    
    public MusicSearchUtils(String searchValue){
    	this.searchValue=searchValue;
    }

    public Musicgarage execute()  {
    	Musicgarage music=null;
        try {
        	music=new Musicgarage();
            String strURL = ("http://www.xiami.com/search?key=" + searchValue);
            URL url = new URL(strURL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            String buf = contentBuf.toString();
            int end = buf.indexOf("\" name=\"recommendids\"");
            int begin=buf.lastIndexOf("\"",end-1);
            String result = buf.substring(begin+1,end);

            url=new URL("http://www.xiami.com/song/"+result);
            httpConn = (HttpURLConnection) url.openConnection();
            input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            bufReader = new BufferedReader(input);
            contentBuf.delete(0,contentBuf.length()-1);
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            buf = contentBuf.toString();
            begin=buf.indexOf("lrc_main\">")+10;
            end=buf.indexOf("</div>",begin);
            music.setLyric(buf.substring(begin,end));

            URL dataUrl=new URL("http://www.xiami.com/widget/xml-single/uid/0/sid/"+result);
            HttpURLConnection dataHttpUrlConnection = (HttpURLConnection) dataUrl.openConnection();
            InputStreamReader dataInput = new InputStreamReader(dataHttpUrlConnection.getInputStream(), "utf-8");
            BufferedReader dataBuffer = new BufferedReader(dataInput);
            StringBuilder dataBuilder = new StringBuilder();
            while ((line = dataBuffer.readLine()) != null) {
                dataBuilder.append(line);
            }
            buf = dataBuilder.toString();

            int beginSongName=buf.indexOf("<song_name><![CDATA[")+20;
            int endSongName=buf.indexOf("]",beginSongName);
            music.setSongtitle(buf.substring(beginSongName,endSongName));

            int beginSongImg=buf.indexOf("cover><![CDATA[")+15;
            int endSongImg=buf.indexOf("]",beginSongImg);
            music.setAlbumimgadr(buf.substring(beginSongImg,endSongImg));

            int beginAlbumName=buf.indexOf("<album_name><![CDATA[")+21;
            int endAlbumName=buf.indexOf("]",beginAlbumName);
            music.setAlbum(buf.substring(beginAlbumName,endAlbumName));

            int beginArtistName=buf.indexOf("<artist_name><![CDATA[")+22;
            int endArtistName=buf.indexOf("]",beginArtistName);
            music.setSinger(buf.substring(beginArtistName,endArtistName));

            int beginMusicLink=buf.indexOf("location><![CDATA[")+18;
            int endMusicLink=buf.indexOf("]",beginMusicLink);
            music.setSongaddress(buf.substring(beginMusicLink,endMusicLink));
        }
        catch (Exception e){
            music=null;
        }
        return music;
    }

}
