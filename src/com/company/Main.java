package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        // JavaMethodSplitter s = new JavaMethodSplitter();
        JavaCodeSplitter jcs = new JavaCodeSplitter();

        // コード文字列の生成
        String code = jcs.getCodeStr("/Users/satodai/Downloads/acf3bd19cc8b7c959118-43c7dd0b77df94ca241714dd9524a72147c9dc12/ShowClassStructure.java");

        System.out.println("code string:\n" + code);

        // コードの分割
        Map<JavaCodeSplitter.Type, Map<String, String>> codeMap = jcs.splitCode(code);



    }
}
