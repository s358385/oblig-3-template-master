package no.oslomet.cs.algdat.Oblig3;


import javax.swing.plaf.IconUIResource;
import java.util.*;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) { //Kilde: Programkode 5.2.3 a)
        Node<T> p = rot, q = null;
        int cmp = 0;
        while (p != null){
            q = p;
            cmp = comp.compare(verdi,p.verdi);
            p = cmp < 0 ? p.venstre : p.høyre;
        }
        p = new Node<T>(verdi,q);
        if (q == null){
            rot = p;
        }
        else if (cmp < 0){
            q.venstre = p;
        }
        else {
            q.høyre = p;
        }
        antall++;
        return true;
    }

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        Stack<Node> stack = new Stack<Node>();
        Node<T> p = rot;
        int antall = 0;
        while (p != null || stack.empty() == false) {
            while (p != null) {
                stack.push(p);
                p = p.venstre;
            }
            p = stack.peek();
            stack.pop();
            if (p.verdi == verdi)
                antall++;
            p = p.høyre;
        }
        return antall;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) { //Kilde: Programkode 5.1.7 h)
        while (true) {
            if (p.venstre != null) {
                p = p.venstre;
            }
            else if (p.høyre != null) {
                p = p.høyre;
            }
            else{
                return p;
            }
        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        if (p.forelder == null){
            return null;
        }
        Node<T> parent = p.forelder;
        if (parent.høyre == null || parent.høyre == p){
            return parent;
        }
        Node<T> current = parent.høyre;
        while (current.venstre != null){
            current = current.venstre;
        }
        return current;
    }

    public void postorden(Oppgave<? super T> oppgave) { //Kilde: Programkode 5.1.15 c)
        Node<T> p = førstePostorden(rot);
        while (p != null){
            oppgave.utførOppgave(p.verdi);
            p = nestePostorden(p);
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) { //Kilde: 5.1.7 Løsningsforslag -> Oppgave 7
        if (p.venstre != null) postordenRecursive(p.venstre,oppgave);
        if (p.høyre != null) postordenRecursive(p.høyre,oppgave);
        oppgave.utførOppgave(p.verdi);
    }

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
