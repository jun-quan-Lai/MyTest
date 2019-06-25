package com.ljq.collection;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Created by laijunquan on 2019/6/25
 */
public interface MyList<E> extends MyCollection<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(MyCollection<?> c);

    boolean addAll(MyCollection<? extends E> c);

    boolean addAll(int index, MyCollection<? extends E> c);

    boolean removeAll(MyCollection<?>  c);

    boolean retainAll(MyCollection<?> c);

    default void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        final ListIterator<E> li = this.listIterator();
        while (iterator().hasNext()) {
            li.set(operator.apply(li.next()));
        }
    }

    default void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<E> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }

    void clear();

    boolean equals(Object o);

    int hashCode();

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

    MyList<E> subList(int fromIndex, int toIndex);

//    @Override
//    default Spliterator<E> spliterator() {
//        return Spliterators.spliterator(this, Spliterator.ORDERED);
//    }
}
