package com.ljq.collection;

import java.util.Arrays;
import java.util.Iterator;

public abstract class MyAbstractCollecction<E> implements MyCollection<E> {

    protected MyAbstractCollecction() {

    }

    public abstract Iterator<E> iterator();

    public abstract int size();

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        Iterator<E> it = iterator();
        if (o == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    return true;
                }
            }
        }

        return false;
    }

    public Object[] toArray() {
        Object[] r = new Object[size()];
        Iterator<E> it = iterator();
        for (int i = 0; i < r.length; i++) {
            if (! it.hasNext()){
                return Arrays.copyOf(r, i);
            }
            r[i] = it.next();
        }
    }
}
