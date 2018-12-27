package annotation.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zephyr
 *
 * 列名创建注解
 *
 * 声明字段类型，是否是主键，字段类型，字段长度，是否为空，默认值
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnCreate {

    //默认不为空
    boolean isNull() default false;

    //默认为不是主键
    boolean isPrimary() default false;

    //字段类型
    String columeType() default "varchar";

    //默认值
    String defaultColValue() default "";

    int length() default 20;

}
