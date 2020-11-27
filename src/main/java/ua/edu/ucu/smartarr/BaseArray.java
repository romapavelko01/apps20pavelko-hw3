package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] myArray;

    public BaseArray(Object[] array) {
        this.myArray = array;
    }

    @Override
    public Object[] toArray() {
        return myArray;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return myArray.length;
    }
}
