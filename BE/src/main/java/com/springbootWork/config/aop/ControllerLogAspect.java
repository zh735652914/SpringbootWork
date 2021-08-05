package com.springbootWork.config.aop;

import com.springbootWork.dao.mongo.LogDAO;
import com.springbootWork.manager.LoginStatusManager;
import com.springbootWork.model.bo.LoginStatusBO;
import com.springbootWork.model.constant.HttpStatusCode;
import com.springbootWork.model.entity.mongo.LogEntity;
import com.springbootWork.model.vo.response.ResultVO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class ControllerLogAspect {
    private static final String PACKAGE_PREFIX = "com.springbootWork.controller.";
    private static final String PACKAGE_PREFIX2 = "com.springbootWork.config.handler.BindExceptionHandler.";
    private static final String CONTROLLER_POSTFIX = "Controller.";

    private final LoginStatusManager loginStatusManager;
    private final LogDAO logDAO;

    public ControllerLogAspect(LoginStatusManager loginStatusManager, LogDAO logDAO) {
        this.loginStatusManager = loginStatusManager;
        this.logDAO = logDAO;
    }

    @Pointcut("execution(public * com.springbootWork.controller..*.*(..)) || " +
            "execution(public * com.springbootWork.config.handler.BindExceptionHandler.handleBindException(..))")
    public void controllerLog() {
    }

    @Around("controllerLog()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();

        LogEntity log = new LogEntity();
        logRequest(log, joinPoint);

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable ex) {
            System.out.println(ex);
            log.setException(ex.getMessage());
            setResponseCode(HttpStatusCode.INTERNAL_SERVER_ERROR);
            result = new ResultVO(ResultVO.SERVER_ERROR, "未知错误", null);
        }

        logResult(log, result, System.currentTimeMillis() - startTime);
        logDAO.insert(log);

        return result;
    }

    private void logRequest(LogEntity logEntity, ProceedingJoinPoint joinPoint) {
        HttpServletRequest request = getRequest();
        if (request != null) {
            LoginStatusBO loginStatus = loginStatusManager.getLoginStatus(request.getSession());
            String requestUrl = request.getRequestURI();
            if (request.getQueryString() != null) {
                requestUrl += "?" + request.getQueryString();
            }

            logEntity.setRequestUrl(requestUrl);
            logEntity.setUserId(loginStatus.getUserId());
            logEntity.setUserType(loginStatus.getUserType());
        }

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String businessTarget = signature.getDeclaringTypeName() + "." + signature.getMethod().getName();
        businessTarget = businessTarget
                .replace(PACKAGE_PREFIX, "")
                .replace(CONTROLLER_POSTFIX, ".")
                .replace(PACKAGE_PREFIX2, "");
        logEntity.setBusinessTarget(businessTarget);
    }

    private void logResult(LogEntity log, Object result, long executeTime) {
        if (!(result instanceof ResultVO)) {
            return;
        }

        ResultVO resultVO = (ResultVO) result;
        log.setResultCode(resultVO.getCode());
        log.setMessage(resultVO.getMessage());
        log.setExecuteTime(executeTime);
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        if (attributes == null) {
            return null;
        }

        return attributes.getRequest();
    }

    private void setResponseCode(int statusCode) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletResponse response = requestAttributes.getResponse();
        if (response == null) {
            return;
        }

        response.setStatus(statusCode);
    }
}
