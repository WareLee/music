/**
 * Created by pupil on 2016/7/19.
 */
window.onload=function () {
    var songId;
    var onInput=document.getElementsByClassName("onInput");
    var searchKeyWords=document.getElementsByClassName("searchKeyWords");
    var buttons=document.getElementsByClassName("buttons");
    var songName=document.getElementsByClassName("songName");
    var albumName=document.getElementsByClassName("albumName");
    var artistName=document.getElementsByClassName("artistName");
    var songImg=document.getElementsByClassName("songImg");
    var downLoad=document.getElementsByClassName("downLoad");
    var songLyric=document.getElementsByClassName("lyric");
    var error=document.getElementsByClassName("error");
    var searchResult=document.getElementsByClassName("searchResult");
    var middle=document.getElementsByClassName("middle");
    var dPlay=document.getElementsByClassName("dPlay");
    var songImg=document.getElementsByClassName("songImg");
    var songName=document.getElementsByClassName("songName");
    var artistName=document.getElementsByClassName("artistName");
    //0.1
    var lyric=document.getElementsByClassName("lyric");
    var dPlayPause=document.getElementsByClassName("dPlayPause");
    var get=document.getElementsByClassName("get");
    var put=document.getElementsByClassName("put");
    var dPlayIt=document.getElementsByClassName("dPlayIt");
    var audio=document.getElementsByTagName("audio");
    var songProcessInner=document.getElementsByClassName("songProcessInner");
    var songProcessOut=document.getElementsByClassName("songProcessOut");
    var mailNumber=document.getElementsByClassName("mailNumber");
    var passWord=document.getElementsByClassName("passWord");
    var mailLogo=document.getElementsByClassName("mailLogo");
    var passWordLogo=document.getElementsByClassName("passwordLogo");
    var changeToRegister=document.getElementsByClassName("changeToRegister");
    var loginSystemTitle=document.getElementsByClassName("loginSystemTitle");
    var formLogin=document.getElementsByClassName("formLogin");
    var loginSubmit=document.getElementsByClassName("loginSubmit");
    var grayBackGround=document.getElementsByClassName("grayBackground");
    var centerArea=document.getElementsByClassName("centerArea");
    var wrong=document.getElementsByClassName("wrong");
    var user=document.getElementsByClassName("user");
//    user[0].innnerHTML=$.cookie('username');

    searchResult[0].style.display="none";
    error[0].style.display="none";
    onInput[0].onclick=function () {
        onInput[0].style.display="none";
        searchKeyWords[0].focus();
    }

    buttons[0].onclick=function() {
        var result;
        var xmlhttp=new XMLHttpRequest();
        xmlhttp.open("POST","/music/searchASong.action?songtitle="+searchKeyWords[0].value,true);
        xmlhttp.send();
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                result=eval("("+xmlhttp.responseText+")");
                if(result==null||result.length==0){
                    searchResult[0].style.display="none";
                    middle[0].style.display="none";
                    error[0].style.display="block";
                    return;
                }
                else {
                    searchResult[0].style.display="block";
                    middle[0].style.display="none";
                    error[0].style.display="none";
                    songId=result[0].id;
                    localStorage.setItem("thesongid", result[0].id);
                    songName[0].innerHTML=result[0].songtitle;
                    albumName[0].innerHTML=result[0].album;
                    artistName[0].innerHTML=result[0].singer;
                    songImg[0].src=result[0].albumimgadr;
                    downLoad[0].href=getSongLink(result[0].songaddress);
                    songLyric[0].innerHTML=result[0].lyric;
                    xmlhttp.open("POST","http://localhost:8080/music/getComment.action?musicId="+songId,true);
                    xmlhttp.send();
                    xmlhttp.onreadystatechange=function() {
                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                            result = eval("(" + xmlhttp.responseText + ")");
                            commentFrame[0].innerHTML="<h2>评论</h2>";
                            for(var i=0;i<result.length;i++){
                                commentFrame[0].innerHTML+="<div class=\"commented\"><div class=\"commentData\">"+result[i].article+"</div></div>";
                            }
                            commentFrame[0].innerHTML+="<textarea class=\"doComment\"></textarea> <input type=\"submit\" class=\"commentSubmit\"  value=\"评论\">"
                        }
                    }
                    return;
                }
            }
        }
        searchKeyWords[0].value=null;
    }


    function getSongLink(str)
    {
        var totle = parseInt(str);
        var newString = str.substr(1);
        var chu = Math.floor(newString.length / totle);
        var yu = newString.length % totle;
        var stor = new Array();
        var i;

        for(i = 0;i<yu;i++)
        {
            stor[i] = newString.substr((chu+1)*i,chu+1);
        }

        for(i=yu;i<totle;i++)
        {
            stor[i] = newString.substr(chu*(i-yu)+(chu+1)*yu,chu);
        }

        var pinString = '';
        for(i=0;i<stor[0].length;i++)
        {
            for(j=0;j<stor.length;j++)
            {
                pinString += stor[j].substr(i,1);
            }
        }
        pinString = rtan(pinString);
        var returnString = '';
        for(i=0;i<pinString.length;i++)
        {
            if(pinString.substr(i,1)=='^')
            {
                returnString += "0";
            } else {
                returnString += pinString.substr(i,1);
            }
        }
        return returnString;
    }

    function rtan(str){
        var ret="";
        for(var i=0;i<str.length;i++){
            var chr = str.charAt(i);
            if(chr == "+"){
                ret+=" ";
            }else if(chr=="%"){
                var asc = str.substring(i+1,i+3);
                if(parseInt("0x"+asc)>0x7f){
                    ret+=String.fromCharCode(parseInt("0x"+asc+str.substring(i+4,i+6)));
                    i+=5;
                }else{
                    ret+=String.fromCharCode(parseInt("0x"+asc));
                    i+=2;
                }
            }else{
                ret+= chr;
            }
        }
        return ret;
    }

    dPlayIt[0].onclick=function () {

        get[0].src=put[0].src;
        get[1].innerHTML=put[1].innerHTML;
        get[2].innerHTML=put[2].innerHTML;
        audio[0].src=put[3].href;
        audio[0].play();
        lyric[1].innerHTML=lyric[0].innerHTML;
    }
    dPlayPause[0].onclick=function () {
        if(audio[0].paused){
            dPlayPause[0].children[0].src="img/playWhite.svg";
            audio[0].play();
        }
        else{
            audio[0].pause();
            dPlayPause[0].children[0].src="img/pause.svg";
        }
    }


    function timeAll(){
        var mPlayer = document.getElementById("musicEngine");
        if(mPlayer.currentTime != 0){
            return mPlayer.duration;
        }else{
            return 0;
        }
    }

    setInterval(function(){process()},1000);
    function process(){
        var allTime=audio[0].duration;
        var currentTime=audio[0].currentTime;
        songProcessInner[0].style.width=(currentTime/allTime)*370+"px";
    }
    
    var searched=document.getElementsByClassName("searched");

 // 为每个
    var commentFrame=document.getElementsByClassName("commentFrame");
    $('div.searched').live(
    'click',function(){

        var result;
        var xmlhttp=new XMLHttpRequest();
        xmlhttp.open("POST","selectASong.action?musicId="+$(this).attr('value'),true);
        xmlhttp.send();
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                result=eval("("+xmlhttp.responseText+")");
                if(result.error!=null){
                    searchResult[0].style.display="none";
                    middle[0].style.display="none";
                    error[0].style.display="block";
                    return;
                }
                else {
                    searchResult[0].style.display="block";
                    middle[0].style.display="none";
                    error[0].style.display="none";
                    songName[0].innerHTML=result[0].songtitle;
                    albumName[0].innerHTML=result[0].album;
                    artistName[0].innerHTML=result[0].singer;
                    songImg[0].src=result[0].albumimgadr;
                    downLoad[0].href=result[0].songaddress;
                    songLyric[0].innerHTML=result[0].lyric;
                    songId=result[0].id;
                    localStorage.setItem("thesongid", result[0].id);
                        xmlhttp.open("POST","http://localhost:8080/music/getComment.action?musicId="+songId,true);
                        xmlhttp.send();
                        xmlhttp.onreadystatechange=function() {
                            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                                result = eval("(" + xmlhttp.responseText + ")");
                                commentFrame[0].innerHTML="<h2>评论</h2>";
                                for(var i=0;i<result.length;i++){
                                	commentFrame[0].innerHTML+="<div class=\"commented\"><div class=\"theirName\">"+result[i].commenttime+"</div><div class=\"commentData\">"+result[i].article+"</div></div>";
                                	//   commentFrame[0].innerHTML+="<div class=\"commented\"><div class=\"commentData\">"+result[i].article+"</div></div>";
                                }
                                commentFrame[0].innerHTML+="<textarea class=\"doComment\"></textarea> <input type=\"submit\" class=\"commentSubmit\"  value=\"评论\">"
                            }
                        }

                    return;
                }
            }
        }
    
    }
    );
    
    
