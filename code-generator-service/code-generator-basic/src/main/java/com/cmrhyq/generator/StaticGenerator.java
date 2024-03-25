package com.cmrhyq.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * <p>静态文件生成器</p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname StaticGenerator.java
 * @project code-generator-basic
 * @package com.cmrhyq.generator
 * @date 2024/3/25 23:47
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class StaticGenerator {

    public static void main(String[] args) {
        String systemPath = System.getProperty("user.dir");
        File parentFile = new File(systemPath).getParentFile();
        String inputPath = new File(parentFile, "code-generator-demo-projects" + File.separator + "acm-template").getPath();
        String outputPath = systemPath;
        doGenerator(inputPath, outputPath);
    }

    /**
     * 文件复制方法
     *
     * @param srcPath  输入路径
     * @param destPath 输出路径
     */
    public static void doGenerator(String srcPath, String destPath) {
        FileUtil.copy(srcPath, destPath, true);
    }
}
