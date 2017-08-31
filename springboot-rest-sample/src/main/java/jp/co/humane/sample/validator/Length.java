package jp.co.humane.sample.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.humane.sample.validator.impl.LengthValidator;

/**
 * 文字列長チェック用アノテーション。
 * @author terada
 *
 */
@Documented
@Constraint(validatedBy = { LengthValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface Length {

    /**
     * メッセージ。
     * @return メッセージ。
     */
    String message() default "入力値は{min}文字以上{max}文字以下としてください。";

    /**
     * 最小文字数。
     * @return 最小文字数。
     */
    int min() default 0;

    /**
     * 最大文字数。
     * @return 最大文字数。
     */
    int max() default Integer.MAX_VALUE;

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
        Length[] value();
    }
}
