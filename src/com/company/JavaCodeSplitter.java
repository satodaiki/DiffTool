package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Javaファイルのコード分解クラス
 *
 * Javaのファイルをフィールド、メソッドごとに分割する
 *
 * TODO: Java以外の言語にも対応できるようinterfaceを定義（する必要ないかも）
 */
public class JavaCodeSplitter {

    /**
     * Javaファイルのコード
     *
     * @param javaFilePath      .javaファイルの絶対パス
     * @return
     * @throws IOException
     */
    public static List<String> getJavaCode(String javaFilePath) throws IOException {

        Pattern extentionP = Pattern.compile("\\.[^\\.]+$");
        Matcher extentionM = extentionP.matcher(javaFilePath);

        if (extentionM.find()) {
            if (!".java".equals(extentionM.group())) {
                throw new IOException("The extension corresponds only to \".java\".");
            }
        }

        return Files.readAllLines(Paths.get(javaFilePath), StandardCharsets.UTF_8);
    }
}
