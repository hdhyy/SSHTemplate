package com.hit.j2ee.sshTemplate.common.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 自定义返回JSON 数据格中日期格式化处理
*
 * @author px
*/
public class CustomDateSerializer extends JsonSerializer<Date> {


	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
		JsonProcessingException {


		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");


		String formattedDate = formatter.format(value);


		jgen.writeString(formattedDate);

	}

}