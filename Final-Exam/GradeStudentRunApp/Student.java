package GradeStudentRunApp;

import java.util.*;

public class Student implements Grade{
    private int mathGrade;
    private int csGrade;

    public Student(int mathGrade, int csGrade) {
        this.mathGrade = mathGrade;
        this.csGrade = csGrade;
    }

    @Override
    public double meanGrade() {
        return (mathGrade + csGrade) / 2.;
    }

    @Override
    public String toString() {
        return "" + meanGrade();
    }

    @Override
    public int compareTo(Grade other) {
        return Double.compare(this.meanGrade(), other.meanGrade());
    }

    public static <T extends Comparable<? super T>> ArrayList<ArrayList<T>> getRuns(ArrayList<T> list) {
        ArrayList<ArrayList<T>> runs = new ArrayList<>();

        if (list == null || list.size() < 2) {
            if (list != null && !list.isEmpty()) { // one element
                runs.add(list);
            }
            return runs;
        }

        // [4, 6, 9, 5, 3, 2, 8, 10, 7] ->
        // [
        // [4, 6, 9],     // increasing
        // [9, 5, 3, 2],  // decreasing
        // [2, 8, 10],    // increasing
        // [10, 7]        // decreasing
        // ]
        int i = 0;
        while (i < list.size() - 1) { // so that j + 1 has a meaning
            ArrayList<T> run = new ArrayList<>();
            run.add(list.get(i));
            int j = i + 1;
            
            // detect mode: 1 ascending or -1 descending
            int mode = 0;
            if (list.get(i).compareTo(list.get(j)) <= 0) { // ascending or equal
                mode = 1;
            } else { // descending
                mode = -1;
            }

            while (j < list.size()) {
                if ((mode == 1 && list.get(j - 1).compareTo(list.get(j)) <= 0) || (mode == -1 && list.get(j - 1).compareTo(list.get(j)) > 0)) {
                    run.add(list.get(j++));
                } else { // run ends
                    break;
                }
            }

            runs.add(run);
            i = j - 1;
        }

        return runs;
    }

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            int math = random.nextInt(101);
            int cs = random.nextInt(101);

            students.add(new Student(math, cs));
        }

        System.out.println("Students:\n[");
        for (Student s : students) {
            System.out.print(s + ", ");
        }
        System.out.println("]\n");

        ArrayList<ArrayList<Student>> runs = getRuns(students);
        System.out.println("Runs:\n[");
        for (ArrayList<Student> run : runs) {
            System.out.print("[");
            for (Student s : run) {
                System.out.print(s + ", ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
