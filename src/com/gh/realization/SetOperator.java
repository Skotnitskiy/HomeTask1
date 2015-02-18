package com.gh.realization;

import com.gh.interfaces.ISetOperations;

import java.util.HashSet;
import java.util.Set;

public class SetOperator implements ISetOperations {
    private Set resultSet;

    @Override
    public boolean equals(Set a, Set b) {
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        this.resultSet = new HashSet(a);
        this.resultSet.addAll(b);
        return this.resultSet;
    }

    @Override
    public Set subtract(Set a, Set b) {
        this.resultSet = new HashSet(a);
        this.resultSet.removeAll(intersect(a, b));
        return this.resultSet;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set resultSet = new HashSet(a);
        resultSet.retainAll(b);
        return resultSet;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        Set p = union(a, b);
        p.removeAll(intersect(a, b));
        return p;
    }
}