/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

/**
 *
 * @author jpere
 */
@Controller
//@Lazy(value = true)
public class DocumentoExcel implements Imprimible  {
    @Override
    public String imprimir() {
        return "Imprimiedo desde un archivo de excel";
    }
    
    @PostConstruct
    public void iniciar(){
        System.out.println("INICIE LA CONSTRUCCION DEL BEAN EXCEL");
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println("DESTRUYENDO EL BEAN EXCEL");
    }
}