package ExceptionTest;

/**
 * @Author Chuanan YANG
 * @DateTime 2019-10-27 12:31
 * @Descripe 业务异常类 应当关闭抑制异常，和关闭保存堆栈信息，提升程序性能
 * 业务异常不应该很明确，直接用字符串代替异常。
 * @Version 0.0.1
 */
public class BusinessException extends Exception {

    BusinessException(String message,boolean enableSuppression){
        // 业务异常可以不获取堆栈信息，提升程序性能
        // enableSuppression 如果为false表示关闭抑制异常，即被抑制的异常不会保留，true保留了被抑制的异常
        super(message, new Exception(), enableSuppression, false);
    }

    public static void main(String[] args) throws BusinessException {
        throw new BusinessException("testException",false);
    }
}
