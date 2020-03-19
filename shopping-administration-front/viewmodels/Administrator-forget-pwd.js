var app = new Vue({
    el: '#app',
    data: {
        email:'',
        loading:false,
        EnableDisable: true,
        counter:60
    },
    methods:{
        handleFindPwd(){
            console.log('find back pwd click');
            this.loading = true;
            this.EnableDisable = false;
            this.counter = 60;
             
            setInterval(function(){
              console.log("count down");
              app.counter--;
              if(app.counter<0){
                 app.EnableDisable = true;
              }
            },1000);

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
                app.loading = false;
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