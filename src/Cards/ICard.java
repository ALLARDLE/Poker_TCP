package Cards;

/**
 * @author Allard Léni & Billon François
 *
 * Interface définissant le fonctionnement d'une carte.
 * Une carte doit posséder une valeur et une couleur.
 * Une carte doit définir une méthode comparaison entre les valeurs.
 */

interface ICard {
    IValue getValue();
    IColor getColor();
    boolean equals(Object o);
    int isUpperTo(Object o) throws Exception;
}
