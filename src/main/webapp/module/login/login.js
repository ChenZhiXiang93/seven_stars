(() => {
    document.querySelector("#verifyCode>img").setAttribute("src", url_verifyCode);

    document.onkeyup = event => {
        if (event.keyCode === 13) login();
    }
})();

function login() {
    let urlSearchParams = new URLSearchParams();
    urlSearchParams.append('userName', document.querySelectorAll("#username")[0].value.trim());
    urlSearchParams.append('pwd', md5(document.querySelectorAll("#password")[0].value.trim()));
    urlSearchParams.append('code', document.querySelectorAll("#verifyCode>input")[0].value.trim());

    axios.post(url_login, urlSearchParams
        /*            , {
                        withCredentials: true,
                        //credentials: 'same-origin',
                        //mode: 'no-cors',
                        headers: {
                            'Access-Control-Allow-Origin': '*',
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                    }*/
    ).then(resp => {
        if (resp.data.code == 200) {
            localStorage.shangquanLiebiao = JSON.stringify(resp.data.data);
            window.location.href = '../bussinessDistrict/business-district.html';
        } else {
            refreshImg();
            alert(resp.data.msg);
        }
    });

    /*    $.ajax({
            type: 'post',
            url: url_login,
            data: {
                userName: document.querySelectorAll("#username")[0].value.trim(),
                pwd: md5(document.querySelectorAll("#password")[0].value.trim()),
                code: document.querySelectorAll("#verifyCode>input")[0].value.trim()
            },
    /!*        headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/x-www-form-urlencoded'
            },*!/
            crossDomain: true,
            xhrFields: {withCredentials: true},
            success: resp => {
                refreshImg();
                alert(resp.msg);
            }
        })*/
}

function refreshImg() {
    document.querySelector("#verifyCode>img").setAttribute("src", url_verifyCode + '?timestamp=' + new Date().valueOf());
}