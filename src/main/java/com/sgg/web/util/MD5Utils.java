package com.sgg.web.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {

    public static String md5(String data) {
        return DigestUtils.md5Hex(data);
    }

}
