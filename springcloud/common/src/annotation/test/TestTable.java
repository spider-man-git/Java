package annotation.test;

import java.util.Date;

import annotation.table.ColumnCreate;
import annotation.table.TableCreate;

@TableCreate(tableName = "test_table")
public class TestTable {

    @ColumnCreate(isPrimary = true)
    public Long id;

    @ColumnCreate(isPrimary = true)
    private String name;

    @ColumnCreate(columeType = "int",length = 10)
    private Integer age;

    @ColumnCreate
    private Date createTime;


}
