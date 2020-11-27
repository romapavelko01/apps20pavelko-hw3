package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;

public class SmartArrayApp {
    static final int grade = 4;
    static final int year = 2;

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate predicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == year && ((Student) t).getGPA() >= grade;
            }
        };

        MyComparator comparator = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String firstStudent = ((Student) o1).getSurname();
                String secondStudent = ((Student) o2).getSurname();

                if (firstStudent.length() > secondStudent.length()) {
                    return 1;
                }
                else if (firstStudent.length() < secondStudent.length()) {
                    return -1;
                }
                else {
                    for (int ci = 0; ci < firstStudent.length(); ci++) {
                        if (firstStudent.charAt(ci) > secondStudent.charAt(ci)) {
                            return 1;
                        }
                        else if (firstStudent.charAt(ci) < secondStudent.charAt(ci)) {
                            return -1;
                        }
                    }
                }
                return 0;
            };
        };

        MyFunction function = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname() + " " + ((Student) t).getName();
            }
        };
        SmartArray studentArr = new BaseArray(students);
        studentArr = new FilterDecorator(studentArr, predicate);
        studentArr = new SortDecorator(studentArr, comparator);
        studentArr = new MapDecorator(studentArr, function);
        studentArr = new DistinctDecorator(studentArr);
        Object[] resArr = studentArr.toArray();
        return Arrays.copyOf(resArr, resArr.length, String[].class);
    }
}
