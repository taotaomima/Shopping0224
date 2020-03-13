const router = new VueRouter({
    routes:routes
});


const routes = [
    {path:'/product/search',component: ProductSearchRoutePage},
    {path:'/administrator/search',component: AdministratorSearchRoutePage},
    {path:'/order/search',component: OrderSearchRoutePage},
    {path:'/return/search',component: ReturnSearchRoutePage},
    {path:'/customer/search',component: CustomerSearchRoutePage},
    {path:'/product/update',component: ProductUpdateRoutePage}

]