package checkpoint.andela.main;

import checkpoint.andela.members.*;

public class Main {

    public static void main(String[] args) {

        Member m = new Member();
        Book book2 = new Book("How to win friends and Influence People","Dale Carnegie",12,"ISBN 1345-7890");
        m.borrowBook(book2);

        Staff staff1 = new Staff("Tosin", 'M', "19860113", "tosin.adesanya@andela.com", "08068999877", "L1-0119", 230000.456);

        staff1.assignToStudent("C10-L1-0119");





    }

}


