package org.example;

import java.util.*;

public class Main{
    // gets the average score of all students
    public static float getAverageScore(int[] grades){
        float averageScore = 0;
        for(int grade : grades){
            averageScore += grade;
        }
        return averageScore/grades.length;
    }

    // prints the count of each grade letter
    public static void printGradeLetterCount(char[] letterGrades){
        int[] letterGradeCounts = new int[5];
        for(char letterGrade: letterGrades){
            if (letterGrade == 'A'){
                letterGradeCounts[0] += 1;
            }
            if (letterGrade == 'B'){
                letterGradeCounts[1] += 1;
            }
            if (letterGrade == 'C'){
                letterGradeCounts[2] += 1;
            }
            if (letterGrade == 'D'){
                letterGradeCounts[3] += 1;
            }
            if (letterGrade == 'F'){
                letterGradeCounts[4] += 1;
            }
        }
        System.out.format("A:%d B:%d C:%d D:%d F:%d\n", letterGradeCounts[0], letterGradeCounts[1], letterGradeCounts[2], letterGradeCounts[3], letterGradeCounts[4]);
    }


    //prints the name and grade of the top student
    public static void printTopStudent(String[] students, int[] grades){
        int maxGrade = 0;
        int maxGradeIndex = 0;
        for(int i = 0; i < grades.length;i++){
            if(maxGrade < grades[i]){
                maxGrade = grades[i];
                maxGradeIndex = i;
            }
        }
        System.out.format("Top Student(s): %s (%d)",students[maxGradeIndex], maxGrade);

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of students: ");

        int numberOfStudents = s.nextInt();
        String[] students = new String[numberOfStudents];
        int[] grades = new int[numberOfStudents];
        char[] letterGrades = new char[numberOfStudents];

        for(int i = 0; i < numberOfStudents; i++){
            System.out.format("\nEnter name of student %d: ", i+1);
            students[i] = s.next();
            System.out.format("Enter score for %s: ", students[i]);
            grades[i] = s.nextInt();


            // calculates the grade letter based on their numerical grade
            if(grades[i] >= 90 && grades[i] <= 100){
                letterGrades[i] = 'A';
            } else if (grades[i] >= 80 && grades[i] <= 89) {
                letterGrades[i] = 'B';
            } else if (grades[i] >= 70 && grades[i] <=79){
                letterGrades[i] = 'C';
            } else if (grades[i] >= 60 && grades[i] <=69) {
                letterGrades[i] = 'D';
            } else if (grades[i] < 60) {
                letterGrades[i] = 'F';

            }

            System.out.format("%s got grade: %c\n",students[i], letterGrades[i]);

        }

        System.out.println("\n----- Class Summary -----");

        System.out.format("Average Score: %.2f\n",getAverageScore(grades));
        System.out.format("Grade Counts: ");
        printGradeLetterCount(letterGrades);
        printTopStudent(students, grades);

    }
}
