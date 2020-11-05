# 纯静态重构家电售后管理系统(Ajax+HTML+SSM)--写的很渣，不要喷我
## Json的使用
```
<script type="text/javascript">
    $("#submit").on("click", function () {
        var params = $("#login").serializeArray();
        var j = {};
        for (var item in params) {
            j[params[item].name] = params[item].value;
        }
       /* alert(JSON.stringify(j));
        $.post(
            "/user/login",
            JSON.stringify(j),
            function (data) {
                alert(JSON.stringify(data));
            },
            "text"
        );*/
        //alert(JSON.stringify(j));
        $.ajax({
            url:'/user/login',
            data:JSON.stringify(j),
            type:'POST',
            dataType:'json',
            /*
           声明参数位json类型，便于后台接收时可以识别
            */
            headers:{
                Accept:"application/json",
                "Content-Type":"application/json"
            },
            processData:false,
            cache:false
        }).done(function (data) {
            var status=JSON.parse(data).status;
            var name=JSON.parse(data).name;
            //alert(status);
            if (status==0){
                alert("您好"+name +",恭喜您登陆成功，即将跳转到主页!");
                var url="/main.html?username="+j.username+"&name="+name+"&role="+j.role;
                //alert(url);
                window.location.href=url;
            }else if(status==1){
                alert("该用户不存在，请重新输入！");
            }else if (status==2){
                alert("密码输入有误，请重新输入！");
            }
        });
    });
</script>
```
***  
* 注意: 在使用该**Ajax**接收和传递Json参数时，需要使用 `@ResponseBody`注释函数体
***  
    
     
     
### 前端传递Json参数为单一对象时
>可以直接将参数转换为Json
```
data:JSON.stringify(thisPage)
// data:JSON.stringify(1)===>这样也可以
```
>后端接收参数用String 或Integer即可
>
`@RequestBody Integer thisPage`
##target域标签无效
>原因：在主页面重新给name参数赋值
>>示例：`var name=$.query.get("name");`
>
>解决办法：修改参数名，不占用name参数
>>示例：`var name1=$.query.get("name");`

## Gson包可以将固定类型的字符串型函数转化位Json类型
>代码示例：
```
 String JsonObject;
    if(complaint.getId()!=0){
      JsonObject="{\"status\":0}";
    }else{
      JsonObject="{\"status\":1}";
    }
    Gson gson = new Gson();
    return gson.toJson(JsonObject) ;
```
>转换结果: `[{"status":0}`
### 当传送的Json由多个类组成时，使用put装载
>代码示例：
```
 String JsonObject;
    if(complaint.getId()!=0){
      JsonObject="{\"status\":0}";
    }else{
      JsonObject="{\"status\":1}";
    }
    Gson gson = new Gson();
    return gson.toJson(JsonObject) ;
```
>转换结果: `[{"status":0}`


