package logika;

import java.util.HashMap;
import java.util.Map;

/**
 *  Class SeznamPrikazu - eviduje seznam pĹ™Ă­pustnĂ˝ch pĹ™Ă­kazĹŻ adventury.
 *  PouĹľĂ­vĂˇ se pro rozpoznĂˇvĂˇnĂ­ pĹ™Ă­kazĹŻ
 *  a vrĂˇcenĂ­ odkazu na tĹ™Ă­du implementujĂ­cĂ­ konkrĂ©tnĂ­ pĹ™Ă­kaz.
 *  KaĹľdĂ˝ novĂ˝ pĹ™Ă­kaz (instance implementujĂ­cĂ­ rozhranĂ­ Prikaz) se
 *  musĂ­ do seznamu pĹ™idat metodou vlozPrikaz.
 *
 *  Tato tĹ™Ă­da je souÄŤĂˇstĂ­ jednoduchĂ© textovĂ© hry.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro ĹˇkolnĂ­ rok 2017/2018
 */
public class SeznamPrikazu {
    // mapa pro uloĹľenĂ­ pĹ™Ă­pustnĂ˝ch pĹ™Ă­kazĹŻ
    private  Map<String,IPrikaz> mapaSPrikazy;

    /**
     * Konstruktor
     */
    public SeznamPrikazu() {
        mapaSPrikazy = new HashMap<String,IPrikaz>();
    }

    /**
     * VklĂˇdĂˇ novĂ˝ pĹ™Ă­kaz.
     *
     *@param  prikaz  Instance tĹ™Ă­dy implementujĂ­cĂ­ rozhranĂ­ IPrikaz
     */
    public void vlozPrikaz(IPrikaz prikaz) {
        mapaSPrikazy.put(prikaz.getNazev(),prikaz);
    }

    /**
     * VracĂ­ odkaz na instanci tĹ™Ă­dy implementujĂ­cĂ­ rozhranĂ­ IPrikaz,
     * kterĂˇ provĂˇdĂ­ pĹ™Ă­kaz uvedenĂ˝ jako parametr.
     *
     *@param  retezec  klĂ­ÄŤovĂ© slovo pĹ™Ă­kazu, kterĂ˝ chce hrĂˇÄŤ zavolat
     *@return          instance tĹ™Ă­dy, kterĂˇ provede poĹľadovanĂ˝ pĹ™Ă­kaz
     */
    public IPrikaz vratPrikaz(String retezec) {
        if (mapaSPrikazy.containsKey(retezec)) {
            return mapaSPrikazy.get(retezec);
        }
        else {
            return null;
        }
    }

    /**
     * Kontroluje, zda zadanĂ˝ Ĺ™etÄ›zec je pĹ™Ă­pustnĂ˝ pĹ™Ă­kaz.
     *
     *@param  retezec  Ĺ�etÄ›zec, kterĂ˝ se mĂˇ otestovat, zda je pĹ™Ă­pustnĂ˝ pĹ™Ă­kaz
     *@return          VracĂ­ hodnotu true, pokud je zadanĂ˝
     *                     Ĺ™etÄ›zec pĹ™Ă­pustnĂ˝ pĹ™Ă­kaz
     */
    public boolean jePlatnyPrikaz(String retezec) {
        return mapaSPrikazy.containsKey(retezec);
    }

    /**
     *  VracĂ­ seznam pĹ™Ă­pustnĂ˝ch pĹ™Ă­kazĹŻ, jednotlivĂ© pĹ™Ă­kazy jsou oddÄ›leny mezerou.
     *  
     *  @return     Ĺ�etÄ›zec, kterĂ˝ obsahuje seznam pĹ™Ă­pustnĂ˝ch pĹ™Ă­kazĹŻ
     */
    public String vratNazvyPrikazu() {
        String seznam = "";
        for (String slovoPrikazu : mapaSPrikazy.keySet()){
            seznam += slovoPrikazu + " ";
        }
        return seznam;
    }

}

