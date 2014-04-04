/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BestDeal;

/**
 *
 * @author Clubiste
 */
public class Deal {

    protected String ref_deal;
    protected String titre_deal;
    protected String marque_deal;
    protected String desc_deal;
    protected Float prix_initial;
    protected Float prix_reduction;
    protected String date_depot;
    protected String date_expiration;

    public Deal(String ref_deal, String titre_deal, String marque_deal, String desc_deal, Float prix_initial, Float prix_reduction, String date_depot, String date_expiration) {
        this.ref_deal = ref_deal;
        this.titre_deal = titre_deal;
        this.marque_deal = marque_deal;
        this.desc_deal = desc_deal;
        this.prix_initial = prix_initial;
        this.prix_reduction = prix_reduction;
        this.date_depot = date_depot;
        this.date_expiration = date_expiration;
    }

    public Deal() {
    }

    
    public String toString() {
        return "Deal{" + "ref_deal=" + ref_deal + ", titre_deal=" + titre_deal + ", marque_deal=" + marque_deal + ", desc_deal=" + desc_deal + ", prix_initial=" + prix_initial + ", prix_reduction=" + prix_reduction + ", date_depot=" + date_depot + ", date_expiration=" + date_expiration + '}';
    }

    public String getRef_deal() {
        return ref_deal;
    }

    public void setRef_deal(String ref_deal) {
        this.ref_deal = ref_deal;
    }

    public String getTitre_deal() {
        return titre_deal;
    }

    public void setTitre_deal(String titre_deal) {
        this.titre_deal = titre_deal;
    }

    public String getMarque_deal() {
        return marque_deal;
    }

    public void setMarque_deal(String marque_deal) {
        this.marque_deal = marque_deal;
    }

    public String getDesc_deal() {
        return desc_deal;
    }

    public void setDesc_deal(String desc_deal) {
        this.desc_deal = desc_deal;
    }

    public Float getPrix_initial() {
        return prix_initial;
    }

    public void setPrix_initial(Float prix_initial) {
        this.prix_initial = prix_initial;
    }

    public Float getPrix_reduction() {
        return prix_reduction;
    }

    public void setPrix_reduction(Float prix_reduction) {
        this.prix_reduction = prix_reduction;
    }

    public String getDate_depot() {
        return date_depot;
    }

    public void setDate_depot(String date_depot) {
        this.date_depot = date_depot;
    }

    public String getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(String date_expiration) {
        this.date_expiration = date_expiration;
    }
}
