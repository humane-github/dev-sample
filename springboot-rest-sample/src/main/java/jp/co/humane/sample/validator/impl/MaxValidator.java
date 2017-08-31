package jp.co.humane.sample.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.humane.sample.validator.Min;

/**
 * 最大値チェック用バリデータ。
 * @author terada
 *
 */
public class MaxValidator implements ConstraintValidator<Min, Integer> {

    /** 最大値 */
    private Integer max = null;

    /**
     * デフォルトコンストラクタ。
     */
    public MaxValidator() {
        super();
    }

    /**
     * 初期化処理。
     */
    @Override
    public void initialize(Min constraintAnnotation) {
        this.max = constraintAnnotation.value();
    }

    /**
     * バリデーションチェック処理。
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        // 文字数が最大値以上の場合はチェックOK。それ以外はチェックNG。
        if (value.intValue() <= max.intValue()) {
            return true;
        }
        return false;
    }

}
