var app = new Vue({
    el: '#app',
    data: {
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
    },
    mounted() {
        console.log('view mounted');

        tinymce.init({
            selector: '#mytextarea'
        });

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
            formData.append("image", this.selectedMainPic);

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
})