//评论有问题的源代码    		
//    var doComment=document.getElementsByClassName("doComment");
//    var commentSubmit=document.getElementsByClassName("commentSubmit");
//
//    commentSubmit[0].onclick=function () {
//        var xmlhttp=new XMLHttpRequest();
//        xmlhttp.open("POST","http://localhost:8080/music/doComment.action?musicId="+songId+"&article="+doComment[0].value+"&userId="+$.cookie('userId'),true);
//        xmlhttp.send();
//        var newItem=document.createElement("div");
//        newItem.setAttribute("class","commented");
//        var textNode=document.createTextNode(doComment[0].value);
//        newItem.appendChild(textNode);
//        commentFrame[0].insertBefore(newItem,doComment[0]);
//    }
    
    
// searched[0].onclick=function(){
//
//     var result;
//     var xmlhttp=new XMLHttpRequest();
//     xmlhttp.open("POST","selectASong.action?musicId="+searched[0].attributes['musicId'].value,true);
//     xmlhttp.send();
//     xmlhttp.onreadystatechange=function()
//     {
//         if (xmlhttp.readyState==4 && xmlhttp.status==200)
//         {
//             result=eval("("+xmlhttp.responseText+")");
//             if(result.error!=null){
//                 searchResult[0].style.display="none";
//                 middle[0].style.display="none";
//                 error[0].style.display="block";
//                 return;
//             }
//             else {
//                 searchResult[0].style.display="block";
//                 middle[0].style.display="none";
//                 error[0].style.display="none";
//                 songName[0].innerHTML=result.songName;
//                 albumName[0].innerHTML=result.albumName;
//                 artistName[0].innerHTML=result.artistName;
//                 songImg[0].src=result.songImg;
//                 downLoad[0].href=getSongLink(result.songLink);
//                 songLyric[0].innerHTML=result.lyric;
//                 return;
//             }
//         }
//     }
// 
// }
 
 var houseSongName=document.getElementsByClassName("housedSongName");
 function houseDownloadCommented() {
     var xmlhttp=new XMLHttpRequest();
     //收藏过
     xmlhttp.open("POST","http://localhost:8080/music/selectCollectionList.action?userId="+$.cookie('userId'),true);
     xmlhttp.send();
     xmlhttp.onreadystatechange=function(){
         if (xmlhttp.readyState==4 && xmlhttp.status==200) {
             var result = eval("(" + xmlhttp.responseText + ")");
             for(var i=0;i<result.length;i++){
            	 houseSongName[0].innerHTML+="<div class=\"searched\" value="+result[i].id+"><a>"+result[i].songtitle+"</a><p>"+result[i].singer+"</p></div>";
            	 //  houseSongName[0].innerHTML+="<div><p class=\"searched\" musicId="+result[i].id+">"+result[i].songtitle+"</p><p>"+result[i].singer+"</p></div>"
             }
         }
     }
     //评论过
     var xmlhttp2=new XMLHttpRequest();
     xmlhttp2.open("POST","http://localhost:8080/music/getCommentedSongList.action?userId="+$.cookie('userId'),true);
     xmlhttp2.send();
     xmlhttp2.onreadystatechange=function(){
         if (xmlhttp2.readyState==4 && xmlhttp2.status==200) {
             var result = eval("(" + xmlhttp2.responseText + ")");
             for(var i=0;i<result.length;i++){
                 houseSongName[1].innerHTML+="<div class=\"searched\" value="+result[i].id+"><a>"+result[i].songtitle+"</a><p>"+result[i].singer+"</p></div>";
             }
         }
     }
     
     //下载过
     var xmlhttp1=new XMLHttpRequest();
     xmlhttp1.open("POST","http://localhost:8080/music/selectDownloadList.action?userId="+$.cookie('userId'),true);
     xmlhttp1.send();
     xmlhttp1.onreadystatechange=function(){
    	 if (xmlhttp1.readyState==4 && xmlhttp1.status==200) {
    		 var result = eval("(" + xmlhttp1.responseText + ")");
    		 for(var i=0;i<result.length;i++){
    			 houseSongName[2].innerHTML+="<div class=\"searched\" value="+result[i].id+"><a>"+result[i].songtitle+"</a><p>"+result[i].singer+"</p></div>";
    		 }
    	 }
     }
    
 }
 houseDownloadCommented();
 var searched=document.getElementsByClassName("searched");


 var play=document.getElementsByClassName("play");
 var songImg=document.getElementsByClassName("songImg");
 var songName=document.getElementsByClassName("songName");
 var artistName=document.getElementsByClassName("artistName");
 var downLoad=document.getElementsByClassName("downLoad");
 //play下标1到音乐结束
 
 $(".play:not('.vivi')").live(
	 'click',function(){
		 var temp=$(this);
		 get[0].src=temp.parent('.dPlay').siblings('.dSongImg').children('img').attr('src');
//		 get[0].src=songImg[1].src;
	     get[1].innerHTML=temp.parent('.dPlay').siblings('.dSongName').children('p').text();
	     get[2].innerHTML=temp.parent('.dPlay').siblings('.dArtistName').children('p').text();;
	     audio[0].src=temp.parent('.dPlay').siblings('.dDownLoad').children('a').attr('href');
	     audio[0].play();
	     //动态请求的歌词你放吧。我这里是静态的。
	     var lyricstr="下雨天了怎么办 我好想你<br>不敢打给你 我找不到原因<br>为什么失眠的声音 变得好熟悉<br>沉默的场景<br>陪我听雨滴<br>期待让人越来越沉溺<br>谁和我一样 等不到他的谁<br>爱上你我总在学会 寂寞的滋味<br>一个人撑伞<br>一个人擦泪<br>怎样的雨 怎样的夜<br>怎样的我能让你更想念<br>雨要多大 天要多黑<br>才能够有你的体贴<br>其实 没有我你分不出那些 差别<br>结局还能多明显<br>别说你会难过<br>别说你想改变<br>被爱的人不用道歉<br> <br>期待让人越来越疲惫<br>谁和我一样<br>等不到他的谁<br>爱上你我总在学会<br>寂寞的滋味<br>一个人撑伞<br>一个人擦泪<br>一个人好累<br>怎样的雨 怎样的夜<br>怎样的我能让你更想念<br>雨要多大 天要多黑<br>才能够有你的体贴<br>其实 没有我你分不出那些 差别<br>结局还能多明显<br>别说你会难过<br>别说你想改变<br>被爱的人不用道歉<br>怎样的雨 怎样的夜<br>怎样的我能让你更想念<br>雨要多大 天要多黑<br>才能够有你的体贴<br>其实 没有我你分不出那些 差别<br>结局还能多明显<br>别说你会难过<br>别说你想改变<br>被爱的人不用道歉";
	     $('.lyric').eq(1).append(lyricstr);
	 }
 );
 play[1].onclick=function () {
     get[0].src=songImg[1].src;
     get[1].innerHTML=songName[1].innerHTML;
     get[2].innerHTML=artistName[1].innerHTML;
     audio[0].src=downLoad[1].href;
     audio[0].play();
     //动态请求的歌词你放吧。我这里是静态的。
 	
 }

}

