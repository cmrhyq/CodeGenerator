import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname FreeMarker.java
 * @project code-generator-basic
 * @package PACKAGE_NAME
 * @date 2024/3/28 22:34
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class FreeMarkerTest {

    @Test
    public void test() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        configuration.setNumberFormat("0.####");

        configuration.setDefaultEncoding("utf-8");

        Template template = configuration.getTemplate("web.html.ftl");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2023);
        List<Map<String, Object>> menuItems = new ArrayList<>();

        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://www.baidu.com");
        menuItem1.put("label", "百度");

        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "https://www.google.com");
        menuItem2.put("label", "google");
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems", menuItems);

        Writer out = new FileWriter("web.html");

        template.process(dataModel, out);

        out.close();
    }
}
