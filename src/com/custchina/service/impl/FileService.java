package com.custchina.service.impl;

import java.util.Date;
import java.util.List;

import com.custchina.pojo.Fileos;

public interface FileService {
	public int addFile(String filename,String filetype,Integer filesize,String fileuptime ,String imgs);
	 List<Fileos> selectAll();
	 
	 List<Fileos> selectOne(String filetype);
	public int delete(Integer fileId);
}
