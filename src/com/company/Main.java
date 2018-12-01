package com.company;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final String INI_FILE_PATH = "./setting.ini";

    public static void main(String[] args) throws IOException {

        IniFileLoader ifl = new IniFileLoader(INI_FILE_PATH);

        // 比較元ファイルを取得
        List<String> origCode = JavaCodeSplitter.getJavaCode(ifl.getOrigFile());
        // 比較先ファイルを取得
        List<String> destCode = JavaCodeSplitter.getJavaCode(ifl.getDestFile());

        // コード差異をカウント
        int diffCnt = JavaCodeDifference.countCodeDiff(origCode, destCode);

        System.out.println("Difference Code Line Count:" + diffCnt);
    }
}