package model.card;



/**
 * @author Allard Léni & Billon François
 *
 * Interface définissant le fonctionnement d'une carte.
 * Une carte doit posséder une valeur et une couleur et elle doit pouvoir se comparer à une autre carte en valeur
 * Une carte doit définir une méthode comparaison entre les valeurs.
 */

public interface ICard {
    ICardValue getValue();
    ICardColor getColor();
    boolean equals(Object o);
    int isUpperTo(Object o) throws Exception;
}
