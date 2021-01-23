package demo.dao;

import demo.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 * @author Eric
 * @date 2021/1/16 18:13
 */
public abstract class BaseDao {
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * update()用来执行：Insert、update、delete语句
     *
     * @param sql  sql
     * @param args 占位符
     * @return 受影响行数
     */
    public int update(String sql, Object... args) {
        Connection conn=null;
        try {
             conn = JdbcUtils.getConnection();
            return queryRunner.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return 0;
    }

    /**查询一条结果
     * @param type type
     * @param sql sql
     * @param args 占位符
     * @param <T> 泛型
     * @return 结果集中第一条
     */
    public <T> T queryOne(Class<T> type, String sql, Object... args) {
        Connection conn=null;
        try {
             conn = JdbcUtils.getConnection();
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**查询多条
     * @param type type
     * @param sql SQL
     * @param args 占位符
     * @param <T> 泛型
     * @return 返回结果集
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = null;
        try {
          conn = JdbcUtils.getConnection();
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /** 查询一行一列
     * @param sql sql
     * @param args 填充占位符
     * @return 结果
     */
    public Object querySpecialValue(String sql,Object...args){
        Connection conn=null;
        try {
             conn = JdbcUtils.getConnection();
            return   queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
