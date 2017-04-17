	function ShowCountDown(timenow,id) {
		var leftTime = timenow;
		var leftsecond = parseInt(leftTime/1000);
		countDown(leftsecond,function(msg){
       		document.getElementById(id).innerHTML = msg; 
    	});
	}

	function getTime(time){
		var minutesZero = "0";
		var secondsZero = "0";
		time /= 1000;
		var hours = Math.floor((time)/3600);
		var minutes = Math.floor( (time-hours*3600)/60 );
		if (minutes > 9) minutesZero = "";
		var seconds = Math.floor(time-hours*3600-minutes*60);
		if (seconds > 9) secondsZero = "";
		msg = hours+"时"+ minutesZero +minutes+"分"+ secondsZero +seconds+"秒";
		return msg;
	}
	
	function countDown(maxtime,fn)
	{
	   var timer = setInterval(function(){
			var minutesZero = "0";
			var secondsZero = "0";
			var hours = Math.floor((maxtime)/3600);
			var minutes = Math.floor( (maxtime-hours*3600)/60 );
			if (minutes > 9) minutesZero = "";
			var seconds = Math.floor(maxtime-hours*3600-minutes*60);
			if (seconds > 9) secondsZero = "";
			msg = hours+"时"+ minutesZero +minutes+"分"+ secondsZero +seconds+"秒";
			fn(msg);
			++maxtime;
	    }, 1000);
	}