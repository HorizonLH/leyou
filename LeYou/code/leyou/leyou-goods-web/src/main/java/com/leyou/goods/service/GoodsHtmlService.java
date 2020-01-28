package com.leyou.goods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author lhh
 * @date 2019/12/9 19:50
 */
@Service
public class GoodsHtmlService {

    @Autowired
    private TemplateEngine engine;
    @Autowired
    private GoodsService goodsService;

    public void create(Long spuId) {
        //初始化运行上下文
        Context context = new Context();
        //设置数据模型
        context.setVariables(this.goodsService.loadData(spuId));
        PrintWriter printWriter = null;
        //把静态文件生成到本地
        try {
            File file = new File("D:\\tools\\nginx-1.16.1\\html\\item\\" + spuId + ".html");
            printWriter = new PrintWriter(file);
            this.engine.process("item", context, printWriter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (printWriter != null){
                printWriter.close();
            }
        }

    }

    public void deleteHtml(Long id) {
        File file = new File("D:\\\\tools\\\\nginx-1.16.1\\\\html\\\\item\\\\\" + spuId + \".html");
        file.deleteOnExit();
    }
}
