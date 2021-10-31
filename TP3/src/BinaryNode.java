import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data)
    {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData()
    {
        return this.data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item)
    {
        if (this.getData().compareTo(item) < 0) {
            if (this.right == null) {
                this.right = new BinaryNode<>(item);
            }
            else {
                this.right.insert(item);
            }
        }
        else {
            if (this.left == null) {
                this.left = new BinaryNode<>(item);
            }
            else {
                this.left.insert(item);
            }
        }
    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item)
    {
        int comp = item.compareTo(this.data);
        if(comp  == 0) return true;
        if(comp < 0 && left != null && left.contains(item)) return true;
        if(comp > 0 && right != null && right.contains(item)) return true;
        return false;
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
        if( this.right == null && this.left == null ) {
            return 0;
        }
        else if (this.right != null && this.left != null) {
            return 1 + Math.max(left.getHeight(), right.getHeight());
        }
        else if (this.right == null) {
            return 1 + left.getHeight();
        }
        else  {
            return 1 + right.getHeight();
        }
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
        if (this.left != null) {
            this.left.fillListInOrder(result);
        }
        result.add(this);

        if (this.right != null) {
            this.right.fillListInOrder(result);
        }
    }
}