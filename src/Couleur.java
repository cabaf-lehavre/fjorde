/**
 * Created by Hawk on 05/01/2015.
 */
public enum Couleur {
    BLANC,
    NOIR, ;

    public char toChar() {
        switch (this) {
            case BLANC:
                return 'B';
            case NOIR:
                return 'N';
            default:
                return 'X';
        }
    }

    public static Couleur getCouleur(char c) {
        switch (c) {
            case 'B':
                return BLANC;
            case 'N':
                return NOIR;
            default:
                return null;
        }
    }
}

