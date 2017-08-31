package jp.co.humane.sample.service;

/**
 * サンプル処理を行うサービス。
 * @author terada
 *
 */
public interface HelloWorldService {

    /**
     * サンプル処理を実施する。
     * @param id   ID。
     * @param name 名前。
     * @return メッセージ。
     */
    String doSample(String id, String name);
}
