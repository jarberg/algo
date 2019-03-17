import java.util.*;

public class LetterLab {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstint = scan.nextInt();
        String[][] A = new String[firstint][firstint];
        Node[][] nodeArray = new Node[firstint][firstint];

        for (int i = 0; i < firstint; i++) {
            String older = scan.nextLine();
            while(older.equals("")){
                older = scan.nextLine();
            }
            for (int j = 0; j < firstint; j++) {
                nodeArray[i][j] =  new Node(String.valueOf(older.charAt(j)));
                //A[i][j] =  String.valueOf(older.charAt(j));
            }
        }

        for (int i = 0; i <nodeArray.length ; i++) {
            for (int j = 0; j <nodeArray.length ; j++) {
                if(i > 0 && !nodeArray[i-1][j].value.equals(nodeArray[i][j].value)){
                    nodeArray[i][j].Insert(nodeArray[i-1][j]);
                }
                if(j > 0 && !nodeArray[i][j-1].value.equals(nodeArray[i][j].value)){
                    nodeArray[i][j].Insert(nodeArray[i][j-1]);
                }
                if(i < nodeArray.length-1 && !nodeArray[i+1][j].value.equals(nodeArray[i][j].value)){
                    nodeArray[i][j].Insert(nodeArray[i+1][j]);
                }
                if(j < nodeArray[i].length-1 && !nodeArray[i][j+1].value.equals(nodeArray[i][j].value)){
                    nodeArray[i][j].Insert(nodeArray[i][j+1]);
                }
            }
        }
        letterlab(nodeArray, new int[]{0,0}, null);
    }

    static void letterlab(Node[][] A, int[] start, Node prev){

        int i = start[0];
        int j = start[1];

        while(!A[i][j].visited){
            for (int k = 0; k < A[i][j].neighbors.size() ; k++) {
                Node temp = A[i][j].neighbors.get(k);
                if(!A[i][j].neighbors.get(k).visited && !A[i][j].neighbors.get(k).equals(prev) ){
                    temp.visited=true;
                }
            }
        }
    }


    public static class Node {

        List<Node> neighbors = new ArrayList<>();
        String value;
        boolean visited;

        public Node(String v) {
            this.value = v;
            this.visited = false;
        }

        boolean PointsTO(Node underNode){
            if(neighbors.contains(underNode)){
                return true;
            }
            return false;
        }

        public List<Node> Neighbours(){
            return neighbors;
        }

        public void Insert(Node node){
            neighbors.add(node);
        }

    }

}
