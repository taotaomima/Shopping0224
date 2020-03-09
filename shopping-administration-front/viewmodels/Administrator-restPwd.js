var app = new Vue({
    el: '#app',
    data: {
        email:'',
        resetCode:'',
        newPwd:'',
        reNewPwd:''
    },
    methods:{
        handleRestPwdClick(){
            console.log('resetPwd click');
            if(newPwd != reNewPwd){
                alert("密码不一致");
                return;
            }
            this.createResetPwd();
        },
        createResetPwd(){
            axios.post('/admin/resetPwd', {
                email:this.email,
                resetCode:this.resetCode,
                newPwd:this.newPwd
              })
              .then(function (response) {
                console.log(response);
                alert('重置密码成功');
              })
              .catch(function (error) {
                console.log(error);
              });
        }
    }
})