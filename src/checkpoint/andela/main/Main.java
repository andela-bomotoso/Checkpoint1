package checkpoint.andela.main;

import checkpoint.andela.members.*;

public class Main {


    public static void main(String[] args) {

      // ReadersClub readersClub = new ReadersClub();
       //readersClub.execute();

        Member m = new Member();
        Book b = new Book();
        m.borrowBook(b);

    }

}


