package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private MyPredicate predicate;

    public FilterDecorator(SmartArray sa, MyPredicate setPr) {
        super(sa);
        predicate = setPr;
    }

    public int getNumberOfFiltered() {
        int numberOfEls = 0;
        Object[] myArr = smartArray.toArray();
        for (Object o : myArr) {
            if (predicate.test(o)) {
                numberOfEls += 1;
            }
        }
        return numberOfEls;
    }

    @Override
    public Object[] toArray() {
        int index = 0;
        Object[] finalArray = new Object[size()];
        for (Object myObj: smartArray.toArray()) {
            if (predicate.test(myObj)) {
                finalArray[index++] = myObj;
            }
        }
        return finalArray;
    }

    @Override
    public String operationDescription() {
        return "Filter decorator";
    }

    @Override
    public int size() {
        return getNumberOfFiltered();
    }
}
