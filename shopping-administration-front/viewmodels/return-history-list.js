var app = new Vue({
    el: '#app',
    data: {
        returnId:'',
        returnHistories:[],
        returnStatuses:[
            { value: 1, label: '待取货' },
            { value: 2, label: '正在处理' },
            { value: 3, label: '完成' },
            { value: 4, label: '拒绝' }
        ],
        selectedReturnStatus:'',
        customerNotified:false,
        comment:''
    },
    mounted(){

        var url = new URL(location.href);
        this.returnId=url.searchParams.get("returnId");
        if(!this.returnId){
            alert('returnId is null');
            return;
        }
        this.getReturnHistory();
    },
    methods:{
        handleCreateClick(){
            console.log('add returnHistory click');
            this.addReturnHistory();
        },
        addReturnHistory(){
            axios.post('/returnHistory/create', {
                returnId: this.returnId,
                customerNotified: this.customerNotified,
                comment: this.comment,
                returnStatus: this.selectedReturnStatus

              })
              .then(function (response) {
                console.log(response);
                alert("添加退货历史成功");
                app.selectedReturnStatus='';
                app.customerNotified=false;
                app.comment='';
                app.getReturnHistory();
              })
              .catch(function (error) {
                console.log(error);
              });
        },
        getReturnHistory(){
            axios.get('/returnHistory/search', {
                params: {
                  returnId:this.returnId
                }
              })
              .then(function (response) {
                console.log(response);
                 app.returnHistories = response.data;
              })
              .catch(function (error) {
                console.log(error);
              });  
        }

    }
})