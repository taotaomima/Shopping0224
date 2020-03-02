var app = new Vue({
    el: '#app',
    data: {
        administratorId: '',
        username: '',
        password: '',
        realName: '',
        email: '',
        avatarUrl: '',
        selectedStatus: 1,
        status: [
            { value: 0, label: '禁用' },
            { value: 1, label: '启用' }
        ]
    },
    mounted(){
        console.log('view mounted');
        var url = new URL(location.href);
        this.administratorId = url.searchParams.get('administratorId');
        if(!this.administratorId ){
            alert('administrator is null');
            return;
        }
        this.getById();
    },
    methods:{
        handleUpdateClick(){
            console.log('update click');
            this.updateAdministrator();
        },
        updateAdministrator(){
            axios.post('/admin/update', {
                administratorId: this.administratorId,
                password: this.password,
                realName: this.realName,
                email: this.email,
                avatarUrl: this.avatarUrl,
                status: this.selectedStatus
              })
              .then(function (response) {
                console.log(response);
                alert('更新成功');
              })
              .catch(function (error) {
                console.log(error);
              });
        },
        getById(){
            axios.get('/admin/getById', {
                params: {
                    administratorId: this.administratorId
                }
              })
              .then(function (response) {
                console.log(response);
                var administrator = response.data;
                app.username = administrator.username;
                app.realName = administrator.realName;
                app.email = administrator.email;
                app.avatarUrl = administrator.avatarUrl;
                app.selectedStatus = administrator.status;
              })
              .catch(function (error) {
                console.log(error);
              });
        }
    }
})