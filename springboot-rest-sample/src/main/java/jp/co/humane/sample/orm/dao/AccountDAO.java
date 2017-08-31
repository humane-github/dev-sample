package jp.co.humane.sample.orm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.humane.sample.orm.dto.AccountDTO;

/**
 * ACCOUNTテーブルにアクセスするDAO
 * @author terada
 *
 */
public interface AccountDAO {

    /**
     * 全レコードを検索する。
     * @return 全アカウント情報。
     */
    @Select("select * from account")
    public List<AccountDTO> selectAll();

    /**
     * IDを指定してアカウント情報を取得する。
     * @param id ID。
     * @return アカウント情報。
     */
    @Select("select * from account where id = #{id}")
    public AccountDTO selectById(Integer id);

    /**
     * アカウント情報を登録する。
     * @param account アカウント情報。
     * @return 登録レコード数。
     */
    @Insert({
            "insert into account",
            "(",
            "    id,",
            "    name",
            ")",
            "values",
            "(",
            "    #{id},",
            "    #{name}",
            ")"
        })
    public int add(AccountDTO account);


    /**
     * アカウント情報の名前を更新する。
     * @param account アカウント情報。
     * @return 更新レコード数。
     */
    @Update("update account set name = #{name} where id = #{id}")
    public int update(AccountDTO account);


    /**
     * 指定IDのアカウント情報を削除する。
     * @param id ID。
     * @return 削除レコード数。
     */
    @Delete("delete account where id = #{id}")
    public int delete(Integer id);
}
