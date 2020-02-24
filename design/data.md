# Administrator
| 字段 | 类型 | 约束 |说明 |
| --- | --- | ---| --- |
| administrator_id | int | 主键，自增 | Id |
| username | varchar(20) | 非空，唯一索引 | 用户名 |
| realName | varchar(30) | 索引 | 真实姓名 |
| email | varchar(30) | 唯一索引 | 邮箱 |
| status | tinyint | 非空 ，默认1启用 | 状态（0禁用，1启用）|
| create_time | datatime | 非空 | 创建时间 |
| encrypted_password  | varchar(100)  | 非空 | 加密密码  |
| avatar_url  | varchar(100)  |   | 头像地址 |


# product
| 字段 | 类型 | 约束 |说明 |
| --- | --- | ---| --- |
| product_id | int | 主键，自增 | id |
| product_name | varchar(30) | 非空 | 商品名称 |
| product_code | varchar(30) | 非空，唯一索引 | 商品代号 |
| product_abstract | varchar(255) | 非空 | 商品摘要 |
| price | double | 非空 | 商品价格 |
| discount | double |  | 打折（0.01-0.99） |
| stock_quantity | int | 非空，默认0 | 库存数量 |
| status | tinyint | 非空，默认1上架 | 状态（0下架，1上架，2待审核） |
| main_pic__url | varchar(100) | 非空 | 商品主图片 |
| rewordPoints | int |  | 积分 |
| sort_order | int |  | 排序 |

# productDetail
| 字段 | 类型 | 约束 |说明 |
| --- | --- | ---| --- |
| product_id | int | 外键 | id |
| description | text | 非空 | 商品描述 |
| other_pic_urls | varchar(2000) | | 其他图片(数组) |

# customer
| 字段 | 类型 | 约束 |说明 |
| --- | --- | ---| --- |
| customer_id | int | 主键，自增 | id |
| username | varchar(20)  | 非空，唯一索引 | 用户名  |
| real_name | varchar(20) | 非空 | 真实姓名 |
| mobile | varchar(20) | 唯一索引 | 手机号 |
| mobile_verified | bit | 非空 | 手机验证 |
| email | varchar(30) | 唯一索引 | 邮箱 |
| email_verified | bit | 非空 | 邮箱验证 |
| real_name | varchar(20) | 非空 | 真实姓名 |
| encrypted_password  | varchar(100)  | 非空 | 加密密码  |
| news_subscribed| bit | 非空 | 新闻订阅 |
| avatar_url | varchar(100) | | 头像 |
| reword_points | int | 非空，默认0 | 积分 |
| status | tinyint | 非空，默认1安全 | 账号状态（0危险，1安全，2封号） |
| default_address_id | int | 外键 | 默认地址 |

# address
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| address_id  | int  | 主键 自增 | Id  |
| customer_id | int | 非空，索引，外键 | 客户id |
| receiver_name | varchar(20) | 非空 | 收货人姓名 |
| receiver_mobile | varchar(20) | 非空 | 收货人手机号 |
| content | varchar(200) | 非空 | 地址内容 |

# order
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| order_id  | bigint  | 主键 自增 | Id  |
| customer_id | int | 非空，外键，索引 | 客户id |
| status  | tinyint  | 非空 | 状态（0待处理，1处理中，2待发货，3已发货，4待签收，5已签收，6待支付，7已支付，8取消，9完成 |
| total_price | double | 非空 | 总金额 |
| reword_points | int | | 积分 |
| create_time  | datetime  |  非空 | 创建时间  |
| update_time  | datetime  |  非空 | 修改时间  |


# orderdetail
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| order_id  | bigint  | 外键 | Id  |
| ship_method | smallint | 非空 | 寄送方式 |
| ship_address | varchar(200) | 非空 | 寄送地址 |
| ship_price | double | 非空 | 邮费 |
| pay_method | smallint | 非空 | 支付方式 |
| invoice_address | varchar(200) | 非空 | 发票地址 |
| incoice_price | double | 非空 | 发票价格 |
| comment | varchar(300) | | 备注 |
| order_products | text | 非空 | 内容（数组） |
| product_id | int | 非空 | 商品id |
| product_name | string | 非空 | 商品名称 |
| product_code | string | 非空 | 商品代号 |
| quantity | int | 非空 | 数量 |
| unit_price | double | 非空 | 单价 |
| unit_reword_points | int | | 单个积分 |



# orderHistory
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| order_history_id | bigint | 主键 自增 | id |
| order_id  | int  | 非空,索引，外键 | 订单Id  |
| time  | datetime  |  非空 | 时间  |
| order_status | tinyint | 非空 | 订单状态 |
| comment | varchar(200) | | 备注 |
| customer_notified | bit  | 非空 | 是否通知客户  |


# return
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| retuen_id  | int  | 主键 自增 | Id  |
| order_id  | int  | 非空,索引，外键 | 订单Id  |
| order_time  | datetime  |  非空 | 订单时间  |
| customer_id | int | 非空 | 客户id |
| customer_name | varchar(30) | 非空 | 客户姓名 |
| mobile | varchar(30) | 非空，唯一索引 | 手机 |
| email | varchar(30) | 非空，唯一索引 | 邮箱 |
| status | tinyint | 非空 | 状态（0等待取货，1正在处理，完成）
| action | tinyint  | 非空 | 处理方式（0退货，1换货，2修理） |
| product_name | varchar(30) | 非空 | 商品名称 |
| product_code | varchar(30) | 非空 | 商品代号 |
| quantity | int | 非空 | 数量 |
| reason | tinyint | 非空 | 退换货原因（0未按约定时间发货，1不想要了，2产品质量有问题） |
| opened | bit  | 非空 | 是否开封  |
| comment | varchar(200) | | 备注 |
| create_time  | datetime  |  非空 | 创建时间  |
| update_time  | datetime  |  非空 | 修改时间  |

# returnHistory
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| return_history_id | int | 主键，自增 | id |
| retuen_id  | int  | 非空，索引，外键 | 退换货Id  |
| time  | datetime  |  非空 | 时间  |
| return_status | tinyint | 非空| 订单状态 |
| comment | varchar(200) | | 备注 |
| customer_notified | bit  | 非空 | 是否通知客户 |

