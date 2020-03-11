var app = new Vue({
    el: '#app',
    data: {
        username: '',
        realName: '',
        mobile: '',
        email: '',
        mobileVerified: '',
        emailVerified: ''
    },
    mounted(){
        console.log('view mmounted');
        this.getCustomer();

    },
    methods:{
        handleUpdateClick(){
            console.log('update click');
            this.updateProfile();
        },
        getCustomer(){
            axios.get('/customer/getProdile')
                .then(function (response) {
                    console.log(response);
                    var me = response.data;
                    app.username = me.username;
                    app.realName = me.realName;
                    app.mobile = me.mobile;
                    app.mobileVerified = me.mobileVerified;
                    app.email = me.email;
                    app.emailVerified = me.emailVerified;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        updateProfile(){
            axios.post('/customer/updateProfile', {
                realName: this.realName,
                mobile: this.mobile,
                email: this.email
            })
                .then(function (response) {
                    console.log(response);
                    alert('更新成功');
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }

})