$(document).ready(function() {
	
	if($.cookie('username')){
		$('a.user').text($.cookie('username'));
	}
	
	// 获取热门推荐
	topHeat(1, 5);

	// 新歌上市
	leastSong(5, 5);

	submitComment();
	
	// 收藏
	collectSong();
	
	// 下载
	downLoadASong();
//	if($.cookie('userId')) {
//		// 我的收藏
//		myCollection(1);
//
//		// 我的下载
//		myDownload(1);
//
//		// 我评论过的曲目
//		myCommentedList(1);
//	}

	// 为热门和最新歌曲两块的每个歌曲绑定事件
//	bindListing();
	
	// 为收藏,评论过的,以及下载过的添加点击事件
//	bindingccd();

});

function downLoadASong(){
	$('.dDownLoad').live(
			'click',function(){
				var temp=$(this);
				var musicId=temp.parent('.songData').attr('value');
				if(!musicId){
					musicId=localStorage.getItem('thesongid');
				}
				var userId=$.cookie('userId');
				
				var songtitle=temp.parent('.dHouse').siblings('.dSongName').children('p').text();
				var singer=temp.parent('.dHouse').siblings('.dArtistName').children('p').text();
				
//				var templete=$('#templete2').html();
//				templete=templete.replace('musicId',musicId);
//				templete=templete.replace('songtitle',songtitle);
//				templete=templete.replace('singer',singer);
				
//				$('#myDownload').append(templete);
				
				$.ajax({
					type: "POST", // 请求类型,是POST还是GET
					url: "/music/downloadASong.action", // 请求得url地址
					async: false, // 是否异步
					data: 'musicId='+musicId+'&userId='+userId, // 请求的参数数据
					success: function(result) { // 请求成功后执行该函数
					},
					error: function() { // 请求失败后执行该函数
//						alert("出错");
					}
				});
			}
	);
//	$('a').live('click', function(event) {
//		  event.preventDefault();   
//	});
	
}

function collectSong(){
	$('.house').live(
		'click',function(){
//			var userId=$.cookie
//			musicId
			var songtitle=$(this).parent('.dHouse').siblings('.dSongName').children('p').text();
			var singer=$(this).parent('.dHouse').siblings('.dArtistName').children('p').text();
			
			var musicId=$(this).parent('.dHouse').parent('.songData').attr('value');
			if(!musicId){
				musicId=localStorage.getItem('thesongid');
			}
			var userId=$.cookie('userId');
			var temp=$(this);
			$.ajax({
				type: "POST", // 请求类型,是POST还是GET
				url: "/music/collectASong.action", // 请求得url地址
				async: false, // 是否异步
				data: 'musicId='+musicId+'&userId='+userId, // 请求的参数数据
				success: function(result) { // 请求成功后执行该函数
					temp.attr('src','img/heartRed.svg');
					
					var templete=$('#templete2').html();
					templete=templete.replace('musicId',musicId);
					templete=templete.replace('songtitle',songtitle);
					templete=templete.replace('singer',singer);
					
					$('#myCollection').append(templete);
					
				},
				error: function() { // 请求失败后执行该函数
					alert("出错");
				}
			});
		}
	);
}

function submitComment() {
	$(".commentSubmit").live(
		'click',function(){
			var article=$('.doComment').val();
			var userId=$.cookie('userId');
			var musicId=localStorage.getItem('thesongid');
			
			$.ajax({
				type: "POST", // 请求类型,是POST还是GET
				url: "/music/doComment.action", // 请求得url地址
				async: false, // 是否异步
				data: 'article='+article+'&userId='+userId+'&musicId='+musicId, // 请求的参数数据
				success: function(result) { // 请求成功后执行该函数
					var templete=$('#templete3').html();
					templete=templete.replace('theuser',$.cookie('username'));
					templete=templete.replace('thecomment',article);
					
					$('.doComment').before(templete);
				},
				error: function() { // 请求失败后执行该函数
					alert("出错");
				}
			});
		}
	);
}

