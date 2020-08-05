package br.com.mtz.cleanarch.api;

import br.com.mtz.cleanarch.application.response.ResourceValueResponse;
import br.com.mtz.cleanarch.domain.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomerApiExceptionHandler {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    private ResourceValueResponse exceptions(HttpServletRequest request, NotFoundException exception) {
        this.logger.error(exception.getMessage(), exception);
        return new ResourceValueResponse(exception.getResourceName(), exception.getId());
    }

}
