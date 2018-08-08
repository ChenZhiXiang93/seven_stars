function changeShangquan() {
    let dom = document.querySelectorAll('#shangquanLiebiao')[0];
    let selectedShangquan = dom.value;

    //标题
    document.querySelectorAll('#title')[0].innerText = dom.selectedOptions[0].innerText;
    //居住地和办公地点排名
    visitorRanking(selectedShangquan);
    //就业指数
    showHumenFlow(selectedShangquan);
    //各楼层访客分析
    floorChart(selectedShangquan);
    //访客统计
    visitorAnalysis(selectedShangquan);
    //历史访客分析
    historyVisitorAnalysis(selectedShangquan);
    //访客画像
    portrait(selectedShangquan);
    //访客标签
    visitorTag(selectedShangquan);
    //访客热力图
    updateHeatmap(selectedShangquan);
    //访客职业
    updateScatter(selectedShangquan);
}

let vm_shangquanLiebiao = new Vue({
    el: '#shangquanLiebiao',
    data: {
        list: JSON.parse(localStorage.shangquanLiebiao)
    },
    methods: {
        changeSelect: changeShangquan
    },
    mounted: changeShangquan
});

function logout() {
    window.location.href = url_logout;
}



