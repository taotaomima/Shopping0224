var app = new Vue({
    el: '#app',
    data: {
        email:''
    },
    methods:{
        handleFindClick(){
            console.log('find pwd click');
            this.getResetPwd();
        },
        getResetPwd(){
            axios.get('/customer/getPwdRestCode', {
                params: {
                  email:this.email
                }
              })
              .then(function (response) {
                console.log(response);
                alert('重置码已发送至邮箱');
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