package com.custchina.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.custchina.dao.FileDao;
import com.custchina.pojo.Fileos;
@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileDao fd;
	@Override
	public int addFile(String filename, String filetype, Integer filesize, String fileuptime,String imgs) {
		
		return fd.addFile(filename, filetype, filesize, fileuptime,imgs);
	}
	@Override
	public List<Fileos> selectAll() {
		// TODO Auto-generated method stub
		List<Fileos> l = fd.findAll();
		System.out.println(l);
		return l;
	}
	@Override
	public List<Fileos> selectOne(String filetype) {
		// TODO Auto-generated method stub
		List<Fileos> lf = fd.findOne(filetype);
		return lf;
	}

	@Override
	public int delete(Integer fileId) {
		int a =fd.deleteByPrimaryKey(fileId);
		if(a>0){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		return a;
	}
}
