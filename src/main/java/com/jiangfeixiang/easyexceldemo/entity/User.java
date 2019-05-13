package com.jiangfeixiang.easyexceldemo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;

/**
 * @ProjectName: easyexceldemo
 * @Package: com.jiangfeixiang.easyexceldemo.entity
 * @ClassName: User
 * @Author: jiangfeixiang
 * @email: 1016767658@qq.com
 * @Description: 用户实体类
 * @Date: 2019/5/13/0013 15:28
 */
@Data
@Builder
public class User extends BaseRowModel {

    @ExcelProperty(value = "姓名",index = 0)
    private String name;

    @ExcelProperty(value = "密码",index = 1)
    private String password;

    @ExcelProperty(value = "年龄",index = 2)
    private Integer age;
}
