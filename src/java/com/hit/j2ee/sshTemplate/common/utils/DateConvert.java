package com.hit.j2ee.sshTemplate.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

/**
 * @author duhw
 * @date:2015年9月27日 下午5:33:22
 */
public class DateConvert implements Converter {

    public Object convert(Class arg0, Object arg1) {
        String p = (String) arg1;
        if (p == null || p.trim().length() == 0) {
            return null;
        }
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.parse(p.trim());
        } catch (Exception e) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                return df.parse(p.trim());
            } catch (ParseException ex) {
                return null;
            }
        }

    }

}
