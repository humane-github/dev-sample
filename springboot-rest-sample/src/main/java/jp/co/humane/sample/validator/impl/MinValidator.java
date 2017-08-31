package jp.co.humane.sample.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.humane.sample.validator.Min;

/**
 * 最小値チェック用バリデータ。
 * @author terada
 *
 */
public class MinValidator implements ConstraintValidator<Min, Integer> {

    /** 最小値 */
    private Integer min = null;

    /**
     * デフォルトコンストラクタ。
     */
    public MinValidator() {
        super();
    }

    /**
     * 初期化処理。
     */
    @Override
    public void initialize(Min constraintAnnotation) {
        this.min = constraintAnnotation.value();
    }

    /**
     * バリデーションチェック処理。
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        // 文字数が最小値以上の場合はチェックOK。それ以外はチェックNG。
        if (min.intValue() <= value.intValue()) {
            return true;
        }
        return false;
    }

}
