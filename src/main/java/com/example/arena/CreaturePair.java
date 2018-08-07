package com.example.arena;

public class CreaturePair {

    private final Creature left;
    private final Creature right;

    public CreaturePair(Creature left, Creature right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CreaturePair that = (CreaturePair) o;

        return (this.left == that.left && this.right == that.right) ||
                (this.left == that.right && this.right == that.left);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (left == null ? 0 : left.hashCode()) + (right == null ? 0 : right.hashCode());
        return hash;
    }
}
