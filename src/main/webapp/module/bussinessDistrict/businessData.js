function sv(str, idName) {
    var id = idName;
    stb = String(str);
    var sub = "";
    var svb;
    for (var i = 0; i < stb.toString().length; i++) {
        var ss = stb.substr(i, 1);
        svb = parseInt(ss)
        var j = ss;
        if (svb == j) {
            sub += '<li>' + ss + '</li>'
        } else {
            sub += "<li class='point'>.</li> "
            /*$(this).next('li').css('margin-left','-4px!important');*/
        }
    }
    $(id).html(sub);
    /*var index = $(id).find('.numanimate').length;
    console.log(index)*/
}


function showHumenFlow(shangquan) {
    axios.get(url_humanFlow, {
        params: {
            busId : shangquan
        }
    }).then(function (res) {
       sv(9.33, "#realTimeProple");
    }).catch(function (err) {
        console.log(err)
    })
}

