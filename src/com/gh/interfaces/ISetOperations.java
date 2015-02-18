package com.gh.interfaces;

import java.util.Set;

public interface ISetOperations {
    //Два множества А и В равны (А=В), если они состоят из одних и тех же элементов

    public boolean equals(Set a, Set b);

//Объединением (суммой) множеств А и В называется множество А ∪ В,
// элементы которого принадлежат хотя бы одному из этих множеств

    public Set union(Set a, Set b);

//Разностью множеств А и В называется множество АВ, элементы которого
// принадлежат множеству А, но не принадлежат множеству В

    public Set subtract(Set a, Set b);

//Пересечением (произведением) множеств А и В называется множество А ∩ В,
// элементы которого принадлежат как множеству А, так и множеству В

    public Set intersect(Set a, Set b);

//Симметричной разностью множеств А и В называется множество А Δ В,
// являющееся объединением разностей множеств АВ и ВА, то есть А Δ В = (АВ) ∪ (ВА)

    public Set symmetricSubtract(Set a, Set b);
}
