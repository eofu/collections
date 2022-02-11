package com.myself.test.ToAppTest.TestUtil;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 编码工具类
 * 1.将byte[]转为各种进制的字符串
 * 2.base 64 encode
 * 3.base 64 decode
 * 4.获取byte[]的md5值
 * 5.获取字符串md5值
 * 6.结合base64实现md5加密
 * 7.AES加密
 * 8.AES加密为base 64 code
 * 9.AES解密
 * 10.将base 64 code AES解密
 *
 * @author uikoo9
 * @version 0.0.7.20140601
 */
@Slf4j
public class EncryptUtils {
    
    // 密码盐
    public static final String PWDSALT = "PAY";
    private static final Logger LOG = LoggerFactory.getLogger(EncryptUtils.class);
    
    /**
     * 私有构造方法,将该工具类设为单例模式.
     */
    private EncryptUtils() {
    
    }
    
    /**
     * @param shaCode
     * @param password
     * @param salt
     * @return
     */
    public static boolean equalShaCode(String shaCode, String password, String salt) {
        if (shaCode == null) {
            return false;
        }
        return shaCode.equalsIgnoreCase(encodeSHA(password, salt));
    }
    
    /**
     * 用SHA算法进行加密
     *
     * @param str  需要加密的字符串
     * @param salt 加密盐
     * @return SHA加密后的结果
     */
    public static String encodeSHA(String str, String salt) {
        if (salt != null) {
            str = str + salt;
        }
        return encodeSHAString(str);
    }
    
    /**
     * 用SHA算法进行加密
     *
     * @param str 需要加密的字符串
     * @return SHA加密后的结果
     */
    public static String encodeSHAString(String str) {
        return encode(str, "SHA");
    }
    
    private static String encode(String str, String method) {
        return encode(str, method, false);
    }
    
    /**
     * @param str
     * @param method
     * @param upcaseByRand 根据随机码生成大小写
     * @return
     */
    private static String encode(String str, String method, boolean upcaseByRand) {
        MessageDigest mdInst = null;
        if (str == null) {
            return "";
        }
        str = str.trim();
        // 把密文转换成十六进制的字符串形式
        // 单线程用StringBuilder，速度快 多线程用stringbuffer，安全
        StringBuilder dstr = new StringBuilder();
        Random random = null;
        if (upcaseByRand) {
            random = new Random();
        }
        try {
            // 获得MD5摘要算法的 MessageDigest对象
            mdInst = MessageDigest.getInstance(method);
            // 使用指定的字节更新摘要
            mdInst.update(str.getBytes());
            // 获得密文
            byte[] md = mdInst.digest();
            for (int i = 0; i < md.length; i++) {
                int tmp = md[i];
                if (tmp < 0) {
                    tmp += 256;
                }
                if (tmp < 16) {
                    dstr.append("0");
                }
                String item = Integer.toHexString(tmp);
                if (upcaseByRand && random.nextInt(10) % 2 == 0) {
                    item = item.toUpperCase();
                }
                dstr.append(item);
            }
        } catch (NoSuchAlgorithmException e) {
            LOG.error(e.getMessage(), e);
        }
        return dstr.toString();
    }
    
    /**
     * 密码编码加密，如果有加密盐，那么使用SHA加密。否则使用MD5
     *
     * @param password
     * @param salt
     * @return
     */
    public static String encodePasswordWithMd5OrSha(String password, String salt) {
        if (StringUtils.isEmpty(salt)) {
            return md5(password);
        }
        return encodeSHA(password, salt);
    }
    
    /**
     * 验证密码是否匹配，如果有加密盐，那么使用的是sha加密。否则使用md5加密。主要用于兼容老旧密码
     *
     * @param shaCode
     * @param password
     * @param salt
     * @return
     */
    public static boolean equalPasswordWithMd5OrSha(String shaCode, String password, String salt) {
        if (shaCode == null) {
            return false;
        }
        if (StringUtils.isEmpty(salt)) {
            return shaCode.equalsIgnoreCase(md5(password));
        }
        return shaCode.equalsIgnoreCase(encodeSHA(password, salt));
    }
    
    /**
     * 用base64算法进行加密
     *
     * @param str 需要加密的字符串
     * @return base64加密后的结果
     */
    public static String encodeBase64String(String str) {
        
        return Base64.encodeBase64String(str.getBytes(StandardCharsets.UTF_8));
    }
    
    /**
     * url地址base64 转码处理
     *
     * @param url
     * @return
     */
    public static String safeUrlBase64Encode(String url) {
        if (url == null) {
            return null;
        }
        return Base64.encodeBase64URLSafeString(url.getBytes(StandardCharsets.UTF_8));
    }
    
    /**
     * url地址base64 解码处理
     *
     * @param url
     * @return
     */
    public static String safeUrlBase64Decode(String url) {
        byte[] result = Base64.decodeBase64(url.getBytes(Charsets.US_ASCII));
        return org.apache.commons.codec.binary.StringUtils.newStringUtf8(result);
    }
    
    /**
     * 用base64算法进行解密
     *
     * @param str 需要解密的字符串
     * @return base64解密后的结果
     * @throws IOException
     */
    public static String decodeBase64String(String str) throws IOException {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        return decodeBase64String(Base64.decodeBase64(str));
    }
    
    /**
     * 用base64算法进行解密
     *
     * @param str 需要解密的字符串
     * @return base64解密后的结果
     * @throws IOException
     */
    public static String decodeBase64String(byte[] str) throws IOException {
        
        return new String(str, StandardCharsets.UTF_8);
    }
    
