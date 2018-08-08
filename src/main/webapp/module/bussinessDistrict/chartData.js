//各楼层访客分析
var container = document.getElementById("floorVisitorsData");
var myChart = echarts.init(container);

var option = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross',
            crossStyle: {
                color: '#999'
            }
        }
    },
    legend: {
        /*data: ['人均停留时间', '日均到访人数'],*/
        textStyle: {
            color: '#ccc'
        }
    },
    grid: {
        left: '5%',
        bottom: '12%',
        top: '15%',
        left: '8%'
    },
    xAxis: [
        {
            type: 'category',
            /*data: [],*/
            color: '#C3CFF7',
            axisPointer: {
                type: 'shadow'
            },
            //  改变x轴字体颜色和大小
            axisLabel: {
                textStyle: {
                    color: '#CDD6F7',
                    fontSize: '16'
                },
            },
            axisTick: {
                show: false
            }
        }
    ],
    yAxis: [
        {
            type: 'value',
            name: '人',
            min: 0,
            max: 3000,
            interval: 750,
            axisLabel: {
                formatter: '{value}',
                textStyle: {
                    color: '#CDD6F7',
                    fontSize: '10'
                }
            },
            axisLine: {
                lineStyle: {
                    color: '#CDD6F7',
                }
            },
            axisTick: {
                show: false
            }
        },
        {
            type: 'value',
            name: '小时',
            min: 0,
            max: 8,
            interval: 2,
            axisLabel: {
                formatter: '{value} ',
                //  改变x轴字体颜色和大小
                textStyle: {
                    color: '#CDD6F7',
                    fontSize: '10'
                },
            },
            axisTick: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#CDD6F7',
                }
            },
        }
    ],
    series: [
        {
            name: '日均到访人数',
            type: 'bar',
            barWidth: 10,
            itemStyle: {
                normal: {
                    barBorderRadius: 5,
                    color: new echarts.graphic.LinearGradient(
                        0, 0, 0, 1,
                        [
                            {offset: 0, color: '#01ABF9'},
                            {offset: 1, color: '#01ABF9'}
                        ]
                    )
                }
            },
            /*  data:[],*/

        },
        {
            name: '人均停留时间',
            type: 'line',
            yAxisIndex: 1,
            color: '#FFE6AF',
            /*data:[]*/
        }
    ],
    dataset: {
        source: []
    }
};
//饼图 访客统计
var pie = document.getElementById("visitorStatistics");
var myChart2 = echarts.init(pie);

var option2 = {
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    legend: {
        type: 'scroll',
        textStyle: {
            color: '#CDD6F7'
        },
        orient: 'horizontal',
        x: 'center',
        y: 'top',
        data: ['女', '男', '00后', '90后', '80后', '70后', '60后','50后']
    },
    series: [
        {
            name: '数据',
            type: 'pie',
            selectedMode: 'single',
            radius: [0, '30%'],
            color: ['#F96968', '#009CF7'],
            label: {
                normal: {
                    position: 'inner'
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: []
        },
        {
            /*  name:'访问来源',*/
            type: 'pie',
            radius: ['40%', '55%'],
            label: {
                normal: {
                    rich: {
                        a: {
                            color: '#999',
                            lineHeight: 22,
                            align: 'center'
                        },
                        hr: {
                            borderColor: '#aaa',
                            width: '100%',
                            borderWidth: 0.5,
                            height: 0
                        },
                        b: {
                            fontSize: 16,
                            lineHeight: 33
                        },
                        per: {
                            color: '#eee',
                            backgroundColor: '#334455',
                            padding: [2, 4],
                            borderRadius: 2
                        }
                    }
                }
            },
            color: ['#00B2B2', '#8A57E2', '#FA9B65', '#FFCD2C', '#05FF90'],
            data: []
        }
    ]
};

//历史访客分析
var historyAnalysis = document.getElementById("historyVisitor");
var myChart3 = echarts.init(historyAnalysis);

var option3 = {
    textStyle: {
        color: '#ccc'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross',
            crossStyle: {
                color: '#999'
            }
        }
    },
    grid: {
        top: '15%',
        right: '0',
        left: '5%',
        bottom: '12%'
    },
    xAxis: {
        type: 'category',
        /*data: ['1号','2号','3号','4号','5号','6号','7号','8号',
            '9号','10号','11号','12号','13号','14号','15号','16号','17号','18号',
            '19号','20号','21号','22号','23号','24号','25号','26号','27号','28号','29号','30号'],*/
        //  改变x轴字体颜色和大小
        axisLabel: {
            textStyle: {
                color: '#CDD6F7',
                fontSize: '16'
            },
        },
        axisTick: {
            show: false
        }
    },
    legend: {
        /*data: ['日均访客', '新增访客', '历史访客'],*/
        textStyle: {
            color: '#CDD6F7'
        }
    },
    yAxis: {
        name: '人次',
        type: 'value',
        axisLabel: {
            formatter: '{value} ',
            //  改变x轴字体颜色和大小
            textStyle: {
                color: '#CDD6F7',
                fontSize: '10'
            },
        },
        axisLine: {
            lineStyle: {
                color: '#CDD6F7',
            }
        },
        axisTick: {
            show: false
        }
    },
    series: [
        {
            name: '历史访客',
            /* data: [],*/
            type: 'bar',
            color: '#01A9FF',
            barWidth: 10,
            symbolSize: 100,
            itemStyle: {
                normal: {
                    barBorderRadius: 5
                }
            }

        }, {
            name: '新增访客',
            /* data: [],*/
            type: 'line',
            color: '#f6fa11',
            smooth: true
        }, {
            name: '日均访客',
            /* data: [],*/
            type: 'line',
            color: '#D53340',
            smooth: true
        }
    ],
    dataset: {
        source: []
    }
};

//雷达图 访客画像
var visitorPortrait = document.getElementById("visitorPortrait");
var myChart4 = echarts.init(visitorPortrait);
var option4 = {
    tooltip: {},
    radar: {
        // shape: 'circle',
        radius: 60,
        name: {
            textStyle: {
                color: '#fff',
                backgroundColor: '#131440',
                borderRadius: 3,
                padding: [3, 4],
                fontSize: 15
            }
        },
        splitArea: {
            show: true,
            areaStyle: {
                color: ["#001A4C", '#0C3B7E']  // 图表背景网格的颜色
            }
        },
        indicator: []
    },
    series: [{
        name: '',
        type: 'radar',
        // areaStyle: {normal: {}},
        data: [
            {
                value: [],
                name: '访客画像'
            }
        ]
    }]
};

//访客标签
var visitorLabel = document.getElementById("visitorLabel");
var myChart5 = echarts.init(visitorLabel);
var option5 = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01],
        axisTick: {
            show: false
        },
        axisLabel: {
            textStyle: {
                color: '#CDD6F7',
                fontSize: '16'
            },
        },
        splitLine: {
            show: false
        }
    },
    yAxis: {
        type: 'category',
        /*data: ['电脑发烧友','美食达人','购物狂'],*/
        axisTick: {
            show: false
        },
        axisLabel: {
            textStyle: {
                color: '#CDD6F7',
                fontSize: '16'
            },
        }
    },
    series: [
        {
            name: 'people',
            type: 'bar',
            barWidth: 10,
            color: '#01A9FF',
            /*data: [],*/
            itemStyle: {
                normal: {
                    barBorderRadius: 5
                }
            }
        }
    ],
    dataset: {
        source: []
    }
};

