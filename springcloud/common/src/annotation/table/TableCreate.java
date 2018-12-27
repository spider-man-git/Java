package annotation.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zephyr
 *
 * 表创建注解，方便使用的时候能够直接写出建表语句
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableCreate {

    //表名
    String tableName();

}
