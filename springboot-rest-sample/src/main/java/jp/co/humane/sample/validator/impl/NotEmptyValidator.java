package jp.co.humane.sample.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.humane.sample.validator.NotEmpty;

/**
 * 空文字チェック用バリデータ。
 * @author terada
 *
 */
public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String> {

    /**
     * デフォルトコンストラクタ。
     */
    public NotEmptyValidator() {
        super();
    }

    /**
     * 初期化処理。
     */
    @Override
    public void initialize(NotEmpty constraintAnnotation) {
        return;
    }

    /**
     * バリデーションチェック処理。
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // 空文字の場合はチェックNG。それ以外はチェックOK。
        if (value.length() == 0) {
            return false;
        }
        return true;
    }

}
