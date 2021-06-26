package nextstep.subway.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAop {

    private static final Logger fileLogger = LoggerFactory.getLogger("file");
    private static final Logger consoleLogger = LoggerFactory.getLogger("console");

//    @Around("execution(* nextstep.subway.auth.application.AuthService.login(..))")
//    public Object loginLogging(ProceedingJoinPoint joinPoint) throws Throwable {
//        String inputParam = Arrays.toString(joinPoint.getArgs());
//        consoleLogger.info("[CLASS] " + joinPoint.getSignature().getDeclaringTypeName() +"/"
//                + "[METHOD] " + joinPoint.getSignature().getName() + "/"
//                + "[PARAMETER]" + inputParam);
//
//        //메소드 실행
//        Object result = joinPoint.proceed();
//
//        //메소드 실행결과 로그
//        consoleLogger.info("[CLASS] " + joinPoint.getSignature().getDeclaringTypeName() +"/"
//                + "[METHOD] " + joinPoint.getSignature().getName() + "/"
//                + "[PARAMETER]" + result);
//        return result;
//    }

    @Around("execution(* nextstep.subway.member.application.MemberService.createMember(..))")
    public Object signUpLogging(ProceedingJoinPoint joinPoint) throws Throwable {

        String inputParam = Arrays.toString(joinPoint.getArgs());
        consoleLogger.info("[CLASS] " + joinPoint.getSignature().getDeclaringTypeName() +"/"
                + "[METHOD] " + joinPoint.getSignature().getName() + "/"
                + "[REQUEST]" + inputParam);
        fileLogger.info("[CLASS] " + joinPoint.getSignature().getDeclaringTypeName() +"/"
                + "[METHOD] " + joinPoint.getSignature().getName() + "/"
                + "[REQUEST]" + inputParam);

        //메소드 실행
        Object result = joinPoint.proceed();

        //메소드 실행결과 로그
        consoleLogger.info("[CLASS] " + joinPoint.getSignature().getDeclaringTypeName() +"/"
                + "[METHOD] " + joinPoint.getSignature().getName() + "/"
                + "[RESPONSE]" + result);
        fileLogger.info("[CLASS] " + joinPoint.getSignature().getDeclaringTypeName() +"/"
                + "[METHOD] " + joinPoint.getSignature().getName() + "/"
                + "[RESPONSE]" + result);
        return result;

    }

//    @Around("execution(* nextstep.subway.map.application.PathService.findPath(..))")
//    public Object findPathLogging(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        //메소드 호출시의 매개변수들
//        //requestInfo(joinPoint);
//
////        String inputParam = Arrays.toString(joinPoint.getArgs());
////        if (inputParam != null) {
////            consoleLogger.info(joinPoint.getKind());
////            consoleLogger.info(joinPoint.getSignature().getDeclaringTypeName());
////            consoleLogger.info(inputParam);
////            consoleLogger.info("==============================");
////        }
//
//        //메소드 실행
//        Object result = joinPoint.proceed();
//
//        //메소드 실행결과 로그
//        return result;
//
//    }
//
//    private void requestInfo(ProceedingJoinPoint joinPoint) {
//
//        String inputParam = Arrays.toString(joinPoint.getArgs());
//        if (inputParam != null) {
//            consoleLogger.info("REQUEST : " + inputParam + "/" + "FROM : " + joinPoint.getSignature().getName());
//        }
//
//        //consoleLogger.
//    }

}
