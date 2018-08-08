let datalist = [{
    offset: [56, 48],
    symbolSize: 120,
    opacity: .95,
    color: '#2A8F58'
}, {
    offset: [35, 80],
    symbolSize: 95,
    opacity: .88,
    color: '#FFA360'
}, {
    offset: [20, 43],
    symbolSize: 90,
    opacity: .84,
    color: '#929542'
}];

let optionScatter = {
    grid: {
        show: false,
        top: 10,
        bottom: 10
    },
    xAxis: [{
        gridIndex: 0,
        type: 'value',
        show: false,
        min: 0,
        max: 100,
        nameLocation: 'middle',
        nameGap: 5
    }],
    yAxis: [{
        gridIndex: 0,
        min: 0,
        show: false,
        max: 100,
        nameLocation: 'middle',
        nameGap: 30
    }],
    series: [{
        type: 'scatter',
        symbol: 'circle',
        symbolSize: 120,
        label: {
            normal: {
                show: true,
                formatter: '{b}',
                color: '#fff',
                textStyle: {
                    fontSize: '20'
                }
            },
        },
        itemStyle: {
            normal: {
                color: '#00acea'
            }
        },
    }]
};

let dom = $("#zhiye")[0];

function updateScatter(shangquan) {
    optionScatter.series[0].data = [];
    let echartsObj = echarts.getInstanceByDom(dom);
    if (echartsObj) echartsObj.clear();

    axios.get(url_fangkeZhiye, {
        params: {
            uuid: shangquan
        }
    }).then(resp => {
            let plantCap = _.sortBy(resp.data.data, item => {
                return -item['value'];
            });

            for (let v of plantCap) v.value /= (parseInt(plantCap[0].value) / 100);

            let data = [];
            for (let i = 0; i < plantCap.length; i++) {

                let item = plantCap[i];
                let itemToStyle = datalist[i];

                data.push({
                    name: item.value + '\n' + item.name,
                    value: itemToStyle.offset,
                    symbolSize: item.value,
                    label: {
                        normal: {
                            textStyle: {
                                fontSize: 11
                            }
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: itemToStyle.color,
                            opacity: itemToStyle.opacity
                        }
                    },
                })
            }
            optionScatter.series[0].data = data;

            echarts.init(dom).setOption(optionScatter);
        }
    )
}

