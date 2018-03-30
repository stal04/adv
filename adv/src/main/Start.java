/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package main;
import java.io.IOException;


import logika.*;
import uiText.TextoveRozhrani;

/*******************************************************************************
 * TĹ™Ă­da  Start je hlavnĂ­ tĹ™Ă­dou projektu,
 * kterĂ˝ pĹ™edstavuje jednoduchou textovou adventuru urÄŤenou k dalĹˇĂ­m ĂşpravĂˇm a rozĹˇiĹ™ovĂˇnĂ­
 *
 * @author    Jarmila PavlĂ­ÄŤkovĂˇ, PavlĂ­ÄŤek
 * @version   ZS 2017/2018
 */
public class Start
{
    /***************************************************************************
     * Metoda, prostĹ™ednictvĂ­m nĂ­Ĺľ se spouĹˇtĂ­ celĂˇ aplikace.
     *
     * @param args Parametry pĹ™Ă­kazovĂ©ho Ĺ™Ăˇdku
     */
    public static void main(String[] args)
    {
        
        IHra hra = new Hra();
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        ui.hraj();
    }
}
