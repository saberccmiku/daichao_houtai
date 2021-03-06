package com.daichao.modules.sys.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.daichao.common.entity.Page;
import com.daichao.modules.sys.entity.GeneratorParamEntity;
import com.daichao.modules.sys.entity.TableEntity;
import com.daichao.modules.sys.service.SysGeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 代码生成器
 * @author zcl<yczclcn@163.com>
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {

	@Autowired
	private SysGeneratorService sysGeneratorService;
	
	/**
	 * 表格列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Page<TableEntity> list(@RequestBody Map<String, Object> params) {
		return sysGeneratorService.listTable(params);
	}

	/**
	 * 生成代码
	 * @param params
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/code")
	public void generator(GeneratorParamEntity params, HttpServletResponse response) throws IOException {
		byte[] code = sysGeneratorService.generator(params);
		String attachment = "attachment; filename=" + params.getTables()[0] + ".zip";
		response.reset();  
        response.setHeader("Content-Disposition", attachment);  
        response.addHeader("Content-Length", "" + code.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");  
        IOUtils.write(code, response.getOutputStream());
	}
	
}
