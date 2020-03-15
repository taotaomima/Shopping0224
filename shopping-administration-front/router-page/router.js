const router = new VueRouter({
    routes:routes
});


const routes = [
    {path:'/product/search',component: ProductSearchRoutePage},

    {path:'/administrator/search',component: AdministratorSearchRoutePage},
    {path:'/administrator/create',component: AdministratorCreateRoutePage},
    {path:'/administrator/update',component: AdministratorUpdateRoutePage},
    { path: '/administrator/updateprofile', component: AdministratorUpdateProfileRoutePage },


    {path:'/order/search',component: OrderSearchRoutePage},
    {path:'/return/search',component: ReturnSearchRoutePage},
    {path:'/customer/search',component: CustomerSearchRoutePage},
    {path:'/customer/show',component: CustomerShowRoutePage},



    {path:'/product/update',component: ProductUpdateRoutePage}

]