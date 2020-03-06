var app = new Vue({
    el: '#app',
    data: {
        orderId: '',
        orderTime: '',
        customerName: '',
        mobile: '',
        email: '',
        productId: '',
        productCode: '',
        productName: '',
        quantity: '',
        reason: '',
        comment: '',
        opened: '',
    },
    mounted(){
        console.log("view mmounted");
        var url = new URL(location.href);
        this.orderId = url.searchParams.get("orderId");
        if(!this.orderId){
            alert("order is null");
            return;
        }

        this.productId = url.searchParams.get("productId");
        if(!this.productId){
            alert("productId is null");
            return;
        }

        this.getOrderById();
    },
    methods:{
        getOrderById(){
            axios.get('/order/getById', {
                params: {
                    orderId: this.orderId
                }
            })
                .then(function (response) {
                    console.log(response);
                    var order = response.data;
                    app.orderTime = new Date(order.createTimestamp);
                    var orderProducts = order.orderProducts;
                    var returnProduct = orderProducts.find(p => p.productId == app.productId);
                    app.productCode = returnProduct.productCode;
                    app.productName = returnProduct.productName;
                    app.quantity = returnProduct.quantity;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})