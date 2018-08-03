package com.learn;

import java.io.File;

import com.learn.execute.Execute_Cancel_brackets;
import com.learn.util.FileUtil;

/**
 * 
 * @author liman
 * @createtime 2018年7月30日
 * @contract 15528212893
 * @comment:
 * 	程序启动
 */
public class App {
	
	public static void main(String[] args) {
		File toDealFile = FileUtil.readFileFromDisk("C:\\Users\\liman\\Desktop\\统一支付测试.xlsx");
		Execute_Cancel_brackets.cancelBrackets(toDealFile);
	}

}
