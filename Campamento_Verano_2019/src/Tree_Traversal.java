import java.util.Stack;

public class Tree_Traversal {
    static String result = "";
    public static void preOrder(Node root) {
        if(root!=null){
            System.out.println(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        Stack<Node> st = new Stack<>();
        st.push(root);
        while (true){
            Node ref = st.pop();
            System.out.print(ref.data+" ");
            st.push(ref.right);
            st.push(ref.left);
        }

    }

    public static void postOrder(Node root) {
        if(root!=null){
            postOrder(root.left);
            System.out.print(root.data+" ");
            postOrder(root.right);
        }

        Stack<Node> st = new Stack<>();
        Stack<Node> stE = new Stack<>();
        st.push(root);
        stE.push(root);
        while (!st.isEmpty()){
            Node ref = st.pop();
            stE.push(ref);
            if (ref.right != null) {
                st.push(ref.right);
            }
            if (ref.left != null) {
                st.push(ref.left);
            }
        }

        while (!stE.isEmpty()){
            System.out.print(stE.pop().data +" ");
        }

    }

}

class Node{
    int data;
    Node left;
    Node right;
}