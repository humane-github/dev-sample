package jp.co.humane.sample.common.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import jp.co.humane.sample.common.dto.ErrorInfo;

/**
 * バリデーションチェック関連の処理をまとめたクラス。
 * @author terada
 *
 */
public class ValidationUtils {

    /**
     * バリデーションチェック結果からエラー情報を取得する。
     *
     * @param result バリデーションチェック結果。
     * @return エラー情報。
     */
    public static List<ErrorInfo> getErrorList(BindingResult result) {

        List<ErrorInfo> ret = null;

        // 各エラーごとErrorInfoに変換する
        ret = result.getAllErrors().stream().map(error -> {

            // バリデータが生成したエラーメッセージを設定
            ErrorInfo errorInfo = new ErrorInfo();
            errorInfo.setMessage(error.getDefaultMessage());

            // フィールドエラーの場合はフィールド名を格納する
            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                errorInfo.setKeyName(fieldName);
            }

            return errorInfo;

        }).collect(Collectors.toList());

        return ret;
    }

}
