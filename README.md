## springfox-bean-validators
springfox-bean-validators是一组springfox-swagger2 plugin，使springfox swagger更完善的支持bean-validators。

与springfox官方springfox-bean-validators的区别是支持了validation的group分组(分组的详细用法 https://www.cnblogs.com/beiyan/p/5946345.html )，并且支持复用pojo。

在一般使用中，不同的请求，pojo非常类似，只有个别字段的区别，如果为了产生完美的swagger文档，那么就不得不写大量相似的pojo，非常不简洁不优雅，这个项目复用了@Null注解标识哪些情况下哪些属性应该隐藏，例如添加和修改时提交请求参数不一样、返回列表和详情的返回字段不同等(具体参见demo工程)：

```
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel
public class Article {
    @ApiModelProperty("编号")
    @Null(groups = {Group.Crud.Create.class, Group.Crud.Update.class, Group.Crud.Retrieve.class})
    private Long id;
    @ApiModelProperty("标题")
    @Pattern(groups = {Group.Crud.Create.class}, regexp = "【\\w+】\\w+")
    private String title;
    @ApiModelProperty("摘要")
    @Size(groups = {Group.Crud.Update.class}, min = 10, max = 512)
    private String summary;
    @ApiModelProperty("详情")
    @Size(groups = {Group.Crud.Create.class, Group.Crud.Update.class}, min = 10, max = 512)
    @Null(groups = Group.Crud.General.class)
    private String content;
    @ApiModelProperty("创建时间")
    @Null(groups = Group.Crud.class)
    private Date gmtCreate;
    @ApiModelProperty("更新时间")
    @Null(groups = Group.Crud.class)
    private Date gmtModified;
 ...
```

![请求](https://raw.githubusercontent.com/charlesvhe/springfox/master/request.png)

![相应](https://raw.githubusercontent.com/charlesvhe/springfox/master/response.png)