function bindingccd(){
	$('.searched').live(
		'click',function(){
			var musicId=$(this).attr('value');
			
			$.ajax({
				type: "POST", // 请求类型,是POST还是GET
				url: "/music/selectASong.action", // 请求得url地址
				async: false, // 是否异步
				data: 'musicId=' + musicId, // 请求的参数数据
				success: function(result) { // 请求成功后执行该函数
					if(result&&result.length>0){
						$('#error').css('display','none');
						var puts=$('.put');
						puts.eq(0).attr('src',result[0]['albumimgadr']);
						puts.eq(1).text(result[0]['songtitle']);
						puts.eq(2).text(result[0]['singer']);
						puts.eq(3).attr('href',result[0]['songaddress']);
					
						$('.searchResult').eq(0).css('display','block');
						$('.middle').eq(0).css('display','none');
						
						for(var inn=0;inn=result.length;inn++){
							var templete=$('#templete3').html();
							templete=templete.replace('theuser'.result[inn]['username']);
							templete=templete.replace('thecomment'.result[inn]['article']);
							
							$('#thecomment').after(templete);
						}
						
					}else{
						$('.searchResult').eq(0).css('display','none');
						$('#error').css('display','block');
					}
					
				},
				error: function() { // 请求失败后执行该函数
					alert("出错u");
				}
			});
			
		}
	);
}
function getCommentByMusicid(musicId){
	$.ajax({
		type: "POST", // 请求类型,是POST还是GET
		url: "/music/getComment.action", // 请求得url地址
		async: false, // 是否异步
		data: 'musicId=' + musicId, // 请求的参数数据
		success: function(result) { // 请求成功后执行该函数
			if(result&&result.length>0){
				for(var i=0;i<result.length;i++){
					var templete=$('#templete3').html();
					templete=templete.replace('theuser'.result[i]['commenttime']);
					templete=templete.replace('thecomment'.result[i]['article']);
					
					$('#thecomment').after(templete);
				}
			}
		},
		error: function() { // 请求失败后执行该函数
			alert("出错哈");
		}
	});
}
function bindListing() {
	var songList=$('.get');
	var songImg=$('.songImg');
	var songName=$('.songName');
	var singer=$('.artistName');
	var download=$('.downLoad');
	
//	$(".play:nth-child(n+1)").live(
//		'click',function() {
//			var ind = $(this).index();
//			songList.eq(0).attr('src',songImg.eq(ind).attr('src'));
//			songList.eq(1).text(songName.eq(ind).text());
//			songList.eq(2).text(singer.eq(ind).text());
//			$('audio').eq(0).attr('src',download.eq(ind).attr('href'));
////			$('audio').eq(0).play();
//		}
//	);
}

// 我评论过的曲目
function myCommentedList(userId) {
	$.ajax({
		type: "POST", // 请求类型,是POST还是GET
		url: "/music/getCommentedSongList.action", // 请求得url地址
		async: false, // 是否异步
		data: 'userId=' + userId, // 请求的参数数据
		success: function(result) { // 请求成功后执行该函数
			dealMyCollectionResult(result, "#myCommented");
		},
		error: function() { // 请求失败后执行该函数
			alert("请求该场次项目列表出错");
		}
	});
}

// 我下载过的曲目
function myDownload(userId) {
	$.ajax({
		type: "POST", // 请求类型,是POST还是GET
		url: "/music/selectDownloadList.action", // 请求得url地址
		async: false, // 是否异步
		data: 'userId=' + userId, // 请求的参数数据
		success: function(result) { // 请求成功后执行该函数
			dealMyCollectionResult(result, "#myDownload");
		},
		error: function() { // 请求失败后执行该函数
			alert("请求该场次项目列表出错");
		}
	});
}

// 请求热门推荐
function topHeat(from, offset) {
	var sendData = 'from=' + from + '&offset=' + offset;

	$.ajax({
		type: "POST", // 请求类型,是POST还是GET
		url: "/music/selectSongList.action", // 请求得url地址
		async: true, // 是否异步
		data: sendData, // 请求的参数数据
		success: function(result) { // 请求成功后执行该函数
			dealTopHeatResult(result, "#heatSong");

		},
		error: function() { // 请求失败后执行该函数
			alert("请求该场次项目列表出错");
		}
	});
}

function dealTopHeatResult(result, appendId) {
	for(var i = 0; i < result.length; i++) {
		var templete = $('#templete').html();

		templete = templete.replace('theid', result[i]['id']);
		templete = templete.replace('albumimgadr', result[i]['albumimgadr']);
		templete = templete.replace('songtitle', result[i]['songtitle']);
		templete = templete.replace('singer', result[i]['singer']);
		templete = templete.replace('album', result[i]['album']);
		templete = templete.replace('songaddress', result[i]['songaddress']);

		$(appendId).append(templete);
	}

}

// 新歌上市
function leastSong(from, offset) {
	var sendData = 'from=' + from + '&offset=' + offset;

	$.ajax({
		type: "POST", // 请求类型,是POST还是GET
		url: "/music/selectSongList.action", // 请求得url地址
		async: true, // 是否异步
		data: sendData, // 请求的参数数据
		success: function(result) { // 请求成功后执行该函数
			dealTopHeatResult(result, "#newSong");
		},
		error: function() { // 请求失败后执行该函数
			alert("请求该场次项目列表出错");
		}
	});
}

// 我的收藏
function myCollection(userId) {
	$.ajax({
		type: "POST", // 请求类型,是POST还是GET
		url: "/music/selectCollectionList.action", // 请求得url地址
		async: false, // 是否异步
		data: 'userId=' + userId, // 请求的参数数据
		success: function(result) { // 请求成功后执行该函数
			dealMyCollectionResult(result, "#myCollection");
		},
		error: function() { // 请求失败后执行该函数
			alert("出错");
		}
	});
}

function dealMyCollectionResult(result, appendId) {
	for(var i = 0; i < result.length; i++) {
		var templete = $('#templete2').html();
		templete = templete.replace('songaddress', result[i]['songaddress']);
		templete = templete.replace('songtitle', result[i]['songtitle']);
		templete = templete.replace('singer', result[i]['singer']);
		templete = templete.replace('musicId', result[i]['id']);

		$(appendId).append(templete);
	}
}