/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mails;

/**
 *
 * @author sebas
 */
public class Correo {
    
    private String destinatario;
    private String asunto;
    private String cuerpo;
    private String remitente;
    private String clave;

    public Correo(String destinatario, String asunto, String cuerpo, String remitente, String clave) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.remitente = remitente;
        this.clave = clave;
    }

    Correo(String remitente, String clave ) {
        this.remitente = remitente;
        this.clave = clave;
    }

    public Correo(String destinatario, String asunto, String cuerpo) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.cuerpo = cuerpo;   
    }
    
    

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    @Override
    public String toString() {
        return "Correo{" + "destinatario=" + destinatario + ", asunto=" + asunto + ", cuerpo=" + cuerpo + ", remitente=" + remitente + ", clave=" + clave + '}';
    }

    
}

