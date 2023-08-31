/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
//@Lazy(value = true)
public class DocumentoTexto implements Imprimible  {
    @Override
    public String imprimir() {
        return "Imprimiedo desde un archivo de texto";
    }  
    
    @PostConstruct
    public void iniciar(){
        System.out.println("INICIE LA CONSTRUCCION DEL BEAN TEXTO");
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println("DESTRUYENDO EL BEAN TEXTO");
    }
}
