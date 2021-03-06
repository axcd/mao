package com.mao.record.io;

import java.io.*;
import android.os.*;
import java.util.*;

public class FileManager{
	
	public static void WriteFile(String dirname, String filename,List<String> lines){

		try {
			File dir = new File(Environment.getExternalStorageDirectory(),
								 "mao/"+dirname);
								 
			if(!dir.exists()){   //如果文件目录不存在
				dir.mkdir();  //创建文件目录
			}
			
			File file = new File(Environment.getExternalStorageDirectory(),
								 "mao/"+dirname+filename);
			
			if(!file.exists()){
				file.createNewFile();
			}	

			if(lines.isEmpty()){		
				file.delete();
			}else{
				
				//第二个参数意义是说是否以append方式添加内容
				BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
				for(String line:lines){
					bw.write(line+"\r\n");
				}
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ReadFile(String dirname, String filename, List<String> lines){

		try {
			File dir = new File(Environment.getExternalStorageDirectory(),
								"mao/"+dirname);
								
			if(!dir.exists()){   //如果文件目录不存在
				dir.mkdir();  //创建文件目录
			}
			File file = new File(Environment.getExternalStorageDirectory(),
								 "mao/"+dirname+filename);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
