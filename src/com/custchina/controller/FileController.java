package com.custchina.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.custchina.pojo.Fileos;
import com.custchina.service.impl.FileService;
import com.custchina.utils.FileTool;

@Controller
public class FileController {

	@Autowired
	private FileService fs;
	@RequestMapping(value="/up.do",method=RequestMethod.POST)
	public String file (@RequestParam(value="file",required=false) MultipartFile file){
	
		String path = "D:\\项目\\cust_cloud\\WebContent\\images";
		File f=new File(path);
		System.out.println(f);
		 Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String date2=sdf.format(date);
		String fileName=file.getOriginalFilename();
		int size=(int)file.getSize();
		 String s = fileName.substring(fileName.lastIndexOf(".") + 1);  
		String h = StringUtils.substringBefore(fileName,".");
		String a =FileTool.filePath(f, fileName);
		System.out.println(a);
		FileTool.FILEUPLOAD(file, a);
		Fileos fo = new Fileos();
		fo.setFileName(h);
		fo.setFileType(s);
		fo.setFileSize(size);
		fo.setFileUptime(date2);
		fs.addFile(h, s, size, date2,a);
		return "redirect:find.do";
		
	}
	@RequestMapping("/find.do")
	public String li(Model model){
		List<Fileos> list = fs.selectAll();
		model.addAttribute("list", list);
		return "/file";
		
		
		
	}
	//图片
	@RequestMapping("/jpng.do")
	public String png(Model model,String str){


		List<Fileos> ls = fs.selectOne("jpg");
		List<Fileos> ls2 = fs.selectOne("png");
		model.addAttribute("list",ls);
		model.addAttribute("list2",ls2);
		
			return "photo";
		}
	//压缩包
	@RequestMapping("/zip.do")
	public String ra(Model model,String str){


		List<Fileos> ls = fs.selectOne("rar");
		List<Fileos> ls2 = fs.selectOne("zip");
		model.addAttribute("list",ls);
		model.addAttribute("list2",ls2);
		
			return "/class";
		}
	//文档
	@RequestMapping("/txt.do")
	public String tt(Model model,String str){


		List<Fileos> ls = fs.selectOne("txt");
		List<Fileos> ls2 = fs.selectOne("java");
		model.addAttribute("list",ls);
		model.addAttribute("list2",ls2);
		
			return "/class";
		}
	//文档
		@RequestMapping("/mps.do")
		public String mm(Model model,String str){
			List<Fileos> ls = fs.selectOne("mp3");
			List<Fileos> ls2 = fs.selectOne("vido");
			model.addAttribute("list",ls);
			model.addAttribute("list2",ls2);
			
				return "/class";
			}
	@RequestMapping("/delate.do")
	public String del(Model model,Integer fileId){
		int a =fs.delete(fileId);
		System.out.printf("删除了%d几条",a);
		if (a>0){
			model.addAttribute("msg","删除成功");
		}else {
			model.addAttribute("msg", "删除失败");
		}
		return "redirect:find.do";

	}
}


