var app = new Vue({
    el: '#app',
    data: {
        username: '',
        password: ''
    },
    methods:{
        handleLoginClick(){
            console.log('login click');
            this.AdminLogin();
        },
        AdminLogin(){
            axios.get('/admin/login', {
                params: {
                    username: this.username,
                    password: this.password
                }
              })
              .then(function (response) {
                console.log(response);
                var dat= response.data;
                localStorage['jcartToken']=dat.token;
                localStorage['expireTimestamp']=dat.expireTimestamp;
                alert('登录成功');
         
              })
              .catch(function (error) {
                console.log(error);
                alert('登录失败');
              });  
        }
    }
})