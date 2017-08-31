package jp.co.humane.sample.api.helloworld;

import jp.co.humane.sample.validator.Length;
import jp.co.humane.sample.validator.NotEmpty;
import jp.co.humane.sample.validator.NotNull;

/**
 * サンプルリクエストデータ。
 * @author terada
 *
 */
public class HelloWorldRequest {

    /** ID */
    @NotNull
    @NotEmpty
    @Length(min = 1, max = 3)
    private String id = null;

    /** 名前 */
    private String name = null;

    /**
     * idを取得する。
     * @return id id。
     */
    public String getId() {
        return id;
    }

    /**
     * idを設定する。
     * @param id id。
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * nameを取得する。
     * @return name name。
     */
    public String getName() {
        return name;
    }

    /**
     * nameを設定する。
     * @param name name。
     */
    public void setName(String name) {
        this.name = name;
    }
}
