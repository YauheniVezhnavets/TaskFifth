package com.epam.task.fifth.entities;

public class Leaf implements Component {

    private final String lexeme;

    private final LeafType leafType;

    private Leaf(String lexeme, LeafType leafType) {
        this.lexeme = lexeme;
        this.leafType = leafType;
    }

    public static Leaf word (String lexeme){
        return new Leaf(lexeme,LeafType.WORD);
    }

    public static Leaf expression (String lexeme){
        return new Leaf(lexeme,LeafType.EXPRESSION);
    }


    public String getLexeme() {
        return lexeme;
    }

    public LeafType getLeafType() {
        return leafType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Leaf leaf = (Leaf) o;

        if (getLexeme() != null ? !getLexeme().equals(leaf.getLexeme()) : leaf.getLexeme() != null){
            return false;
        }
        return getLeafType() == leaf.getLeafType();
    }

    @Override
    public int hashCode() {
        int result = getLexeme() != null ? getLexeme().hashCode() : 0;
        result = 31 * result + (getLeafType() != null ? getLeafType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Leaf{" + "lexeme='" + lexeme + '\'' + ", leafType=" + leafType + '}';
    }
}
