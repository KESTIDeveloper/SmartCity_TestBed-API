package co.kesti.smartcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalErrorController extends AbstractErrorController {

    private static final String PATH = "/error";

    @Autowired
    public GlobalErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

//    @RequestMapping(value = PATH)
//    public ApiResult<Object> error(HttpServletRequest httpServletRequest) {
//        HttpStatus status = getStatus(httpServletRequest);
//        String reason = status.getReasonPhrase();
//
//        switch (status) {
//            case BAD_REQUEST:
//                return ApiResult.badRequest(reason);
//            case UNAUTHORIZED:
//                return ApiResult.unauthenticated(reason);
//            case FORBIDDEN:
//                return ApiResult.unauthorized(reason);
//            case NOT_FOUND:
//                return ApiResult.notFound(reason);
//            default:
//                return ApiResult.error(reason);
//        }
//    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
