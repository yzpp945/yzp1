package com.yzpjy.controller;

import com.yzpjy.domain.Syslog;
import com.yzpjy.domain.UserInfo;
import com.yzpjy.service.SyslogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SyslogService syslogService;

    private Date startTime;

    private Class clazz;
    private Method method;

    @Before("execution(* com.yzpjy.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        startTime = new Date();
        //获取访问类
        clazz = jp.getTarget().getClass();
        //获取访问方法
        String methodName = jp.getSignature().getName();
        //通过反射去得到有参和无参的方法
        Object[] args = jp.getArgs();

            if (args == null || args.length == 0) {
                method = clazz.getMethod(methodName);
            } else {
                Class[] classes = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    classes[i] = args[i].getClass();
                }
                method = clazz.getMethod(methodName, classes);
            }
    }

    @After("execution(* com.yzpjy.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        if (clazz!=SyslogController.class){
            RequestMapping annotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (annotation!=null){
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null){
                    String url = "";
                    url = annotation.value()[0]+methodAnnotation.value()[0];
                    Syslog syslog = new Syslog();
                    //访问时长
                    long time = new Date().getTime()-startTime.getTime();
                    syslog.setExecutionTime(time);
                    syslog.setUrl(url);
                    //ip地址
                    String ip = request.getRemoteAddr();
                    syslog.setIp(ip);

                    SecurityContext context = SecurityContextHolder.getContext();
                    Authentication authentication = context.getAuthentication();
                    String username =  ((User)authentication.getPrincipal()).getUsername();
                    syslog.setUsername(username);

                    SecurityContextImpl securityContext = (SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                    String name = securityContext.getAuthentication().getName();
                    System.out.println(name);

                    syslog.setMethod("类名"+clazz.getName()+"方法名"+method.getName());
                    syslog.setVisitTime(startTime);

                    syslogService.insertSyslog(syslog);
                }
            }
        }


    }




}
