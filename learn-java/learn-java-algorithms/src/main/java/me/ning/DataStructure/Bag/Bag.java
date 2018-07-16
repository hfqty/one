package me.ning.DataStructure.Bag;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Bag<Element> implements Iterable<Element> {


    private Node<Element> firstElement;
    private int size;


    public Bag(){
        firstElement = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public void add(Element element){
        Node<Element> oldFirst = firstElement;
        firstElement = new Node<>();
        firstElement.content = element;
        firstElement.nextElement = oldFirst;
        size ++;
    }

    public boolean contains(Element element){
        Iterator<Element> iterator = this.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(element)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Iterator<Element> iterator() {
        return new ListIterator<Element>(firstElement);
    }

    private class ListIterator<Element> implements Iterator<Element> {

        private Node<Element> currentElement;

        public ListIterator(Node<Element> firstElement) {
            currentElement = firstElement;
        }



        @Override
        public boolean hasNext() {
            return currentElement != null;
        }

        @Override
        public Element next() {
            if(!hasNext())
                throw new NoSuchElementException();
            Element element = currentElement.content;
            currentElement = currentElement.nextElement;
            return  element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("cannot remove from bag");
        }

        @Override
        public void forEachRemaining(Consumer<? super Element> action) {

        }
    }

    private static class Node<Element>{
        private Element content;
        private Node<Element> nextElement;

    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        bag.add("what");
        bag.add("are");
        bag.add("you");
        bag.add("do");

        System.out.println("bag 的size"+bag.size());

        for (String s: bag){
            System.out.println(s);
        }

        System.out.println(bag.contains(null));
        System.out.println(bag.contains("what"));
        System.out.println(bag.contains("1"));
    }
}
