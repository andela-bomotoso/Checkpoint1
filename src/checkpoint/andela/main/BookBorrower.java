package checkpoint.andela.main;

import checkpoint.andela.members.Staff;

import java.util.Comparator;

import java.util.List;

import java.util.PriorityQueue;

/**
 * Represents book borrower information.
 */

public class BookBorrower extends Member {

    /**
     * Creates a new book borrower with default properties
     */

    public BookBorrower() {

    }

    /**
     * Creates a new book borrower with specific properties
     */

    public BookBorrower(String fullName, char gender, String dateOfBirth, String emailAddress, String phoneNumber) {
        super(fullName, gender, dateOfBirth, emailAddress, phoneNumber);
    }


    public Member getBorrower(List<Member> clubMembers) {

        Member prioritizedMember =  new Member();

        try {
            PriorityQueue<Member> registeredReaders = new PriorityQueue(clubMembers.size()+1, memberPreference);

            for (Member m : clubMembers)
                registeredReaders.offer(m);

            prioritizedMember = registeredReaders.poll();

        }

        catch (IllegalArgumentException e) {

            e.getMessage();

        }

        return prioritizedMember;
    }

    /**
     * A Comparator anonymous class to specify how the registered readers queue will be prioritized
     */

    public static Comparator<Member> memberPreference = new Comparator<Member>() {

        @Override
        public int compare(Member m1, Member m2) {

            /** if two members have the same readers category of either staff or students, registration date should take precedence
             * otherwise, the staff reader should take precedence
             */

            return (m1 instanceof Staff == m2 instanceof Staff) ? m1.getDateOfRegistration().compareTo(m2.getDateOfRegistration())
                    : (m1 instanceof Staff  ? -1 : 1);
        }

    };

}

