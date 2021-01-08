package com.custchina.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.custchina.pojo.Fileos;

public interface FileDao {
	public int addFile(@Param("filename") String filename,@Param("filetype") String filetype
			,@Param("filesize") Integer filesize,@Param("fileuptime") String fileuptime,@Param("imgs")String imgs );
	List<Fileos> findAll();
	List<Fileos> findOne( String filetype);
	int deleteByPrimaryKey(@Param("fileId") Integer fileId);
}
