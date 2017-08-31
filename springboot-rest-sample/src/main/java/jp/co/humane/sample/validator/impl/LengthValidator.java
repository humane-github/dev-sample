package jp.co.humane.sample.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.humane.sample.validator.Length;

/**
 * 文字数チェック用バリデータ。
 * @author terada
 *
 */
public class LengthValidator implements ConstraintValidator<Length, String> {

    /** 最小文字数 */
    private Integer min = null;

    /** 最大文字数 */
    private Integer max = null;

    /**
     * デフォルトコンストラクタ。
     */
    public LengthValidator() {
        super();
    }

    /**
     * 初期化処理。
     */
    @Override
    public void initialize(Length constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }


    /**
     * バリデーションチェック処理。
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // 文字数が指定範囲内の場合はチェックOK。それ以外はチェックNG。
        if (min.intValue() <= value.length() && value.length() <= max.intValue()) {
            return true;
        }
        return false;
    }

}
