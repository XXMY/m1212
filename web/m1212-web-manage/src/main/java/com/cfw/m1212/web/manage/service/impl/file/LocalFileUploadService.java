package com.cfw.m1212.web.manage.service.impl.file;

import com.cfw.m1212.server.commons.utils.FileUtils;
import com.cfw.m1212.web.manage.service.file.AbstractFileUploadService;
import com.cfw.m1212.web.manage.service.file.FileUploadService;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@Component("fileUploadHandler")
public class LocalFileUploadService extends AbstractFileUploadService implements FileUploadService {

	/**
	 * 将输入流写出到本地目标文件
	 * 
	 * @param source					原文件输入流
	 * @param output					目标文件名
	 * @throws IOException
	 */
	@Override
	protected void write(InputStream source, String output) throws IOException {
		
		FileUtils.createDirectory(FileUtils.truncateFilePath(output));

		org.apache.commons.io.FileUtils.copyInputStreamToFile(source, new File(output));
	}

}
