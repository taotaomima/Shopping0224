var app = new Vue({
    el: '#app',
    data: {
    
        subMenus: [
            {
                name:'商品管理',
                index: '1',
                icon: 'el-icon-goods',
                menuItems:[
                    {name: '商品列表', index: '1-1',route: '/product/search'}
                ]
            },
            {
                index: '2',
                icon: 'el-icon-customer',
                menuItems:[
                    {name: '客户列表', index: '2-1'}
                ]
            },
            {
                name:'订单管理',
                index: '3',
                icon: 'el-icon-order',
                menuItems:[
                    {name: '订单列表', index: '3-1'},
                    {name: '退货列表', index: '3-2'}
                ]
            },
            
            {
                name:'用户管理',
                index: '4',
                icon: 'el-icon-user',
                menuItems:[
                    {name: '用户列表', index: '4-1'}
                ]
            }
            
        ]
    },
    methods:{
        
    }
})