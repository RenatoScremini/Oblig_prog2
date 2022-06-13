package List;

public class  MyLinkedList<T> implements Lista <T>{ // public class adt.MyLinkedList <E> implements Lista { para hacer que no sea solo object y lo tenoguqe cambiar  en nodo en lista y en todo
    private Nodo primero;


    @Override
    public void add(T value) {
        if (this.primero == null) {
            primero = new Nodo(value);

        } else {
            Nodo temp = primero;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Nodo(value));

        }
    }

    @Override
    public void remove(int position) {
        Nodo temp = primero;

        if (temp.getValue() == null){
            System.out.println("El espacio de memoria esta vacio");
        }
        if(position < 0){
            System.out.println("La posicion buscada es incorrecta");
        }
        if(position == 0){
            if(temp != null){
                primero = temp.getNext();
            }
        }
        else {
            int i = 0;
            while (i < position - 1) {
                temp = temp.getNext();
                i++;
            }
            Nodo newNextNodo = temp.getNext().getNext();
            temp.setNext(newNextNodo);
        }
    }

    @Override
    public Object get(int position) {
        Nodo temp = primero;
        if (position == 0) {
            return temp.getValue();
        }
        int i = 0;
        while (i < position) {
            temp = temp.getNext();
            i++;
        }
        return temp.getValue();

    }

    public boolean buscar(T value){
        Nodo temp = primero;
        if(temp == null){
            return false;
        }
        else {
            while (temp != null) {
                if (temp.getValue() == value) {
                    return true;
                }
                else {
                    temp = temp.getNext();
                }
            }
            return false;
        }
    }

    public void display ( ){
        Nodo temp = this.primero;
        while (temp.getNext() != null){
            System.out.print(temp.getValue());
            System.out.print(" ");
            temp = temp.getNext();
        }
        System.out.print(temp.getValue());
    }

    public void addFirst(T value) {
        Nodo temp = primero;
        Nodo newNodo = new Nodo(value);

        if (temp != null) {
            newNodo.setNext(temp);
        }
        primero = newNodo;
    }

    public void addLast (T value){
        Nodo temp = primero;
        Nodo newNodo = new Nodo(value);

        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNodo);
    }
}







