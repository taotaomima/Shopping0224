var app = new Vue({
  el: '#app',
  data: {
    pageInfo: '',
    pageNum: 1,
    productCode: '',
    productName: '',
    price: '',
    stockQuantity: '',
    selectedStatus: '',
    statuses: [
      { value: 0,label: '上架'},
      { value: 1,label: '下架'},
      { value: 2,label: '待审核'}
    ]
  },
  mounted() {
    console.log('view mounted');
    this.searchProduct();
  },
  methods: {
    handleSearchClick(){
      console.log('search click');
      this.pageNum = 1;
      this.searchProduct();
    },
    handleClearClick(){
      console.log('clear click');
      this.productCode='',
      this.productName='',
      this.price='',
      this.stockQuantity='',
      this.selectedStatus=''
    },
    handleEdit(index,row){
        console.log('edit click',index,row);
        location.href = 'product-update.html?productId='+row.productId;
    },

    handlePageChange(val) {
      console.log('page change', val);
      this.pageNum = val;
      this.searchProduct();
    },
    searchProduct() {
      axios.get('/product/search', {
        params: {
          pageNum: this.pageNum,
          productCode: this.productCode,
          productName: this.productName,
          price: this.price,
          stockQuantity: this.stockQuantity,
          status: this.selectedStatus
        }
      })
        .then(function (response) {
          console.log(response);
          app.pageInfo = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });

    }
  }
})