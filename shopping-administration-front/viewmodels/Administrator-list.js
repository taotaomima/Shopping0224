var app = new Vue({
    el: '#app',
    data: {
        pageInfo: '',
        pageNum: 1,
        selectedAdministrators: [],
        statuses:['禁用','启用']
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