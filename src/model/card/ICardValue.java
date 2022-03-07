package model.card;


/**
 * @author Allard Léni & Billon François
 *
 * Définie la valeur d'une carte d'un jeu de poker
 *
 */

interface ICardValue {
    boolean equals(Object o);
    int isUpperTo(Object o) throws Exception;
}
