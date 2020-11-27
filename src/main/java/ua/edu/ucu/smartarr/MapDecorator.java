package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(SmartArray sa, MyFunction setThis) {
        super(sa);
        this.function = setThis;
    }

    @Override
    public Object[] toArray() {
        Object[] arrayToMap = smartArray.toArray();
        Object[] finalArr = new Object[size()];
        for (int j = 0; j < size(); j++) {
            finalArr[j] = function.apply(arrayToMap[j]);
        }
        return finalArr;
    }

    @Override
    public String operationDescription() {
        return "Mapping function decorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
