## 1.1 商品列表

URL: /product/search   
Method：GET  

ResponseBody:  
```json
[
    {
        "productId":1234,
        "productName": "华为",
        "productCode": 234,
        "price": 2399,
        "stockQuantity": 8,
        "rewordPoints": 15
    },
    {
        "productId":1235,
        "productName": "vivo",
        "productCode": 235,
        "price": 2099,
        "stockQuantity": 10,
        "rewordPoints": 10
    }
]

```


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId   | Integer | 商品Id |
| productName | String  | 商品名称 |
| productCode | Integer | 商品代码 |
| price | double | 商品价格    |
| stockQuantity | Integer | 库存数量  |
| rewordPoints | Integer | 可得积分  |


## 1.2 商品添加

URL: /product/create  
Request Content-Type：  application/json(默认)    
Method: POST

RequestBody:
```json 
{
     "productId":1235,
     "productName": "vivo",
     "productCode": 235,
     "price": 2099,
     "stockQuantity": 10,
     "rewordPoints": 10

}

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId   | Integer | 商品Id |
| productName | String  | 商品名称 |
| productCode | Integer | 商品代码 |
| price | double | 商品价格    |
| stockQuantity | Integer | 库存数量  |
| rewordPoints | Integer | 可得积分  |




## 1.3 图片上传

URL: /productphoto/upload    
Method：POST    
Request Content-Type: multipart/formdata  
RequestParam: productId  
RequestParam: mainPicUrl  

ResponseBody:  
```json
[
    "http://xxx.com/xxx1.jpg"
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId | Integer | 产品id |
| mainPicUrl   | String   | 上传文件key    |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
|    | String   | 上传图片后Urls    |


## 1.4 商品回显
URL: /product/search?productId={productId}   
Method：GET  

ResponseBody:  
```json

{
    "productId":1234,
    "productName": "华为",
    "productCode": 234,
    "price": 2399,
    "stockQuantity": 8,
    "rewordPoints": 15
}

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId   | Integer   | 产品id    |


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId   | Integer | 商品Id |
| productName | String  | 商品名称 |
| productCode | Integer | 商品代码 |
| price | double | 商品价格    |
| stockQuantity | Integer | 库存数量  |
| rewordPoints | Integer | 可得积分  |


## 1.5商品修改
URL: /product/update  
Request Content-Type: application/json(默认)    
Method：POST  

RequestBody:
```json 
{
     "productId":1235,
     "productName": "vivo",
     "productCode": 235,
     "price": 2099,
     "stockQuantity": 10,
     "rewordPoints": 10

}

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId   | Integer | 商品Id |
| productName | String  | 商品名称 |
| productCode | Integer | 商品代码 |
| price | double | 商品价格    |
| stockQuantity | Integer | 库存数量  |
| rewordPoints | Integer | 可得积分  |


## 2.1 用户注册

URL: /customer/create  
Request Content-Type: application/json(默认)    
Method：POST  

RequestBody:  
```json
{
    "username": "弓长三尺",
    "mobile": "18976789654",
    "email": "157544839@qq.com",
    "realName":"张三",
    "encryptedPassword": "2233qa"
}

```


Request Field

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| username | String | 昵称 |
| mobile | String | 手机 |
| email | String | 邮箱 |
| realName | String | 真实姓名 |
| encryptedPassword | String | 密码 |



## 2.2 用户登录

URL: /customer/login?username={username}&encryptedPassword={encryptedPassword}   
Method：GET  

ResponseBody:  
```json
[
    {
        "username": "弓长三尺",
        "mobile": "18976789654",
        "email": "157544839@qq.com",
        "realName":"张三",
        "encryptedPassword": "2233qa"
    },
    
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| useranme   | String   | 用户名 |
| encryptedPassword   | Boolean   | 密码   |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| username | String | 昵称 |
| mobile | String | 手机 |
| email | String | 邮箱 |
| realName | String | 真实姓名 |
| encryptedPassword | String | 密码 |


## 3.1 添加地址

URL: /address/create    
Request Content-Type: application/json(默认)    
Method：POST

RequestBody:  
```json
{
    "customerId": 2,
    "receiverName": "王云",
    "receiverMobile": "15754483903",
    "content":"上海徐家汇"
}

```


Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerId   | Integer   | 客户Id    |
| receiverName   | String   | 收货人姓名    |
| receiverMobile   | String   | 收货人手机号    |
| content | String | 收货地址 |




## 4.1 订单创建

URL: /order/create  
Request Content-Type: application/json(默认)    
Method：POST  

RequestBody:  
```json
{
    "customerId": 1,
    "shipAddress": "上海奉贤区",
    "createTime":"2019-12-12T00:00:00.000+0000",
    "productName":"现代风电脑桌",
    "unitPrice":567.9,
    "quantity": 1,
    "totalPrice": 567.9,
    "payMethod": 1,
    "shipPrice": 10

}

```


Request Field

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerId | Integer | 客户id |
| shipAddress | String | 邮寄地址 |
| createTime | String | 创建时间 |
| productName | String | 商品名称 |
| unitPrice | Double | 单价 |
| quantity | Integer | 数量 |
| totalPrice | Double | 总金额 |
| payMethod | Integer | 支付方式 |
| shipPrice | Double | 邮费 |




## 5.1 退换货
URL: /return/create  
Request Content-Type: application/json(默认)    
Method：POST  

RequestBody:  
```json
{
    "orderId": 1,
    "shipAddress": "上海奉贤区",
    "orderTime":"2019-12-12T00:00:00.000+0000",
    "customerName": "张三",
    "mobile": "10392090983",
    "email":"87879792@qq.com",
    "productName":"手机",
    "quantity": 1,
    "reason": "屏幕有划痕",
    "opened": 1,
    "comment": "退货"

}

```

Request Field

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderId | Integer | 订单id |
| shipAddress | String | 邮寄地址 |
| orderTime | String | 订单时间 |
| customerName | String | 客户姓名 |
| mobile | String | 手机 |
| email | String | 邮箱 |
| productName | String | 商品名称 |
| quantity | Integer | 数量 |
| reason | String | 理由 |
| opened | Integer | 是否开封 |
| comment | String | 备注 |

