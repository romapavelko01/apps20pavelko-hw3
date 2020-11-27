package ua.edu.ucu.smartarr;


import java.util.Arrays;
import java.util.HashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{
    private HashSet<Object> mySet;

    public DistinctDecorator(SmartArray sa) {
        super(sa);
        mySet = new HashSet<>();
    }

    @Override
    public Object[] toArray() {
        Object[] finalArray = new Object[size()];
        Object[] oldArray = smartArray.toArray();
        int index = 0;

        mySet = new HashSet<>();
        for (Object e : oldArray) {
            if (mySet.add(e)) {
                finalArray[index++] = e;
            }
        }
        return finalArray;
    }

    @Override
    public int size() {
        mySet = new HashSet<>();
        mySet.addAll(Arrays.asList(smartArray.toArray()));
        int mySize = mySet.size();
        mySet.clear();
        return mySize;
    }

    @Override
    public String operationDescription() {
        return "Distinct elements decorator";
    }

}