## mapper操作数据库，insert可以将插入数据后的逐渐返回并set进调用的实体类中
>示例：
```
 System.out.println(consult.toString());
 System.out.println("插入前consult的id值为："+consult.getId());
 consultService.addConsult(consult);
 System.out.println("插入后consult的id值为："+consult.getId());
```
>日志显示结果：
```
Consult{id=0, question='1+1=？', answer='2', customername='黄光辉', phone='17624407987'}
插入前consult的id值为：0
Creating a new SqlSession
SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1b6592b7] was not registered for synchronization because synchronization is not active
31-Jul-2020 15:55:37.913 信息 [http-nio-8081-exec-85] com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource. Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 3, acquireRetryAttempts -> 30, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1b61ageab19gu5l52pn1gj|28cc6e98, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.mysql.cj.jdbc.Driver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1b61ageab19gu5l52pn1gj|28cc6e98, idleConnectionTestPeriod -> 0, initialPoolSize -> 5, jdbcUrl -> jdbc:mysql://localhost:3306/dbmanager?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 10, maxStatements -> 0, maxStatementsPerConnection -> 0, minPoolSize -> 3, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {user=******, password=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
JDBC Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@3d2b4c13 [wrapping: com.mysql.cj.jdbc.ConnectionImpl@9ef993a]] will not be managed by Spring
==>  Preparing: INSERT INTO consult(question,answer,customername,phone) VALUE ( ?, ?, ?, ? )
==> Parameters: 1+1=？(String), 2(String), 黄光辉(String), 17624407987(String)
<==    Updates: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1b6592b7]
插入后consult的id值为：5
```
## 号码判断正则表达式
```
/*以1开头的11位纯数字*/
 function checkMobile(phone){
        var regex = /^1\d{10}$/;
        return regex.test(phone);
 }
```
## Json在传送带实体类的数据时可以直接读取？（尚不理解）
#### 已理解，被传送至前段时，已经被转换为Json类，所以可以直接使用。
### 代码示例
>逻辑代码
```
 Page page=repairService.repairList(current);


    Gson gson = new Gson();
    String JsonObject=gson.toJson(page);
    System.out.println(JsonObject);
    return JsonObject ;
```
>实体类代码
```
 private int pageSize=10;
    //每页10条
    private int currentPage;
    //当前页，页面传递
    private int totalSize;
    //总条数，查询数据库得来
    private int totalPage;
    //共多少页
	private int startIndex;
	//起始记录索引
    private List<Map<String, Object>> list;
    //当前页包含的列表，读取数据库获取
    private int num=6;
    //页面显示的页码个数
    private int start;
    //页面显示页码的起始值
	private int end;
	//页面显示页码的终止值
```
>命令行出结果
```
{"pageSize":10,"currentPage":1,"totalSize":24,"totalPage":0,"startIndex":0,"list":[{"reason":"1","address":"1","phone":"1","productname":"1","id":1,"state":1,"customername":"1","type":0},{"reason":"1","address":"2","phone":"2","productname":"1","id":2,"state":3,"customername":"1","type":0},{"reason":"3","address":"3","phone":"3","productname":"3","id":3,"state":1,"customername":"3","type":0},{"reason":"3","address":"3","phone":"3","productname":"4","id":4,"state":3,"customername":"3","type":0},{"reason":"6","address":"6","phone":"6","productname":"6","id":5,"state":0,"customername":"6","type":0},{"reason":"4","address":"4","phone":"5","productname":"5","id":6,"state":0,"customername":"3","type":0},{"reason":"4","address":"4","phone":"5","productname":"5","id":7,"state":0,"customername":"3","type":0},{"reason":"8","address":"8","phone":"8","productname":"8","id":8,"state":0,"customername":"8","type":0},{"reason":"h","address":"h","phone":"11223","productname":"h","id":9,"state":0,"customername":"h","type":0},{"reason":"ll","address":"ll","phone":"6","productname":"ll","id":10,"state":0,"customername":"ll","type":0}],"num":6,"start":0,"end":0}

```
### 输出示例
>ajax
```
 $.ajax({
                url:'/waiter/repair/list',
                data:JSON.stringify(thisPage),
                type:'POST',
                dataType:'json',
                /*
               声明参数位json类型，便于后台接收时可以识别
                */
                headers:{
                    Accept:"application/json",
                    "Content-Type":"application/json"
                },
                processData:false,
                cache:false
            }).done(function (data) {

                alert(data.pageSize);
                alert(data.list);
                alert(data.list.reason);
                alert(data.list[0].reason);

                }
            );
```
>alert输出的值
```
data.pageSize:10

data.list:[object Object],[object Object],[object Object],[object Object],[object Object],[object Object],[object Object],[object Object],[object Object],[object Object]

data.list.reason:undefined

data.list[0].reason:1
```

## Json读取List元素参数
>Json参数
`"list":[{"name":"3","id":3,"state":0,"username":"3"},{"name":"5","id":5,"state":0,"username":"5"},{"name":"6","id":6,"state":0,"username":"6"}]`

>js获取方法
```
 for (var key in freeWorkerInfo){
      var workerUsername=freeWorkerInfo[key].username;
      var workerName=freeWorkerInfo[key].name;
      workerList+="<option value='"+workerUsername+"'>"+workerName+"</option>";
}
```
## String转Json
>Gson方法执行类似操作时需要知道转换后的对象类型，操作比较多
```
public static Object JSONToObject(String json,Class beanClass) {
    Gson gson =new Gson();
    Object res = gson.fromJson(json, beanClass);
    return res;
}
```
>alibaba的jackson的jar包可以直接对其转换
```
 /**
     *  jackson.jar包可以将String转换为JsonObject
     */
    JSONObject jsonObject =JSONObject.parseObject(dispatchJson);
    System.out.println((String) jsonObject.get("productname"));
```
>总结，当返回的字符串Json不是单一对象类，还有其他参数时，Gson并不适用，建议用jaskson，
>对象类型单一时，Gson可以完成类的转换，省去了手动转换，建议使用Gson
## 设置时间格式
```SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");```
## MyBatis中特殊符号（大于、小于等）的处理
第一种写法：
*  &lt;              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;               小于号（\&lt;） 
*  &lt;=             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                           小于等于(\&lt;=)
*  &gt;              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;               大于号 (\&gt;)              
*  &gt;=             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                           大于等于(\&gt;=)
*  &amp;             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;               取地址符(\&amp;) 
*  &apos;            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   单引号 (\&apos;)
*  &quot;            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;         双引号 (\&quot;)

