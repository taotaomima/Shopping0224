Vue.component('jc-product-update-page',{
    template:`
    <div id="app">
    <el-input v-model="input" placeholder="请输入商品代码"></el-input>
    <el-input v-model="input" placeholder="请输入商品名称"></el-input>
    <el-input v-model="input" placeholder="请输入价格"></el-input>
    <el-input v-model="input" placeholder="请输入打折"></el-input>
    <el-input v-model="input" placeholder="请输入库存量"></el-input>
    <el-input v-model="input" placeholder="请输入积分"></el-input>
    <el-input v-model="input" placeholder="请输入排序"></el-input>
    <el-input v-model="productAbstract" type="textarea" placeholder="请输入摘要"></el-input>
    <textarea id="mytextarea">{{description}}</textarea>
    <el-select v-model="selectedStatus" placeholder="请选择状态">
        <el-option v-for="item in status" :key="item.value" :label="item.label" :value="item.value">
        </el-option>
    </el-select>

    <el-upload ref="uploadMain" action="" :http-request="uploadMainImage" :limit="1" accept="image/*"
        :auto-upload="false" :on-change="handleOnMainChange" :file-list="mainFileList">
        <el-button slot="trigger" size="small" type="primary">选取主图</el-button>
        <el-button size="small" type="success" @click="handleUploadMainClick">上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
    </el-upload>
    上传后主图：<el-link type="primary">{{mainPicUrl}}</el-link><br>
    <el-image style="width: 100px; height: 100px" :src="mainPicUrl" :fit="fit"></el-image>
    <br>
    <br>

    <el-upload ref="uploadOther" multipe action="" :http-request="uploadOtherImage" :limit="9" accept="image/*"
        :auto-upload="false" :on-change="handleOnOtherChange" :on-remove="handleOnOtherRemove"
        :file-list="otherFileList">
        <el-button slot="trigger" size="small" type="primary">选取其他图片</el-button>
        <el-button size="small" type="success" @click="handleUploadOtherClick">上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
    </el-upload>

    <br>
    <div  v-for="item in otherPicUrls">
        上传后其他图片：
        <el-link type="primary">{{item}}</el-link><br>
        <el-image style="width: 50px; height: 50px" :src="item" :fit="fit"></el-image>
        <br>
    </div>
    <br>
    <el-button type="primary" @click="handleUpdateClick">更新</el-button>
</div>
    
    `,
    data(){
        return {
            productId: '',
            productCode: '',
            productName: '',
            price: '',
            discount: '',
            stockQuantity: '',
            rewordPoints: '',
            sortOrder: '',
            productAbstract: '',
            description: '',
            selectedStatus: 0,
            status: [
                { value: 0,label: '上架'},
                { value: 1,label: '下架'},
                { value: 2,label: '待审核'}
            ],
            mainPicUrl: '',
            selectedMainPic: '',
            otherPicUrls: [],
            selectedOtherPics: [],
            mainFileList: [],
            otherFileList: []
        }
    },
        mounted() {
            console.log('view mounted');
    
            /* tinymce.init({
                selector: '#mytextarea'
            }); */
            var url = new URL(location.href);
            this.productId = url.searchParams.get("productId");
            if (!this.productId) {
                alert('productId is null');
                return;
            }
    
            this.getProductById();
        },
        methods:{
            handleUpdateClick(){
                console.log('update click');
                this.description = tinyMCE.activeEditor.getContent();
                this.updateProduct();
            },
            handleOnMainChange(val){
                thid.selectedMainPic = val.raw;
            },
            handleUploadMainClick(){
                console.log('upload main pic click');
                this.uploadMainImage();
            },
            uploadMainImage() {
                var formData = new FormData();
                formData.append("image", this.selectedMainPic);
    
                axios.post('/image/upload', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                    .then(function (response) {
                        console.log(response);
                        app.mainPicUrl = response.data;
                        alert('上传成功');
                    })
                    .catch(function (error) {
                        console.log(error);
                        alert('上传失败');
                    });
            },
            handleOnOtherChange(file,fileList){
                console.log('fileList',fileList);
                this.selectedOtherPics= fileList;
            },
            handleOnOtherRemove(file,fileList){
                console.log('fileList',fileList);
                this.selectedOtherPics= fileList;
            },
            handleUploadOtherClick(file,fileList){
                console.log('upload other pic click');
                this.uploadOtherPics();
            },
            uploadOtherPics(){
                this.selectedOtherPics.forEach(pic => {
                    var formData = new FormData();
                formData.append("image", pic.raw);
    
                axios.post('/image/upload', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                    .then(function (response) {
                        console.log(response);
                        var url = response.data;
                        app.otherPicUrls.push(url);
                        alert('上传成功');
                    })
                    .catch(function (error) {
                        console.log(error);
                        alert('上传失败');
                    });
                });
            },
            updateProduct(){
                axios.post('/product/update', {
                    productId: this.productId,
                    productCode: this.productCode,
                    productName: this.productName,
                    price: this.price,
                    discount: this.discount,
                    stockQuantity: this.stockQuantity,
                    status: this.selectedStatus,
                    mainPicUrl: this.mainPicUrl,
                    rewordPoints: this.rewordPoints,
                    sortOrder: this.sortOrder,
                    productAbstract: this.productAbstract,
                    description: this.description,
                    otherPicUrls: this.otherPicUrls
                  })
                  .then(function (response) {
                    console.log(response);
                    alert('更新成功');
                  })
                  .catch(function (error) {
                    console.log(error);
                    alert('更新失败');
                  });
            },
            getProductById(){
                axios.get('/product/findbyId', {
                    params: {
                      productId: this.productId
                    }
                  })
                  .then(function (response) {
                    console.log(response);
                    var product = response.data;
                    app.productId = product.productId;
                    app.productCode = product.productCode;
                    app.productName = product.productName;
                    app.price = product.price;
                    app.discount = product.discount;
                    app.stockQuantity = product.stockQuantity;
                    app.status = product.status;
                    app.rewordPoints = product.rewordPoints;
                    app.sortOrder = product.sortOrder;
                    app.productAbstract = product.productAbstract;
                    app.description = product.description;
                    app.mainPicUrl = product.mainPicUrl;
                    app.otherPicUrls = product.otherPicUrls;
                  })
                  .catch(function (error) {
                    console.log(error);
                  })
                  .then(function () {
                    // always executed
                  });  
            }
        }
    
    
});