var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1
    },
    mounted(){
        console.log('vew mounted');
        this.getOrderList();
    },
    methods:{
        handleChangePage(val){
            console.log('change page');
            this.pageNum=val;
            this.getOrderList();
        },
        getOrderList(){
            axios.get('/order/getList', {
                params: {
                  pageNum:this.pageNum
                }
              })
              .then(function (response) {
                console.log(response);
                app.pageInfo = response.data;
              })
              .catch(function (error) {
                console.log(error);
              })
              .then(function () {
                // always executed
              });  
        }
    }
})