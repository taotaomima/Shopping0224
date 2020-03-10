var app = new Vue({
    el: '#app',
    data: {
        username: '',
        password: '',
        realName: '',
        email: '',
        avatarUrl: '',
        selectedAvatarUrl: '',
        mainFileList: [],
        selectedStatus: 1,
        statuses: [
            { value: 0, label: '禁用' },
            { value: 1, label: '启用' }
        ]
    },
    methods:{
        handleCreateClick(){
            console.log('create click');
            this.createAdministrator();
        },
        handleOnMainChange(val){
            this.selectedAvatarUrl = val.raw;
        },
        handleUploadPicClick(){
            console.log('upload pic click');
            this.uploadImage();
        },
        uploadImage(){
            var formData = new FormData();
            formData.append("image", this.selectedAvatarUrl);

            axios.post('/image/upload', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.avatarUrl = response.data;
                    alert('上传成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('上传失败');
                });
        },
        createAdministrator(){
            axios.post('/admin/create', {
                username: this.username,
                password: this.password,
                realName: this.realName,
                email: this.email,
                avatarUrl: this.avatarUrl,
                status: this.selectedStatus
              })
              .then(function (response) {
                console.log(response);
                alert('创建成功');
              })
              .catch(function (error) {
                console.log(error);
              });
        }
    }
})