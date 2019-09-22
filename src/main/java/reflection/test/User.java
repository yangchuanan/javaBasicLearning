package reflection.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Chuanan YANG
 * @DateTime 2019-09-22 11:50
 * @Descripe User类
 * @Version 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String sex;

}
