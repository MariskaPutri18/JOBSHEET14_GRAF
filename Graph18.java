public class Graph18 {
    int vertex;
    DoubleLinkedList18[] list;

    public Graph18(int v) {
        vertex = v;
        list = new DoubleLinkedList18[v];
        for (int i = 0; i < v; i++) {
            list[i] = new DoubleLinkedList18();
        }
    }

    public void addEdge(int asal, int tujuan, int jarak) {
        list[asal].addFirst(tujuan, jarak);
    }

    public void degree(int asal) {
        int totalIn = 0;
        int totalOut = list[asal].size();

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                if (list[i].get(j) != null && list[i].get(j) == asal) {
                    totalIn++;
                }
            }
        }

        System.out.println("InDegree dari gedung " + (char) ('A' + asal) + ": " + totalIn);
        System.out.println("OutDegree dari Gedung " + (char) ('A' + asal) + ": " + totalOut);
        System.out.println("Degree dari gedung " + (char) ('A' + asal) + ": " + (totalIn + totalOut));
    }

    public void removeEdge(int asal, int tujuan) {
        list[asal].remove(tujuan);
    }

    public void removeAllEdges() {
        for (int i = 0; i < vertex; i++) {
            list[i].clear();
        }
        System.out.println("Graf berhasil dikosongkan");
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                System.out.println("Gedung " + (char) ('A' + i) + " terhubung dengan: ");
                for (int j = 0; j < list[i].size(); j++) {
                    Integer destination = list[i].get(j);
                    Integer jarak = list[i].getJarak(j);
                    if (destination != null && jarak!= null) {
                        System.out.print((char) ('A' + destination) + " (" + jarak + "m), ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
