package rsa.secret.test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-05-04 10:33
 * @Descripe 从keystore中提取公钥和私钥
 * @Version 0.0.1
 */
public class ExtractPrivateAndPubTest {
    private static final String keyStoreType = "jks";
    private static final String keystoreFile = "D:\\keystoreTest\\yang.keystore";
    /**keystore的解析密码**/
    private static final String password = "lidongxu";
    /**条目的解析密码**/
    private static final  String friendPassword = "lidongxu";
    /**
     * 条目别名
     */
    private static final String alias = "yangjkstest";
    private static final String exportCertFile = "D:\\keystoreTest\\cert.txt";
    private static final String exportPrivateFile = "D:\\keystoreTest\\privateKey.txt";
    private static final String exportPublicFile = "D:\\keystoreTest\\publicKey.txt";

    /**
     * 导出证书 base64格式
     */
    @Test
    public void exportCert() throws KeyStoreException, IOException,
            CertificateException, NoSuchAlgorithmException {
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(new FileInputStream(keystoreFile), password.toCharArray());
        Certificate certificate = keyStore.getCertificate(alias);
        Base64.Encoder encoder = Base64.getEncoder();
        String encoded = encoder.encodeToString(certificate.getEncoded());
        FileWriter fw = new FileWriter(exportCertFile);
        fw.write("------Begin Certificate----- \r\n ");
        fw.write(encoded);
        fw.write("\r\n-----End Certificate-----");
        fw.close();
    }

    /** 导出公钥 **/
    @Test
    public void extractPrivateKey() throws IOException, KeyStoreException,
            CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(new FileInputStream(keystoreFile), password.toCharArray());

        // 没有设置默认为keystore的密码
        Key key = keyStore.getKey(alias, friendPassword.toCharArray());
        PublicKey publicKey = null;
        if (key instanceof PrivateKey) {
            Certificate certificate = keyStore.getCertificate(alias);
            publicKey = certificate.getPublicKey();
        }

        Base64.Encoder encoder = Base64.getEncoder();
        String encoded = encoder.encodeToString(publicKey.getEncoded());
        FileWriter fileWriter = new FileWriter(exportPublicFile);
        fileWriter.write("-----Begin Public Key-----\r\n");
        fileWriter.write(encoded);
        fileWriter.write("\r\n-----End Public Key-----");
        fileWriter.close();
    }

    @Test
    public void extractPrivatekey() throws UnrecoverableKeyException,
            NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(new FileInputStream(keystoreFile), password.toCharArray());

        // 没有设置默认为keystore的密码
        Key key = keyStore.getKey(alias, friendPassword.toCharArray());
        PrivateKey privateKey=null;
        if (key instanceof PrivateKey) {
            privateKey=(PrivateKey)key;
        }

        Base64.Encoder encoder = Base64.getEncoder();
        String encoded = encoder.encodeToString(privateKey.getEncoded());
        FileWriter fileWriter = new FileWriter(exportPrivateFile);
        fileWriter.write("-----Begin Private Key-----\r\n");
        fileWriter.write(encoded);
        fileWriter.write("\r\n-----End Private Key-----");
        fileWriter.close();
    }
}
