package jp.co.humane.sample.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.humane.sample.validator.impl.MaxValidator;

/**
 * 最大値チェック用アノテーション。
 * @author terada
 *
 */
@Documented
@Constraint(validatedBy = { MaxValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface Max {

    /**
     * メッセージ。
     * @return メッセージ。
     */
    String message() default "{value}以下の値を入力してください。";

    /**
     * 最大値。
     * @return 最大値。
     */
    int value();

    /**
     * グループ。
     * @return グループ。
     */
    Class<?>[] groups() default {};

    /**
     * ペイロード。
     * @return ペイロード。
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * valueアノテーション。
     * @author terada
     *
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        Max[] value();
    }
}
