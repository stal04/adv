/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance tĹ™Ă­dy resRovnici pĹ™edstavujĂ­ rieĹˇenie rovnice.
 *
 * @author    Lenka Ĺ ĹĄastnĂˇ
 * @version   ĹˇkolskĂ˝ rok 2017/2018
 */
public class PrikazResRovnici implements IPrikaz
{
    private static final String NAZEV = "res_rovnici";
    private HerniPlan plan;

    /**
     *  konĹˇtruktor
     *  
     */
    public PrikazResRovnici(HerniPlan plan){
        this.plan=plan;

    }

    /**
     *  @parametre zĂˇvisia na prĂ­kazoch, pouĹľĂ­vam jeden, sprĂˇvny vĂ˝sledok
     *  
     */

    
    public String provedPrikaz(String... parametry){
        if (parametry.length == 0) {
            return "Zadaj prĂ­kaz v tvare res_rovnici cislo."; //zle zadanĂ˝ prĂ­kaz
        }

        if(plan.getAktualniProstor().getNazev().equals("vedec")) { //odpovedaĹĄ mĂ´ĹľeĹˇ len u vedca
            while(plan.getPokus() <2){ // mĂˇĹˇ 3 pokusy
                if((parametry[0].equals("3") || parametry[0].equals("tri"))){   //vĂ˝sledok rovnice mĂ´ĹľeĹˇ zadaĹĄ ako ÄŤĂ­slo aj ako slovo          

                    plan.getAktualniProstor().vlozVec(new Vec("diamant", true)); //ak uhĂˇdneĹˇ, mĂ´ĹľeĹˇ si vziaĹĄ diamant
                    return "SprĂˇvne, pokraÄŤuj k ÄŤarodejovi. \nveci v miesnoti: " + plan.getAktualniProstor().nazvyVeci();
                } 

                else { 
                    plan.spatnaOdpoved();
                    return "NesprĂˇvne, mĂ´ĹľeĹˇ hĂˇdaĹĄ eĹˇte " + (3- plan.getPokus()) + "krĂˇt";
                }

            }
            plan.setProhra(true); //ak nesprĂˇvne 3krĂˇt odpovieĹˇ, hra sa skonÄŤĂ­
            return "hra ukonÄŤenĂˇ";
        }
        return "V tejto miestnosti nemĂ´ĹľeĹˇ odpovedaĹĄ.";
    }

    /**
     *  Metoda vracĂ­ nĂˇzev pĹ™Ă­kazu (slovo kterĂ© pouĹľĂ­vĂˇ hrĂˇÄŤ pro jeho vyvolĂˇnĂ­)
     *  
     *  @return nazev prikazu
     */

   
    public String getNazev(){
        return NAZEV;
    }

}

