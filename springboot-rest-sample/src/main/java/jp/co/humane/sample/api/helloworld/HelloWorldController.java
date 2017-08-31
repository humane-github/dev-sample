package jp.co.humane.sample.api.helloworld;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.humane.sample.common.consts.ResultCode;
import jp.co.humane.sample.common.dto.ApiResult;
import jp.co.humane.sample.common.utils.ValidationUtils;
import jp.co.humane.sample.service.HelloWorldService;

/**
 * サンプルコントローラ
 * @author terada
 *
 */
@RestController
public class HelloWorldController {

    /** サンプルサービス */
    @Autowired
    private HelloWorldService service = null;

    /**
     * サンプルコントローラ処理。
     * @param req    リクエストデータ。
     * @param result バリデーションチェック結果。
     * @return レスポンスデータ。
     */
    @PostMapping("/helloworld")
    @ResponseBody
    public ApiResult<HelloWorldResponse>
        sample(@RequestBody @Valid HelloWorldRequest req, BindingResult result) {

        // レスポンスデータ
        ApiResult<HelloWorldResponse> apiResult = null;

        if (result.hasErrors()) {

            // バリデーションチェック結果がNGの場合は結果コード101を返す。
            apiResult = new ApiResult<>();
            apiResult.setResultCode(ResultCode.VALIDATION_ERROR);
            apiResult.setErrorList(ValidationUtils.getErrorList(result));

        } else {

            // サンプル処理を実施する
            apiResult = doSample(req.getId(), req.getName());
        }

        return apiResult;
    }

    /**
     * サンプル処理を行う。
     * @param id   ID。
     * @param name 名前。
     * @return レスポンスデータ。
     */
    private ApiResult<HelloWorldResponse> doSample(String id, String name) {

        // サービスに処理を委譲する
        String message = service.doSample(id, name);

        // サービス処理結果をレスポンスデータに格納する
        HelloWorldResponse res = new HelloWorldResponse();
        res.setMessage(message);

        ApiResult<HelloWorldResponse> apiResult = new ApiResult<>();
        apiResult.setResultCode(ResultCode.SUCCESS);
        apiResult.setResultInfo(res);

        // レスポンスデータを返却
        return apiResult;
    }
}
