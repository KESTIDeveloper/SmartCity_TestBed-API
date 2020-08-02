package co.kesti.smartcity.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.kesti.smartcity.model.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(value= HttpStatus.OK)
    @ExceptionHandler(value = ApplicationException.class)
    public ApiResponse<?> applicationExceptionHandler(ApplicationException e) {
        log.error("{}", e.getMessage(), e);
        return ApiResponse.error(e.getResponseCode().getHttpStatus().value(), e.getResponseCode().getMessage());
    }

    @ResponseBody
    @ResponseStatus(value= HttpStatus.OK)
    @ExceptionHandler(value = Exception.class)
    public ApiResponse<?> errorHandler(Exception e) {
        log.error("{}", e.getMessage(), e);
        return ApiResponse.error(ResponseCode.INTERNAL_SERVER_ERROR.getHttpStatus().value(), e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = UserException.class)
    public ApiResponse<?> userExceptionHandler(UserException e) {
        log.error("{}", e.getMessage(), e);
        return ApiResponse.error(999, e.getMessage());
    }

}
