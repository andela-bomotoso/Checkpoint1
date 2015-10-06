package checkpoint.andela.main;

public class Main {

    public static void main(String[] args) {

        Member m = new Member();
        Book book2 = new Book("How to win friends and Influence People","Dale Carnegie",12,"ISBN 1345-7890");
        m.borrowBook(book2);

    }

}


