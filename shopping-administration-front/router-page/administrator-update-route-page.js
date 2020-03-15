const AdministratorUpdateRoutePage = {
    template: `
    <div id="app">
        <el-page-header @back="handleGoBack" content="更新管理员">
        </el-page-header>
        <el-input v-model="username" placeholder="请输入用户名"></el-input>
        <el-input v-model="password" placeholder="请输入密码"></el-input>
        <el-input v-model="realName" placeholder="请输入姓名"></el-input>
        <el-input v-model="email" placeholder="请输入邮箱"></el-input>
        
        <el-upload ref="uploadPic" action="" :http-request="uploadImage" :limit="1" accept="image/*"
        :auto-upload="false" :on-change="handleOnMainChange" :file-list="mainFileList">
        <el-button slot="trigger" size="small" type="primary">选取头像</el-button>
        <el-button size="small" type="success" @click="handleUploadPicClick">上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
    </el-upload>
上传的头像：<el-link type="primary">{{avatarUrl}}</el-link><br>
<el-image style="width: 100px; height: 100px" :src="avatarUrl" :fit="fit"></el-image>
<br>
        <el-select v-model="selectedStatus" placeholder="请选择状态">
            <el-option v-for="item in status" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
        </el-select>
        <br>

        <el-button type="primary" @click="handleUpdateClick">更新</el-button>
</div>
    `,

    data(){
        return {
            administratorId: '',
        username: '',
        password: '',
        realName: '',
        email: '',
        avatarUrl: '',
        selectedAvatarUrl: '',
        mainFileList: [],
        selectedStatus: 1,
        status: [
            { value: 0, label: '禁用' },
            { value: 1, label: '启用' }
        ]
        }
    },
    mounted(){
        console.log('view mounted');
       /*  var url = new URL(location.href);
        this.administratorId = url.searchParams.get('administratorId'); */

        this.administratorId = this.$route.params.administratorId;
        if(!this.administratorId ){
            alert('administrator is null');
            return;
        }
        this.getById();
    },
    methods:{
        handleGoBack(){
            console.log('go back click');
            this.$router.back();
        },
        handleUpdateClick(){
            console.log('update click');
            this.updateAdministrator();
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
                .then((response) =>{
                    console.log(response);
                    tjis.avatarUrl = response.data;
                    alert('上传成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('上传失败');
                });
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
              .then((response)=> {
                console.log(response);
                var administrator = response.data;
                this.username = administrator.username;
                this.realName = administrator.realName;
                this.email = administrator.email;
                this.avatarUrl = administrator.avatarUrl;
                this.selectedStatus = administrator.status;
              })
              .catch(function (error) {
                console.log(error);
              });
        }
    }
}