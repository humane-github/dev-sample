package jp.co.humane.sample.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.humane.sample.validator.NotNull;

/**
 * Nullチェック用バリデータ。
 * @author terada
 *
 */
public class NotNullValidator implements ConstraintValidator<NotNull, String> {

    /**
     * デフォルトコンストラクタ。
     */
    public NotNullValidator() {
        super();
    }

    /**
     * 初期化処理。
     */
    @Override
    public void initialize(NotNull constraintAnnotation) {
        return;
    }

    /**
     * バリデーションチェック処理。
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // nullの場合はチェックNG。それ以外はチェックOK。
        if (null == value) {
            return false;
        }
        return true;
    }

}