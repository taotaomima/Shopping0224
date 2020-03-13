Vue.component('jc-return-search-page',{
    template:`
    <div id="app">
        <el-input v-model="returnId" placeholder="请输入退货id"></el-input>
        <el-input v-model="orderId" placeholder="请输入订单id"></el-input>
        <el-input v-model="customerName" placeholder="请输入客户姓名"></el-input>
        <el-input v-model="productCode" placeholder="请输入商品代号"></el-input>
        <el-input v-model="productName" placeholder="请输入商品名称"></el-input>
        <el-select v-model="selectedStatus" placeholder="请选择状态">
            <el-option v-for="item in statuses" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
        </el-select>

        <el-date-picker v-model="startTime" type="date" placeholder="选择开始日期">
        </el-date-picker>
        <el-date-picker v-model="endTime" type="date" placeholder="选择结束日期">
        </el-date-picker>
        <br>
        <el-button type="primary" @click="handleFindClick">查询</el-button>
        <el-button type="primary" @click="handleClearClick">置空条件</el-button>
        <br>
        <el-table :data="pageInfo.list" style="width: 100%">
            <el-table-column prop="returnId" label="退货Id"" width=" 180">
            </el-table-column>
            <el-table-column prop="orderId" label="订单ID" width="180">
            </el-table-column>
            <el-table-column prop="productCode" label="商品代码">
            </el-table-column>
            <el-table-column prop="productName" label="商品名称">
            </el-table-column>
            <el-table-column prop="status" label="状态">
                <template slot-scope="scope">
                    {{statuses[scope.row.status].label}}
                </template>
            </el-table-column>
            <el-table-column prop="createTimestamp" label="申请日期">
                <template slot-scope="scope">
                    {{(new Date(scope.row.createTimestamp)).toLocaleString()}}
                </template>
            </el-table-column>
            <el-table-column prop="updateTimestamp" label="修改日期">
                <template slot-scope="scope">
                    {{(new Date(scope.row.updateTimestamp)).toLocaleString()}}
                </template>
            </el-table-column>
        </el-table>

        <el-pagination layout="prev, pager, next" :total="pageInfo.total" @current-change="handlePageChange">
        </el-pagination>
    </div>
    
    `,
    data(){
        return {
            returnId:'',
            orderId:'',
            customerName:'',
            productCode:'',
            productName:'',
            selectedStatus:'',
            statuses:[
                { value: 0, label: '待处理' },
                { value: 1, label: '待取货' },
                { value: 2, label: '正在处理' },
                { value: 3, label: '完成' },
                { value: 4, label: '拒绝' }
            ],
            startTime:'',
            endTime:'',
            pageInfo:'',
            pageNum:1
        }
    },
        mounted(){
            console.log('view mounted');
            this.getReturnSearch();
        },
        methods:{
            handleFindClick(){
                console.log('search click');
                this.pageNum=1;
                this.getReturnSearch();
            },
            handleClearClick(){
                console.log('clear click');
                this.returnId = '';
                this.orderId = '';
                this.customerName='';
                this.productCode='';
                this.productName='';
                this.selectedStatus='';
                this.startTime='';
                this.endTime='';
            },
            handlePageChange(val){
                console.log('change page',val);
                this.pageNum=val;
                this.getReturnSearch();
            },
            getReturnSearch(){
                axios.get('/return/search', {
                    params: {
                        pageNum: this.pageNum,
                        returnId:this.returnId,
                        orderId:this.orderId,
                        customerName:this.customerName,
                        productCode:this,productCode,
                        productName:this.productName,
                        status:this.selectedStatus,
                        startTime:this.startTime,
                        endTime:this.endTime
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
});