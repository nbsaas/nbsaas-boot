package com.nbsaas.boot.security.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;

public class PasswordUtils {

    public static int hashIterations = 2048;

    public static PasswordResponse password(String password) {
        RandomNumberGenerator generator = new SecureRandomNumberGenerator();
        ByteSource salt = generator.nextBytes(32);
        Sha256Hash sha256Hash = new Sha256Hash(password, salt, hashIterations);
        return PasswordResponse.builder().password(sha256Hash.toBase64()).salt(salt.toBase64()).build();
    }

    public static PasswordResponse password(String password, String salt) {
        ByteSource byteSource = ByteSource.Util.bytes(Base64.decode(salt));
        ;
        Sha256Hash sha256Hash = new Sha256Hash(password, byteSource, hashIterations);
        return PasswordResponse.builder().password(sha256Hash.toBase64()).salt(byteSource.toBase64()).build();
    }

    public static PasswordResponse passwordMd5(String password) {
        RandomNumberGenerator generator = new SecureRandomNumberGenerator();
        ByteSource salt = generator.nextBytes(32);
        Md5Hash sha256Hash = new Md5Hash(password, salt, hashIterations);
        return PasswordResponse.builder().password(sha256Hash.toBase64()).salt(salt.toBase64()).build();
    }

    public static PasswordResponse passwordMd5(String password, String salt) {
        ByteSource byteSource = ByteSource.Util.bytes(Base64.decode(salt));
        Md5Hash sha256Hash = new Md5Hash(password, byteSource, hashIterations);
        return PasswordResponse.builder().password(sha256Hash.toBase64()).salt(byteSource.toBase64()).build();
    }

    public static String md5(String password) {
        Md5Hash sha256Hash = new Md5Hash(password);
        return sha256Hash.toBase64();
    }

    public static void main(String[] args) {
        String salt = "OXDAKzTHAGjsBTWG6HVOg1diEzhDhGdMRzj59ztzTwk=";
        System.out.println(password("123456"));
        System.out.println(md5("123456"));
        System.out.println(passwordMd5("123456"));
        System.out.println(passwordMd5("123456", salt));
        System.out.println(password("123456", salt));

    }
}
