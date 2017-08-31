package jp.co.humane.sample.orm.dto;

public class AccountDTO {

    /** Id */
    private Integer id = null;

    /** 名前 */
    private String name = null;

    /**
     * デフォルトコンストラクタ。
     */
    public AccountDTO() {
        super();
    }

    /**
     * idを取得する。
     * @return id id。
     */
    public Integer getId() {
        return id;
    }

    /**
     * idを設定する。
     * @param id id。
     */
    public void setId(Integer id) {
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