function floorChart(shangquan) {
    axios.get(url_visitorFloorAnalysis, {
        params: {
            area: shangquan
        }
    }).then(function (res) {
        option.dataset.source = [
            ['type', '日均到访人数', '人均停留时间'],
            ['1楼', 115, 1.5],
            ['2楼', 284, 2],
            ['3楼', 900, 0.5],
            ['4楼', 789, 1.5],
            ['5楼', 880, 1.0],
            ['6楼', 910, 0.5]
        ];
        myChart.setOption(option, true);
    }).catch(function (err) {
        console.log(err)
    })
}

function visitorAnalysis(shangquan) {
    //option2数据
    axios.get(url_visitorStatistics, {
        params: {
            area: shangquan
        }
    }).then(function (res) {
        option2.series[0].data = [
            {value: 1507, name: '女'},
            {value: 999, name: '男'},
        ];
        //'00后', '90后', '80后', '70后', '60后'
        option2.series[1].data = [
            {value: 335, name: '00后'},
            {value: 310, name: '90后'},
            {value: 234, name: '80后'},
            {value: 135, name: '70后'},
            {value: 1048, name: '60后'},
            {value: 1088, name: '50后'}
        ];
        myChart2.setOption(option2, true);
    }).catch(function (err) {
        console.log(err)
    })
}

function historyVisitorAnalysis(shangquan) {
    //option3数据
    axios.get(url_historyVisitorAnalysis, {
        params: {
            area: shangquan
        }
    }).then(function (res) {
        option3.dataset.source = [
            ['type', '历史访客', '新增访客', '日均访客'],
            ['1号', 1250, 782, 510],
            ['2号', 1000, 900, 1100],
            ['3号', 1500, 920, 1605],
            ['4号', 900, 600, 1000],
            ['5号', 500, 425, 510],
            ['6号', 1000, 600, 923],
            ['7号', 1250, 782, 510],
            ['8号', 1000, 900, 1100],
            ['9号', 1500, 920, 1605],
            ['10号', 900, 600, 1000],
            ['11号', 500, 425, 510],
            ['12号', 1000, 600, 923],
            ['13号', 1250, 782, 510],
            ['14号', 1000, 900, 1100],
            ['15号', 1500, 920, 1605],
            ['16号', 900, 600, 1000],
            ['17号', 500, 425, 510],
            ['18号', 1000, 600, 923],
            ['19号', 1250, 782, 510],
            ['20号', 1000, 900, 1100],
            ['21号', 1500, 920, 1605],
            ['22号', 900, 600, 1000],
            ['23号', 500, 425, 510],
            ['24号', 1000, 600, 923],
            ['25号', 1250, 782, 510],
            ['26号', 1000, 900, 1100],
            ['27号', 1500, 920, 1605],
            ['28号', 900, 600, 1000],
            ['29号', 500, 425, 510],
            ['30号', 1000, 600, 923],
        ];
        myChart3.setOption(option3, true);
    }).catch(function (err) {
        console.log(err)
    })
}

function portrait(shangquan) {
    //option4数据
    axios.get(url_visitorPortrait, {
        params: {
            area: shangquan
        }
    }).then(function (res) {
        option4.radar.indicator = [
            {name: '金融', max: 5000},
            {name: '娱乐', max: 5000},
            {name: '咨询', max: 5000},
            {name: '消费倾向', max: 5000},
            {name: '消费能力', max: 5000},
        ];
        option4.series[0].data[0].value = [2100, 4500, 2320, 1580, 3005];
        myChart4.setOption(option4, true);
    }).catch(function (err) {
        console.log(err)
    })
}

function visitorTag(shangquan) {
    //option5数据
    axios.get(url_visitorLabel, {
        params: {
            area: shangquan
        }
    }).then(function (res) {
        option5.dataset.source = [
            ['type', '数据'],
            ['电脑发烧友', 8],
            ['美食达人', 7.1],
            ['购物狂', 6.5]
        ]
        myChart5.setOption(option5, true);
    }).catch(function (err) {
        console.log(err)
    })
}


