class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int totalStudents = students.length;
        int circular = 0, square = 0;
        for (int student : students) {
            if (student == 0) circular++; // if student wants a circular sandwich
            else square++; // if student wants a square sandwich
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0) { // if circular sandwich is at the top 
                if (circular > 0) circular--; // if we have sufficient circular sandwiches then give it to student from total circular sandwiches
                else break; // if we don't have enough circular sandwiches
            } else { // if square sandwich is at the top
                if (square > 0) square--; // if we have enough square sandwiches to give to students
                else break; // we are out of square sandwiches to provide
            }
        }

        int unableToEatStudents = square + circular; // remaining sandwiches which were not distributed
        return unableToEatStudents;
    }
}
