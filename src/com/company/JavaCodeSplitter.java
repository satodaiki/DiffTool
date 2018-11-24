package com.company;

import com.sun.tools.javac.parser.JavacParser;
import com.sun.tools.javac.util.StringUtils;

import javax.swing.text.StringContent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaCodeSplitter {

    public static final String EMPTY_STR = "";

    // codeSplitがリターンするマップオブジェクトのキー
    public static enum Type {
        Method,
        Field
    };


    /**
     *
     * 入力ファイルのコード文字列を分解<pre>
     * 各フィールド、各メソッドがマップオブジェクトに格納される
     *
     * @param code
     * @return マップオブジェクト
     */
    public Map<Type, Map<String, String>> splitCode(String code) {
        Map<Type, Map<String, String>> methodList = new HashMap<Type, Map<String, String>>();



        return methodList;
    }


    public Map<String, String> splitMethod(String code) {

        Map<String, String> methodList = new HashMap<String, String>();

        // メソッドの解析
        for (char c : code.toCharArray()) {
            if (c == '{') {

            }
        }

        String regex_method = ".+\\(*\\)*\\{*(\\{*\\})*\\}.+";

        Pattern method = Pattern.compile(regex_method);

        Matcher methodMatch = method.matcher(code);

        if (methodMatch.find()) {

        }
        return methodList;
    }

    /**
     *
     * コード文字列取得
     *
     * @param filePath  コード取得先ファイルパス
     * @return コード文字列
     */
    public String getCodeStr(String filePath) {

        String codeStr = EMPTY_STR;

        try(BufferedReader in = new BufferedReader(new FileReader(filePath))){

            // 空文字で初期化
            String codeLine = EMPTY_STR;

            //最後の一行まで読み込む
            while((codeLine = in.readLine()) != null){
                codeStr = codeStr + codeLine + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return codeStr;
    }
}
