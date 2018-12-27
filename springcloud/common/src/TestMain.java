import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import annotation.table.ColumnCreate;
import annotation.table.TableCreate;

/**
 * 测试方法类
 */
public class TestMain {

    static class MapConver {
        static Map<String, String> fieldTypeToColumnType = new HashMap<String, String>() {{
            put("java.lang.Long","bigint");
            put("java.lang.String","varchar");
            put("java.lang.Integer","integer");
            put("java.util.Date","datetime");
            put("java.math.BigDecimal","DECIMAL");
            put("java.lang.Double","DOUBLE");
            put("java.lang.Float","FLOAT");
            put("java.lang.Boolean","BIT");
        }};
    }

    public static void main(String[] args) {
        String basePackage = "annotation.test";
        String classPath = TestMain.class.getResource("/").getPath();
        System.out.println(classPath);

        String test = "userName";
        test.toCharArray();
        for (char byte1 : test.toCharArray()){
//            if (byte1.)
        }

    }


    public void buildTable(String className) {
        try {
            String tableName = "";
            Class aClass = Class.forName(className);
            Field[] fields = aClass.getDeclaredFields();
            Annotation[] annotations = aClass.getDeclaredAnnotations();
            for (Annotation annotation : annotations){
                if(annotation.annotationType().getName().equals("annotation.table.TableCreate")) {
                    TableCreate tableCreate = (TableCreate) annotation;
                    tableName = tableCreate.tableName();
                }
            }
            StringBuffer columnBuffer = new StringBuffer();
            String primaryKey = "";
            for (Field field : fields){
                String columnName = field.getName();
                String columnType = MapConver.fieldTypeToColumnType.get(field.getType().getName());
                Annotation[] annotations1 = field.getDeclaredAnnotations();
                String anColumeType = "";
                String anDefvalue = "";

                boolean anIsNull = false;
                boolean anIsPri = false;
                int length = 0;
                for (Annotation annotation : annotations1){
                    if(annotation.annotationType().getName().equals("annotation.table.ColumnCreate")){
                        ColumnCreate columnCreate = (ColumnCreate) annotation;
                        anColumeType = columnCreate.columeType();
                        anDefvalue = columnCreate.defaultColValue();
                        anIsNull = columnCreate.isNull();
                        anIsPri = columnCreate.isPrimary();
                        length = columnCreate.length();
                    }
                }
                String isEmpty = anIsNull?"":"NOT NULL";
                primaryKey = anIsPri?(primaryKey+columnName+","):primaryKey;
                String column = "`"+columnName+"` "+columnType+"("+length+") "+isEmpty+" ,";
                columnBuffer.append(column);
            }
            //拼接一个完整的SQL
            String sql = "CREATE TABLE `"+tableName+"` ("+columnBuffer.toString()+"PRIMARY KEY ("+primaryKey.substring(0,primaryKey.lastIndexOf(","))+ ")) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
            System.out.println(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
