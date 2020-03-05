var app = new Vue({
    el: '#app',
    data: {
        myShoppingCart:[]
    },
    mounted(){
        console.log("view mounted");
        //sessionStorage
        var myShoppingCartJson= localStorage['myShoppingCartJson'];
        this.myShoppingCart = myShoppingCartJson ? JSON.parse(myShoppingCartJson) : []; 
    } ,
    methods:{
        handleUpdateClick(index,row){
            console.log('update click');
            localStorage['myShoppingCartJson']=JSON.stringify(this.myShoppingCart);
            this.$message.success('修改购物车成功');
        },
        handleDeleteClick(index,row){
            console.log('delete click');
            this.mmyShoppingCart.splice(index,1);
            localStorage['myShoppingCartJson']=JSON.stringify(this.myShoppingCart);
            this.$message.success('删除购物车成功');
        }
    }
})