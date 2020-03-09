var app = new Vue({
    el: '#app',
    data: {
        email:''
    },
    methods:{
        handleFindPwd(){
            console.log('find back pwd click');
            this.getPwdRestCode();
        },
        getPwdRestCode(){
            axios.get('/admin/getPwdRestCode', {
                params: {
                  email: this.email
                }
              })
              .then(function (response) {
                console.log(response);
                alert('重置码发送邮箱成功');
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