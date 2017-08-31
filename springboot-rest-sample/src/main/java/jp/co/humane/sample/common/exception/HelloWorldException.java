package jp.co.humane.sample.common.exception;

/**
 * サンプルの例外クラス。
 * @author terada
 *
 */
public class HelloWorldException extends RuntimeException {

    /**
     * デフォルトコンストラクタ。
     */
    public HelloWorldException() {
        super();
    }

    /**
     * メッセージ指定ありのコンストラクタ。
     * @param message メッセージ。
     */
    public HelloWorldException(String message) {
        super(message);
    }

    /**
     * 例外指定ありのコンストラクタ。
     * @param ex 例外。
     */
    public HelloWorldException(Throwable ex) {
        super(ex);
    }

    /**
     * メッセージ、例外指定ありのコンストラクタ。
     * @param message メッセージ。
     * @param ex 例外。
     */
    public HelloWorldException(String message, Throwable ex) {
        super(message, ex);
    }

}
