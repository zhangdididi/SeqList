public class Test {
    public static void main(String[] args) {

        SeqList seqList = new SeqList();
        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        seqList.add(2,5);
        System.out.println(seqList.contains(7));
        System.out.println(seqList.search(5));
        seqList.remove(3);
        seqList.remove(5);
        seqList.display();
    }
}
