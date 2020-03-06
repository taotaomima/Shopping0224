var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1
    },
    mounted(){
        console.log('view mounted');
        this.getReturnSearch();
    },
    methods:{
        handlePageChange(){

        },
        getReturnSearch(){
            axios.get('/return/getList', {
                params: {
                    pageNum: this.pageNum
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                }); 
        }
    }
})