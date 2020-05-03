package rsa.secret.test;

import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-05-03 23:27
 * @Descripe 公钥加密，私钥解密
 * @Version 0.0.1
 */
public class RsaSecretTest {

    @Test
    public void certificateTest() throws CertificateException, IOException,
            NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException,
            IllegalBlockSizeException, InvalidKeyException, KeyStoreException,
            UnrecoverableKeyException {
        final String alias = "lidongxutest";
        //秘钥库密码/证书密码
        final String keystore_password = "lidongxu";
        final String ca_password = "lidongxu";


        //公钥证书的编码格式是x509
        /*lidongtest.cer中提取公钥*/
        X509Certificate x509Certificate;
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream("D:\\keystoreTest\\lidongtest.cer");
        x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fis);
        fis.close();

        /*==========使用公钥加密============*/
        Key key = x509Certificate.getPublicKey();
        System.out.println("获取公钥为："+key.toString());
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal("helloworld".getBytes());
        System.out.println("加密结果: " + Base64.getEncoder().encodeToString(bytes));


        /*提取秘钥*/
        // 读入keystore
        fis = new FileInputStream("D:\\keystoreTest\\yang.keystore");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(fis, keystore_password.toCharArray());
        fis.close();

        // 提取lidongxutest 的私钥
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, ca_password.toCharArray());
        System.out.println("获取私钥钥为："+privateKey.toString());

        /*=======使用私钥解密=========*/
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        bytes = cipher.doFinal(bytes);
        System.out.println("解密： " + new String(bytes));
    }
}
