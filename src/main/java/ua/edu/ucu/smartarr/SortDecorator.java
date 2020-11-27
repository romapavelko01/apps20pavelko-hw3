package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;
import java.util.Comparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;

    public SortDecorator(SmartArray sa, MyComparator newComparator) {
        super(sa);
        this.comparator = newComparator;
    }

    @Override
    public Object[] toArray() {
        Object[] oldSmartArray = smartArray.toArray();
        Arrays.sort(oldSmartArray, comparator);
        return oldSmartArray;
    }

    @Override
    public String operationDescription() {
        return "Sorting elements decorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
