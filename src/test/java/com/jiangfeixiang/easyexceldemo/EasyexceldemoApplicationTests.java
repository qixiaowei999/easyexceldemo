package com.jiangfeixiang.easyexceldemo;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.jiangfeixiang.easyexceldemo.controller.UserController;
import com.jiangfeixiang.easyexceldemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyexceldemoApplicationTests {

    @Autowired
    private UserController userController;


    @Test
    public void contextLoads(){
        // 文件输出位置
        OutputStream out = null;
        try {
            //获取桌面路径，然后把文件输出在桌面
            File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
            //创建时间
            String format = new SimpleDateFormat("yyyy-MM-dd").format( new Date( ));
            //根据时间，在桌面创建文件
            File path = new File(desktop+"\\"+format+".xlsx");
            //输出文件
            out = new FileOutputStream(path);
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
            Sheet sheet1 = new Sheet(1, 0,User.class);

            // 写数据到 Writer 上下文中
            // 入参1: 创建要写入的模型数据
            // 入参2: 要写入的目标 sheet
            writer.write(userController.getAllUser(), sheet1);
            // 将上下文中的最终 outputStream 写入到指定文件中
            writer.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                // 关闭流
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
