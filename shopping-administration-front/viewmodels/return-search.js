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
        handlePageChange(val){
            console.log('change page',val);
            this.pageNum=val;
            this.getReturnSearch();
        },
        getReturnSearch(){
            axios.get('/return/search', {
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