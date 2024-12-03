public class LinkedList<T> {

    Node<T> head;

      static class Node<T>{
         T data;
         Node<T> next;

         Node(T d){
             this.data = d;
             this.next = null;
         }
     }

     public void insert(T data){
         Node<T> new_node = new Node<>(data);

         if(head == null){
             head = new_node;
         }
         else{
             Node<T> last = head;
             while(last.next != null){
                 last = last.next;
             }
             last.next = new_node;
         }
     }

     public void print(){
         Node<T> currNode = head;

         while(currNode != null){
             System.out.print(currNode.data + " ");
             currNode = currNode.next;
         }
     }

    public static void main(String[] args) {

         LinkedList<String> list = new LinkedList<>();

         list.insert("T1");
         list.insert("T2");
         list.insert("T3");

         list.print();


    }


}