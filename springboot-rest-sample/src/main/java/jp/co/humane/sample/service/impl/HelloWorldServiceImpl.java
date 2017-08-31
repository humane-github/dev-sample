package jp.co.humane.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.humane.sample.common.exception.HelloWorldException;
import jp.co.humane.sample.orm.dao.AccountDAO;
import jp.co.humane.sample.orm.dto.AccountDTO;
import jp.co.humane.sample.service.HelloWorldService;

/**
 * サンプル処理としてDBアクセスを行う。
 * @author terada
 *
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    /** アカウント情報DAO */
    @Autowired
    private AccountDAO dao = null;

    /**
     * サンプル処理としてアカウント情報テーブルのアクセスを行う。
     */
    @Transactional
    @Override
    public String doSample(String strId, String name) {

        Integer id = Integer.valueOf(strId);

        // 指定されたIDのアカウントがいない場合は登録を行う
        AccountDTO account = dao.selectById(id);
        if (null == account) {
            account = new AccountDTO();
            account.setId(id);
            account.setName(name);
            int cnt = dao.add(account);
            if (1 != cnt) {
                throw new HelloWorldException("アカウント登録に失敗");
            }
            return "登録しました";
        }

        // 指定されたIDのアカウントがいる場合は更新を行い、名前の変更内容を返す。
        String message = account.getName().trim() + "から" + name + "に変更";
        account.setName(name);
        int cnt = dao.update(account);
        if (1 != cnt) {
            throw new HelloWorldException("アカウント更新に失敗");
        }
        return message;
    }

}
