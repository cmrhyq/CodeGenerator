package com.cmrhyq.model;

import lombok.Data;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname TemplateConfig.java
 * @project code-generator-basic
 * @package com.cmrhyq.model
 * @date 2024/3/28 23:40
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Data
public class TemplateConfig {

    private boolean loop = true;

    private String author = "Alan Huang";

    private String outputText = "Sum: ";
}
