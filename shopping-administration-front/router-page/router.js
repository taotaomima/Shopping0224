const router = new VueRouter({
    routes:routes
});


const routes = [

    {path:'/administrator/search',component: AdministratorSearchRoutePage},
    {path:'/administrator/create',component: AdministratorCreateRoutePage},
    {path:'/administrator/update/:administratorId',component: AdministratorUpdateRoutePage},
    {path: '/administrator/updateprofile', component: AdministratorUpdateProfileRoutePage },

    {path:'/customer/search',component: CustomerSearchRoutePage},
    {path:'/customer/show/:customerId',component: CustomerShowRoutePage},

    {path:'/product/search',component: ProductSearchRoutePage},
    {path:'/product/create', component: ProductCreateRoutePage },
    {path:'/product/update:productId', component: ProductUpdateRoutePage },

    {path:'/order/search',component: OrderSearchRoutePage},
    {path:'/order/show/:orderId',component: OrderShowRoutePage},

    {path:'/return/search',component: ReturnSearchRoutePage},
    {
        path: '/return/edit/:returnId',
        component: ReturnEditRoutePage,
        children:[
            {
                path: 'show',
                component: ReturnShowRoutePage
            },
            {
                path: 'history',
                component: ReturnHistoryIndexRoutePage
            }
        ]
    }






]