    /**
     * 加密
     *
     * @param datasource Utf8 字符串
     * @param password   Utf8 字符串
     * @return base64 String
     */
    public static String encryptByDes(String datasource, String password) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] data = datasource.getBytes(StandardCharsets.UTF_8);
            DESKeySpec desKey = new DESKeySpec(password.getBytes(StandardCharsets.UTF_8));
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            // 正式执行加密操作
            byte[] result = cipher.doFinal(data);
            
            return encodeBase64String(result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 用base64算法进行加密
     *
     * @param str 需要加密的字符串
     * @return base64加密后的结果
     */
    public static String encodeBase64String(byte[] str) {
        return Base64.encodeBase64String(str);
    }
    
    /**
     * 解密
     *
     * @param src      base64 String
     * @param password Utf8  String
     * @return Utf8 字符串
     * @throws Exception
     */
    public static String decryptByDes(String src, String password) {
        try {
            byte[] encryptBytes = Base64.decodeBase64(src);
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(password.getBytes(StandardCharsets.UTF_8));
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            byte[] result = cipher.doFinal(encryptBytes);
            return new String(result, StandardCharsets.UTF_8);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 用MD5算法进行加密
     *
     * @param sourse 需要加密的字符串
     * @return MD5加密后的结果
     */
    public static String md5(String sourse) {
        return encode(sourse, "MD5");
    }
    
    public static String md5Encrypt(String secretKey, String originalString) {
        return md5Encrypt(originalString + secretKey);
    }
    
    /**
     * MD5算法加密字符串
     *
     * @param originalString 需要加密的字符串
     * @return 加密之后的字符串(16进制格式)
     **/
    public static String md5Encrypt(String originalString) {
        
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(originalString.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            log.error("md5编码失败", e);
        }
        final byte[] encrypted = messageDigest.digest();
        return toHexString(encrypted);
    }
    
    /**
     * 字节数组转成16进制表示格式的字符串
     *
     * @param byteArray 需要转换的字节数组
     * @return 16进制表示格式的字符串
     **/
    public static String toHexString(byte[] byteArray) {
        
        final StringBuilder hexString = new StringBuilder();
        for (byte aByteArray : byteArray) {
            if ((aByteArray & 0xff) < 0x10) {
                hexString.append("0");
            }
            hexString.append(Integer.toHexString(0xFF & aByteArray));
        }
        return hexString.toString().toLowerCase();
    }
    
    /**
     * 用MD5算法进行加密
     *
     * @param sourse       需要加密的字符串
     * @param upcaseByRand 随机大小写（生成accesstoken时有效）
     * @return MD5加密后的结果
     */
    public static String md5(String sourse, boolean upcaseByRand) {
        return encode(sourse, "MD5", upcaseByRand);
    }
    
    public static String to64BitString(Long code) {
        if (code == null) {
            return "0";
        }
        String randStr = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int size = randStr.length();
        String result = "";
        Integer index = ((Long) (code % size)).intValue();
        code = code / size;
        while (code != 0) {
            result = randStr.charAt(index) + result;
            index = ((Long) (code % size)).intValue();
            code = code / size;
        }
        return result;
    }
    
    
    /**
     * 生成md5编码
     *
     * @param str
     * @param upcaseByRand
     * @return
     */
    public static String encodeMD5String(String str, boolean upcaseByRand) {
        return encode(str, "MD5", upcaseByRand);
    }
    
    public static String createVerifyCode(int len) {
        return createRandCode(len, "0123456789");
    }
    
    /**
     * 生成指定长度的随机码
     *
     * @param len
     * @param randStr
     * @return
     */
    public static String createRandCode(int len, String randStr) {
        if (StringUtils.isEmpty(randStr)) {
            randStr = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        Random random = new Random();
        String result = "";
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(randStr.length());
            result = result + randStr.charAt(index);
        }
        return result;
    }
    
    public static String createRandCode(int len) {
        return createRandCode(len, null);
    }
    
    public static String createPasswordCode(int len) {
        return createRandCode(len, "abcdefghkmnpqrtwxy23456789ABCDEFGHKLMNPQRSTWXY");
    }
    
    public static String formatOpenId(Long userId) {
        String result = "";
        byte[] userIdBytes = userId.toString().getBytes(StandardCharsets.UTF_8);
    
        String src = Base64.encodeBase64URLSafeString(userIdBytes);
        int length = src.length();
        if (length == 27) {
            return src + "_";
        } else if (length < 27) {
            length = 27 - length;
            src = src + "_" + createRandCode(length, null);
        }
        result = src;
        return result;
    }
    
    
    public static String encryptGeneralAES(String content, String key, String ivString)
            throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, UnsupportedEncodingException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
// 注意，为了能与 iOS 统一
// 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
        byte[] enCodeFormat = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
        byte[] initParam = ivString.getBytes();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encryptedBytes = cipher.doFinal(byteContent);
        return new String(Base64.encodeBase64(encryptedBytes));
    }
    
    public static String decryptGeneralAES(String content, String key, String ivString)
            throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        // base64 解码
        byte[] encryptedBytes = Base64.decodeBase64(content.getBytes(StandardCharsets.UTF_8));
        byte[] enCodeFormat = key.getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
        byte[] initParam = ivString.getBytes();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] result = cipher.doFinal(encryptedBytes);
        return new String(result, StandardCharsets.UTF_8);
    }
    
    /**
     * 校验密码
     * 1、6~20位
     * 2、同时包含数字和大小写字母
     *
     * @param pwd
     * @return
     */
    public static boolean checkPwd(String pwd) {
        int length = pwd.length();
        if (length < 6 || length > 20) {
            return false;
        }
        String reg = "^(?![0-9A-Z]+$)(?![0-9a-z]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
        Pattern pattern = Pattern.compile(reg);
        Matcher match = pattern.matcher(pwd);
        return match.matches();
    }
}
