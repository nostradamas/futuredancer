package com.fdw.util.staticHtml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.SimpleHash;
import freemarker.template.Template;

@Component
public class TemplateUtils {

	private FreeMarkerConfigurer freeMarkerConfigurer;

	private String charset;

	/** 日志类 */
	public Log logger = LogFactory.getLog(this.getClass());

	@SuppressWarnings("unchecked")
	public String parse(String templateName, Object model) {
		StringWriter out = null;
		try {
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateName, "UTF-8");
			SimpleHash root = null;
			if (model instanceof Map) {
				root = new SimpleHash((Map<?, ?>) model);
			} else {
				root = new SimpleHash(BeanUtils.describe(model));
			}
			out = new StringWriter();
			template.process(root, out);
		} catch (Throwable e) {
			logger.info("template error<" + templateName + ">");
		}
		return out.toString();
	}

	public boolean createHtml(String str, String filePath, boolean flag) {
		boolean b = false;
		File writeFile = new File(filePath);

		try {
			if (writeFile.exists()) {
				if (flag) {
					writeFile.delete();
					writeFile.createNewFile();
				} else {
					writeFile.createNewFile();
				}
			} else {
				writeFile.delete();
				writeFile.createNewFile();
			}

			OutputStream os = new FileOutputStream(writeFile, true);
			os.write(str.getBytes("utf-8"));
			os.close();
		} catch (IOException e) {
			logger.warn("create html error:" + filePath);
		}

		return b;
	}

	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		return freeMarkerConfigurer;
	}

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

}