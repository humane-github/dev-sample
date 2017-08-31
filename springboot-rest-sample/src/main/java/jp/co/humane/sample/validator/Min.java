package jp.co.humane.sample.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.humane.sample.validator.impl.MinValidator;

/**
 * 最小値チェック用アノテーション。
 * @author terada
 *
 */
@Documented
@Constraint(validatedBy = { MinValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface Min {

    /**
     * メッセージ。
     * @return メッセージ。
     */
    String message() default "{value}以上の値を入力してください。";

    /**
     * 最小値。
     * @return 最小値。
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
        Min[] value();
    }
}
