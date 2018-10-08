package com.zd.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 人员档案的添加与上传的控制器
 * @author Administrator
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Config_shang;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_standard_details;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IConfig_public_charservice;
import com.zd.service.IConfig_sahngService;
import com.zd.service.IHuman_fileservice;
import com.zd.service.IStandardService;
/**
 * 上传和添加控制器
 * @author Administrator
 *
 */

@Controller
public class Human_filecontroller {
	@Autowired
	private IConfig_file_first_kindService config_file_first_kindService;
	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	@Autowired
	private IConfig_majorService config_majorService;
	@Autowired
	private IStandardService standardService;
	@Autowired
	private com.zd.service.IHuman_fileservice IHuman_fileservice;
	@Autowired
	private IConfig_sahngService config_sahngService;
	//查询所有的公共字段
	@Autowired
	private IConfig_public_charservice Config_public_charservice;
	//查询分类
	@Autowired
	private IConfig_major_kindService Config_major_kindService;
	//人员表的service
	@Autowired
	private IHuman_fileservice Human_fileservice;	
	
	Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
	
	@RequestMapping("/register_choose_picture")
	public String register_choose_picture(Human_file Engage_major_release,Map map) {
		try {
			//一级机构联动单条查询赋值
			Config_file_first_kind cffk = config_file_first_kindService.queryDan(Engage_major_release.getFirst_kind_id());
			Engage_major_release.setFirst_kind_name(cffk.getFirstkindname());
			//二级机构联动单条查询赋值
			Config_file_second_kind cfsk =  config_file_second_kindService.queryDan(Engage_major_release.getSecond_kind_id());
			if(cfsk != null) {
			Engage_major_release.setSecond_kind_name(cfsk.getSecondkindname());
			}
			//三级机构联动单条查询赋值
			Config_file_third_kind cftk = config_file_third_kindService.queryDan(Engage_major_release.getThird_kind_id());
			if(cftk != null) {
			Engage_major_release.setThird_kind_name(cftk.getThirdkindname());
			}
			//职业分类一级联动单查赋值
			Config_major_kind cmk =  config_major_kindService.majorQueryDan(Engage_major_release.getHuman_major_kind_id());
			Engage_major_release.setHuman_major_kind_name(cmk.getMajor_kind_name());
			//职业分联动类二级单查赋值
			Config_major cmajor = config_majorService.ErMajorQueryDan(Engage_major_release.getHuman_major_id());
			Engage_major_release.setHunma_major_name(cmajor.getMajorname());
			
			
			Salary_standard_details selSalaryone = standardService.selSalaryone(Engage_major_release.getSalary_standard_name());
			int standard_id = selSalaryone.getStandard_id();
			String standard_name = selSalaryone.getStandard_name();
			Engage_major_release.setSalary_standard_name(standard_name);
			Engage_major_release.setSalary_standard_id(standard_id);
			
			IHuman_fileservice.add(Engage_major_release);
			map.put("pd", Engage_major_release.getHuman_id());
		} catch (Exception e) {
			logger.error("人力简历添加", e);
		}
		return "humanResources/register_choose_picture";
	}
	
	@RequestMapping("/upload")
	public String upload(MultipartFile file1,HttpSession session,Config_shang shang){
		try {
		// 获取上传文件的文件名
		String fname = file1.getOriginalFilename();
		// 获取到要上传到文件的路径
		// 1、获取upload文件夹在web项目中的真实路径
		String dir = 
			session.getServletContext().getRealPath("/upload");
//		String dir = "/usr/file_upload";
		// 2、获取上传到文件的的路径
		String fnewname = fname.replace(".", System.currentTimeMillis()+".");
		String fpath = dir +"/" +fnewname;
		System.currentTimeMillis();// 2.jpg 时间.
		// 创建要上传到的文件对象
		File file = new File(fpath);
			// 做上传
			file1.transferTo(file);
			shang.setAttribute_kind(fname);
			shang.setAttribute_name(fnewname);
			config_sahngService.add(shang);
			IHuman_fileservice.update(shang);
		} catch (Exception e) {
			logger.error("上传添加到表", e);
		} 
		return "humanResources/success";
	}
	
	@RequestMapping("/check_list")
	public String check_list(Map map) {
		List<Human_file> human_fileselall = IHuman_fileservice.Humanfileselall();
		map.put("arr", human_fileselall);
		return "humanResources/check_list";
	}
	
	//人力资源档案复核
	@RequestMapping("/human_check")
	public String human_check(String human_id,Map map) {
		List<Human_file> human_fileselall = IHuman_fileservice.Humanfileselall();
		List<Config_public_char> queryall = Config_public_charservice.queryall();
		List<Salary_standard_details> selallSalary = standardService.selSalaryall();
		map.put("arr2", selallSalary);
		map.put("arr1", queryall);
		map.put("human_id", human_id);
		map.put("arr", human_fileselall);
		return "humanResources/human_check";
	}
	//人力资源档案变更
	@RequestMapping("/change_locate")
	public String change_locate(Map map) {
		try {
			List<com.zd.entity.Config_file_first_kind> query = config_file_first_kindService.query();
			List<Config_major_kind> majorQuery = Config_major_kindService.majorQuery();
			map.put("arr", query);
			map.put("arr1", majorQuery);
			} catch (Exception e) {
				logger.error("跳转查询页面", e);
			}
		return "humanResources/change_locate";
	}
	//条件查询
	@RequestMapping("/change_list")
	public String change_list(@RequestParam Map map,Map reqestmap) {
			try {
			String startDate = (String) map.get("utilBean.startDate");
			String endDate = (String) map.get("utilBean.endDate");
			
			SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd");
			Date startDate1 = aDate.parse(startDate);
			Date endDate1 = aDate.parse(endDate);
			map.put("startDate", startDate1);
			map.put("endDate", endDate1);
			List<Human_file> query_list = Human_fileservice.query_list(map);
			reqestmap.put("arr", query_list);
			} catch (Exception e) {
				logger.error("条件查询", e);
			}
			return "humanResources/change_list";
		}
	//人力资源档案删除
	@RequestMapping("/delete_locate")
	public String delete_locate(Map map) {
		try {
			List<com.zd.entity.Config_file_first_kind> query = config_file_first_kindService.query();
			List<Config_major_kind> majorQuery = Config_major_kindService.majorQuery();
			map.put("arr", query);
			map.put("arr1", majorQuery);
			} catch (Exception e) {
				logger.error("跳转查询页面", e);
			}
		return "humanResources/delete_locate";
	}
	
	//删除条件查询
	@RequestMapping("/delete_list")
	public String dlete_list(@RequestParam Map map,Map reqestmap) {
		try {
			String startDate = (String) map.get("utilBean.startDate");
			String endDate = (String) map.get("utilBean.endDate");
			
			SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd");
			Date startDate1 = aDate.parse(startDate);
			Date endDate1 = aDate.parse(endDate);
			map.put("startDate", startDate1);
			map.put("endDate", endDate1);
			List<Human_file> query_list = Human_fileservice.delete_list(map);
			reqestmap.put("arr", query_list);
		} catch (Exception e) {
			logger.error("条件查询", e);
		}
			return "humanResources/delete_list";
		}
	//保存删除
	@RequestMapping("/humanfiledo")
	public String humanfiledo(String human_id) {
		try {
			IHuman_fileservice.delete_update(human_id);
		} catch (Exception e) {
			logger.error("条件查询", e);
		}
			return "redirect:delete_locate";
		}	
}
