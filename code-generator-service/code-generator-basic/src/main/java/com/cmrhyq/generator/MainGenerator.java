package com.cmrhyq.generator;

import com.cmrhyq.model.TemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * <p>核心生成器</p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname MainGenerator.java
 * @project code-generator-basic
 * @package com.cmrhyq.generator
 * @date 2024/3/29 0:25
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class MainGenerator {

    /**
     * 生成
     *
     * @param model {"loop":true,"author":"Alan Huang","outputText":"Sum:"}
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerator(Object model) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");
        // 项目根路径
        File parentFile = new File(projectPath).getParentFile();
        System.out.println("parentFile = " + parentFile);
        // 输入路径
        String inputPath = new File(parentFile, "code-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        //生成静态文件
        StaticGenerator.doGenerator(inputPath, outputPath);
        //生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/Template.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/yupi/acm/Template.java";
        DynamicGenerator.doGenerator(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setLoop(true);
        templateConfig.setAuthor("alanHuang");
        templateConfig.setOutputText("test：");
        doGenerator(templateConfig);
    }
}
