const vmm = new Vue({
    el: '#ranking',
    data: {
        residence: [],
        officeSpace: []
    }
})
$(function () {
    //居住地和办公地点排名
    visitorRanking(shangquan);
})
function visitorRanking(shangquan) {
    //居住地排名
    axios.get(url_visitorResource, {
        params: {
            area: shangquan
        }
    }).then(function (res) {
        vmm.residence = res.data;
        vmm.officeSpace = res.data;
    }).catch(function (err) {
        console.log(err)
    })
    /*//办公地排名
    axios.get(url_visitorResource,{
        params:{
            area:shangquan
        }
    }).then(function (res) {
    }).catch(function (err) {
        console.log(err)
    })*/
}