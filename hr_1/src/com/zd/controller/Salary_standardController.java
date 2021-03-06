package com.zd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.entity.zm_some;
import com.zd.service.IConfig_public_charservice;
import com.zd.service.IStandardService;
/**
 * 
 * @author 张敏
 * Salary_standardController
 *
 */
@Controller
public class Salary_standardController {

	@Autowired
	private IConfig_public_charservice Config_public_charService;
	@Autowired
	private IStandardService StandardService;
	
	//去网页的Controller
	@RequestMapping({"salaryCriterion/salarystandard_query_locate","salaryCriterion/salarystandard_change_locate"})
	public String topage(HttpServletRequest Request) {
		String path = Request.getServletPath();
		path = path.substring(1, path.length());
		return path;
	}
	
	//查询去tosalarystandard_register的内容
	@RequestMapping("/tosalarystandard_register")
	public String tosalarystandard_register(Map<String, Object> map) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			//实现查询功能
			List<Config_public_char> charlist = Config_public_charService.selsalary();
			//生成时间戳
			Long timeid = System.currentTimeMillis();
			//将页面需要的数据通过map发送过去
			map.put("timeid", timeid);
			map.put("charlist", charlist);
			map.put("charlist_size", charlist.size());
		} catch (Exception e) {
			log.error("跳转tosalarystandard_register.jsp失败",e);
		}
		//发送到salarystandard_register.jsp
		return "salaryCriterion/salarystandard_register";
	}
	
	//添加一个薪酬标准信息
	@RequestMapping("/addSalary_standard")
	public String addSalary_standard(Salary_standard salary_standard,@RequestParam Map xcxmMap) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			StandardService.addstandard(salary_standard);
			String Standard_id = salary_standard.getStandard_id();
			Map moneyMap = new HashMap<>();
			// 获取map中的所有键 1 money_1 2  money_2
			Set<String> keySet = xcxmMap.keySet();
			for (String key : keySet) {
				// 如果键是以money_开始的就是我们需要的键
				if(key.startsWith("money_")) {
					// 获取id,对键进行分割
					int  xcbzId = Integer.parseInt(key.split("_")[1]);
					// 获取金额
					double money = Double.parseDouble((String)xcxmMap.get(key));
					moneyMap.put("pbc_id", xcbzId);
					moneyMap.put("money", money);
					moneyMap.put("standard_id", Standard_id);
					// 添加
					StandardService.addzm_some(moneyMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加失败",e);
		}
		return "salaryCriterion/salarystandard_register_success";
	}

	//查询去salarystandard_check_list的内容(首页)
	@RequestMapping("/selallSalary")
	public String selallSalary(Map<String,Object> map) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0; //总页数
			int start = 1; //当前页
			int count = StandardService.selallSalary_count();
			map.put("count", count);
			if(count%10==0) {
				total = count/10;
				map.put("total", total);
			}else {
				total = count/10+1;
				map.put("total", total);
			}
			map.put("start", start);
		List<Salary_standard> salary_standards = StandardService.selallSalary((start-1)*10);
		map.put("salary_standards", salary_standards);
		} catch (Exception e) {
			log.error("跳转首页失败",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//尾页薪酬标准信息
	@RequestMapping("/tolast")
	public String tolast(Map<String, Object> map) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//总页数
			int start = 1;//当前页
			int count = //获取总数
					StandardService.selallSalary_count();
			map.put("count", count);
			if(count%10==0) {
				total = count/10;
				map.put("total", total);
			}else {
				total = count/10+1;
				map.put("total", total);
			}
			map.put("start", total);
			List<Salary_standard> salary_standards = StandardService.selallSalary((total-1)*10);
			map.put("salary_standards", salary_standards);
		} catch (Exception e) {
			log.error("跳转尾页失败",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//上一页薪酬标准信息
	@RequestMapping("/toup")
	public String toup(Map<String, Object> map,int start) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//总页数
			int count = //获取总数
					StandardService.selallSalary_count();
			map.put("count", count);
			if(count%10==0) {
				total = count/10;
				map.put("total", total);
			}else {
				total = count/10+1;
				map.put("total", total);
			}
			map.put("start", start-1);
			List<Salary_standard> salary_standards = StandardService.selallSalary((start-2)*10);
			map.put("salary_standards", salary_standards);
		} catch (Exception e) {
			log.error("跳转上一页失败",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//下一页薪酬标准信息
	@RequestMapping("/todown")
	public String todown(Map<String, Object> map,int start) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//总页数
			int count = //获取总数
					StandardService.selallSalary_count();
			map.put("count", count);
			if(count%10==0) {
				total = count/10;
				map.put("total", total);
			}else {
				total = count/10+1;
				map.put("total", total);
			}
			map.put("start", start+1);
			List<Salary_standard> salary_standards = StandardService.selallSalary((start)*10);
			map.put("salary_standards", salary_standards);
		} catch (Exception e) {
			log.error("跳转下一页失败",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//页面跳转薪酬标准信息
	@RequestMapping("/tojump")
	public String tojump(Map<String, Object> map,int pages) {
			Logger log = LoggerFactory.getLogger(Salary_standardController.class);
			try {
				int count = //获取信息总数
						StandardService.selallSalary_count();
				map.put("count", count);
				if(count%10==0) {
					int total = count/10;
					map.put("total", total);
				}else {
					int  total = count/10+1;
					map.put("total", total);
				}
				map.put("start", pages);
				List<Salary_standard> salary_standards = StandardService.selallSalary((pages-1)*10);
				map.put("salary_standards", salary_standards);
			} catch (Exception e) {
				log.error("页面跳转失败",e);
			}
			return "salaryCriterion/salarystandard_check_list";
		}	
	
	//进复核查询单条信息
	@RequestMapping("/selone_Salary_standard")
	public String selone_Salary_standard(int ssd_id,Map<String, Object> map,String standard_id) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			//查询基本信息
			Salary_standard salary_standard = 
					StandardService.selone_Salary_standard(ssd_id);
			map.put("salary_standard", salary_standard);
			//进复核查询单条信息--项目信息
			List<zm_some> zm_somelist =  StandardService.selone_zmsome(standard_id);
			map.put("zm_somelist", zm_somelist);
			map.put("zm_somelist_size", zm_somelist.size());
		} catch (Exception e) {
			log.error("页面跳转失败",e);
		}
		return "salaryCriterion/salarystandard_check";
	}
	
	//审核
	@RequestMapping("/updfuhe")
	public String updfuhe(Salary_standard salary_standard,@RequestParam Map map) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			//修改基本信息
			StandardService.updfuhe(salary_standard);
			//获取修改和添加的map
			Map<String, Object> updmap = new HashMap<>();
			Map<String, Object> addmap = new HashMap<>();
			//获取编号
			String standard_id = salary_standard.getStandard_id();
			String standard_name = salary_standard.getStandard_name();
			//获取id 和 钱数
			Set<String> keyset = map.keySet();
			for (String key : keyset) {
				if(key.startsWith("x_")) {
					int pbc_id = Integer.parseInt(key.split("_")[1]);
					double money = Double.parseDouble((String)map.get(key));
					updmap.put("pbc_id", pbc_id);
					updmap.put("money", money);
					updmap.put("standard_id", standard_id);
					//实现修改项目钱数
					StandardService.updfuhe2(updmap);
					//获取添加项目需要的信息
					Config_public_char attribute = Config_public_charService.selfuhe(pbc_id);
					String attribute_name = attribute.getAttribute_name();
					addmap.put("item_id", pbc_id);
					addmap.put("item_name", attribute_name);
					addmap.put("salary", money);
					addmap.put("standard_id", standard_id);
					addmap.put("standard_name", standard_name);
					//实现添加功能
					StandardService.addfuhe(addmap);
				}
			}
		} catch (Exception e) {
			log.error("审核失败",e);
		}
		return "salaryCriterion/salarystandard_check_success";
	}
	
	//分页查询
	@RequestMapping("salaryCriterion/selstatus")
	public String selstatus(@RequestParam Map<String,Object> map,Map<String, Object> selmap,Map<String,Object> sjmap) {
		int total = 0;
		selmap.put("standard_id", map.get("standard_id"));
		selmap.put("gjz", map.get("gjz"));
		selmap.put("minday", map.get("minday"));
		selmap.put("maxday", map.get("maxday"));
		selmap.put("start", map.get("start"));
		
		String startstr = (String)map.get("start");
		int startint = Integer.parseInt(startstr);
		map.put("start", startint*10);
		List<Salary_standard> salary_standardslist = StandardService.selstatus1(map);
		selmap.put("salary_standardslist", salary_standardslist);
		int li = StandardService.selcount(selmap);
		if(li % 10 == 0) {
			total = li/10;
			selmap.put("total", total);
		} else {
			total = li/10+1;
			selmap.put("total", total);
		}
		selmap.put("li", li);
		sjmap.put("starttrue", startint+1);
		return "salaryCriterion/salarystandard_query_list";
	}
	
	//根据编号查询详情信息
	@RequestMapping("salaryCriterion/selbystandard_id")
	public String selbystandard_id(String standard_id,Map<String, Object> map) {
		Salary_standard salary_standard = StandardService.selbyid(standard_id);
		map.put("salary_standard", salary_standard);
		List<zm_some> zm_somelist =  StandardService.selone_zmsome(standard_id);
		map.put("zm_somelist", zm_somelist);
		return "salaryCriterion/salarystandard_query";
	}
	
	//薪酬标准查询变更——模糊查询
	@RequestMapping("salaryCriterion/selzt2")
	public String selzt2(@RequestParam Map map,Map<String, Object> infomap,Map<String, Object> umap) {
		String maxday = (String)map.get("maxday");
		String minday = (String)map.get("minday");
		String gjz = (String)map.get("gjz");
		String id = (String)map.get("standard_id");
		int startPage = 0;
		umap.put("maxday", maxday);
		umap.put("minday", minday);
		umap.put("gjz", gjz);
		umap.put("standard_id", id);
		umap.put("page.startPage", startPage);
		List<Salary_standard> salary_standardslist = StandardService.selstatus2(umap);
		infomap.put("salary_standardslist", salary_standardslist);
		infomap.put("size", salary_standardslist.size());
		umap.put("maxday", maxday);
		umap.put("minday", minday);
		umap.put("gjz", gjz);
		umap.put("standard_id", id);
		return "salaryCriterion/salarystandard_change_list";
	}
	
	//根据编号查询详情信息
		@RequestMapping("salaryCriterion/selbysid")
		public String selbysid(Map<String, Object> map,@RequestParam Map map1) {
			String maxday = (String)map1.get("maxday");
			String minday = (String)map1.get("minday");
			String gjz = (String)map1.get("gjz");
			String id = (String)map1.get("id");
			map.put("maxday", maxday);
			map.put("minday", minday);
			map.put("gjz", gjz);
			map.put("id", id);
			String standard_id = (String)map1.get("standard_id");
			Salary_standard salary_standard = StandardService.selbyid(standard_id);
			map.put("salary_standard", salary_standard);
			List<zm_some> zm_somelist =  StandardService.selone_zmsome(standard_id);
			map.put("zm_somelist", zm_somelist);	
			map.put("zm_somelist_size", zm_somelist.size());
			return "salaryCriterion/salarystandard_change";
		}
		
		//变更
		@RequestMapping("salaryCriterion/updbiangeng")
		public String updbiangeng(Salary_standard salary_standard,@RequestParam Map map,Map<String, Object> map1) {
			//获取编号
			String maxday = (String)map.get("maxday");
			String minday = (String)map.get("minday");
			String gjz = (String)map.get("gjz");
			String id = (String)map.get("id");
			map1.put("maxday", maxday);
			map1.put("minday", minday);
			map1.put("gjz", gjz);
			map1.put("standard_id", id);
			String standard_id = salary_standard.getStandard_id();
			StandardService.updbiangeng(salary_standard);
			Map<String, Object> updmap = new HashMap<>();
				//修改基本信息
				//获取id 和 钱数
				Set<String> keyset = map.keySet();
				for (String key : keyset) {
					if(key.startsWith("x_")) {
						int pbc_id = Integer.parseInt(key.split("_")[1]);
						double money = Double.parseDouble((String)map.get(key));
						updmap.put("pbc_id", pbc_id);
						updmap.put("money", money);
						updmap.put("standard_id", standard_id);
						StandardService.updfuhe2(updmap);
					}
				}
				
			return "salaryCriterion/salarystandard_change_success";
		}
}
