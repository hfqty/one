package me.ning.Sort;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;

public class BinaryTreeSort implements SortAlgorithm {

    interface TreeVisitor<T extends Comparable<T>>{
        void visit(Node<T> node);
    }

    private static class SortVisitor<T extends Comparable<T>> implements TreeVisitor<T>{

        private final T[] array;
        private int counter;
        SortVisitor(T[]array){
            this. array = array;
        }

        @Override
        public void visit(Node<T> node) {
            array[counter ++] = node.value;
        }
    }

    private static class Node<T extends Comparable<T>>{
        private T value;
        private Node<T> left;
        private Node<T> right;

        Node(T value){
            this.value = value;
        }

        void insert(Node<T> node){
            if(less(node.value,value)){
                if(left != null )left.insert(node);
                else left = node;

            }
            else{
                if(right != null )right.insert(node);
                else right = node;
            }
        }

        void traverse(TreeVisitor<T> visitor){
            if(left != null)
                left.traverse(visitor);
            visitor.visit(this);

            if(right != null)
                right.traverse(visitor);

        }
    }


    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        Node<T> root = new Node<>(array[0]);
        for(int i = 1;i<array.length;i++){
            root.insert(new Node<>(array[i]));
        }
        root.traverse(new SortVisitor<>(array));
        return array;
    }

    public static void main(String[] args) {
        Integer [] integers  = {19,1,3,49,13,47,13,55,22};
        BinaryTreeSort treeSort = new BinaryTreeSort();
        integers  = treeSort.sort(integers);
        print(integers);

        Double[]decimalArray = {19.3,123.4,22.1,33.1,1.3,0.321,3.123,6.4};
        decimalArray = treeSort.sort(decimalArray);
        print(decimalArray);


    }




}
