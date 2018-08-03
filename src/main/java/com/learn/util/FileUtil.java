package com.learn.util;

import java.io.File;

/**
 * 
 * @author liman
 * @createtime 2018��7��30��
 * @contract 15528212893
 * @comment:
 * ��ȡ�ļ������࣬Ԥ��
 */
public class FileUtil {
	
	/**
	 * 从磁盘读取文件
	 * @param path 文件路径
	 * @return
	 */
	public static File readFileFromDisk(String path) {
		
		File file = null;
		
		try {
			file = new File(path);
		} catch (Exception e) {
			System.out.println("读取文件异常："+e.getMessage());
		}
		
		return file;
		
	}

}
