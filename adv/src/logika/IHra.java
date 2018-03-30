/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;



/**
 *  RozhranĂ­ kterĂ© musĂ­ implementovat hra, je na nÄ› navĂˇzĂˇno uĹľivatelskĂ© rozhranĂ­
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro ĹˇkolnĂ­ rok 2017/2018
 */
public interface IHra
{
    //== VEĹ�EJNĂ‰ KONSTANTY =====================================================
    //== DEKLAROVANĂ‰ METODY ====================================================
    /**
     *  VrĂˇtĂ­ ĂşvodnĂ­ zprĂˇvu pro hrĂˇÄŤe.
     *  
     *  @return  vracĂ­ se Ĺ™etÄ›zec, kterĂ˝ se mĂˇ vypsat na obrazovku
     */
    public String vratUvitani();

    /**
     *  VrĂˇtĂ­ zĂˇvÄ›reÄŤnou zprĂˇvu pro hrĂˇÄŤe.
     *  
     *  @return  vracĂ­ se Ĺ™etÄ›zec, kterĂ˝ se mĂˇ vypsat na obrazovku
     */
    public String vratEpilog();

    /** 
     * VracĂ­ informaci o tom, zda hra jiĹľ skonÄŤila, je jedno zda vĂ˝hrou, prohrou nebo pĹ™Ă­kazem konec.
     * 
     * @return   vracĂ­ true, pokud hra skonÄŤila
     */
    public boolean konecHry();

    /**
     *  Metoda zpracuje Ĺ™etÄ›zec uvedenĂ˝ jako parametr, rozdÄ›lĂ­ ho na slovo pĹ™Ă­kazu a dalĹˇĂ­ parametry.
     *  Pak otestuje zda pĹ™Ă­kaz je klĂ­ÄŤovĂ˝m slovem  napĹ™. jdi.
     *  Pokud ano spustĂ­ samotnĂ© provĂˇdÄ›nĂ­ pĹ™Ă­kazu.
     *
     *@param  radek  text, kterĂ˝ zadal uĹľivatel jako pĹ™Ă­kaz do hry.
     *@return          vracĂ­ se Ĺ™etÄ›zec, kterĂ˝ se mĂˇ vypsat na obrazovku
     */
    public String zpracujPrikaz(String radek);

    /**
     *  Metoda vrĂˇtĂ­ odkaz na hernĂ­ plĂˇn, je vyuĹľita hlavnÄ› v testech,
     *  kde se jejĂ­m prostĹ™ednictvĂ­m zĂ­skĂˇvĂˇ aktualnĂ­ mĂ­stnost hry.
     *  
     *  @return     odkaz na hernĂ­ plĂˇn
     */
    public HerniPlan getHerniPlan();

}
