<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/playmusic.css" media="screen" type="text/css" />
  </head>
  
<body>

  <div class="music-player">
  <!--<div style="background-image: url(http://i.imgur.com/yqB0erk.jpg);" class="album"></div>-->

  <div class="info">
    <div class="left">
      <a href="javascript:;" class="icon-shuffle"></a>
      <a href="javascript:;" class="icon-heart"></a>
    </div>
    <div class="center">
    <div class="jp-playlist">
      <ul>
        <li></li>
      </ul>
    </div>

    </div>
    <div class="right">
      <a href="javascript:;" class="icon-repeat"></a>
      <a href="javascript:;" class="icon-share"></a>
    </div>

    <div class="progress jp-seek-bar">
      <span class="jp-play-bar" style="width: 0%"></span>
    </div>
  </div>

  <div class="controls">
    <div class="current jp-current-time">00:00</div>
    <div class="play-controls">
      <a href="javascript:;" class="icon-previous jp-previous" title="previous"></a>
      <a href="javascript:;" class="icon-play jp-play" title="play"></a>
      <a href="javascript:;" class="icon-pause jp-pause" title="pause"></a>
      <a href="javascript:;" class="icon-next jp-next" title="next"></a>
    </div>
    <div class="volume-level jp-volume-bar">
      <span class="jp-volume-bar-value" style="width: 0%"></span>
      <a href="javascript:;" class="icon-volume-up jp-volume-max" title="max volume"></a>
      <a href="javascript:;" class="icon-volume-down jp-mute" title="mute"></a>
    </div>
  </div>

  <div id="jquery_jplayer" class="jp-jplayer"></div>

</div>



<script src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.jplayer.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jplayer.playlist.min.js"></script>
<script src="<%=request.getContextPath()%>/js/playmusic.js"></script>
</body>

</html>
