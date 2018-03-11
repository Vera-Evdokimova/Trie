import java.util.*;

public class pref {
    static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<>();
        boolean leaf;
    }

    TrieNode root = new TrieNode();

    public void put(String s) {
        TrieNode v = root;
        for (char ch : s.toLowerCase().toCharArray()) {
            if (!v.children.containsKey(ch)) {
                v.children.put(ch, new TrieNode());
            }
            v = v.children.get(ch);
        }
        v.leaf = true;
    }
    public boolean find(String s) {
        TrieNode v = root;
        for (char ch : s.toLowerCase().toCharArray()) {
            if (!v.children.containsKey(ch)) {
                return false;
            } else {
                v = v.children.get(ch);
            }
        }
        return true;
    }

    private Map<Integer,String> levelSpacesMap = new HashMap<>();

    private String getSpace(int level) {
        String result = levelSpacesMap.get(level);
        if (result == null) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<level; i++) {
                sb.append(" ");
            }
            result = sb.toString();
            levelSpacesMap.put(level,result);
        }
        return result;
    }

    public String printSorted() {
        return printSorted(root,0);
    }

    private String printSorted(TrieNode node, int level) {
        boolean fst = true;
        StringBuilder res = new StringBuilder();
        for (Character ch : node.children.keySet()) {
            if(fst) {
                res.append("-").append(ch);
                fst = false;
            }else
                res.append(getSpace(level)).append("\\").append(ch);
            res.append(printSorted(node.children.get(ch), level+1));
        }
        if (node.leaf) {
            res.append("\n");
        }
        return res.toString();
    }
}
