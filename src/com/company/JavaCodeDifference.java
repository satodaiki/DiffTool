package com.company;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ２つのコードの比較クラス
 *
 * TODO: Java以外の言語にも対応できるようinterfaceを定義（？）
 */
public class JavaCodeDifference {

    // 文字比較時に無視する正規表現定数
    // → 半角スペース、全角スペース、タブ文字、改行文字
    private static final String IGNORE_REGEX = "[^ 　\t\n]*";

    /**
     * ２つのコードの比較を行い、一致した行数を返却
     *
     * @param origCode      比較元コード
     * @param destCode      比較先コード
     * @return 比較一致行数
     */
    public static int countCodeDiff(List<String> origCode, List<String> destCode) {

        int cnt = 0;

        // 文字列用イテレータの生成
        StringCharacterIterator origCodeIterator =  new StringCharacterIterator(getNotIncludeIgnoreCode(origCode));
        System.out.println("getNotIncludeIgnoreCode(origCode):\n" + getNotIncludeIgnoreCode(origCode));
        StringCharacterIterator destCodeIterator =  new StringCharacterIterator(getNotIncludeIgnoreCode(destCode));
        System.out.println("getNotIncludeIgnoreCode(destCode):\n" + getNotIncludeIgnoreCode(destCode));

        // 比較元または比較先のどちらかの文字が終了するまで実行
        while (origCodeIterator.current() != StringCharacterIterator.DONE &&
                destCodeIterator.current() != StringCharacterIterator.DONE) {

            // 比較元と比較先で違うコード文字が含まれ、かつ比較先の方が先に改行していた場合にカウントを増やす
            System.out.println("origCodeIterator.current():" + origCodeIterator.current());
            System.out.println("destCodeIterator.current():" + destCodeIterator.current());

            if (origCodeIterator.current() == destCodeIterator.current()) {
                destCodeIterator.next();
                origCodeIterator.next();
            } else {
                if (destCodeIterator.next() == '\n') {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    /**
     * コードから無視する文字を排除（現在未使用）
     *
     * @param codeList      コード文字列格納リスト
     * @return 無視する文字列を排除したコード
     */
    private static List<String> getNotIncludeIgnoreCodeList (List<String> codeList) {
        List<String> notIncludeIgnoreCodeList = new ArrayList<String>();

        Pattern ignoreP = Pattern.compile(IGNORE_REGEX);

        for (String codeLine : codeList) {
            Matcher ignoreM = ignoreP.matcher(codeLine);

            if (ignoreM.find()) {
                notIncludeIgnoreCodeList.add(ignoreM.group());
            }
        }

        return notIncludeIgnoreCodeList;
    }

    /**
     * コードから無視する文字を排除
     *
     * @param codeList      コード文字列格納リスト
     * @return 無視する文字列を排除し、リスト毎に改行を付与したコード
     */
    private static String getNotIncludeIgnoreCode (List<String> codeList) {

        String notIncludeIgnoreCode = "";

        Pattern ignoreP = Pattern.compile(IGNORE_REGEX);

        for (String codeLine : codeList) {
            Matcher ignoreM = ignoreP.matcher(codeLine);

            if (ignoreM.find()) {
                notIncludeIgnoreCode = notIncludeIgnoreCode + ignoreM.group() + '\n';
            }
        }

        return notIncludeIgnoreCode;
    }
}
