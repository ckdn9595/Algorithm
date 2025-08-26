import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1967 {
    static int max = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node root = new Node(1, 0);
        Node[] nodes = new Node[10001];
        nodes[1] = root;
        while(N-- > 1){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Node parent = nodes[p];
            if(parent == null){
                parent = new Node(p, 0);
                nodes[p] = parent;
            }
            Node child = new Node(c, v);
            if(nodes[c] != null){
                nodes[c].v = v;
                child = nodes[c];
            }else{
                nodes[c] = child;
            }
            parent.addChild(child);
        }

        dfs(root);

        System.out.println(max);
    }

    static void dfs(Node node){
        for(Node c : node.nodes){
            dfs(c);
        }
        node.setMax();
        node.setParentNodeV();
        max = Math.max(max, node.getMax());
    }

    static class Node implements  Comparable<Node>{
        List<Node> nodes = new ArrayList<>();
        int i;
        int v;
        int max;
        int toParentV;

        public Node (int i, int v){
            this.i = i;
            this.v = v;
        }

        public void addChild(Node node){
            nodes.add(node);
        }


        public void setMax(){
            Collections.sort(nodes);
            if(isLeafNode()){
                max = 0;
                return;
            }
            if(nodes.size() == 1){
                max = nodes.get(0).toParentNodeCost();
                return;
            }
            max = nodes.get(0).toParentNodeCost() + nodes.get(1).toParentNodeCost();
        }

        public int getMax(){
            return this.max;
        }
        public void setParentNodeV(){
            if(isLeafNode()){
                this.toParentV =  v;
                return;
            }
            this.toParentV = nodes.get(0).toParentNodeCost() + v;
        }
        public int toParentNodeCost(){
           return this.toParentV;
        }

        public boolean isLeafNode(){
            return nodes.isEmpty();
        }

        @Override
        public int compareTo(Node o){
            return o.toParentV - this.toParentV;
        }
    }
}
