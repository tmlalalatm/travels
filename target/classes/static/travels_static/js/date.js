// 时间显示
var show = document.getElementById("show");
var timer = setInterval(function () {
    var time = new Date();
    // 获取当前的年
    var year = time.getFullYear();
    // 获取月份
    var month = time.getMonth() + 1;
    // 获取日
    var day = time.getDate();
    // 获取小时
    var hours = time.getHours();
    // 获取分钟
    var minutes = time.getMinutes();
    if (minutes <= 9) {
        minutes = "0" + minutes;
    }
    // 获取秒
    var seconds = time.getSeconds();
    if (seconds <= 9) {
        seconds = "0" + seconds;
    }
    show.innerHTML = '当前系统时间：' + year + '年' + month + '月' + day + '日' + ' ' + hours + ':' + minutes + ':' + seconds;
}, 1000);
