let amap = new AMap.Map("heatmap", {
    resizeEnable: true,
    mapStyle: 'amap://styles/blue',
    zoom: 11
});

amap.plugin(["AMap.Heatmap"]);

let heatmap = new AMap.Heatmap(amap, {
    radius: 25, //给定半径
    opacity: [0, 0.8]
});


async function updateHeatmap(shangquan) {
    let resp = await axios.get(url_heatmap, {
        params: {
            uuid: shangquan
        }
    });
    let data = [];
    for (let v of resp.data.data) {
        data.push({
            lng: v[0],
            lat: v[1],
            count: v[2],
        })
    }

    heatmap.setDataSet({
        data: data,
        max: 100
    });

    data = _.sortBy(data, item => {
        return -item['count'];
    });
    amap.panTo([data[0].lng, data[0].lat]);
}