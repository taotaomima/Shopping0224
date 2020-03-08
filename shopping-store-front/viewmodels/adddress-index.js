var app = new Vue({
    el: '#app',
    data: {
        addresses:[]
    },
    mounted(){
        console.log("view mounted");
        this.getAddressList();
    },
    methods:{
        getAddressList(){
            axios.get('/address/getAddressByCustomerId')
                .then(function (response) {
                    console.log(response);
                    app.addresses = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})