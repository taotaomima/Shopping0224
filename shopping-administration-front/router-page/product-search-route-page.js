const ProductSearchRoutePage = {
    template: `
    <div id="app">

    <el-button type="primary" @click="handleCreateClick">添加商品</el-button>
        <br><br>

    <el-input v-model="productCode" placeholder="请输入商品代号"></el-input>
    <el-input v-model="productName" placeholder="请输入商品名称"></el-input>
    <el-input v-model="price" placeholder="请输入价格"></el-input>
    <el-input v-model="stockQuantity" placeholder="请输入库存"></el-input>
    <el-select v-model="selectedStatus" placeholder="请选择状态">
        <el-option v-for="item in statuses" :key="item.value" :label="item.label" :value="item.value">
        </el-option>
    </el-select>
    <el-button type="primary" @click="handleSearchClick">查询</el-button>
    <el-button type="primary" @click="handleClearClick">置空条件</el-button><br>
    <br>
    <el-table :data="pageInfo.list" stripe style="width: 100%">
        <el-table-column label="主图" width="180">
            <template slot-scope="scope">
                <el-image style="width: 50px; height: 50px" :src="scope.row.mainPicUrl" fit="fill"></el-image>
                
            </template>
        </el-table-column>
        <el-table-column prop="productCode" label="商品代码" width="180"></el-table-column>
        <el-table-column prop="productName" label="商品名称" width="180"></el-table-column>
        <el-table-column label="价格" width="180">
            <template slot-scope="scope">
                <s>{{scope.row.price}}</s><br>
                {{(scope.row.price * scope.row.discount).toFixed(2)}}
            </template>
        </el-table-column>
      <!--   <el-table-column prop="discount" label="打折" width="180"></el-table-column> -->
        <el-table-column prop="stockQuantity" label="库存" width="180"></el-table-column>
        
        <el-table-column label="状态" width="180">
            <template slot-scope="scope">
                {{statuses[scope.row.status].label}}
            </template>
        </el-table-column>

        <el-table-column label="操作" width="180">
        <template slot-scope="scope">
          <router-link :to="'/product/update/'+scope.row.productId">编辑</router-link>
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        </template>
    </el-table-column>
    </el-table>

    <el-pagination small layout="prev, pager, next" :total="pageInfo.total" @current-change="handlePageChange">
    </el-pagination>
</div>
`,
    data() {
        return {
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
          }
        },
          mounted() {
            console.log('view mounted');
            this.searchProduct();
          },
          methods: {
            handleCreateClick(){
              this.$router.push('/product/create');
          },
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
              console.log("edit click");
              this.$router.push('/product/update/'+row.productId);
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
                .then((response)=> {
                  console.log(response);
                  this.pageInfo = response.data;
                })
                .catch(function (error) {
                  console.log(error);
                });
        
            }
          }
}