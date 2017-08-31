package jp.co.humane.sample.api.helloworld;

/**
 * サンプルレスポンスデータ。
 * @author terada
 *
 */
public class HelloWorldResponse {

    /** メッセージ */
    private String message = null;

    /**
     * messageを取得する。
     * @return message message。
     */
    public String getMessage() {
        return message;
    }

    /**
     * messageを設定する。
     * @param message message。
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
