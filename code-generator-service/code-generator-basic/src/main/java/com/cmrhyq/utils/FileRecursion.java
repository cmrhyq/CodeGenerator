package com.cmrhyq.utils;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * <p>文件递归拷贝</p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname FileRecursion.java
 * @project code-generator-basic
 * @package com.cmrhyq.utils
 * @date 2024/3/27 23:03
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class FileRecursion {

    /**
     * 递归拷贝文件
     *
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void copyFile(String inputPath, String outputPath) throws IOException {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFileByRecursion(inputFile, outputFile);
        } catch (Exception e) {
            System.out.println("文件复制失败: " + e);
        }
    }


    /**
     * 递归拷贝文件
     *
     * @param inputFile  输入目录
     * @param outputFile 输出目录
     * @throws IOException
     */
    public static void copyFileByRecursion(File inputFile, File outputFile) throws IOException {
        // 判断是文件还是文件夹
        if (inputFile.isDirectory()) {
            // 是文件
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 判断文件夹是否存在，不存在则创建文件夹
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            // 获取文件夹下的文件
            File[] files = inputFile.listFiles();
            // 无子文件，直接结束
            if (ArrayUtil.isNotEmpty(files)) {
                return;
            }
            for (File file : files) {
                // 递归拷贝
                copyFileByRecursion(file, destOutputFile);
            }
        } else {
            // 是文件，直接复制
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
