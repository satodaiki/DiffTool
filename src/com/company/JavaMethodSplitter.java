package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**メインのクラス
 * 基礎となるコード解析処理をまとめたクラス
 * 解析はFileReaderで対象ファイルをロードし正規表現でメソッドやクラスを判断する
 * それぞれ取得したクラス名、メソッド名はListに格納する
 * @author kentsu-141
 * @version 1.0
 * */
public class JavaMethodSplitter {
	
	//取得した文字列を格納するためのlist
	List<String> methodNameList;
	
	//すべてを格納するlist
	List<String> codeList;

	/**
     *
     * コード解析用のメソッド
	 *
     * @param code code<br>
	 * コードを文字列で受け取る
	 * 解析は正規表現を用いて、パターンにマッチすればlistに格納する
	 * このメソッドを使用する前にlistの参照変数にコレクションを代入しておく必要がある
     *
	 * */
	public void codeAnalysis(String code){
		//クラス、メソッド、アクセス修飾子のパターン定義
		String regex_method = "(void.[a-zA-Z0-9]*\\(*\\)*\\{)|(int.[a-zA-Z0-9]*\\(*\\)*\\{)|(short.[a-zA-Z0-9]*\\(*\\)*\\{)|(byte.[a-zA-Z0-9]*\\(*\\)*\\{)|(double.[a-zA-Z0-9]*\\(*\\)*\\{)|(boolean.[a-zA-Z0-9]*\\(*\\)*\\{)|(String.[a-zA-Z0-9]*\\(*\\)*\\{)";
		String regex_access = "(public.*)|(private.*)|(protected.*)|(.*)";
		String regex_exception = "(=)|(;)";//変数を区別
		Pattern mName = Pattern.compile(regex_method);
		Pattern access = Pattern.compile(regex_access);
		
		Pattern Exception_type = Pattern.compile(regex_exception);

		Matcher methodMatch = mName.matcher(code);
		Matcher accessMatch = access.matcher(code);
		
		Matcher exceptionMatch = Exception_type.matcher(code);

		if(methodMatch.find() && accessMatch.find() && !exceptionMatch.find()){
			String str = methodMatch.group();
            System.out.println(">>> methodName:" + str);
			this.methodNameList.add(str);
			this.codeList.add(str);
		}
	}
	
	/**
	 * 参照型変数としてファイルを受け取る
	 * 対象ファイルを一行ずつ読み込んで、codeAnalysis()に文字列として渡す
	 * codeAnalysis()を使用するより前のコードで
	 * それぞれのlistにコレクションを定義しておく必要がある
     *
     * @param file file<br>
     *
	 **/
	public void loadJavaFile(FileReader file){
		
		//コレクションを代入
		methodNameList = new ArrayList<>();
		codeList = new ArrayList<>();
		
		try(BufferedReader in = new BufferedReader(file)){
			String code_s;
			//最後の一行まで読み込む
			while((code_s = in.readLine()) != null){
				System.out.println(code_s);
				codeAnalysis(code_s+"\n");//改行をつけてメソッドに渡す
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}