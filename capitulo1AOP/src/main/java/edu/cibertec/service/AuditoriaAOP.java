/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */

@Aspect
@Service 
public class AuditoriaAOP {
   
   @Pointcut("execution(* edu.cibertec.beans.*.*(..))")
   public void generico(){} 
   
   @Before("generico()")
   //@Before(pointcut = "generico()") 
   public void alertarAntes(JoinPoint JP){
       System.out.println("Auditoria antes de ejecutar el metodo "+JP.getSignature().getName());
   }
   
   @After("generico()")
   //@After(pointcut = "generico()") 
   public void alertarDespues(){
       System.out.println("Auditoria despues de ejecutar el metodo");
   }
   
   @Around("generico()")
   //@Around(pointcut = "generico()") 
   public void alertarAlrededor(ProceedingJoinPoint pjp) throws Throwable{
       System.out.println("Auditoria al rededor de la ejecucion del metodo "+pjp.getSignature().getName());
       //Tu codigo de validacion        
       pjp.proceed();// Te ejecuta el metodo que lo invoco
   }
   
   @AfterReturning("generico()")
   //@AfterReturning(pointcut = "generico()") 
   public void alertarDespuesDeLaRespuesta(){
       System.out.println("Auditoria despues de ejecutar el metodo si no hay ningun error");
   }
   
   @AfterThrowing("generico()")
   //@AfterThrowing(pointcut = "generico()") 
  // @AfterThrowing("execution(* edu.cibertec.beans.*.*(..))") // Se ejecuta directamente sin considerar el Pointcut de la clase  
   public void alertarExcepcion(){
       System.out.println("Auditoria en la excepcion");
   }
   
   @AfterThrowing(pointcut = "auditoria()", throwing = "exception")
    public void alertarExcepcion(JoinPoint jp, Exception exception) {
        System.out.println("Se va producir un ERROR: "+ exception.getMessage());
    }
}