例如：sql如下：  
```create_date_time &gt;= #{startTime} and  create_date_time &lt;= #{endTime}```
在MyBatis中效果:  
```create_date_time >= #{startTime} and  create_date_time <= #{endTime}```  
 
第二种写法：
* 大于等于 `<![CDATA[ >= ]]>`
* 小于等于 `<![CDATA[ <= ]]>` 
   
例如：sql如下：  
```create_date_time <![CDATA[ >= ]]> #{startTime} and  create_date_time <![CDATA[ <= ]]> #{endTime}```  
在MyBatis中效果:  
```create_date_time >= #{startTime} and  create_date_time <= #{endTime}```


## MyBatis一次执行多个SQL语句
### MySQL中
>1.在MySQL的链接字符串中添加allowMultiQueries=true字段
```
<property name="user" value="admin"></property>
        <property name="password" value="123"></property>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3305/dbmanager?useUnicode=true&amp;characterEncoding=utf8&amp;serverTimezone=UTC&amp;allowMultiQueries=true"></property>
        <property name="driverClass" value="com.mysql.cj.jdbc.Driver"></property>
```
>2.多个语句用分号隔开
```
<update id="outOfStorage" parameterType="Fixlog" >
        UPDATE fixlog SET toolname = #{toolname} , toolcount = #{toolcount}, partsname = #{partsname} , partscount = #{partscount}  WHERE id = #{id};
        UPDATE stock SET count = count-1  WHERE name = #{toolname} and type = 0;
        UPDATE stock SET count = count-#{partscount}  WHERE name = #{partsname} and type = 1;
</update>
```  
### Oracle中  
>直接使用begin end 字段
```
<delete id="delete" parameterType="upc.cbs.HtxxlrEntity">
begin 
  delete from PC_CBS_CONTRACT where contract_id = #{contract_id};
  delete from PC_CBS_UPLOAD_FILES where  contract_id = #{contract_id} and  filetype='合同附件';
  delete from PC_CBS_CONTRACT_TEAM where contract_id = #{contract_id};
 end;
</delete>
```
## Ajax中append() 和before()、after()用法的区别  
```
<p>hello</p>
  
//使用append插入
$("p").append("<b>world</b>")
//显示结果
<p>hello<b>world</b></p>

//使用prepend插入
$("p").prepend("<b>world</b>")
//显示结果
<p><b>world</b>hello</p>

//使用after插入语句
$("p").after("<b>world</b>")
//显示结果
<p>hello</p><b>world</b>

//使用before插入语句
$("p").before("<b>world</b>")
//显示结果
<b>world</b><p>hello</p>
```

## repository接口调用Mybatis操作数据库时，可以使用注解的方式向Mybatis注入字段
* 使用注解前  
   接口端（注入）:   
   `public List<Map<String, Object>> consultList(int startIndex, int pageSize);` 
    
   Mybatis端（接收）：
    ```
    <select id="consultList" resultType="java.util.Map">
            SELECT * FROM consult  LIMIT  #{param1} , #{param2}
    </select>
    ```
 * 使用注解后  
    接口端（注入）:   
      `public int fixingLogToFixedLog(@Param("fixlog") Fixlog fixlog,@Param("complaintState") int complaintState);` 
       
    Mybatis端（接收）：
    ```
        <update id="fixingLogToFixedLog" parameterType="Fixlog">
               UPDATE fixlog SET bonus = #{fixlog.bonus},state = #{fixlog.state},reason = #{fixlog.reason},cost = #{fixlog.cost}  WHERE id = #{fixlog.id};
               UPDATE complaint SET state = #{complaintState}  WHERE phone = #{fixlog.customerphone} and productname = #{fixlog.productname} and type = 0;
               UPDATE worker SET state = 0  WHERE username = #{fixlog.username};
       </update>
   ```
