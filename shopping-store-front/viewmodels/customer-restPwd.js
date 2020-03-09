var app = new Vue({
    el: '#app',
    data: {
        email:'',
        resetCode:'',
        newPwd:'',
        reNewPwd:''
    },
    methods:{
        handleRestClick(){
            console.log('restPwd click');
            if(newPwd!=reNewPwd){
                alert('密码不一致');
                return;
            }
            this.getRestPwd();
        },
        getRestPwd(){
            axios.post('/customer/resetPwd', {
                email:this.email,
                resetCode:this.resetCode,
                newPwd:this.newPwd
              })
              .then(function (response) {
                console.log(response);
                alert("重置密码成功");
              })
              .catch(function (error) {
                console.log(error);
              });
        }
    }
})