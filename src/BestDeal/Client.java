
package BestDeal;

import java.util.Date;

public class Client {
//Attributs
    
 private int refClient ;
 private String nomClient ;
 private String prenomClient ;
 private String mailClient ;
 private String passClient ;
 private String naissanceClient ;
 private int refPhoto ;
 private boolean accept = false ;

 
 //Constructeurs
 public Client() {
    }
    
    
    public Client(int refClient, String nomClient, String prenomClient, String mailClient, String passClient, String naissanceClient, int refPhoto) {
        this.refClient = refClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.mailClient = mailClient;
        this.passClient = passClient;
        this.naissanceClient = naissanceClient;
        this.refPhoto = refPhoto;
    }

    // setters and getters 
    public int getRefClient() {
        return refClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public String getMailClient() {
        return mailClient;
    }

    public String getPassClient() {
        return passClient;
    }

    public String getNaissanceClient() {
        return naissanceClient;
    }

    public int getRefPhoto() {
        return refPhoto;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setRefClient(int refClient) {
        this.refClient = refClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }

    public void setPassClient(String passClient) {
        this.passClient = passClient;
    }

    public void setNaissanceClient(String naissanceClient) {
        this.naissanceClient = naissanceClient;
    }

    public void setRefPhoto(int refPhoto) {
        this.refPhoto = refPhoto;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

 
    public String toString() {
        return "Client{" + "refClient=" + refClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", mailClient=" + mailClient + ", passClient=" + passClient + ", naissanceClient=" + naissanceClient + ", refPhoto=" + refPhoto + ", accept=" + accept + '}';
    }  

   
}
