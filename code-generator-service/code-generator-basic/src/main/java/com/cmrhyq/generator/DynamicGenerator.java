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
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        configuration.setNumberFormat("0.####");

        configuration.setDefaultEncoding("utf-8");

        Template template = configuration.getTemplate("Template.java.ftl");

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setLoop(true);
        templateConfig.setAuthor("Alan");
        templateConfig.setOutputText("Sum:");

        Writer out = new FileWriter("Template.java");

        template.process(templateConfig, out);

        out.close();
    }
}
