package zipcode;

public class DashaMapThree implements HashMapX{

    class Node {
        String key;
        String value;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] hasharray;

    public DashaMapThree() {
        this.hasharray = new Node[676];
        int i = 0;
        for(int x = 0; x < 26; x++){
            for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
                hasharray[i] = new Node(String.valueOf(alphabet), "-1");
                i++;
            }
        }
    }

    private String HashFunctionThree(String input) {
        if (input.length() > 1) {
            return String.valueOf(input.charAt(0)+input.charAt(1)).toLowerCase();
        }
        return null;
    }

    @Override
    public void set(String key, String value) {
        String keyhash =  HashFunctionThree(key);
        Node newval = new Node(key, value);
        appendTo(keyhash, newval);
    }

    private void appendTo(String kh, Node n) {
        Integer bucket = findHead(kh);
        if (bucket != -1) {
            n.next =  hasharray[bucket].next;
            hasharray[bucket].next = n;
        }
    }

    private Integer findHead(String kh) {
        int i = 0;
        for (Node n : hasharray) {
            if (n.key.equals(kh)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public String delete(String key) {
        return null;
    }

    private Node findIn(String keyword) {
        String keyhash =  HashFunctionThree(keyword);
        Integer bucket = findHead(keyhash);
        Node n = hasharray[bucket].next;
        while (n != null && !n.key.equals(keyword)) {
            n = n.next;
        }
        return n;
    }

    @Override
    public String get(String key) {
        String keyhash =  HashFunctionThree(key);
        Node newnode = findIn(key);
        if (newnode != null) {
            return newnode.value;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        for (Node node : hasharray) {
            if (node.next != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long size() {
        long s = 0;
        for (Node n : hasharray) {
            Integer l = bucketSize(n.key);
            s += l;
        }
        return s;
    }

    @Override
    public Integer bucketSize(String key) {
        Integer foundhead = findHead(key);
        if (foundhead != -1) {
            Node p = hasharray[foundhead].next;
            int n = 0;
            while (p != null) {
                p = p.next;
                n++;
            }
            return n;
        }

        return 0;
    }
}
