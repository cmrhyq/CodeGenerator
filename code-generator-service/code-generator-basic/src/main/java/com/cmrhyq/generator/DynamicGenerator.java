package com.cmrhyq.generator;

import com.cmrhyq.model.TemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname DynamicGenerator.java
 * @project code-generator-basic
 * @package com.cmrhyq.generator
 * @date 2024/3/28 23:45
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "src/main/resources/templates/Template.java.ftl";
        String outputPath = projectPath + File.separator + "Template.java";
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setLoop(true);
        templateConfig.setAuthor("Alan Huang 1");
        templateConfig.setOutputText("Sum1 = ");
        doGenerator(inputPath, outputPath, templateConfig);
    }

    /**
     * 文件生成
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     * @param model {"loop":true,"author":"Alan Huang","outputText":"Sum:"}
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerator(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 模板文件所在路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);
        // 设置字符集，数字格式
        configuration.setNumberFormat("0.####");
        configuration.setDefaultEncoding("utf-8");
        // 加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 创建数据模型
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setLoop(false);
        templateConfig.setAuthor("Alan Huang");
        templateConfig.setOutputText("Sum = ");

        Writer out = new FileWriter(outputPath);
        template.process(model, out);

        out.close();
    }
}
