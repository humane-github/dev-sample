package jp.co.humane.sample.common.consts;

/**
 * ログメッセージを定義するクラス。
 * @author terada
 *
 */
public class LogId {

    /**
     * 特に決まりがない場合、ログIDは以下の書式とする。
     * [エラーレベル]_[機能名]_[任意]
     *    エラーレベル：E(Error)/W(Warning)/I(Information)/D(Debug)
     *                  ※DebugはログIDで定義せずに出力してもよい
     *    機能名      ：COMMON/AUTH/GET_USERなど
     *                  適宜省略形を使うこと
     *    任意        ：ログ内容を表す名前
     *
     * メッセージの先頭は以下の書式でメッセージIDを設定する。
     * [エラーレベル]_[機能名]_[連番]
     *    エラーレベル：ログIDと同じエラーレベル
     *    機能名      ：ログIDと同じ機能名
     *    連番        ：上から連番を振る。
     */

    /** リクエスト情報 */
    public static final String D_CMN_REQ = "D_CMN_001 リクエストを受け付けました。{}";

    /** 起動ログ */
    public static final String I_CMN_START = "I_CMN_001 アプリケーションが正常に起動しました。version={}、profile={}";

    /** エラー時のリクエスト情報 */
    public static final String I_CMN_ERR_REQ = "I_CMN_002 次のリクエストでエラーが発生しました。{}";

    /** 業務例外 */
    public static final String E_CMN_APP_ERR = "E_CMN_001 業務例外が発生しました。";

    /** 予期せぬエラー */
    public static final String E_CMN_OTHER_ERR = "E_CMN_002 予期せぬエラーが発生しました。";

}
