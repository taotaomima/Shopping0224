const AdministratorSearchRoutePage = {
    template: `
    <div id="app">
    <el-button type="primary" @click="handleCreateClick">添加</el-button>
    <el-button type="danger" @click="handleDetchDeleteClick">批量删除</el-button>
    <el-table ref="multipleTable" :data="pageInfo.list" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"></el-table-column>
    <el-table-column prop="administratorId" label="ID" width="120"> </el-table-column>
    <el-table-column prop="username" label="用户名"" width="120"></el-table-column>
    <el-table-column prop="realName" label="姓名" width="120"></el-table-column>
    <el-table-column prop="status" label="状态" width="120">
        <template slot-scope="scope">
            {{statuses[scope.row.status]}}
         </template>
    </el-table-column>
    <el-table-column label="创建时间" width="120">
        <template slot-scope="scope">
           {{(new Date(scope.row.createTimestamp)).toLocaleString()}}
        </template>
    </el-table-column>

    <el-table-column label="操作">
        <template slot-scope="scope">
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
    </el-table-column>
  </el-table>
  <!-- 分页 -->
  <el-pagination layout="prev, pager, next" :total="pageInfo.total" @current-change="handlePageChange">
</el-pagination>

</div>
    
    `,
    data(){
        return {
            pageInfo: '',
            pageNum: 1,
            selectedAdministrators: [],
            statuses:['禁用','启用']
        }
    },
        computed: {
            selectedAdministratorIds() {
                return this.selectedAdministrators.map(a => a.adminstratorId);
            }
        },
        mounted() {
            console.log('view mounted');
            this.getAdministrators();
        },
        methods:{
            handlePageChange(val) {
                console.log('page change', val);
                this.pageNum = val;
                this.getAdministrators();
            },
            handleCreateClick(){
                console.log("create click");
                this.$router.push('admin/create');
            },
            handleDelete(index,row){
                console.log('delete click');
                if(confirm("确认删除吗？")){
                    this.deleteAdministrator(row.administratorId);
                }
            },
            handleDetchDeleteClick() {
                console.log('batch delete click');
                if (confirm("确认删除？")) {
                    this.batchDeleteAdministrators();
                }
            },
            handleSelectionChange(val) {
                console.log('selection change', val);
                this.selectedAdministrators = val;
            },
            deleteAdministrator(administratorId) {
                axios.post('/admin/delete', administratorId, {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                    .then(function (response) {
                        console.log(response);
                        alert('删除成功');
                        location.reload();
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            batchDeleteAdministrators() {
                axios.post('/admin/betchDelete', this.selectedAdministratorIds)
                    .then(function (response) {
                        console.log(response);
                        alert('批删成功');
                        location.reload();
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            getAdministrators(){
                axios.get('/admin/getList', {
                    params: {
                        pageNum: this.pageNum
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